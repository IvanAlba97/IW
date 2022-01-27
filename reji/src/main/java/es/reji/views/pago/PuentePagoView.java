package es.reji.views.pago;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import es.reji.views.cartelera.CarteleraView;

@PageTitle("Puente de Compra")
@Route("puente")
//@Tag("puentepago-view")
//@JsModule("./views/pago/puentepago-view.ts")
public class PuentePagoView extends VerticalLayout{

    public PuentePagoView() {
        setSpacing(false);
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");

        add(new H1("Puente de Pago"));
        add(new Paragraph("En esta página nos encontraríamos con el puente de pago seguro con tu entidad bancaria."));
        add(new Paragraph("Si aceptas la compra, te redirigirémos a tu compra realizada, en caso contrario, a la cartelera."));
        add(new H2("¿Que acción deseas realizar?"));
        
        setSizeFull();
        getStyle().set("text-align", "justify");
        Button buttonC = new Button("Cancelar");
        buttonC.addClickListener(clickEvent -> {
            this.getUI().ifPresent(ui -> ui.navigate(CarteleraView.class));
        });
        add(buttonC);

        // Stretch the username field over 2 columns
        Button buttonP = new Button("Pagar");
        buttonP.addClickListener(clickEvent -> {
            this.getUI().ifPresent(ui -> ui.navigate(CompraFinalView.class));
                        
        });
        add(buttonP);
        buttonP.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_SUCCESS);
        HorizontalLayout horizontalLayout = new HorizontalLayout(buttonC, buttonP);
        add(horizontalLayout);
    }
    
}
