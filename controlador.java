import java.util.*;

public class controlador {

    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador jugador3;
    private Jugador jugador4;

    private Monstruo enemigo1;
    private Monstruo enemigo2;
    private Monstruo enemigo3;
    private Monstruo enemigo4;
    private Monstruo enemigo5;

    public boolean oleadaViva = false;

    private int piso = 1;
    private int monedas = 5;

    private static final String[][][] tipos = { { { "Fuego" }, { "Tierra", "Agua" }, { "Planta", "Acero" } },
            { { "Agua" }, { "Planta", "Electrico" }, { "Fuego", "Tierra" } },
            { { "Electrico" }, { "Tierra" }, { "Agua", "Acero" } },
            { { "Tierra" }, { "Agua", "Planta" }, { "Electrico", "Agua" } },
            { { "Planta" }, { "Fuego" }, { "Agua", "Tierra" } },
            { { "Acero" }, { "Fuego", "Electrico" }, { "Fisico" } },
            { { "Magia" }, {}, {} }, { { "Fisico" }, { "Acero" }, {} } };

    private String[] nombresMonstruos = {
            "Ogro", "Espora", "slime", "dragonito", "diablillo", "brujo", "ladron"
    };

    private List<Habilidades> habilidades = Arrays.asList(
            // FUEGO
            new Habilidades("Lanzallamas", "Fuego", 60, 88),
            new Habilidades("Rafaga Llameante", "Fuego", 95, 70),

            // AGUA
            new Habilidades("Cascada", "Agua", 60, 88),
            new Habilidades("Marea", "Agua", 95, 70),

            // ELECTRICO
            new Habilidades("Chispazo", "Electrico", 60, 88),
            new Habilidades("Trueno", "Electrico", 95, 70),

            // TIERRA
            new Habilidades("Pedrazo", "Tierra", 60, 88),
            new Habilidades("Terremoto", "Tierra", 95, 70),

            // PLANTA
            new Habilidades("Latigazo", "Planta", 60, 88),
            new Habilidades("Rafaga Espinada", "Planta", 95, 70),
            new Habilidades("Bien Natural", "Planta", 0, 95), // sin mana

            // ACERO
            new Habilidades("Tajo", "Acero", 55, 90),
            new Habilidades("Cuchillada", "Acero", 85, 75),
            new Habilidades("Hachazo", "Acero", 105, 50),

            // MAGIA
            new Habilidades("Bendicion", "Magia", 0, 70),
            new Habilidades("Curacion", "Magia", 0, 80),
            new Habilidades("Concentracion", "Magia", 0, 100),
            new Habilidades("Esfuerso", "Magia", 0, 90),

            // FISICO
            new Habilidades("Sutura", "Fisico", 0, 90), // curación
            new Habilidades("Cachetada", "Fisico", 30, 100),
            new Habilidades("Golpe", "Fisico", 45, 100),
            new Habilidades("Bastonaso", "Fisico", 75, 80),
            new Habilidades("Patada", "Fisico", 80, 80),
            new Habilidades("Cabezazo", "Fisico", 100, 60),
            new Habilidades("Embestida", "Fisico", 110, 40));

