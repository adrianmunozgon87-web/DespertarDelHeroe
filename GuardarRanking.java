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
import org.w3c.dom.NodeList;

public class GuardarRanking {

    public static void guardarJugador(String usuario, int puntos) {
        try {
            CrearXMLRanking.crearXML();
            File archivo = new File("ranking.xml");
            DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
            DocumentBuilder constructor = fabrica.newDocumentBuilder();
            Document documento = constructor.parse(archivo);
            Element raiz = documento.getDocumentElement();
            if (!raiz.getTagName().equals("ranking")) {
                System.out.println("Error: la raiz del XML no es ranking");
                return;
            }
            NodeList jugadores = raiz.getElementsByTagName("jugador");
            String[] usuarios = new String[jugadores.getLength() + 1];
            int[] puntuaciones = new int[jugadores.getLength() + 1];
            for (int i = 0; i < jugadores.getLength(); i++) {
                Element jugador = (Element) jugadores.item(i);
                usuarios[i] = jugador.getElementsByTagName("usuario")
                        .item(0).getTextContent();

                puntuaciones[i] = Integer.parseInt(
                        jugador.getElementsByTagName("puntos")
                                .item(0).getTextContent());
            }
            int ultimaPosicion = usuarios.length - 1;
            usuarios[ultimaPosicion] = usuario;
            puntuaciones[ultimaPosicion] = puntos;
            for (int i = 1; i < puntuaciones.length; i++) {

                int puntosAux = puntuaciones[i];
                String usuarioAux = usuarios[i];

                int j = i - 1;

                while (j >= 0 && puntuaciones[j] < puntosAux) {

                    puntuaciones[j + 1] = puntuaciones[j];
                    usuarios[j + 1] = usuarios[j];

                    j--;
                }

                puntuaciones[j + 1] = puntosAux;
                usuarios[j + 1] = usuarioAux;
            }
            while (raiz.hasChildNodes()) {
                raiz.removeChild(raiz.getFirstChild());
            }
            int limite = Math.min(10, usuarios.length);
            for (int i = 0; i < limite; i++) {
                Element jugador = documento.createElement("jugador");
                raiz.appendChild(jugador);
                Element elementoUsuario = documento.createElement("usuario");
                elementoUsuario.setTextContent(usuarios[i]);
                jugador.appendChild(elementoUsuario);
                Element elementoPuntos = documento.createElement("puntos");
                elementoPuntos.setTextContent(
                String.valueOf(puntuaciones[i]));
                jugador.appendChild(elementoPuntos);
            }
            TransformerFactory transformeFabrica =TransformerFactory.newInstance();
            Transformer transformer = transformeFabrica.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "ranking.dtd");
            DOMSource origen = new DOMSource(documento);
            StreamResult destino = new StreamResult(archivo);
            transformer.transform(origen, destino);
            System.out.println("Ranking actualizado correctamente");
        } catch (Exception e) {
            System.out.println("Error al guardar el ranking");
            e.printStackTrace();
        }
    }
}