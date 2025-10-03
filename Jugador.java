import java.util.Random;

public class Jugador {
    private String nombre;
    private int vida;
    private int defensa;
    private int ataque;
    private int mana;
    private int experiencia;
    private Clase rol;
    private Objetos objetoEquipado;
    private Random rand = new Random();


    public Jugador(String nombre, int vida, int defensa, int ataque,int mana, int experiencia, Clase rol) {
        this.nombre = nombre;
        this.vida = vida;
        this.defensa = defensa;
        this.ataque = ataque;
        this.mana = mana;
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
    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia += experiencia;
    }

    public Clase getRol() {
        return rol;
    }

    public void setRol(Clase rol) {
        this.rol = rol;
    }

    public int calcularAtaque(int skill){
        int poderAtaque = (int) Math.round(1 + (ataque * (rol.getHabilidades().get(skill).getPoder() * 0.01)));
        return poderAtaque;//45 a 15 de ataque por ataque y clase se multiplica por la potencia por un 1.2%
    }



    public String recivirDaño(int poder){//proximamente pedir tipo para multiplicador
        int vidaquitada = 0;
        String ataqueCrit = "";
        String nuevaDefensa;

        
        if (rand.nextInt(10)==1) {
            vidaquitada = (int) Math.round(((40+rand.nextInt(61))*0.01)*(defensa))-2*(poder);      
            ataqueCrit = "ATAQUE CRITICO    ";        
        }else{
            vidaquitada = (int) Math.round(((40+rand.nextInt(61))*0.01)*(defensa))-(poder);              
        }
        if (vidaquitada >= 0) {
            return ataqueCrit+"La defensa del jugador "+nombre+" neutralizo el ataque";
        }else{
            vida = vida+vidaquitada;            
        }
        if (vida <= 0) {
            return ataqueCrit+"El jugador "+nombre+" ha caido";
        }else{
            return ataqueCrit+"El jugador "+nombre+" ha sido dañado";
        }
    }

    public String calcularCuracion(Clase rolCurador, int mana){
        int vidamax = (int) Math.round(rol.getMultiplicadorVida()*5);
        int vidaSumada = (int) Math.round((5*rolCurador.getMultiplicadorVida()*mana)*0.017);
        this.vida = this.vida + vidaSumada;
        if (this.vida > vidamax) {
            this.vida = vidamax;
        }
        return"El aliado ha recuperado:  " + vidaSumada;
    }

    public void equiparObjeto(Objetos objetoN){
        if (objetoEquipado == null) {
            
        }else{

        }
    }
}