    private List<Objetos> objetos = Arrays.asList(
            new Objetos("Armadura ligera", 2, 2, 0, 0, false, 1),
            new Objetos("Espada ligera", 0, 1, 3, 0, false, 1),
            new Objetos("Varita simple", 0, 0, 2, 2, false, 1),
            new Objetos("Colgante simple", 2, 0, 0, 2, false, 1),
            new Objetos("Bufanda rota", 1, 1, 1, 1, false, 1),
            new Objetos("Gafas rotas", -2, -2, 5, 4, false, 1),

            new Objetos("Armadura pesada", 2, 5, 0, 0, false, 2),
            new Objetos("Armadura maldita", -2, 5, 1, 3, false, 2),
            new Objetos("Espada larga", 1, 1, 5, 0, false, 2),
            new Objetos("Espada corta", 1, 0, 6, 0, false, 2),
            new Objetos("Varita elegante", 2, 0, 0, 5, false, 2),
            new Objetos("Varita espinosa", -2, 0, 4, 5, false, 2),
            new Objetos("Colgante Sagrado", 6, 0, 0, 1, false, 2),
            new Objetos("Colgante Sangrante", 4, 0, 0, 3, false, 2),
            new Objetos("Bufanda Gruesa", 2, 2, 1, 2, false, 2),
            new Objetos("Bufanda ligera", 2, 1, 2, 2, false, 2),
            new Objetos("Gafas difuntas", -6, 0, 7, 7, false, 2),
            new Objetos("Gafas ferricas", 7, 7, 0, -6, false, 2),

            new Objetos("Armadura blindada", 4, 6, 0, 0, false, 3),
            new Objetos("Armadura tchk tchk", -2, 20, -4, -2, false, 3),
            new Objetos("Espada de luz", 1, 0, 5, 4, false, 3),
            new Objetos("Espada escudo", 0, 5, 5, 0, false, 3),
            new Objetos("Varita tungstenica", 0, 5, 0, 5, false, 3),
            new Objetos("Varita aurora", 0, 0, 1, 9, false, 3),
            new Objetos("Colgante sanador", 9, 0, 0, 1, false, 3),
            new Objetos("Colgante damocles", -10, -10, 15, 16, false, 3),
            new Objetos("Bufanda absoluta", 3, 3, 3, 3, false, 3),
            new Objetos("Bufanda astral", 2, 2, 4, 4, false, 3),
            new Objetos("Gafas de lazaro", 25, 0, -6, -6, false, 3),
            new Objetos("Gafas bazuca", -6, -6, 24, 0, false, 3));

    private String[] nombresClases = { "Mago", "Caballero", "Ladron", "Gladeador", "Curandero", "brujo" };
    private int[] vidaClases = { 3, 7, 5, 10, 8, 5 };
    private int[] dañoClases = { 8, 7, 9, 3, 5, 7 };
    private int[] defensaClases = { 3, 7, 5, 10, 3, 3 };
    private int[] manaClases = { 10, 3, 5, 1, 8, 9 };

    private List<Habilidades> habilidadesPlayer;

