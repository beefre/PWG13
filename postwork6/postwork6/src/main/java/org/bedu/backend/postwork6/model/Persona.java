package org.bedu.backend.postwork6.model;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Persona implements Comparable<Persona> {
    private String nombre;
    private String telefono;


    public Persona() {
    }


    public Persona(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getTelefono() {
        return telefono;
    }


    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }

    @Override
    public int compareTo(Persona o) {
        return this.nombre.compareTo(o.nombre);
    }
}



