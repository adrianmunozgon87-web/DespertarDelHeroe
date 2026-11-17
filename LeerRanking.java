import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class LeerRanking {

    public static void mostrarRanking() {

        try {
            File archivo = new File("ranking.xml");
            if (!archivo.exists()) {
                System.out.println("Todavia no hay puntuaciones guardadas");
                return;
            }
            DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
            DocumentBuilder constructor = fabrica.newDocumentBuilder();
            Document documento = constructor.parse(archivo);
            NodeList jugadores = documento.getElementsByTagName("jugador");
            if (jugadores.getLength() == 0) {
                System.out.println("El ranking esta vacio");
                return;
            }
            System.out.println("===== RANKING =====");
            for (int i = 0; i < jugadores.getLength(); i++) {
                Element jugador = (Element) jugadores.item(i);
                String usuario = jugador.getElementsByTagName("usuario")
                        .item(0).getTextContent();
                String puntos = jugador.getElementsByTagName("puntos")
                        .item(0).getTextContent();
                System.out.println((i + 1) + ". " + usuario + " - " + puntos + " puntos");
            }
        } catch (Exception e) {
            System.out.println("Error al leer el ranking");
            e.printStackTrace();
        }
    }
}