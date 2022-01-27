package es.reji.views.pago;

import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;

import es.reji.data.service.CarritoService;
import es.reji.views.MainLayout;
import es.reji.views.cartelera.CarteleraView;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;

@PageTitle("Pago")
@Route(value = "pago", layout = MainLayout.class)
/* @Tag("pago-view")
@JsModule("./views/pago/pago-view.ts") */
public class PagoView extends VerticalLayout implements HasStyle {
        private CarritoService carrito;
  
        //private Binder<Pago> binder = new BeanValidationBinder<>(Registration.class);
        public PagoView(CarritoService carrito) { 
                this.carrito = carrito;
                addClassNames("flex", "flex-col", "h-full"); 

                TextField numTarjeta = new TextField("Número de tarjeta");
                PasswordField codSeguridad = new PasswordField("Código de seguridad");
                ComboBox<String> comboBoxAnno = new ComboBox<>("Año de caducidad");
                comboBoxAnno.setAllowCustomValue(true);
                comboBoxAnno.setItems("2022", "2023", "2024", "2025","2026", "2027", "2028", "2029");
                ComboBox<String> comboBoxMes = new ComboBox<>("Mes de caducidad");
                comboBoxMes.setAllowCustomValue(true);
                comboBoxMes.setItems("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre");

                FormLayout formLayout = new FormLayout();
                add(formLayout);
                formLayout.add(
                        numTarjeta, codSeguridad,
                        comboBoxAnno, comboBoxMes
                        
                );

                formLayout.setResponsiveSteps(
                        // Use one column by default
                        new ResponsiveStep("0", 1),
                        // Use two columns, if layout's width exceeds 500px
                        new ResponsiveStep("500px", 2)
                );
                Button buttonC = new Button("Cancelar");
                buttonC.addClickListener(clickEvent -> {
                        this.getUI().ifPresent(ui -> ui.navigate(CarteleraView.class));
                });
                add(buttonC);

                // Stretch the username field over 2 columns
                Button buttonP = new Button("Pagar");
                buttonP.addClickListener(clickEvent -> {
                        numTarjeta.setRequired(true);
                        codSeguridad.setRequired(true);
                        comboBoxAnno.setRequired(true);
                        comboBoxMes.setRequired(true);
                        if((numTarjeta.getValue() != null) && (codSeguridad.getValue() != null) && (comboBoxAnno.getValue() != null) && (comboBoxMes.getValue() != null))
                                this.getUI().ifPresent(ui -> ui.navigate(PuentePagoView.class));
                                
                });
                add(buttonP);
                buttonP.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_SUCCESS);
                HorizontalLayout horizontalLayout = new HorizontalLayout(buttonC, buttonP);
                add(horizontalLayout);


        }

}


