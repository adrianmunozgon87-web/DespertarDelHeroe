public class Enemigo  extends Personaje
{
    private int nivel;
    public Enemigo(String nombre, int daño, int vida, int nivel)
    {
       super(nombre, daño, vida);
       this.nivel = nivel;
    }
    public int getNivel() {
        return nivel;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
}
