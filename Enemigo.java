public class Enemigo  extends Personaje
{
    private int nivel;
    public Enemigo(String nombre, int danio, int vida, int nivel)
    {
       super(true, nombre, danio, vida);
       this.nivel = nivel;
    }
    public int getNivel() {
        return nivel;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
}
