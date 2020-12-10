package com.jk.proyectofinal_idnp.Model.Models;

public class Trayectoria {
    private String id;
    private String fecha;
    private String hora;
    private String latitud;
    private String longitud;
    private String velocidad;

    public Trayectoria() {
    }

    public String getId() {
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String getLatitud() {
        return latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public void setVelocidad(String velocidad) {
        this.velocidad = velocidad;
    }

    @Override
    public String toString() {
        return "Trayectoria{" +
                "id='" + id + '\'' +
                ", fecha='" + fecha + '\'' +
                ", hora='" + hora + '\'' +
                '}';
    }

    public String getVelocidad() {
        return velocidad;
    }
}
