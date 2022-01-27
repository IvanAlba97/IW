package es.reji.views.crud;

import java.util.List;

import org.vaadin.crudui.crud.CrudOperation;
import org.vaadin.crudui.crud.impl.GridCrud;
import es.reji.data.entity.Pelicula;
import es.reji.data.service.PeliculaService;
import es.reji.views.MainLayout;

import org.vaadin.crudui.form.impl.form.factory.DefaultCrudFormFactory;
import org.vaadin.crudui.layout.impl.HorizontalSplitCrudLayout;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasValueAndElement;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "CrudCartelera")
public class CrudSplitPeliView extends VerticalLayout {

    public CrudSplitPeliView(PeliculaService PeliculaService) {
      
        // form configuration
	DefaultCrudFormFactory<Pelicula> formFactory = new DefaultCrudFormFactory<Pelicula>(Pelicula.class) {
	    @Override
	    protected void configureForm(FormLayout formLayout, List<HasValueAndElement> fields) {
		Component nameField = (Component) fields.get(0);
	        formLayout.setColspan(nameField, 2);
	    }
	};
        formFactory.setUseBeanValidation(true);
        formFactory.setVisibleProperties(
        		 "genero", "pegi", "sinopsis", "titulo", "url");
        formFactory.setVisibleProperties(
            CrudOperation.ADD,
             "genero", "pegi", "sinopsis", "titulo", "url");
              
        // crud instance
        GridCrud<Pelicula> crud = new GridCrud<Pelicula>(Pelicula.class, new HorizontalSplitCrudLayout(), formFactory);
        //crud.setClickRowToUpdate(true);
        crud.setUpdateOperationVisible(false);

        // grid configuration
        crud.getGrid().setColumns("id", "genero", "pegi", "sinopsis", "titulo", "url");
        crud.getGrid().setColumnReorderingAllowed(true);
        
        // layout configuration
        setSizeFull();
        add(crud);

        // logic configuration
        crud.setOperations(
                () -> PeliculaService.findAll(),
                pelicula -> PeliculaService.save(pelicula),
                pelicula -> PeliculaService.save(pelicula),
                pelicula -> PeliculaService.delete(pelicula)
        );
        
        formFactory.setButtonCaption(CrudOperation.ADD, "Añadir una nueva pelicula");
        formFactory.setCancelButtonCaption("Cancelar");
        crud.getFindAllButton().getElement().setAttribute("title", "Actualizar");
        crud.getAddButton().getElement().setAttribute("title", "Añadir");
        crud.setSavedMessage("Pelicula guardada");
        crud.setDeletedMessage("Pelicula borrada");
        crud.setRowCountCaption("%d pelicula(s) encontradas");
    }

}