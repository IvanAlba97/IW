package es.reji.views.crud;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.vaadin.crudui.crud.CrudOperation;
import org.vaadin.crudui.crud.CrudOperationException;
import org.vaadin.crudui.crud.impl.GridCrud;

import es.reji.data.entity.Pelicula;
import es.reji.data.service.PeliculaService;
import es.reji.views.admin.PanelAdminView;

@SuppressWarnings("serial")
@Route(value = "crud-pelicula")
public class CrudPeliView extends VerticalLayout {

	public CrudPeliView(PeliculaService peliculaService) {
		// crud instance
		GridCrud<Pelicula> crud = new GridCrud<>(Pelicula.class);

		Button buttonPanel = new Button("Panel de administración");
   	 	buttonPanel.addClickListener(clickEvent -> {this.getUI().ifPresent(ui -> ui.navigate(PanelAdminView.class));});
		
		// grid configuration
		crud.getGrid().setColumns("id", "genero", "pegi", "sinopsis", "titulo", "url");
		crud.getGrid().setColumnReorderingAllowed(true);

		// form configuration
		crud.getCrudFormFactory().setUseBeanValidation(true);
		crud.getCrudFormFactory().setVisibleProperties("genero", "pegi", "sinopsis", "titulo", "url");
		crud.getCrudFormFactory().setVisibleProperties(CrudOperation.ADD, "genero", "pegi", "sinopsis", "titulo",
				"url");
		
		// layout configuration
		setSizeFull();
		add(crud);
		crud.setFindAllOperationVisible(false);

		// logic configuration
		crud.setOperations(() -> peliculaService.findAll(), pelicula -> peliculaService.save(pelicula), pelicula -> {
			if (pelicula.getId().equals(10L)) {
				throw new CrudOperationException("Simulated error.");
			}
			return peliculaService.save(pelicula);
		}, pelicula -> peliculaService.delete(pelicula));
		
		add(buttonPanel);
		
        crud.getFindAllButton().getElement().setAttribute("title", "Actualizar");
        crud.getAddButton().getElement().setAttribute("title", "Añadir");
        crud.getUpdateButton().getElement().setAttribute("title", "Modificar");
        crud.getDeleteButton().getElement().setAttribute("title", "Eliminar");
        crud.setSavedMessage("Pelicula guardada");
        crud.setDeletedMessage("Pelicula borrada");
        crud.setRowCountCaption("%d pelicula(s) encontradas");
	}

}