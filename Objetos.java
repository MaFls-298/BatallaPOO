public class Objetos {
    private String nombre;
    private int vidaGanada;
    private int defensaGanada;
    private int ataqueGanado;
    private int manaGanado;
    private boolean unUso;
    private int rareza;

    public Objetos(String nombre, int vidaGanada, int defensaGanada, int ataqueGanado, int manaGanado, boolean unUso, int rareza) {
        this.nombre = nombre;
        this.vidaGanada = vidaGanada;
        this.defensaGanada = defensaGanada;
        this.ataqueGanado = ataqueGanado;
        this.manaGanado = manaGanado;
        this.unUso = unUso;
        this.rareza = rareza;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVidaGanada() {
        return vidaGanada;
    }

    public int getDefensaGanada() {
        return defensaGanada;
    }

    public int getAtaqueGanado() {
        return ataqueGanado;
    }

    public int getManaGanado() {
        return manaGanado;
    }
    public boolean getUnUso() {
        return unUso;
    }
    public int getRareza() {
        return rareza;
    }

    public void efectoEspecial(){

    }
    
}
