public class Personaje
{
    private String nombre;
    private String ataque;
    private int daño;
    

    public Personaje (String nombre, String ataque, int daño )
    {
        this.nombre = nombre;
        this.ataque = ataque;
        this.daño = daño;
        
    }
   
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getAtaque() {
        return ataque;
    }
    public void setAtaque(String ataque) {
        this.ataque = ataque;
    }
    public int getDaño() {
        return daño;
    }
    public void setDaño(int daño) {
        this.daño = daño;
    }
   
        
    
  
   
    public void mostrarDatosH()
    {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Ataque: " + this.ataque);
        System.out.println("Daño: " + this.daño);
       

    }
}
