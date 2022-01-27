package es.reji.views.login;

import java.util.List;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

import es.reji.views.MainLayout;
import es.reji.views.admin.PanelAdminView;
import es.reji.views.cartelera.CarteleraView;
import es.reji.views.registration.RegistrationService;
import es.reji.views.registration.domain.Registration;

@PageTitle("login")
@Route(value = "login", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class LoginView extends VerticalLayout {

    private RegistrationService service;

    public LoginView(RegistrationService service) {
        this.service = service;

        TextField user = new TextField("Usuario");
        PasswordField password = new PasswordField("Contraseña");
        add(user);
        add(password);
        List<Registration> lista = service.findAll();

        Button button = new Button("Iniciar sesión");
        
        button.addClickListener(clickEvent -> {
            if(user.getValue() == "" || password.getValue() == "") {
                add("Debe rellenar ambos campos.");
            } else {
                for(Registration registration:lista) {
                    if(registration.getEmail().equals(user.getValue()) && registration.getPassword().equals(password.getValue())) {
                        if(registration.getId() == 0) {
                            this.getUI().ifPresent(ui -> ui.navigate(PanelAdminView.class));
                        } else {
                            this.getUI().ifPresent(ui -> ui.navigate(CarteleraView.class));
                        }
                    } else {
                        if(registration.getEmail().equals(user.getValue()) && !registration.getPassword().equals(password.getValue())) {
                            add("Acceso incorrecto o usuario no registrado.");
                        }
                    }
                }
            }
        });
        add(button);
    }
}

