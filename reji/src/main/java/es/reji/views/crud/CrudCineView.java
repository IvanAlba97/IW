package es.reji.views.crud;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.vaadin.crudui.crud.CrudOperation;
import org.vaadin.crudui.crud.CrudOperationException;
import org.vaadin.crudui.crud.impl.GridCrud;

import es.reji.data.entity.Cine;
import es.reji.data.service.CineService;
import es.reji.views.admin.PanelAdminView;

@SuppressWarnings("serial")
@Route(value = "crud-cine")
public class CrudCineView extends VerticalLayout {

	public CrudCineView(CineService cineService) {
		// crud instance
		GridCrud<Cine> crud = new GridCrud<>(Cine.class);
		
		Button buttonPanel = new Button("Panel de administración");
   	 	buttonPanel.addClickListener(clickEvent -> {this.getUI().ifPresent(ui -> ui.navigate(PanelAdminView.class));});

		// grid configuration
		crud.getGrid().setColumns("id", "nombre", "direccion");
		crud.getGrid().setColumnReorderingAllowed(true);

		// form configuration
		crud.getCrudFormFactory().setUseBeanValidation(true);
		crud.getCrudFormFactory().setVisibleProperties("nombre", "direccion");
		crud.getCrudFormFactory().setVisibleProperties(CrudOperation.ADD, "nombre", "direccion");
		
		// layout configuration
		setSizeFull();
		add(crud);
		crud.setFindAllOperationVisible(false);

		// logic configuration
		crud.setOperations(() -> cineService.findAll(), cine -> cineService.save(cine), cine -> {
			if (cine.getId().equals(10L)) {
				throw new CrudOperationException("Simulated error.");
			}
			return cineService.save(cine);
		}, cine -> cineService.delete(cine));
		
		add(buttonPanel);
		
        crud.getFindAllButton().getElement().setAttribute("title", "Actualizar");
        crud.getAddButton().getElement().setAttribute("title", "Añadir");
        crud.getUpdateButton().getElement().setAttribute("title", "Modificar");
        crud.getDeleteButton().getElement().setAttribute("title", "Eliminar");
        crud.setSavedMessage("Cine guardado");
        crud.setDeletedMessage("Cine borrado");
        crud.setRowCountCaption("%d cine(s) encontrados");
	}

}