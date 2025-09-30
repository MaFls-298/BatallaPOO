public class Monstruo {
    private String nombre;
    private String tipo;
    private int vida;
    private int defensa;
    private int ataque;
    private Objetos Objeto;
    private int monedas;

    public Monstruo(String nombre, String tipo, int vida, int defensa, int ataque, Objetos objeto, int monedas) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.vida = vida;
        this.defensa = defensa;
        this.ataque = ataque;
        this.Objeto = objeto;
        this.monedas = monedas;
    }

    public String getNombre() {
        return nombre;
    }
    public String getTipo() {
        return tipo;
    }

    public int getVida() {
        return vida;
    }

    public int getDefensa() {
        return defensa;
    }

    public int getAtaque() {
        return ataque;
    }

    public Objetos getObjeto() {
        return Objeto;
    }

    public int getMonedas() {
        return monedas;
    }

}
