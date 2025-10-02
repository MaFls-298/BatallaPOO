import java.util.Random;

public class Monstruo {
    Random rand = new Random();
    private String nombre;
    private String tipo;
    private int vida;
    private int defensa;
    private int ataque;
    private Objetos objeto;
    private int monedas;

    public Monstruo(String nombre, String tipo, int vida, int defensa, int ataque, Objetos objeto, int monedas) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.vida = vida + objeto.getVidaGanada();
        this.defensa = defensa + objeto.getDefensaGanada();
        this.ataque = ataque + objeto.getAtaqueGanado();
        this.objeto = objeto;
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
        return objeto;
    }

    public int getMonedas() {
        return monedas;
    }

    public String recivirDaño(int poder){//proximamente pedir tipo para multiplicador
        int vidaquitada = 0;
        String ataqueCrit = "";
        int multiplicador = 1;
        
        if (rand.nextInt(10)==1) {
            vidaquitada = (int) Math.round(((20+rand.nextInt(81))*0.01)*(defensa+objeto.getDefensaGanada()))-2*(poder);    
            ataqueCrit = "ATAQUE CRITICO    ";   
            multiplicador = 2;     
        }else{
            vidaquitada = (int) Math.round(((20+rand.nextInt(81))*0.01)*(defensa+objeto.getDefensaGanada()))-(poder);           
        }
        if (vidaquitada >= 0) {
            return ataqueCrit+"La defensa del enemigo neutralizo el ataque      daño hecho: "+(poder*multiplicador);
        }else{
            vida = vida+vidaquitada;            
        }
        if (vida <= 0) {
            return ataqueCrit+"El enemigo ha caido      daño hecho: "+(poder*multiplicador);
        }else{
            return ataqueCrit+"El enemigo ha sido dañado        daño hecho: "+(poder*multiplicador);
        }
    }

    public int calcularAtaque(){
        int poderAtaque = (int) Math.round(1 + (ataque * ((30+ rand.nextInt(80)) * 0.01)));
        return poderAtaque;
    }

}
