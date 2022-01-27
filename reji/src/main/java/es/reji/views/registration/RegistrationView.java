package es.reji.views.registration;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import es.reji.views.MainLayout;
import es.reji.views.registration.domain.Registration;

@PageTitle("registration")
@Route(value = "registration", layout = MainLayout.class)
public class RegistrationView extends VerticalLayout {

    private transient RegistrationService service;

    private Binder<Registration> binder = new BeanValidationBinder<>(Registration.class);

    private EmailField email = new EmailField("Correo electronico");
    private TextField name = new TextField("Contraseña");

    public RegistrationView(RegistrationService service) {
        this.service = service;

        // Build the layout
        H1 heading = new H1("Registro cine REJI");
        H5 recomendaciones = new H5("La contraseña a de cumplir:"
        		+ " Caracteres alfanuméricos\r\n"
        		+ ", 8 caracteres mínimo\r\n"
        		+ ", Una mayúscula\r\n"
        		+ ", Un carácter especial");
        Button submit = new Button("Registrarse");
        setAlignItems(Alignment.CENTER);
		setJustifyContentMode(JustifyContentMode.CENTER);
        add(
                heading,
                email,
                name,
                recomendaciones,
                submit
        );

        // configure components

        submit.addClickListener(e -> {
            submitOrder();
            String msg = String.format(
                    "Gracias, se ha registrado",
                    binder.getBean().getName());
            Notification.show(msg, 3000, Notification.Position.MIDDLE);
            init();
        });


        // Add keyboard shortcut
        submit.addClickShortcut(Key.ENTER);

        // Bind fields from this UI class to domain object using naming convention
        binder.bindInstanceFields(this);
        // enable save button only if the bean is valid
        binder.addStatusChangeListener(e -> submit.setEnabled(binder.isValid()));

        init();
    }

	private void submitOrder() {
        service.register(binder.getBean());
    }

    private void init() {
        binder.setBean(new Registration());
    }

}