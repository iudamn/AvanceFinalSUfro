package model;
/**
 * Contiene los métodos utilizados en el enfrentamiento entre el jugador y sus miedos
 * @author Joaquin, Leandro, Gustavo, Camila
 */
public class FightExecution {
    private String mainDisplay;
    private Estudiante jugador;
    private Enemigo enemigo;

    /**
     *
     * @param jugador objeto del estudiante correspondiente al usuario logueado
     * @param enemigo objeto del enemigo que le corresponde al usuario logueado
     * @param opcion integer que indica la seleccion en la ventana anterior por parte del usuario
     */
    public FightExecution(Estudiante jugador, Enemigo enemigo, int opcion) {
        this.jugador = jugador;
        this.enemigo = enemigo;
        action(opcion);
    }
    /**
     * @return devuelve el recorrido de la historia
     */
    public String getMainDisplay() {
        return mainDisplay;
    }
    /**
     * hay un ataque por parte del jugador al enemigo
     */
    public void atacar() {
        this.enemigo.setHp(this.enemigo.getHp() - this.jugador.getMoral());
        this.jugador.setHp(this.jugador.getHp() - this.enemigo.getDamage());
        this.mainDisplay = "Le hiciste " + this.jugador.getMoral() + " puntos de daño a " + this.enemigo.getNombre();
    }
    /**
     * el usuario se defiende
     */
    public void defenderse() {
        this.jugador.setHp(this.jugador.getHp() - this.enemigo.getDamage() / 3);
        this.enemigo.setHp(this.enemigo.getHp() - this.jugador.getMoral() / 2);
        this.mainDisplay = "El daño recibido ha sido reducido."+ "\n"+"Le hiciste " + this.jugador.getMoral()/2 + " puntos de daño a " + this.enemigo.getNombre();;
    }

    /**
     * @param opcion dependiendo de las opciones elegidas en el juego, desembocaràn en diferentes caminos; como se puede ver
     *               a continuaciòn
     */
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