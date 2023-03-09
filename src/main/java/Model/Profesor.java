package Model;

import jakarta.persistence.*;

@Entity
public class Profesor {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idProfesor")
    private long idProfesor;
    @Basic
    @Column(name = "nombre")
    private String nombre;

    public long getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(long idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Profesor profesor = (Profesor) o;

        if (idProfesor != profesor.idProfesor) return false;
        if (nombre != null ? !nombre.equals(profesor.nombre) : profesor.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idProfesor ^ (idProfesor >>> 32));
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        return result;
    }
}
