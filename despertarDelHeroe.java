import java.util.Random;
import java.util.Scanner;
public class despertarDelHeroe
{
    public static String Inicio()
    {
        return 
        "Bienvenido a la Aventura!!!\n"
        +"1.Nueva partida\n"
        +"2.Consultar Ranking\n"
        +"3.Ayuda\n"
        +"4.Salir\n";
    }
    public static void mostrarInventario(String [] nombre, int [] cantidad)
    {
        int i;
        for(i = 0; i<6; i++)
        {
            if(cantidad[i]== 0) 
            {
                System.out.println("Hueco " + i + " Vacio");
            }else{
                System.out.println("Hueco " + i + ": ");
            }
        }
    }
    public static String ayuda()
    {
        return 
        "1.Reglas\n"
        +"2.Acciones\n"
        +"3.Puntuaciones\n";
    }
    public static String reglas()
    {
        return
        "-Solo se puede hacer una accion cada turno\n"
        +"-No puedes tener mas de 100 de vida\n"
        +"-Las pociones maximas son 3";
    }
    public static String acciones()
    {
        return
        "Cada turno puedes:\n"
        +"  -Atacar\n"
        +"  -Curarte\n"
        +"  -Consultar inventario anque no gastas el turno";
    }
    public static String puntuaciones()
    {
        return
        "-Cada enemigo eliminado da 100 puntos\n"
        +"-La victoria otorga 1 vida extra";
    }
    
    public static void curarVida(Heroe heroe)
    {
       
        int vidaactual = heroe.getVida();
        vidaactual += 25;
        heroe.setVida(vidaactual);
    }
    public static int DanioHeroe()
    {
        Random random = new Random();
        int dañoHeroe = random.nextInt(10,20);
        return dañoHeroe;

    }
    public static int DanioEnemigo()
    {
        Random random = new Random();
        int dañoEnemigo = random.nextInt(5,15);
        return dañoEnemigo;
    }
    public static String Historia()
    {
        return
        "Durante cien años, el reino de Eldrath vivió en paz bajo la luz de la Llama Eterna. Pero una noche el fuego se apagó, y de las sombras del bosque surgieron criaturas que nadie había visto jamás.\n" + //
                        "\n" + //
        "Tú eres un joven sin nombre ni fama, y hoy despiertas en una cabaña abandonada, con una espada oxidada y tres pociones que dejó un viejo curandero.\n" + //
                        "\n" + //
        "Tres enemigos te esperan en el camino hacia la Llama. Cada uno es más fuerte que el anterior. ¿Despertará el héroe que llevas dentro?\n" + //
                        "\n" + //
        "El camino hacia la Llama Eterna se estrecha entre árboles retorcidos. El aire huele a ceniza y, a lo lejos, algo se mueve entre las sombras.\n" + //
                        "\n" + //
        "Aprietas la empuñadura de tu espada oxidada. No hay vuelta atrás: el enemigo te ha visto.\n" + //
                        "\n" + //
        "¡Comienza la batalla!";
    }
    public static String nombreDelHeroe()
    {
        Scanner sc = new Scanner(System.in);
            System.out.println("Introduce el nombre de tu heroe");
            String nombre  = sc.next();
            if(nombre==null)
                {
                System.out.println("El nombre no puede estar vacio");
                }
            return nombre;
    }
    public static String batallaOpciones()
    {
        return
        "1.Atacar\n"
        +"2.Curarte\n"
        +"3.Inventario\n"
        +"4.Huir";
    }
    static final int enCurso = 0;
    static final int victoria = 1;
    static final int derrota = 2;
    public static int  accionesBatalla(Heroe heroe, Enemigo enemigo)
    {
        Scanner sc = new Scanner(System.in);
        boolean turnoConsumido;
       int resultado = enCurso;
       boolean enCombate = true;
        
        while (enCombate) {    
            int option = sc.nextInt();
            switch (option) {
            case 1:
                if(enCombate = true)
                {
                    System.out.println("Enemigo atacado");
                }
                restarVida(enemigo, heroe);
                System.out.println("El enemigo tiene "+enemigo.getVida());
                turnoConsumido = true;
                break;
            
            case 2:
                curarVida(null);
                turnoConsumido = true;
                break;
            case 3:
                

                break;
            case 4:
                resultado = huir();
                enCombate = true;
                break;
            default:
                break;
            
            }
        }
        return resultado;
    }
    public static int huir()
    {
        System.out.println("huyes de la batalla...");
        return abandono;
    }
    static final int abandono = 3;
    static final int puntosPorEnemigo = 100;
    static final int totalEnemigos = 3;
    public static int calcularPuntuacion(int enemigosDerrotados, int vidaactual )
    {
        int puntos = enemigosDerrotados * puntosPorEnemigo;
        if(enemigosDerrotados == totalEnemigos){
            puntos = puntos +  vidaactual;
        }
        return puntos;
    }
    public static boolean enemigoDerrotad(int vidaEnemigo)
    {
      return vidaEnemigo <= 0;
    }
    public static void restarVida(Enemigo enemigo, Heroe heroe)
    {
        if(enemigo.vivo())
        {
            heroe.setDaño(DanioHeroe());
           
            int enemigoVidaActual = enemigo.getVida();
            int vidaFin = enemigoVidaActual - heroe.getDaño();
            enemigo.setVida(vidaFin);
        }
        else{
            int vidaFin = 0;
            enemigo.setVida(vidaFin);
        }
    } 
    public static void restarVidaHeroe(Heroe heroe, Enemigo enemigo)
    {
        if(heroe.vivo())
        {
            enemigo.setDaño(DanioEnemigo());
            int HeroeVidaActual = heroe.getVida();
            int vidaFinal = HeroeVidaActual - enemigo.getDaño();
            heroe.setVida(vidaFinal);

        }else{
            int vidaFinal = 0;
            enemigo.setVida(vidaFinal);
        }
    }
    
    public static void main(String[] args)
    {
        int opcion;
        boolean repetir = true;
        Heroe heroe = new Heroe("Adrian", 0, 100, true);
        Enemigo enemigo = new Enemigo("Mordisco", 0, 40, 1);
        Enemigo villano = new Enemigo("Gorvak", 0, 60, 2);
        Enemigo Oscuro  = new Enemigo("Nerthal", 0, 80, 3);
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println(Inicio());
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Iniciando partdida....");
                    String heroenombre = nombreDelHeroe();
                    System.out.println(Historia());
                    heroe.setNombre(heroenombre);
                    System.out.println(batallaOpciones());
                    int resultado = accionesBatalla(heroe,enemigo);
                    repetir = false;
                    break;
                case 2:
                    break;
                case 3:
                    System.out.println(ayuda());
                    int opcionAyuda = sc.nextInt();
                    switch (opcionAyuda) {
                        case 1:
                            System.out.println(reglas());

                            repetir = false;
                            break;
                        case 2:
                            System.out.println(acciones());
                            repetir = false;
                            break;
                        case 3:
                            System.out.println(puntuaciones());
                            repetir = false;
                            break;
                        default:
                            break;
                    }
                    break;
                case 4:
                    System.out.println("Hasta luego");
                    break;
            }

        }while(repetir); 
            
        
    System.out.println("El nombre del heroe es: "+heroe.getNombre());
    }
    
    
}