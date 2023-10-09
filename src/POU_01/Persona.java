package Coleccions.Exercicis.POU_01;

import java.util.Objects;

public class Persona
{
    private String nombre;
    private String apellidos;
    private String telefono;

    /* -- CONSTRUCTOR -- */
    public Persona(String nombre, String apellidos, String telefono)
    {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
    }

    /* -- GETERS / SETERS -- */
    public String getNombre()
    {
        return this.nombre;
    }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellidos() { return this.apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public String getTelefono() { return this.telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    /* -- toString -- */
    @Override
    public String toString()
    {
        return "Persona [nombre=" + nombre + ", apellidos=" + apellidos + ", telefono=" + telefono + "]";
    }

    /* -- equals -- */
    @Override
    public boolean equals(Object obj)
    {
        if (this.nombre == obj) return true;
        if (obj ==null || getClass() != obj.getClass()) return false;

        Persona persona = (Persona) obj;
        return Objects.equals(nombre, persona.nombre) && Objects.equals(apellidos, persona.apellidos);
    }

    /* -- hashCode -- */
    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellidos);
    }
}