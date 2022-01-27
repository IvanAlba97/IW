package es.reji.views.politicadecookies;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import es.reji.views.MainLayout;

@PageTitle("Politica de cookies")
@Route(value = "politicadecookies", layout = MainLayout.class)
public class PoliticadecookiesView extends VerticalLayout {

    public PoliticadecookiesView() {
    	 setSpacing(false);

         add(new H1("Política de Cookies"));
         add(new Paragraph("Esta web solo utiliza las cookies necesarias para el proceso de compra"));
         add(new Paragraph("No se queda en su equipo almacenada ninguna cookie que pueda ser utilizada por terceros ni de utilidad, solo unas cadenas de texto de tamaño ínfimo."));
         add(new Paragraph("A continuación vamos a explicarle en que consisten las cookies para aclararle el concepto"));
         add(new H2("¿Qué es una cookie?"));
         add(new Paragraph("Una cookie es un fichero de texto inofensivo que se almacena en su navegador cuando visita casi cualquier página web. La utilidad de la cookie es que la web sea capaz de recordar su visita cuando vuelva a navegar por esa página. Aunque mucha gente no lo sabe las cookies se llevan utilizando desde hace 20 años, cuando aparecieron los primeros navegadores para la World Wide Web."));
         add(new H2("¿Qué NO es una cookie?"));
         add(new Paragraph("No es un virus, ni un troyano, ni un gusano, ni spam, ni spyware, ni abre ventanas pop-up."));
         add(new H2("¿Qué información almacena una cookie?"));
         add(new Paragraph("Las cookies no suelen almacenar información sensible sobre usted, como tarjetas de crédito o datos bancarios, fotografías, su DNI o información personal, etc. Los datos que guardan son de carácter técnico, preferencias personales, personalización de contenidos, etc. El servidor web no le asocia a usted como persona si no a su navegador web. De hecho, si usted navega habitualmente con Edged y prueba a navegar por la misma web con Firefox o Chrome verá que la web no se da cuenta que es usted la misma persona porque en realidad está asociando al navegador, no a la persona."));
         add(new H2("¿Qué son las cookies propias y las de terceros?"));
         add(new Paragraph("Las cookies propias son las generadas por la página que está visitando y las de terceros son las generadas por servicios o proveedores externos como Facebook, Twitter, Google, etc."));
         add(new H2("¿Se pueden eliminar las cookies?"));
         add(new Paragraph("Sí. No sólo eliminar, también bloquear, de forma general o particular para un dominio específico. Para eliminar las cookies de un sitio web debe ir a la configuración de su navegador y allí podrá buscar las asociadas al dominio en cuestión y proceder a su eliminación"));
         add(new Paragraph("Para consultas y ayuda envie un mail a admin@cinesreji.com"));
         
         setSizeFull(); 
         getStyle().set("text-align", "justify");
     }

}
