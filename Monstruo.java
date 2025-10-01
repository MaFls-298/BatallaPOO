import java.util.Random;

public class Monstruo {
    Random rand = new Random();
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

    public String recivirDaño(int poder){//proximamente pedir tipo para multiplicador
        System.out.println(poder);
        int vidaquitada = 0;
        String ataqueCrit = "";
        String nuevaDefensa;
        System.out.println(nombre+ " vida: "+ vida);

        
        if (rand.nextInt(10)==1) {
            vidaquitada = defensa-2*(poder);    
            ataqueCrit = "ATAQUE CRITICO    ";        
        }else{
            vidaquitada = defensa-(poder);            
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

}
