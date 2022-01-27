package es.reji.views.crud;

import java.util.List;

import org.vaadin.crudui.crud.CrudOperation;
import org.vaadin.crudui.crud.impl.GridCrud;

import es.reji.data.entity.Cine;
import es.reji.data.entity.Sala;
import es.reji.data.service.CineService;
import es.reji.data.service.SalaService;

import org.vaadin.crudui.form.impl.field.provider.CheckBoxGroupProvider;
import org.vaadin.crudui.form.impl.field.provider.ComboBoxProvider;
import org.vaadin.crudui.form.impl.form.factory.DefaultCrudFormFactory;
import org.vaadin.crudui.layout.impl.HorizontalSplitCrudLayout;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasValueAndElement;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.TextRenderer;
import com.vaadin.flow.router.Route;

@SuppressWarnings("serial")
@Route(value = "crud-sala")
public class CrudSalaView extends VerticalLayout {

	public CrudSalaView(SalaService salaService, CineService cineService) {

		// form configuration
		DefaultCrudFormFactory<Sala> formFactory = new DefaultCrudFormFactory<Sala>(Sala.class) {
			@Override
			protected void configureForm(FormLayout formLayout, List<HasValueAndElement> fields) {
				Component nameField = (Component) fields.get(0);
				formLayout.setColspan(nameField, 2);
			}
		};
		formFactory.setUseBeanValidation(true);
		formFactory.setVisibleProperties("numSala", "cine");
		formFactory.setVisibleProperties(CrudOperation.ADD, "numSala", "cine");
		formFactory.setFieldProvider("mainCine", new ComboBoxProvider<>(cineService.findAll()));
		formFactory.setFieldProvider("cines", new CheckBoxGroupProvider<>(cineService.findAll()));
		formFactory.setFieldProvider("cines",
				new CheckBoxGroupProvider<>("Cines", cineService.findAll(), Cine::getNombre));
		formFactory.setFieldProvider("mainCine", new ComboBoxProvider<>("Menú de Cines", cineService.findAll(),
				new TextRenderer<>(Cine::getNombre), Cine::getNombre));

		// crud instance
		GridCrud<Sala> crud = new GridCrud<Sala>(Sala.class, new HorizontalSplitCrudLayout(), formFactory);
		crud.setClickRowToUpdate(true);
		crud.setUpdateOperationVisible(false);

		// grid configuration
		crud.getGrid().setColumns("id", "numSala", "cine");
		crud.getGrid().setColumnReorderingAllowed(true);

		// layout configuration
		setSizeFull();
		add(crud);

		// logic configuration
		crud.setOperations(() -> salaService.findAll(), sala -> salaService.save(sala), sala -> salaService.save(sala),
				sala -> salaService.delete(sala));

		formFactory.setButtonCaption(CrudOperation.ADD, "Añadir una nueva sala");
		formFactory.setCancelButtonCaption("Cancelar");
		crud.getFindAllButton().getElement().setAttribute("title", "Actualizar");
		crud.getAddButton().getElement().setAttribute("title", "Añadir");
		crud.setSavedMessage("Sala guardada");
		crud.setDeletedMessage("Sala borrada");
		crud.setRowCountCaption("%d sala(s) encontradas");
	}

}