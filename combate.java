import java.util.*;

public class combate {

    private static controlador control = new controlador();

    public static void main(String[] args) {
        boolean equipolisto = false;
        int Jugadores = 0;
        Scanner escaner = new Scanner(System.in);

        
        String nombreNuevo;

        System.out.println(" //----- The Legend Of Pablo -----//");
        System.out.print("Ingresa nombre de la partida: ");
        String nombre = escaner.nextLine();

        while (!equipolisto) {
            System.out.println("Cantidad de Jugadores 1-4");
            Jugadores = escaner.nextInt();
            if (Jugadores > 4) {
                System.out.println("ingrese un numero del 1 al 4");
            } else {
                equipolisto = true;
            }
        }
        nombre = escaner.nextLine();

        for (int i = 0; i < Jugadores; i++) {
            System.out.println("ingrese el nombre del jugador " + (i + 1) + ":");
            nombreNuevo = escaner.nextLine();
            control.crearJugador(nombreNuevo);
        }

        // controlador.generarEquipoAleatorio();

        int opcion = 0;

        while (true) {
            if (control.oleadaViva) {
                
            }else{
                control.generarOleada();
            }

            System.out.println();
            System.out.println("-------Menú Principal--------");
            System.out.println("1) Ver equipo");
            System.out.println("2) Ver Enemigos");
            System.out.println("3) Atacar");
            System.out.println("4) Objetos");
            System.out.print("Elige una opción: ");

            opcion = escaner.nextInt();

            switch (opcion) {
                case 1:
                    for (int i = 0; i < Jugadores; i++) {
                        System.out.println();
                        System.out.println(control.verEquipo(i+1).getNombre());
                        System.out.println("Rol: "+ 
                        (control.verEquipo(i+1).getRol().getNombre())+" Vida: "+
                        control.verEquipo(i+1).getVida()+" Ataque: "+
                        control.verEquipo(i+1).getAtaque()+" defensa: "+
                        control.verEquipo(i+1).getDefensa()+" Mana: "+
                        control.verEquipo(i+1).getMana()+" EXP: "+
                        control.verEquipo(i+1).getExperiencia());
                        System.out.println("Skills: ");
                        for (int j = 0; j < control.verEquipo(i+1).getRol().getHabilidades().size(); j++) {
                            System.out.print(""+control.verEquipo(i+1).getRol().getHabilidades().get(j).getNombre()+" tipo:"+
                            control.verEquipo(i+1).getRol().getHabilidades().get(j).getTipo()+" poder:"+
                            control.verEquipo(i+1).getRol().getHabilidades().get(j).getPoder()+" acierto:"+
                            control.verEquipo(i+1).getRol().getHabilidades().get(j).getAcierto()
                            );
                            System.out.println("");
                        }
                        
                    }
                    break;
                case 2:
                
                    for (int i = 0; i < 5; i++) {
                        
                            System.out.println();
                            System.out.println(control.getEnemigo(i+1).getNombre());
                            System.out.println("Tipo: "+ 
                            (control.getEnemigo(i+1).getTipo())+" Vida: "+
                            (control.getEnemigo(i+1).getVida())+" Ataque: "+
                            (control.getEnemigo(i+1).getAtaque())+" defensa: "+
                            (control.getEnemigo(i+1).getDefensa())+ " Objeto: "+
                            control.getEnemigo(i+1).getObjeto().getNombre());

                    }

                    break;
                case 3:
                for (int i = 0; i < Jugadores; i++) {    
                    System.out.println();
                    System.out.println("------Jugador "+(i+1)+"-------ATACAR A:");
                    System.out.println("    1) "+ control.getEnemigo(1).getNombre()+" Vida: " + control.getEnemigo(1).getVida());
                    System.out.println("    2) "+ control.getEnemigo(2).getNombre()+" Vida: " + control.getEnemigo(2).getVida());
                    System.out.println("    3) "+ control.getEnemigo(3).getNombre()+" Vida: " + control.getEnemigo(3).getVida());
                    System.out.println("    4) "+ control.getEnemigo(4).getNombre()+" Vida: " + control.getEnemigo(4).getVida());
                    System.out.println("    5) "+ control.getEnemigo(5).getNombre()+" Vida: " + control.getEnemigo(5).getVida());
                    System.out.print("  Elige una opción: ");
                    int objetivo = escaner.nextInt();
                    if (objetivo > 5 || objetivo <0) {
                        System.out.println("ERROR ELIJA UN NUMERO DEL 1 AL 5");
                        break;
                    }
                    System.out.println("------Jugador "+(i+1)+"-------Elejir Habilidad:");
                    System.out.println("        1) "+ control.verEquipo(i+1).getRol().getHabilidades().get(0).getNombre()+" Poder: "+control.verEquipo(i+1).getRol().getHabilidades().get(0).getPoder() +" Acierto: " + control.verEquipo(i+1).getRol().getHabilidades().get(0).getAcierto());
                    System.out.println("        2) "+ control.verEquipo(i+1).getRol().getHabilidades().get(1).getNombre()+" Poder: "+control.verEquipo(i+1).getRol().getHabilidades().get(1).getPoder() +" Acierto: " + control.verEquipo(i+1).getRol().getHabilidades().get(1).getAcierto());
                    System.out.println("        3) "+ control.verEquipo(i+1).getRol().getHabilidades().get(2).getNombre()+" Poder: "+control.verEquipo(i+1).getRol().getHabilidades().get(2).getPoder() +" Acierto: " + control.verEquipo(i+1).getRol().getHabilidades().get(2).getAcierto());
                    System.out.println("        4) "+ control.verEquipo(i+1).getRol().getHabilidades().get(3).getNombre()+" Poder: "+control.verEquipo(i+1).getRol().getHabilidades().get(3).getPoder() +" Acierto: " + control.verEquipo(i+1).getRol().getHabilidades().get(3).getAcierto());
                    System.out.print("  Elige una opción: ");
                    int objetivoAtaque = escaner.nextInt();
                    if (objetivoAtaque > 5 || objetivo <0) {
                        System.out.println("ERROR ELIJA UN NUMERO DEL 1 AL 4");
                        break;
                    }
                    

                    System.out.println(control.atacar(objetivo, i+1,objetivoAtaque-1)); 
                    
                }
                    break;
                case 4:
                    System.out.println("Cerrando juego");
                    System.out.println("");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }

    }
}
