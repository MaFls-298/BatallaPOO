public class Habilidades {
    private String nombre;
    private String tipo;
    private int poder;
    private int acierto;

    public Habilidades(String nombre, String tipo, int poder, int acierto) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.poder = poder;
        this.acierto = acierto;
    }

    public String getNombre() {
        return nombre;
    }
    public String getTipo(){
        return tipo;
    }

    public int getPoder() {
        return poder;
    }

    public int getAcierto() {
        return acierto;
    }

    public void setAcierto(int acierto) {
        this.acierto = acierto;
    }

    public void setPoder(int poder) {
        this.poder = poder;
    }

}
