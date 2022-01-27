package es.reji.views.admin;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import es.reji.views.crud.CrudCineView;
import es.reji.views.crud.CrudPeliView;
import es.reji.views.login.LoginView;
import es.reji.views.registration.ListRegistrationsView;

@PageTitle("Panel de administración")
@Route(value = "panel-admin")
public class PanelAdminView extends VerticalLayout {

    public PanelAdminView() {
    	 setSpacing(false);
    	 
		 Button buttonPeli = new Button("CRUD - Peliculas");
    	 buttonPeli.addClickListener(clickEvent -> {this.getUI().ifPresent(ui -> ui.navigate(CrudPeliView.class));});
    	 Button buttonRegistro = new Button("CRUD - Registros");
    	 buttonRegistro.addClickListener(clickEvent -> {this.getUI().ifPresent(ui -> ui.navigate(ListRegistrationsView.class));});
    	 Button buttonCines = new Button("CRUD - Cines");
    	 buttonCines.addClickListener(clickEvent -> {this.getUI().ifPresent(ui -> ui.navigate(CrudCineView.class));});
		 
		Button logout = new Button("Cerrar sesión");
        
        logout.addClickListener(clickEvent -> {
            this.getUI().ifPresent(ui -> ui.navigate(LoginView.class));
        });
        add(logout);
    	 
    	 HorizontalLayout horizontalLayout = new HorizontalLayout(buttonPeli, buttonRegistro, buttonCines);
         add(horizontalLayout);

         setSizeFull(); 
         getStyle().set("text-align", "justify");
     }
}
