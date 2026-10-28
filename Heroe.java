public class Heroe  extends Personaje
{
private int curar;
public Heroe(String nombre, String ataque, int daño)
{
    super(nombre, ataque, daño);
    this.curar = curar;
}
public int getCurar() {
    return curar;
}
public void setCurar(int curar) {
    this.curar = curar;
}
}
