public class Heroe 
{
    private String nombre;
    private String ataque;
    private int daño;
    private int curar;
    private String matar;
    private String morir;
    private String ganar;
    private int vida;

    public Heroe()
    {

    }
    public Heroe(String nombre, String ataque, int daño, int curar, String matar, String morir, String ganar, int vida)
    {
        this.nombre = nombre;
        this.ataque = ataque;
        this.daño = daño;
        this.curar = 25;
        this.matar = matar;
        this.morir = morir;
        this.ganar = ganar;
        this.vida = 100;
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
    public int getCurar() {
        return curar;
    }
    public void setCurar(int curar) {
        this.curar = curar;
    }
    public String getMatar() {
        return matar;
    }
    public void setMatar(String matar) {
        this.matar = matar;
    }
    public String getMorir() {
        return morir;
    }
    public void setMorir(String morir) {
        this.morir = morir;
    }
    public String getGanar() {
        return ganar;
    }
    public void setGanar(String ganar) {
        this.ganar = ganar;
    }
    public int getVida() {
        return vida;
    }
    public void setVida(int vida) {
        this.vida = vida;
    }
    public void mostrarDatosH()
    {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Ataque: " + this.ataque);
        System.out.println("Daño: " + this.daño);
        System.out.println("Te has curado: " + this.curar);
        System.out.println("Has sido derrotado: " + this.morir);

    }
}
