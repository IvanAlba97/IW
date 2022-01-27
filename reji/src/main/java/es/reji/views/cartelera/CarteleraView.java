package es.reji.views.cartelera;

import java.util.List;

import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteParameters;

import es.reji.data.entity.Pelicula;
import es.reji.data.service.PeliculaService;
import es.reji.views.MainLayout;
import es.reji.views.login.LoginView;
import es.reji.views.pelicula.PeliculaView;


@PageTitle("Cartelera")
@Route(value = "cartelera", layout = MainLayout.class)
@Tag("cartelera-view")
@JsModule("./views/cartelera/cartelera-view.ts")
public class CarteleraView extends LitTemplate implements HasComponents, HasStyle {

    private PeliculaService service;

    public CarteleraView(PeliculaService service) {
        addClassNames("cartelera-view", "flex", "flex-col", "h-full");
        this.service = service;

        List<Pelicula> lista = service.findAll();

        for(Pelicula pelicula:lista) {
        	
            add(	new ImageCard(pelicula.getTitulo(), 
            		pelicula.getUrl(), 
            		pelicula.getGenero(), 
            		e -> this.getUI().ifPresent(ui -> ui.navigate(PeliculaView.class, new RouteParameters("id", String.valueOf(pelicula.getId()))))));
        }
        //Otra forma de hacer enlaces
        //add(new RouterLink("Greeting",AvisolegalView.class));

        Button logout = new Button("Cerrar sesión");
        
        logout.addClickListener(clickEvent -> {
            this.getUI().ifPresent(ui -> ui.navigate(LoginView.class));
        });
        add(logout);
    }
}