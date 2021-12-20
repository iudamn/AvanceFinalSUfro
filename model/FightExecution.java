package model;

public class FightExecution {
    private String mainDisplay;
    private Estudiante jugador;
    private Enemigo enemigo;

    //Constructor desde ventanaJuego, recibe el objeto usuario ya creado y actualiza sus stats
    public FightExecution(Estudiante jugador, Enemigo enemigo, int opcion) {
        this.jugador = jugador;
        this.enemigo = enemigo;
        action(opcion);
    }

    public String getMainDisplay() {
        return mainDisplay;
    }

    public void atacar() {
        this.enemigo.setHp(this.enemigo.getHp() - this.jugador.getMoral());
        this.jugador.setHp(this.jugador.getHp() - this.enemigo.getDamage());
        this.mainDisplay = "Le hiciste " + this.jugador.getMoral() + " puntos de daño a " + this.enemigo.getNombre();
    }

    public void defenderse() {
        this.jugador.setHp(this.jugador.getHp() - this.enemigo.getDamage() / 3);
        this.enemigo.setHp(this.enemigo.getHp() - this.jugador.getMoral() / 2);
        this.mainDisplay = "El daño recibido ha sido reducido."+ "\n"+"Le hiciste " + this.jugador.getMoral()/2 + " puntos de daño a " + this.enemigo.getNombre();;
    }

    //Asigna en base a la seleccion de opciones
    public void action(int opcion) {
        if (this.jugador.getCoordenada() == 9997) {
            if (opcion == 0) {
                atacar();
                if (this.enemigo.getHp() < 1) {
                    this.jugador.setCoordenada(68); //pelea ganada ->final bueno
                } else if (this.jugador.getHp() < 1) {
                    this.jugador.setCoordenada(69); //pelea perdida ->final malo
                }
            }
            if (opcion == 1) {
                defenderse();
                if (this.enemigo.getHp() < 1) {
                    this.jugador.setCoordenada(68); //pelea ganada ->final bueno
                } else if (this.jugador.getHp() < 1) {
                    this.jugador.setCoordenada(69); //pelea perdida ->final malo
                }
            }
        }
    }
}