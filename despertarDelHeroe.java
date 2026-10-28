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
}