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
    
    public static void curarVida(Heroe heroe)
    {
       
        int vidaactual = heroe.getVida();
        vidaactual += 25;
        heroe.setVida(vidaactual);
    }
    public static void main(String[] args)
    {
        Heroe heroe = new Heroe("Adrian", 0, 100);
        Enemigo enemigo = new Enemigo("Zaid", 0, 40, 1);
        Enemigo villano = new Enemigo("ehle", 0, 60, 2);
        Enemigo Oscuro  = new Enemigo("dñhgol", 0, 80, 3);
    }
}