    public void crearJugador(String nombre) {

        Random rand = new Random();
        int claseganada = rand.nextInt(6);
        int havilidadganada;

        habilidadesPlayer = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            havilidadganada = rand.nextInt(habilidades.size());
            habilidadesPlayer.addLast(habilidades.get(havilidadganada));
        }
        Clase rol = new Clase(nombresClases[claseganada], vidaClases[claseganada], dañoClases[claseganada],
                defensaClases[claseganada], manaClases[claseganada], habilidadesPlayer);
        if (jugador1 == null) {
            jugador1 = new Jugador(nombre, 5, 5, 5, 0, rol);
        } else if (jugador2 == null) {
            jugador2 = new Jugador(nombre, 5, 5, 5, 0, rol);
        } else if (jugador3 == null) {
            jugador3 = new Jugador(nombre, 5, 5, 5, 0, rol);
        } else if (jugador4 == null) {
            jugador4 = new Jugador(nombre, 5, 5, 5, 0, rol);
        }
    }

    public void generarOleada() {
        Random rand = new Random();

        int[] numeros = { 0, 1, 2, 3, 4, 5, 7 };
        int[] pesos = { 1, 1, 1, 1, 1, 1, 2 };

        int totalPeso = 0;

        for (int p : pesos) {
            totalPeso += p;
        }

        if (false /* piso % 5 == 0 */) {

        } else if (false /* piso % 5 == 1 */) {

        } else {
            int numMon = 2 + rand.nextInt(2);
            for (int i = 0; i < 5; i++) {

                int r = rand.nextInt(totalPeso);

                int acumulado = 0;
                int elegido = 7;

                for (int j = 0; j < numeros.length; j++) {
                    acumulado += pesos[j];
                    if (r < acumulado) {
                        elegido = numeros[j];
                        break;
                    }
                }

                if (enemigo1 == null) {
                    enemigo1 = new Monstruo(nombresMonstruos[rand.nextInt(nombresMonstruos.length)],
                            tipos[elegido][0][0],
                            2 + rand.nextInt(5),
                            2 + rand.nextInt(5), 2 + rand.nextInt(5), objetos.get(rand.nextInt(objetos.size())),
                            rand.nextInt(2));
                } else if (enemigo2 == null) {
                    enemigo2 = new Monstruo(nombresMonstruos[rand.nextInt(nombresMonstruos.length)],
                            tipos[elegido][0][0],
                            2 + rand.nextInt(5),
                            2 + rand.nextInt(5), 2 + rand.nextInt(5), objetos.get(rand.nextInt(objetos.size())),
                            rand.nextInt(2));
                } else if (enemigo3 == null) {
                    enemigo3 = new Monstruo(nombresMonstruos[rand.nextInt(nombresMonstruos.length)],
                            tipos[elegido][0][0],
                            2 + rand.nextInt(5),
                            2 + rand.nextInt(5), 2 + rand.nextInt(5), objetos.get(rand.nextInt(objetos.size())),
                            rand.nextInt(2));
                } else if (enemigo4 == null) {
                    enemigo4 = new Monstruo(nombresMonstruos[rand.nextInt(nombresMonstruos.length)],
                            tipos[elegido][0][0],
                            2 + rand.nextInt(5),
                            2 + rand.nextInt(5), 2 + rand.nextInt(5), objetos.get(rand.nextInt(objetos.size())),
                            rand.nextInt(2));
                } else if (enemigo5 == null) {
                    enemigo5 = new Monstruo(nombresMonstruos[rand.nextInt(nombresMonstruos.length)],
                            tipos[elegido][0][0],
                            2 + rand.nextInt(5),
                            2 + rand.nextInt(5), 2 + rand.nextInt(5), objetos.get(rand.nextInt(objetos.size())),
                            rand.nextInt(2));
                } else {

                }
            }
        }
        oleadaViva = true;
    }

    public Monstruo getEnemigo(int num) {
        if (num == 1) {
            return (enemigo1);
        } else if (num == 2) {
            return enemigo2;

        } else if (num == 3) {
            return enemigo3;

        } else if (num == 4) {
            return enemigo4;

        } else if (num == 5) {
            return enemigo5;

        }
        return enemigo5;
    }

    public Jugador verEquipo(int num) {
        if (num == 1) {
            return (jugador1);
        } else if (num == 2) {
            return (jugador2);
        } else if (num == 3) {
            return (jugador3);
        } else if (num == 4) {
            return (jugador4);
        }
        return (jugador4);
    }

    public String atacar(int enemigo, int jugador, int ataque) {
        Random rand = new Random();
        int poderAtaque = 1;
        int acierto = 1;

        if (jugador == 1) {
            poderAtaque = jugador1.calcularAtaque(ataque);
            acierto = jugador1.getRol().getHabilidades().get(ataque).getAcierto();
        } else if (jugador == 2) {
            poderAtaque = jugador2.calcularAtaque(ataque);
            acierto = jugador1.getRol().getHabilidades().get(ataque).getAcierto();
        } else if (jugador == 3) {
            poderAtaque = jugador3.calcularAtaque(ataque);
            acierto = jugador1.getRol().getHabilidades().get(ataque).getAcierto();
        } else if (jugador == 4) {
            poderAtaque = jugador4.calcularAtaque(ataque);
            acierto = jugador4.getRol().getHabilidades().get(ataque).getAcierto();
        }

        if (rand.nextInt(100) > acierto) {
            return "El Ataque Ha fallado!!!";
        } else {
            if (enemigo == 1) {
                return enemigo1.recivirDaño(poderAtaque);
            } else if (enemigo == 2) {
                return enemigo2.recivirDaño(poderAtaque);              
            } else if (enemigo == 3) {
                return enemigo3.recivirDaño(poderAtaque);              
            } else if (enemigo == 4) {
                return enemigo4.recivirDaño(poderAtaque);             
            } else if (enemigo == 5) {
                return enemigo5.recivirDaño(poderAtaque);  
            }
        }
        return "";
    }

}
