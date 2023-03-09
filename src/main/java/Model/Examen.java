package Model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class Examen {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idExamen")
    private long idExamen;
    @Basic
    @Column(name = "fecha", columnDefinition="DATETIME DEFAULT NOW()")
    private Timestamp fecha;
    @Basic
    @Column(name = "nota")
    private Double nota;
    @ManyToOne
    @JoinColumn(name = "idAlumno", referencedColumnName = "idAlumno")
    private Alumno alumnoByIdAlumno;

    @ManyToOne
    @JoinColumn(name = "idModul", referencedColumnName = "idModulo")
    private Modulo moduloByIdModulo;

    public long getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(long idExamen) {
        this.idExamen = idExamen;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public Alumno getAlumnoByIdAlumno() {
        return alumnoByIdAlumno;
    }

    public void setAlumnoByIdAlumno(Alumno alumnoByIdAlumno) {
        this.alumnoByIdAlumno = alumnoByIdAlumno;
    }

    public Modulo getModuloByIdModulo() {return moduloByIdModulo;}

    public void setModuloByIdModulo(Modulo moduloByIdModulo) {
        this.moduloByIdModulo = moduloByIdModulo;
    }
}
