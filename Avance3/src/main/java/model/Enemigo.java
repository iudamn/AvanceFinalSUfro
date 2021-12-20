package model;

/**
 *
 * Clase para instanciar un objeto del tipo enemigo.
 *
 * @author Joaquín Ortiz Castillo
 *
 * */
public class Enemigo {
    protected String nombre;
    protected int damage;
    protected int hp;
    protected String ubicacionImagen;

    /**
     *
     * @param nombre Nombre del enemigo a crear.
     * @param damage Daño innato del enemigo a crear.
     * @param puntajeVida Vida del enemigo a crear.
     * @param ubicacionImagen Path reference del archivo que contiene la imagen del enemigo.
     */
    public Enemigo(String nombre, int damage, int puntajeVida, String ubicacionImagen){
        this.nombre = nombre;
        this.damage = damage;
        this.hp = puntajeVida;
        this.ubicacionImagen = ubicacionImagen;
    }

    public String getUbicacionImagen() {
        return ubicacionImagen;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDamage() {
        return damage;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
