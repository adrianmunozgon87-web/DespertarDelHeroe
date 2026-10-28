public class Enemigo  extends Personaje
{
    private int nivel;
    public Enemigo(String nombre, int ataque, int daño)
    {
       super(nombre, nombre, daño);
       this.nivel = nivel;
    }
    public int getNivel() {
        return nivel;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}
