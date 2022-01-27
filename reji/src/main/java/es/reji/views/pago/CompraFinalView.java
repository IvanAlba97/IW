package es.reji.views.pago;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import es.reji.views.cartelera.CarteleraView;

@PageTitle("Compra final")
@Route("Compra")
public class CompraFinalView extends VerticalLayout{

    public CompraFinalView(){
        setSpacing(false);
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
        add(new H1("HA FINALIZADO SU COMPRA CON ÉXITO"));
        add(new H1("¡DISFRUTE DE LA PELÍCULA!"));

        Button button = new Button("Finalizar");
        button.addClickListener(clickEvent -> {
                this.getUI().ifPresent(ui -> ui.navigate(CarteleraView.class));
        });
        add(button);
    }
    
}
