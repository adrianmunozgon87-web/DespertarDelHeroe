public class Personaje
{
    private String nombre;
    private String ataque;
    private int danio;
    private int vida;
    private boolean vivo;

    public Personaje ( boolean vivo, String nombre, int danio, int vida)
    {
        this.nombre = nombre;
        this.danio = danio;
        this.vida = vida;
        this.vivo = vivo;
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
    public int getDanio() {
        return danio;
    }
    public void setDanio( int danio) {
        this.danio = danio;
    }
   
        
    
  
   
    public void mostrarDatosH()
    {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Ataque: " + this.ataque);
        System.out.println("Danio: " + this.danio);
       

    }
    public boolean vivo()
    {
        return vida > 0;
    }
}
