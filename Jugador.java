public class Jugador {
    private String nombre;
    private int vida;
    private int defensa;
    private int ataque;
    private int experiencia;
    private Clase rol;
    private Objetos objetoEquipado;

    public Jugador(String nombre, int vida, int defensa, int ataque, int experiencia, Clase rol) {
        this.nombre = nombre;
        this.vida = vida;
        this.defensa = defensa;
        this.ataque = ataque;
        this.experiencia = experiencia;
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public Clase getRol() {
        return rol;
    }

    public void setRol(Clase rol) {
        this.rol = rol;
    }

    public int calcularAtaque(int skill){
        int poderAtaque = (int) Math.round(1 + ((ataque * rol.getMultiplicadorDaño()) * (rol.getHabilidades().get(skill).getPoder() * 0.0012)));
        return poderAtaque;//45 a 15 de ataque por ataque y clase se multiplica por la potencia por un 1.2%
    }
}
