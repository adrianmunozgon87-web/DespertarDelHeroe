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
public class CrearXMLRanking {
public static void crearXML() {
try {
File archivo = new File("ranking.xml");
if (archivo.exists()) {
return;
}
DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
DocumentBuilder constructor = fabrica.newDocumentBuilder();
Document documento = constructor.newDocument();
Element raiz = documento.createElement("ranking");
documento.appendChild(raiz);
TransformerFactory transformeFabrica = TransformerFactory.newInstance();
Transformer transformer = transformeFabrica.newTransformer();
transformer.setOutputProperty(OutputKeys.INDENT, "yes");
transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "ranking.dtd");
DOMSource origen = new DOMSource(documento);
StreamResult destino = new StreamResult(archivo);
transformer.transform(origen, destino);
System.out.println("Fichero ranking.xml generado correctamente");
} catch (Exception e) {
System.out.println("Error al crear el XML");
e.printStackTrace();
}
}
}