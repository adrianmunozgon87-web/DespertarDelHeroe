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
            String[] nombres = new String[jugadores.getLength()];
            int[] puntos = new int[jugadores.getLength()];

            
            for (int i = 0; i < jugadores.getLength(); i++) {
                Element jugador = (Element) jugadores.item(i);
                nombres[i] = jugador.getElementsByTagName("usuario")
                        .item(0).getTextContent();

                puntos[i] = Integer.parseInt(
                        jugador.getElementsByTagName("puntos")
                                .item(0).getTextContent());
            }

            for (int i = 0; i < puntos.length - 1; i++) {
                for (int j = i + 1; j < puntos.length; j++) {
                    if (puntos[j] > puntos[i]) {

                        int puntosAux = puntos[i];
                        puntos[i] = puntos[j];
                        puntos[j] = puntosAux;

                        String nombreAux = nombres[i];
                        nombres[i] = nombres[j];
                        nombres[j] = nombreAux;
                    }
                }
            }
            System.out.println("===== TOP 10 RANKING =====");

            int limite = Math.min(10, nombres.length);

            for (int i = 0; i < limite; i++) {
                System.out.println((i + 1) + ". " + nombres[i]
                        + " - " + puntos[i] + " puntos");
            }

        } catch (Exception e) {
            System.out.println("Error al leer el ranking");
            e.printStackTrace();
        }
    }
}