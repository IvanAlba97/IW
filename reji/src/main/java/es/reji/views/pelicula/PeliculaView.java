package es.reji.views.pelicula;

import java.util.Optional;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import es.reji.data.entity.Carrito;
import es.reji.data.entity.Pelicula;
import es.reji.data.entity.Sesion;
import es.reji.data.service.PeliculaService;
import es.reji.data.service.SesionService;
import es.reji.data.service.CarritoService;
import es.reji.views.MainLayout;
import es.reji.views.login.LoginView;
import es.reji.views.pago.PagoView;

@PageTitle("Pelicula")
@Route(value = "pelicula/:id", layout = MainLayout.class)
public class PeliculaView extends VerticalLayout implements BeforeEnterObserver {

    private PeliculaService service;
    private SesionService sesion;
    private CarritoService carrito;
    private Integer id;
    private static DateTimeFormatter formatoCorrecto = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
    Checkbox checkboxPalomitas, checkboxBebidas;
    private final double precioEntradas = 7.50, precioPalomitas = 4.50, precioBebidas = 2.50;
    private double precioTotal = 0;

    public PeliculaView(PeliculaService service, SesionService sesion, CarritoService carrito) {
        this.service = service;
        this.sesion = sesion;
        this.carrito = carrito;
        setSpacing(false);
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
    }

    @Override
    public void beforeEnter(BeforeEnterEvent arg0) {
        Optional<String> aux = arg0.getRouteParameters().get("id");
        if(aux.isPresent()) {
            id = Integer.valueOf(aux.get());
            Optional<Pelicula> p = service.findById(id);
            Image img = new Image(p.get().getUrl(), "placeholder plant");
            img.setWidth("400px");
            add(img);
            add(new H2("Título: " + p.get().getTitulo()));
            add(new H2("Sinopsis: "));
            add(p.get().getSinopsis());
            add(new H2("Pegi: " + p.get().getPegi()));
 
    
            ComboBox<Sesion> sesiones = new ComboBox<>("Sesion");
            sesiones.setItems(sesion.findByPelicula(p));
            sesiones.setItemLabelGenerator(sesion -> sesion.getFecha().format(formatoCorrecto));
            sesiones.setRequired(true);
            add(sesiones);

            IntegerField entradas = new IntegerField();
            entradas.setLabel("Entradas");
            entradas.setHelperText("Precio por entrada: " + precioEntradas + "€");
            entradas.setMin(0);
            entradas.setMax(10);
            entradas.setValue(0);
            entradas.setHasControls(true);
            add(entradas);

            IntegerField palomitas = new IntegerField();
            palomitas.setLabel("Palomitas");
            palomitas.setHelperText("Precio por palomitas: " + precioPalomitas + "€");
            palomitas.setMin(0);
            palomitas.setMax(10);
            palomitas.setValue(0);
            palomitas.setHasControls(true);
            add(palomitas);

            IntegerField bebidas = new IntegerField();
            bebidas.setLabel("Bebidas");
            bebidas.setHelperText("Precio por bebida: " + precioBebidas + "€");
            bebidas.setMin(0);
            bebidas.setMax(10);
            bebidas.setValue(0);
            bebidas.setHasControls(true);
            add(bebidas);

            Button siguiente = new Button("Siguiente");
            Button comprar = new Button("Comprar");

            comprar.setVisible(false);

            siguiente.addClickListener(clickEvent -> {
                double totalEntradas = entradas.getValue() * precioEntradas;
                double totalPalomitas = palomitas.getValue() * precioPalomitas;
                double totalBebidas = bebidas.getValue() * precioBebidas;
                precioTotal =  totalEntradas + totalPalomitas + totalBebidas;

                if((entradas.getValue() != 0) && (sesiones.getValue() != null)) {
                    /* Para mostrar el precio por partes: */
                    add(new H5("Precio total de entradas: " + totalEntradas + "€"));
                    add(new H5("Precio total de palomitas: " + totalPalomitas + "€"));
                    add(new H5("Precio total de bebidas: " + totalBebidas + "€"));
                    add(new H5("Total a pagar: " + precioTotal + "€"));
                    comprar.setVisible(true);
                } else {
                    add("Debe seleccionar tanto una sesión como el número de entradas obligatoriamente.");
                }
            });
            add(siguiente);

            comprar.addClickListener(clickEvent -> {
                // Para ir a la vista de pago.
                if((entradas.getValue() != 0) && (sesiones.getValue() != null)) {
                    Carrito c = new Carrito();
                    c.setNEntradas(entradas.getValue());
                    c.setNPalomitas(palomitas.getValue());
                    c.setNBebidas(bebidas.getValue());
                    c.setPrecioTotal(precioTotal);
                    carrito.save(c);
                    this.getUI().ifPresent(ui -> ui.navigate(PagoView.class));
                } else {
                    add("Debe seleccionar tanto una sesión como el número de entradas obligatoriamente.");
                }
            });
            add(comprar);

            Button logout = new Button("Cerrar sesión");
        
            logout.addClickListener(clickEvent -> {
                this.getUI().ifPresent(ui -> ui.navigate(LoginView.class));
            });
            add(logout);
        }
    }
}