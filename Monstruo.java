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
        System.out.println(poder);
        int vidaquitada = 0;
        String ataqueCrit = "";
        
        if (rand.nextInt(10)==1) {
            vidaquitada = (int) Math.round(((50+rand.nextInt(51))*0.01)*(defensa+objeto.getDefensaGanada()))-2*(poder);    
            ataqueCrit = "ATAQUE CRITICO    ";        
        }else{
            vidaquitada = (int) Math.round(((50+rand.nextInt(51))*0.01)*(defensa+objeto.getDefensaGanada()))-(poder);           
        }
        if (vidaquitada >= 0) {
            return ataqueCrit+"La defensa del enemigo neutralizo el ataque";
        }else{
            System.out.println("vida: "+ vida);
            System.out.println(" vida quitada "+ vidaquitada);
            vida = vida+vidaquitada;            
        }
        if (vida <= 0) {
            return ataqueCrit+"El enemigo ha caido";
        }else{
            return ataqueCrit+"El enemigo ha sido dañado";
        }
    }

    public int calcularAtaque(){
        int poderAtaque = (int) Math.round(1 + (ataque * ((20+ rand.nextInt(90)) * 0.01)));
        return poderAtaque;
    }

}
