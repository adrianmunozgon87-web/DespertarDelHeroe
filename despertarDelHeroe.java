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
    public static String[] crearInventario()
    {
        String [] inventario = {"pocion", "pocion", "pocion"};
         return inventario;
            
    }
   
    public static void mostrarInventario( String [] crearInventario)
    {
        int pociones = 3;
        for ( int i = 0 ; i< crearInventario.length; i ++)
        {
            if (crearInventario [i] == null)
            {
                System.out.println("Hueco " + (i+1) + ": "+ "vacio");
            }
            else{
                System.out.println("Hueco " + (i+1) + ": "+ crearInventario[i]);
            }
        }
        
    }
    public static void usarPocion(String [] crearInventario)
    {
        for (int i = 0; i< crearInventario.length; i++){
            if(crearInventario[i] != null)
            {
                crearInventario[i] = null;
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
        int vidaMaximaDelHeroe = 100;
        if(vidaactual > vidaMaximaDelHeroe){
            vidaactual = vidaMaximaDelHeroe;
        }
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
    public static void Historia()
    {
        
        System.out.println("Durante cien años, el reino de Eldrath vivió en paz bajo la luz de la Llama Eterna. Pero una noche el fuego se apagó, y de las sombras del bosque surgieron criaturas que nadie había visto jamás.");
            esperar(2);
        System.out.println("Tú eres un joven sin nombre ni fama, y hoy despiertas en una cabaña abandonada, con una espada oxidada y tres pociones que dejó un viejo curandero.");
            esperar(2);
        System.out.println("Tres enemigos te esperan en el camino hacia la Llama. Cada uno es más fuerte que el anterior. ¿Despertará el héroe que llevas dentro?");
            esperar(2);
        System.out.println("El camino hacia la Llama Eterna se estrecha entre árboles retorcidos. El aire huele a ceniza y, a lo lejos, algo se mueve entre las sombras.");
            esperar(2);
        System.out.println("Aprietas la empuñadura de tu espada oxidada. No hay vuelta atrás: el enemigo te ha visto.");
            esperar(2);
        System.out.println(" ¡Comienza la batalla!");
            esperar(2);
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
    public static String batallaOpciones(Heroe heroe, Enemigo enemigo)
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
        boolean turnoConsumido = false;
       int resultado = enCurso;
       boolean enCombate = true;
        
        while (enCombate) {  
            System.out.println(batallaOpciones(heroe, enemigo));  
            int option = sc.nextInt();
            switch (option) {
            case 1:
                
                
                System.out.println("Atacando...");
                
                restarVida(enemigo, heroe);
                System.out.println("El enemigo tiene " + enemigo.getVida() + " de vida");
                turnoConsumido = true;
                break;
            
            case 2:
                curarVida(heroe);
                System.out.println("El heroe se ha curado y tiene " +heroe.getVida());
                usarPocion(crearInventario());
                turnoConsumido = true;
                break;
            case 3:
                String [] inventario = crearInventario();
                mostrarInventario(inventario);
                turnoConsumido = false;

                break;
            case 4:
                resultado = huir();
                enCombate = false;
                break;
            default:
                System.out.println("Has introducido un caracter incorrecto");
            
                break;
            
            }
            if(turnoConsumido && enemigo.vivo() && heroe.vivo())
        {
            System.out.println(" TURNO  DEL ENEMIGO");
            enemigo.setDanio(DanioEnemigo());
            int HeroeVidaActual = heroe.getVida();
            System.out.println("Vida del heroe antes: " + HeroeVidaActual);
            int vidaFinal = HeroeVidaActual - enemigo.getDanio();
            if(vidaFinal < 0)
            {
                vidaFinal = 0;
            }
            heroe.setVida(vidaFinal);
            System.out.println("Vida del heroe despues: " + heroe.getVida());
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
            heroe.setDanio(DanioHeroe());
           
            int enemigoVidaActual = enemigo.getVida();
            int vidaFin = enemigoVidaActual - heroe.getDanio();
        
            if(vidaFin <0){
                vidaFin = 0;
            }
            enemigo.setVida(vidaFin);
        }

       
        
    }
    
    public static void esperar(int segundos)
    
    {
        try
        {
            Thread.sleep(segundos * 1000);
        }
        catch(InterruptedException e)
        {
            System.out.println("Se ha interrumpido la espera");
        }
    }
    public static void Historia2()
    {
        System.out.println("El enemigo cae al suelo y su cuerpo se convierte poco a poco en cenizas oscuras. Por un instante, el bosque queda en silencio. Respiras profundamente y limpias tu espada, consciente de que has superado tu primera prueba.");
        esperar(2);
        System.out.println("Entre los restos de la criatura encuentras un pequeño fragmento brillante que desprende un calor extraño. Al acercarlo a tu mano, una tenue luz dorada ilumina el camino que tienes delante.");
        esperar(2);
        System.out.println("Pero la tranquilidad dura poco. Un rugido profundo retumba entre los árboles. Algo mucho más grande te está esperando.");
        esperar(2);
        System.out.println("Aprietas tu espada y continúas avanzando. La Llama Eterna aún necesita un héroe.");
        esperar(2);
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
                    Historia();
                    heroe.setNombre(heroenombre);
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
                    repetir = false;
                    break;
            }

        }while(repetir); 
            
        
    }
    
    
}