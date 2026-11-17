import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
public class GuardarRanking {
    public static void guardarJugador(String usuario, int puntos) {
        try {
            CrearXMLRanking.crearXML();
            File archivo = new File("ranking.xml");
            DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
            DocumentBuilder constructor = fabrica.newDocumentBuilder();
            Document documento = constructor.parse(archivo);
            Element raiz = documento.getDocumentElement();
            Element jugador = documento.createElement("jugador");
            raiz.appendChild(jugador);
            Element elementoUsuario = documento.createElement("usuario");
            elementoUsuario.setTextContent(usuario);
            jugador.appendChild(elementoUsuario);
            Element elementoPuntos = documento.createElement("puntos");
            elementoPuntos.setTextContent(String.valueOf(puntos));
            jugador.appendChild(elementoPuntos);
            TransformerFactory transformeFabrica = TransformerFactory.newInstance();
            Transformer transformer = transformeFabrica.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            DOMSource origen = new DOMSource(documento);
            StreamResult destino = new StreamResult(archivo);
            transformer.transform(origen, destino);
            System.out.println("Puntuacion guardada correctamente");
        } catch (Exception e) {
            System.out.println("Error al guardar el jugador");
            e.printStackTrace();
        }
    }
}
