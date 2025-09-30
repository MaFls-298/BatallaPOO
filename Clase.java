import java.util.*;

public class Clase {

    private String nombre;
    private int multiplicadorVida;
    private int multiplicadorDaño;
    private int multiplicadorDefensa;
    private int cantidadMana;
    private List<Habilidades> habilidades;

        
    public Clase(String nombre, int multiplicadorVida, int multiplicadorDaño, int multiplicadorDefensa, int cantidadMana, List<Habilidades> habilidades) {
        this.nombre = nombre;
        this.multiplicadorVida = multiplicadorVida;
        this.multiplicadorDaño = multiplicadorDaño;
        this.multiplicadorDefensa = multiplicadorDefensa;
        this.cantidadMana = cantidadMana;
        this.habilidades = habilidades;
    }

    public String getNombre() {
        return nombre;
    }

    public double getMultiplicadorVida() {
        return multiplicadorVida;
    }

    public double getMultiplicadorDaño() {
        return multiplicadorDaño;
    }

    public double getMultiplicadorDefensa() {
        return multiplicadorDefensa;
    }

    public int getCantidadMana() {
        return cantidadMana;
    }

    public List<Habilidades> getHabilidades() {
        return habilidades;
    }
    
}
