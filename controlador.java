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
    
    private int habilidadDuplicada = 10;
    private int habilidadDuplicada2 = 17;
    
    private int piso = 1;
    private int dificultadpiso = 0;
    private boolean pisoTienda = false;
    private boolean primerPiso = true;
    
    private int monedas = 5;    
    private Random rand = new Random();

    public int getMonedas(){
        return monedas;
    }
    public void setMonedas(int coste){
        monedas = monedas-coste;
    }
    public boolean getTienda(){
        return pisoTienda;
    }

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
            new Habilidades("Lanzallamas", "Fuego", 60, 90),
            new Habilidades("Rafaga Llameante", "Fuego", 95, 75),

            // AGUA
            new Habilidades("Cascada", "Agua", 60, 90),
            new Habilidades("Marea", "Agua", 95, 75),

            // ELECTRICO
            new Habilidades("Chispazo", "Electrico", 60, 90),
            new Habilidades("Trueno", "Electrico", 95, 75),

            // TIERRA
            new Habilidades("Pedrazo", "Tierra", 60, 90),
            new Habilidades("Terremoto", "Tierra", 95, 75),

            // PLANTA
            new Habilidades("Latigazo", "Planta", 60, 90),
            new Habilidades("Rafaga Espinada", "Planta", 95, 75),
            new Habilidades("Bien Natural", "Planta", 0, 95), // sin mana

            // ACERO
            new Habilidades("Tajo", "Acero", 55, 95),
            new Habilidades("Cuchillada", "Acero", 85, 80),
            new Habilidades("Hachazo", "Acero", 105, 65),

            // MAGIA
            new Habilidades("Bendicion", "Magia", 0, 75),
            new Habilidades("Curacion", "Magia", 0, 80),
            new Habilidades("Concentracion", "Magia", 0, 100),
            new Habilidades("Esfuerso", "Magia", 0, 90),

            // FISICO
            new Habilidades("Sutura", "Fisico", 0, 90), // curación
            new Habilidades("Cachetada", "Fisico", 30, 100),
            new Habilidades("Golpe", "Fisico", 45, 100),
            new Habilidades("Bastonaso", "Fisico", 75, 90),
            new Habilidades("Patada", "Fisico", 80, 80),
            new Habilidades("Cabezazo", "Fisico", 100, 70),
            new Habilidades("Embestida", "Fisico", 110, 55));

    private List<Objetos> objetos = Arrays.asList(
            new Objetos("Armadura ligera", 2, 2, 0, 0, false, 1),
            new Objetos("Toga ligera", 0, 2, 0, 2, false, 1),
            new Objetos("Espada ligera", 0, 1, 3, 0, false, 1),
            new Objetos("Varita simple", 0, 0, 2, 2, false, 1),
            new Objetos("Colgante simple", 2, 0, 0, 2, false, 1),
            new Objetos("Guante simple", 2, 0, 0, 2, false, 1),
            new Objetos("Bufanda rota", 1, 1, 1, 1, false, 1),
            new Objetos("Bufanda empolvada", 2, 1, 1, -1, false, 1),
            new Objetos("Gafas rotas", -2, -2, 5, 4, false, 1),
            new Objetos("Gafas enpolvadas", 5, 4, -2, -2, false, 1),
            new Objetos("Botella de vida", 5, 0, 0,0, false, 1),

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
            new Objetos("Botella de mana", 0, 0, 0, 8, false, 2),

            new Objetos("Armadura blindada", 4, 6, 0, 0, false, 3),
            new Objetos("Armadura tchk tchk", -2, 20, -4, -2, false, 3),
            new Objetos("Espada de luz", 1, 0, 5, 4, false, 3),
            new Objetos("Guante reforzado", 0, 5, 5, 0, false, 3),
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
    private int[] dañoClases = { 80, 70, 90, 30, 50, 70 };
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
            if (havilidadganada == habilidadDuplicada || havilidadganada == habilidadDuplicada2) {
                havilidadganada = rand.nextInt(habilidades.size());
            }
            habilidadesPlayer.add(habilidades.get(havilidadganada));
            habilidadDuplicada2 = habilidadDuplicada;
            habilidadDuplicada = havilidadganada;
        }
        Clase rol = new Clase(nombresClases[claseganada], vidaClases[claseganada], dañoClases[claseganada],
                defensaClases[claseganada], manaClases[claseganada], habilidadesPlayer);
        if (jugador1 == null) {
            jugador1 = new Jugador(nombre, 5*vidaClases[claseganada], 5*defensaClases[claseganada], 5*dañoClases[claseganada],5+(3*manaClases[claseganada]), 0, rol);
        } else if (jugador2 == null) {
            jugador2 = new Jugador(nombre, 5*vidaClases[claseganada], 5*defensaClases[claseganada], 5*dañoClases[claseganada],5+(3*manaClases[claseganada]), 0, rol);
        } else if (jugador3 == null) {
            jugador3 = new Jugador(nombre, 5*vidaClases[claseganada], 5*defensaClases[claseganada], 5*dañoClases[claseganada],5+(3*manaClases[claseganada]), 0, rol);
        } else if (jugador4 == null) {
            jugador4 = new Jugador(nombre, 5*vidaClases[claseganada], 5*defensaClases[claseganada], 5*dañoClases[claseganada],5+(3*manaClases[claseganada]), 0, rol);
        }
    }

    public int pesoPorTier(int tier) {
        switch (tier) {//Peso de los objetos por tier
            case 1: return 60;  
            case 2: return 30;  
            case 3: return 10;  
            default: return 1;  
        }
    }
    public Objetos obtenerObjetoAleatorioPorTier() {
        
        Random rand = new Random();
        int totalPeso=0;

        for (Objetos obj : objetos) {            
            totalPeso += pesoPorTier(obj.getRareza());
        }

        int r = rand.nextInt(totalPeso);

        int acumulado = 0;
        for (Objetos obj : objetos) {
            acumulado += pesoPorTier(obj.getRareza());
            if (r < acumulado) {
                return obj;
            }
        }
        return objetos.get(objetos.size() - 1);
    }


    public void generarOleada() {
        Random rand = new Random();

        int[] numeros = { 0, 1, 2, 3, 4, 5, 7 };
        int[] pesos = { 1, 1, 1, 1, 1, 1, 2 };

        int totalPeso = 0;

        for (int p : pesos) {
            totalPeso += p;
        }

        if (piso % 5 == 0 ) {
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
                    enemigo1 = new Monstruo("Jefe "+nombresMonstruos[rand.nextInt(nombresMonstruos.length)],
                            tipos[elegido][0][0],
                            10*7*(3+dificultadpiso + rand.nextInt(4+dificultadpiso)),
                            5*(3+dificultadpiso + rand.nextInt(4+dificultadpiso)), 6*(3+dificultadpiso + rand.nextInt(4+dificultadpiso)), obtenerObjetoAleatorioPorTier(),
                            5+rand.nextInt(4*(1+dificultadpiso)));
                } else if (enemigo2 == null) {
                    enemigo2 = new Monstruo(nombresMonstruos[rand.nextInt(nombresMonstruos.length)],
                            tipos[elegido][0][0],
                            7*(2+dificultadpiso + rand.nextInt(5+dificultadpiso)),
                            5*(2 +dificultadpiso+ rand.nextInt(5+dificultadpiso)), 4*(2+dificultadpiso + rand.nextInt(5+dificultadpiso)), obtenerObjetoAleatorioPorTier(),
                            rand.nextInt(2));
                } else if (enemigo3 == null) {
                    enemigo3 = new Monstruo(nombresMonstruos[rand.nextInt(nombresMonstruos.length)],
                            tipos[elegido][0][0],
                            7*(2+dificultadpiso + rand.nextInt(5+dificultadpiso)),
                            5*(2+dificultadpiso + rand.nextInt(5+dificultadpiso)), 4*(2+dificultadpiso + rand.nextInt(5+dificultadpiso)), obtenerObjetoAleatorioPorTier(),
                            rand.nextInt(2));
                } else if (enemigo4 == null) {
                    enemigo4 = new Monstruo(nombresMonstruos[rand.nextInt(nombresMonstruos.length)],
                            tipos[elegido][0][0],
                            7*(2+dificultadpiso + rand.nextInt(5+dificultadpiso)),
                            5*(2+dificultadpiso + rand.nextInt(5+dificultadpiso)), 4*(2+dificultadpiso + rand.nextInt(5+dificultadpiso)), obtenerObjetoAleatorioPorTier(),
                            rand.nextInt(2));
                } else if (enemigo5 == null) {
                    enemigo5 = new Monstruo(nombresMonstruos[rand.nextInt(nombresMonstruos.length)],
                            tipos[elegido][0][0],
                            7*(2+dificultadpiso + rand.nextInt(5+dificultadpiso)),
                            5*(2+dificultadpiso + rand.nextInt(5+dificultadpiso)), 4*(2+dificultadpiso + rand.nextInt(5+dificultadpiso)), obtenerObjetoAleatorioPorTier(),
                            rand.nextInt(2));
                } else {

                }
            }
            
            dificultadpiso += 1+dificultadpiso;
        } else if (!primerPiso && ((piso - 1) % 5 == 0)) {
            System.out.println("TIENDA ABIERTA");
            //TIENDA :VVVVVVVVVVVVVVVVVVVVVVVVV
            pisoTienda = true;

        } else {
            primerPiso = false;
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
                            7*(2+dificultadpiso + rand.nextInt(5+dificultadpiso)),
                            5*(2+dificultadpiso + rand.nextInt(5+dificultadpiso)), 4*(2+dificultadpiso + rand.nextInt(5+dificultadpiso)), obtenerObjetoAleatorioPorTier(),
                            rand.nextInt(3));
                } else if (enemigo2 == null) {
                    enemigo2 = new Monstruo(nombresMonstruos[rand.nextInt(nombresMonstruos.length)],
                            tipos[elegido][0][0],
                            7*(2+dificultadpiso + rand.nextInt(5+dificultadpiso)),
                            5*(2+dificultadpiso + rand.nextInt(5+dificultadpiso)), 4*(2+dificultadpiso + rand.nextInt(5+dificultadpiso)), obtenerObjetoAleatorioPorTier(),
                            rand.nextInt(2));
                } else if (enemigo3 == null) {
                    enemigo3 = new Monstruo(nombresMonstruos[rand.nextInt(nombresMonstruos.length)],
                            tipos[elegido][0][0],
                            7*(2+dificultadpiso + rand.nextInt(5+dificultadpiso)),
                            5*(2+dificultadpiso + rand.nextInt(5+dificultadpiso)), 4*(2+dificultadpiso + rand.nextInt(5+dificultadpiso)), obtenerObjetoAleatorioPorTier(),
                            rand.nextInt(2));
                } else if (enemigo4 == null) {
                    enemigo4 = new Monstruo(nombresMonstruos[rand.nextInt(nombresMonstruos.length)],
                            tipos[elegido][0][0],
                            7*(2+dificultadpiso + rand.nextInt(5+dificultadpiso)),
                            5*(2+dificultadpiso + rand.nextInt(5+dificultadpiso)), 4*(2+dificultadpiso + rand.nextInt(5+dificultadpiso)), obtenerObjetoAleatorioPorTier(),
                            rand.nextInt(2));
                } else if (enemigo5 == null) {
                    enemigo5 = new Monstruo(nombresMonstruos[rand.nextInt(nombresMonstruos.length)],
                            tipos[elegido][0][0],
                            7*(2+dificultadpiso + rand.nextInt(5+dificultadpiso)),
                            5*(2+dificultadpiso + rand.nextInt(5+dificultadpiso)), 4*(2+dificultadpiso + rand.nextInt(5+dificultadpiso)), obtenerObjetoAleatorioPorTier(),
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

    public String curar(int num, Clase rol, int mana, int acierto){
        if (rand.nextInt(100)< acierto) {
            if (num == 1) {
                return jugador1.calcularCuracion(rol,mana);
            } else if (num == 2) {
                return jugador2.calcularCuracion(rol,mana);
            } else if (num == 3) {
                return jugador3.calcularCuracion(rol,mana);
            } else if (num == 4) {
                return jugador4.calcularCuracion(rol,mana);
            }
            
        }
        return "La curacion ha fallado";
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

    public void turnoEnemigos(){
        if (enemigo1 != null && enemigo1.getVida() > 0) {
            monstruosAtacan(enemigo1.calcularAtaque(), enemigo1.getVida());
        }
        if (enemigo2 != null && enemigo2.getVida() > 0) {
            monstruosAtacan(enemigo2.calcularAtaque(), 0);
        }
        if (enemigo3 != null && enemigo3.getVida() > 0) {
            monstruosAtacan(enemigo3.calcularAtaque(),0);
        }
        if (enemigo4 != null && enemigo4.getVida() > 0) {
            monstruosAtacan(enemigo4.calcularAtaque(),0);
        }
        if (enemigo5 != null && enemigo5.getVida() > 0) {
            monstruosAtacan(enemigo5.calcularAtaque(),0);
        }

        if (enemigo5.getVida() <= 0 && enemigo4.getVida() <= 0 && enemigo3.getVida() <= 0 && enemigo2.getVida() <= 0 && enemigo1.getVida() <= 0 && !(pisoTienda)) {
            reiniciarPiso();
        }

    }

    public void monstruosAtacan(int ataque, int vida){

        if (rand.nextInt(101)>88 && vida >= 200) {
            System.out.println("El MONSTRUO HA FALLADO!!");
        }else if (vida >=200) {

            int jugadoresActuales=0;
            boolean verificar = true;
            if (jugador1 != null) {
                jugadoresActuales = 1;
            }
            if (jugador2 != null) {
                jugadoresActuales=2;
            }
            if (jugador3 != null) {
                jugadoresActuales=3;
            }
            if (jugador4 != null) {
                jugadoresActuales=4;
            }
            while (verificar) {
                int eleccion = rand.nextInt(jugadoresActuales);
                if (eleccion == 0 && jugador1.getVida()>0) {
                    System.out.println(jugador1.recivirDaño(ataque));
                    verificar = false;
                } else if(eleccion ==1 && jugador2.getVida()>0){
                    System.out.println(jugador2.recivirDaño(ataque));
                    verificar = false;
                }else if(eleccion ==2 && jugador3.getVida()>0){
                    System.out.println(jugador3.recivirDaño(ataque));
                    verificar = false;
                }else if(eleccion ==3 && jugador4.getVida()>0){
                    System.out.println(jugador4.recivirDaño(ataque));
                    verificar = false;
                }

            }
        }

        if (rand.nextInt(101)>64) {
            System.out.println("El MONSTRUO HA FALLADO!!");
        }else{
            int jugadoresActuales=0;
            boolean verificar = true;
            if (jugador1 != null) {
                jugadoresActuales = 1;
            }
            if (jugador2 != null) {
                jugadoresActuales=2;
            }
            if (jugador3 != null) {
                jugadoresActuales=3;
            }
            if (jugador4 != null) {
                jugadoresActuales=4;
            }
            while (verificar) {
                int eleccion = rand.nextInt(jugadoresActuales);
                if (eleccion == 0 && jugador1.getVida()>0) {
                    System.out.println(jugador1.recivirDaño(ataque));
                    verificar = false;
                } else if(eleccion ==1 && jugador2.getVida()>0){
                    System.out.println(jugador2.recivirDaño(ataque));
                    verificar = false;
                }else if(eleccion ==2 && jugador3.getVida()>0){
                    System.out.println(jugador3.recivirDaño(ataque));
                    verificar = false;
                }else if(eleccion ==3 && jugador4.getVida()>0){
                    System.out.println(jugador4.recivirDaño(ataque));
                    verificar = false;
                }

            }
        }
    }


    public void reiniciarPiso(){
        monedas += enemigo1.getMonedas()+enemigo2.getMonedas()+enemigo3.getMonedas()+enemigo4.getMonedas()+enemigo5.getMonedas()+rand.nextInt(2+dificultadpiso);
        enemigo1 = null;
        enemigo2 = null;
        enemigo3 = null;
        enemigo4 = null;
        enemigo5 = null;
        int cantidadEXP =-2;
        if (jugador1==null) {
            cantidadEXP +=1;
        }
        if (jugador2==null) {
            cantidadEXP +=1;
            
        }
        if (jugador3==null) {
            cantidadEXP +=1;
            
        }
        if (jugador4==null) {
            cantidadEXP +=1;
            
        }
        if (jugador1 != null) {
            jugador1.setExperiencia(30-(cantidadEXP*10)+rand.nextInt(51));
            if (jugador1.getExperiencia()>=100) {
                jugador1.setExperiencia(-100);
                if (rand.nextInt(2)==1) {
                    //setvida
                    jugador1.setVidaMaxima(rand.nextInt(2));
                } else {
                    jugador1.setDefensa(jugador1.getDefensa()+rand.nextInt(2));
                    
                }
                if (rand.nextInt(2)==1) {
                    jugador1.setAtaque(jugador1.getAtaque()+rand.nextInt(2));
                } else {
                    jugador1.setMana(jugador1.getMana()+rand.nextInt(2));
                }
                
            }
        }
        if (jugador2 != null) {
            jugador2.setExperiencia(30-(cantidadEXP*10)+rand.nextInt(51));
            if (jugador2.getExperiencia()>=100) {
                jugador2.setExperiencia(-100);
                if (rand.nextInt(2)==1) {
                    //setvida
                    jugador2.setVidaMaxima(rand.nextInt(2));
                } else {
                    jugador2.setDefensa(jugador2.getDefensa()+rand.nextInt(2));
                    
                }
                if (rand.nextInt(2)==1) {
                    jugador2.setAtaque(jugador2.getAtaque()+rand.nextInt(2));
                } else {
                    jugador2.setMana(jugador2.getMana()+rand.nextInt(2));
                }
                
            }
        }
        if (jugador3 != null) {
            jugador3.setExperiencia(30-(cantidadEXP*10)+rand.nextInt(51));
            if (jugador3.getExperiencia()>=100) {
                jugador3.setExperiencia(-100);
                if (rand.nextInt(2)==1) {
                    //setvida
                    jugador3.setVidaMaxima(rand.nextInt(2));
                } else {
                    jugador3.setDefensa(jugador3.getDefensa()+rand.nextInt(2));
                    
                }
                if (rand.nextInt(2)==1) {
                    jugador3.setAtaque(jugador3.getAtaque()+rand.nextInt(2));
                } else {
                    jugador3.setMana(jugador3.getMana()+rand.nextInt(2));
                }
                
            }
        }
        if (jugador4 != null) {
            jugador4.setExperiencia(30-(cantidadEXP*10)+rand.nextInt(51));
            if (jugador4.getExperiencia()>=100) {
                jugador4.setExperiencia(-100);
                if (rand.nextInt(2)==1) {
                    //setvida
                    jugador4.setVidaMaxima(rand.nextInt(2));
                } else {
                    jugador4.setDefensa(jugador4.getDefensa()+rand.nextInt(2));
                    
                }
                if (rand.nextInt(2)==1) {
                    jugador4.setAtaque(jugador4.getAtaque()+rand.nextInt(2));
                } else {
                    jugador4.setMana(jugador4.getMana()+rand.nextInt(2));
                }
                
            }
        }
        piso = piso+1;
        generarOleada();
    }

    public void terminarTienda(){
        enemigo1 = null;
        enemigo2 = null;
        enemigo3 = null;
        enemigo4 = null;
        enemigo5 = null;
        pisoTienda = false;
        piso = piso+1;
        generarOleada();
    }

}
