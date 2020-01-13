package com.jpa.JPA.Entity;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p ORDER BY p.idPersona")
})
@Table(name="person")
public class Person implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id //Primary Key
    @GeneratedValue(strategy=GenerationType.IDENTITY) //DB Autogenerate the ID
    @Column(name="id_person") //Its mapped by column id_person
    private int idPersona;

    private String nombre;

    private String apellido;

    private String email;

    private String telefono;

    public Person() {
    }

    public Person(String nombre, String apellido, String email, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", telefono=" + telefono + '}';
    }


}
