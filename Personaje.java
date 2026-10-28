public class Personaje
{
    private String nombre;
    private String ataque;
    private int daño;
    private int vida;

    public Personaje (String nombre, int daño, int vida)
    {
        this.nombre = nombre;
        this.daño = daño;
        this.vida = vida;
        
    }
   
    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getDaño() {
        return daño;
    }
    public void setDaño( int daño) {
        this.daño = daño;
    }
   
        
    
  
   
    public void mostrarDatosH()
    {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Ataque: " + this.ataque);
        System.out.println("Daño: " + this.daño);
       

    }
}
