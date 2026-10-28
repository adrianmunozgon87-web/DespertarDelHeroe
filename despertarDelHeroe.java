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
        +"  -Atacar"
        +"  -Curarte"
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
    public static int DañoHeroe()
    {
        Random random = new Random();
        int dañoHeroe = random.nextInt(10-20);
        return dañoHeroe;

    }
    public static int DañoEnemigo()
    {
        Random random = new Random();
        int dañoEnemigo = random.nextInt(5-15);
        return dañoEnemigo;
    }

    public static void main(String[] args)
    {
        int opcion;
        boolean repetir = true;
        Heroe heroe = new Heroe("Adrian", 0, 100);
        Enemigo enemigo = new Enemigo("Zaid", 0, 40, 1);
        Enemigo villano = new Enemigo("ehle", 0, 60, 2);
        Enemigo Oscuro  = new Enemigo("dñhgol", 0, 80, 3);
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println(Inicio());
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Iniciando partdida....");
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
                        case 3:
                            System.out.println(puntuaciones());
                            repetir = false;
                        default:
                            break;
                    }
                    break;
                case 4:
                    break;
            }

        }while(repetir); 
            
        
    }

}