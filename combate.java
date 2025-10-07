import java.util.*;

public class combate {

    private static controlador control = new controlador();

    public static void main(String[] args) {
        boolean equipolisto = false;

        Random rand = new Random();
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
        // bt vercion2000

        int opcion = 0;

        while (true) {
            if (control.oleadaViva) {

            } else {
                control.generarOleada();
            }

            System.out.println();
            System.out.println("-------Menú Principal--------");
            System.out.println("1) Ver equipo");
            if (control.getTienda()) {
                System.out.println("2) Comprar");
                System.out.println("3) Objetos");
            } else {
                System.out.println("2) Ver Enemigos");
                System.out.println("3) Atacar");
                System.out.println("4) Objetos");
            }
            System.out.print("Elige una opción: ");
            
            opcion = escaner.nextInt();
            
            if (control.getTienda() && opcion == 2) {
                opcion = 3;
            } else if (control.getTienda() && opcion == 3) {
                opcion = 4;
            }         
            

            switch (opcion) {
                case 1:
                    for (int i = 0; i < Jugadores; i++) {
                        System.out.println();
                        System.out.println(control.verEquipo(i + 1).getNombre());
                        System.out.println("Rol: " +
                                (control.verEquipo(i + 1).getRol().getNombre()) + " Vida: " +
                                control.verEquipo(i + 1).getVida() + " Ataque: " +
                                control.verEquipo(i + 1).getAtaque() + " defensa: " +
                                control.verEquipo(i + 1).getDefensa() + " Mana: " +
                                control.verEquipo(i + 1).getMana() + " EXP: " +
                                control.verEquipo(i + 1).getExperiencia());
                        System.out.println("Skills: ");
                        for (int j = 0; j < control.verEquipo(i + 1).getRol().getHabilidades().size(); j++) {
                            System.out.print("" + control.verEquipo(i + 1).getRol().getHabilidades().get(j).getNombre()
                                    + " tipo:" +
                                    control.verEquipo(i + 1).getRol().getHabilidades().get(j).getTipo() + " poder:" +
                                    control.verEquipo(i + 1).getRol().getHabilidades().get(j).getPoder() + " acierto:" +
                                    control.verEquipo(i + 1).getRol().getHabilidades().get(j).getAcierto());
                            System.out.println("");
                        }

                    }
                    break;
                case 2:

                    for (int i = 0; i < 5; i++) {

                        System.out.println();
                        System.out.println(control.getEnemigo(i + 1).getNombre());
                        System.out.println("Tipo: " +
                                (control.getEnemigo(i + 1).getTipo()) + " Vida: " +
                                (control.getEnemigo(i + 1).getVida()) + " Ataque: " +
                                (control.getEnemigo(i + 1).getAtaque()) + " defensa: " +
                                (control.getEnemigo(i + 1).getDefensa()) + " Objeto: " +
                                control.getEnemigo(i + 1).getObjeto().getNombre());

                    }

                    break;
                case 3:
                    if (!control.getTienda()) {
                        for (int i = 0; i < Jugadores; i++) {
                            if (control.verEquipo(i + 1).getVida() > 0) {
                                System.out.println();
                                System.out.println("------Jugador " + control.verEquipo(i + 1).getNombre()
                                        + "-------Elejir Habilidad:");
                                System.out.println("      1) "
                                        + control.verEquipo(i + 1).getRol().getHabilidades().get(0).getNombre()
                                        + " Poder: "
                                        + control.verEquipo(i + 1).getRol().getHabilidades().get(0).getPoder()
                                        + " Acierto: "
                                        + control.verEquipo(i + 1).getRol().getHabilidades().get(0).getAcierto());
                                System.out.println("      2) "
                                        + control.verEquipo(i + 1).getRol().getHabilidades().get(1).getNombre()
                                        + " Poder: "
                                        + control.verEquipo(i + 1).getRol().getHabilidades().get(1).getPoder()
                                        + " Acierto: "
                                        + control.verEquipo(i + 1).getRol().getHabilidades().get(1).getAcierto());
                                System.out.println("      3) "
                                        + control.verEquipo(i + 1).getRol().getHabilidades().get(2).getNombre()
                                        + " Poder: "
                                        + control.verEquipo(i + 1).getRol().getHabilidades().get(2).getPoder()
                                        + " Acierto: "
                                        + control.verEquipo(i + 1).getRol().getHabilidades().get(2).getAcierto());
                                System.out.println("      4) "
                                        + control.verEquipo(i + 1).getRol().getHabilidades().get(3).getNombre()
                                        + " Poder: "
                                        + control.verEquipo(i + 1).getRol().getHabilidades().get(3).getPoder()
                                        + " Acierto: "
                                        + control.verEquipo(i + 1).getRol().getHabilidades().get(3).getAcierto());
                                System.out.print("  Elige una opción: ");
                                int objetivoAtaque = escaner.nextInt();
                                if (objetivoAtaque > 4 || objetivoAtaque < 0) {
                                    System.out.println("ERROR ELIJA UN NUMERO DEL 1 AL 4");
                                    break;
                                }
                                if (control.verEquipo(i + 1).getRol().getHabilidades().get(objetivoAtaque - 1)
                                        .getPoder() <= 0) {
                                    System.out.println("------Jugador " + control.verEquipo(i + 1).getNombre()
                                            + "-------CURAR A:");
                                    if (control.verEquipo(1) != null) {
                                        System.out.println("    1) " + control.verEquipo(1).getNombre() + " Vida: "
                                                + control.verEquipo(1).getVida());
                                    }
                                    if (control.verEquipo(2) != null) {
                                        System.out.println("    2) " + control.verEquipo(2).getNombre() + " Vida: "
                                                + control.verEquipo(2).getVida());
                                    }
                                    if (control.verEquipo(3) != null) {
                                        System.out.println("    3) " + control.verEquipo(3).getNombre() + " Vida: "
                                                + control.verEquipo(3).getVida());
                                    }
                                    if (control.verEquipo(4) != null) {
                                        System.out.println("    4) " + control.verEquipo(4).getNombre() + " Vida: "
                                                + control.verEquipo(4).getVida());
                                    }
                                    System.out.print("  Elige una opción: ");
                                    int objetivo = escaner.nextInt();
                                    System.out.println(control.curar(objetivo, control.verEquipo(i + 1).getRol(),
                                            control.verEquipo(i + 1).getMana(), control.verEquipo(i + 1).getRol()
                                                    .getHabilidades().get(objetivoAtaque - 1).getAcierto()));
                                } else {
                                    System.out.println("------Jugador " + control.verEquipo(i + 1).getNombre()
                                            + "-------ATACAR A:");
                                    System.out.println("        1) " + control.getEnemigo(1).getNombre() + " Vida: "
                                            + control.getEnemigo(1).getVida());
                                    System.out.println("        2) " + control.getEnemigo(2).getNombre() + " Vida: "
                                            + control.getEnemigo(2).getVida());
                                    System.out.println("        3) " + control.getEnemigo(3).getNombre() + " Vida: "
                                            + control.getEnemigo(3).getVida());
                                    System.out.println("        4) " + control.getEnemigo(4).getNombre() + " Vida: "
                                            + control.getEnemigo(4).getVida());
                                    System.out.println("        5) " + control.getEnemigo(5).getNombre() + " Vida: "
                                            + control.getEnemigo(5).getVida());
                                    System.out.print("  Elige una opción: ");
                                    int objetivo = escaner.nextInt();
                                    if (objetivo > 5 || objetivo < 0) {
                                        System.out.println("ERROR ELIJA UN NUMERO DEL 1 AL 5");
                                        break;
                                    }
                                    System.out.println(control.atacar(objetivo, i + 1, objetivoAtaque - 1));

                                }

                            } else {

                                
                            }

                        }
                    }else{
                        System.out.println("");
                                System.out.println("TODOS LOS JUGADORES HAN RECUPERADO SU SALUD MAXIMA");
                                for (int j = 0; j < Jugadores; j++) {
                                    System.out.println(control.verEquipo(j + 1).getNombre());
                                    System.out.println(control.verEquipo(j + 1).calcularCuracion(control.verEquipo(j + 1).getRol(), 1000));
                                }
                                for (int i = 0; i < Jugadores; i++) {
                                    
                                    System.out.println("------TIENDAv"+i+" de: "+Jugadores+"-------Elejir una opcion:");
                                    Objetos objeto1 = control.obtenerObjetoAleatorioPorTier();
                                    Objetos objeto2 = control.obtenerObjetoAleatorioPorTier();
                                    Objetos objeto3 = control.obtenerObjetoAleatorioPorTier();
                                    Objetos objeto4 = control.obtenerObjetoAleatorioPorTier();
                                    int precio1 = 3+(objeto1.getRareza()*5) + (int) Math.round((objeto1.getRareza()*9)*((5+rand.nextInt(10))*0.1));
                                    int precio2 = 3+(objeto2.getRareza()*5) + (int) Math.round((objeto2.getRareza()*9)*((5+rand.nextInt(10))*0.1));
                                    int precio3 = 3+(objeto3.getRareza()*5) + (int) Math.round((objeto3.getRareza()*9)*((5+rand.nextInt(10))*0.1));
                                    int precio4 = 3+(objeto4.getRareza()*5) + (int) Math.round((objeto4.getRareza()*9)*((5+rand.nextInt(10))*0.1));
                                    System.out.println("      1) " + objeto1.getNombre() + " Vida: "
                                            + objeto1.getVidaGanada() + " Ataque: " + objeto1.getAtaqueGanado()
                                            + " Defensa: " + objeto1.getDefensaGanada() + " Mana: "
                                            + objeto1.getManaGanado() + " Rareza: " + objeto1.getRareza() + " Precio: "
                                            + precio1);
                                            System.out.println("      2) " + objeto2.getNombre() + " Vida: "
                                                    + objeto2.getVidaGanada() + " Ataque: " + objeto2.getAtaqueGanado()
                                                    + " Defensa: " + objeto2.getDefensaGanada() + " Mana: "
                                                    + objeto2.getManaGanado() + " Rareza: " + objeto2.getRareza() + " Precio: "
                                                    + precio2);
                                            System.out.println("      3) " + objeto3.getNombre() + " Vida: "
                                                    + objeto3.getVidaGanada() + " Ataque: " + objeto3.getAtaqueGanado()
                                                    + " Defensa: " + objeto3.getDefensaGanada() + " Mana: "
                                                    + objeto3.getManaGanado() + " Rareza: " + objeto3.getRareza() + " Precio: "
                                                    + precio3);
                                            System.out.println("      4) " + objeto4.getNombre() + " Vida: "
                                                    + objeto4.getVidaGanada() + " Ataque: " + objeto4.getAtaqueGanado()
                                                    + " Defensa: " + objeto4.getDefensaGanada() + " Mana: "
                                                    + objeto4.getManaGanado() + " Rareza: " + objeto4.getRareza() + " Precio: "
                                                    + precio4);
                                            System.out.println("      5) Saltar Tienda");
                                            System.out.print("  Elige una opción: ");
                                            int objetivoAtaque = escaner.nextInt();
                                            int coste = 0;
                                            Objetos onjetoElejido = null;
                                            switch (objetivoAtaque) {
                                                case 1:
                                                    onjetoElejido = objeto1;
                                                    coste = precio1;
                                                    break;
                                                case 2:
                                                    onjetoElejido = objeto2;
                                                    coste = precio2;
            
                                                    break;
                                                case 3:
                                                    onjetoElejido = objeto3;
                                                    coste = precio3;
            
                                                    break;
                                                case 4:
                                                    onjetoElejido = objeto4;
                                                    coste = precio4;
            
                                                    break;
            
                                                default:
                                                    break;
                                            }
                                            if (objetivoAtaque > 5 || objetivoAtaque < 0) {
                                                System.out.println("ERROR ELIJA UN NUMERO DEL 1 AL 4");
                                                break;
                                            } else if (objetivoAtaque == 5) {
            
                                            } else if (control.getMonedas() >= coste) {
                                                control.setMonedas(coste);
                                                System.out.println("------Equipar a Jugador-------:");
                                                if (control.verEquipo(1) != null) {
                                                    System.out.println("    1) " + control.verEquipo(1).getNombre());
                                                }
                                                if (control.verEquipo(2) != null) {
                                                    System.out.println("    2) " + control.verEquipo(2).getNombre());
                                                }
                                                if (control.verEquipo(3) != null) {
                                                    System.out.println("    3) " + control.verEquipo(3).getNombre());
                                                }
                                                if (control.verEquipo(4) != null) {
                                                    System.out.println("    4) " + control.verEquipo(4).getNombre());
                                                }
                                                System.out.print("  Elige una opción: ");
                                                int objetivo = escaner.nextInt();
                                                switch (objetivo) {
                                                    case 1:
                                                        control.verEquipo(1).equiparObjeto(onjetoElejido);
                                                        break;
                                                    case 2:
                                                        control.verEquipo(2).equiparObjeto(onjetoElejido);
            
                                                        break;
                                                    case 3:
                                                        control.verEquipo(3).equiparObjeto(onjetoElejido);
            
                                                        break;
                                                    case 4:
                                                        control.verEquipo(4).equiparObjeto(onjetoElejido);
            
                                                        break;
            
                                                    default:
                                                        control.verEquipo(1).equiparObjeto(onjetoElejido);
                                                        break;
                                                }
            
                                            } else {
                                                System.out.println("No Cuentan con suficientes monedas");
                                            }
                                }


                                
                    }

                        if (!control.getTienda()) {
                            
                            control.turnoEnemigos();
                        }else{

                            control.terminarTienda();
                        }

                    
                    break;
                case 4:
                    System.out.println("--------inventario--------");
                    System.out.println("Monedas: " + control.getMonedas());
                    if (control.verEquipo(1) != null && control.verEquipo(1).getObjeto() != null) {
                        System.out.println("    "+control.verEquipo(1).getNombre());
                        System.out.println("Nombre: "+control.verEquipo(1).getObjeto().getNombre() + " +Vida: " +
                        control.verEquipo(1).getObjeto().getVidaGanada()+ " +Ataque: "+
                        control.verEquipo(1).getObjeto().getAtaqueGanado() + " +Defensa: "+
                        control.verEquipo(1).getObjeto().getDefensaGanada() + " +Mana: " +
                        control.verEquipo(1).getObjeto().getManaGanado());
                    }
                    if (control.verEquipo(2) != null && control.verEquipo(2).getObjeto() != null) {
                        System.out.println("    "+control.verEquipo(2).getNombre());
                        System.out.println("Nombre: "+control.verEquipo(2).getObjeto().getNombre() + " +Vida: " +
                        control.verEquipo(2).getObjeto().getVidaGanada()+ " +Ataque: "+
                        control.verEquipo(2).getObjeto().getAtaqueGanado() + " +Defensa: "+
                        control.verEquipo(2).getObjeto().getDefensaGanada() + " +Mana: " +
                        control.verEquipo(2).getObjeto().getManaGanado());
                    }
                    if (control.verEquipo(3) != null && control.verEquipo(3).getObjeto() != null) {
                        System.out.println("    "+control.verEquipo(3).getNombre());
                        System.out.println("Nombre: "+control.verEquipo(3).getObjeto().getNombre() + " +Vida: " +
                        control.verEquipo(3).getObjeto().getVidaGanada()+ " +Ataque: "+
                        control.verEquipo(3).getObjeto().getAtaqueGanado() + " +Defensa: "+
                        control.verEquipo(3).getObjeto().getDefensaGanada() + " +Mana: " +
                        control.verEquipo(3).getObjeto().getManaGanado());
                    }
                    if (control.verEquipo(4) != null && control.verEquipo(4).getObjeto() != null) {
                        System.out.println("    "+control.verEquipo(4).getNombre());
                        System.out.println("Nombre: "+control.verEquipo(4).getObjeto().getNombre() + " +Vida: " +
                        control.verEquipo(4).getObjeto().getVidaGanada()+ " +Ataque: "+
                        control.verEquipo(4).getObjeto().getAtaqueGanado() + " +Defensa: "+
                        control.verEquipo(4).getObjeto().getDefensaGanada() + " +Mana: " +
                        control.verEquipo(4).getObjeto().getManaGanado());
                    }
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

        }

    }
}
