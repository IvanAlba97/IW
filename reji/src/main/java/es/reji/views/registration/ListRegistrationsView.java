package es.reji.views.registration;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

import es.reji.views.admin.PanelAdminView;
import es.reji.views.registration.domain.Registration;
import es.reji.views.registration.domain.RegistrationRepository;

@PageTitle("CrudRegistration")
@Route(value = "crud-registro")
public class ListRegistrationsView extends VerticalLayout {
    
    private final transient RegistrationRepository repo;
    private final Grid<Registration> registrations = new Grid<>(Registration.class);
    
    public ListRegistrationsView(RegistrationRepository repo) {
    	
    	Button buttonPanel = new Button("Panel de administración");
   	 	buttonPanel.addClickListener(clickEvent -> {this.getUI().ifPresent(ui -> ui.navigate(PanelAdminView.class));});
    	
        this.repo = repo;
        // Build the layout
        H1 heading = new H1("Lista de usuarios registrados");
        Button update = new Button(VaadinIcon.REFRESH.create());
        RouterLink orderView = new RouterLink();
        add(heading, update, registrations, orderView);
        
        registrations.setColumns("name", "email");
        registrations.addComponentColumn(order -> {
            Button deleteBtn = new Button(VaadinIcon.TRASH.create());
            deleteBtn.addClickListener(e -> {
                repo.delete(order);
                listOrders();
            });
            return deleteBtn;
        });
        listOrders();
        
        update.addClickListener(e -> listOrders());
        
        add(buttonPanel);
        
    }

    public void listOrders() {
        registrations.setItems(repo.findAll());
    }
    
}