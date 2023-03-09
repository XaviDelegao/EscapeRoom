package Model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Modulo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idModulo")
    private long idModulo;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "moduloByIdModulo")
    private Collection<Examen> examenByIdModulo;

    public long getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(long idModulo) {
        this.idModulo = idModulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Collection<Examen> getExamenByIdModulo() {
        return examenByIdModulo;
    }

    public void setExamenByIdModulo(Collection<Examen> examenByIdModulo) {
        this.examenByIdModulo = examenByIdModulo;
    }
}
