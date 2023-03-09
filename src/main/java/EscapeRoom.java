
import org.hibernate.Session;
import org.hibernate.query.Query;

public class EscapeRoom {
    public static void main(String[] args) {
        int x=codigo1();
        int y=codigo2();
        int z=codigo3();
        int w=codigo4();
        System.out.println("El código descubierto es :" +x+y+z+w);
    }
    public static int codigo1() {
        Session laSesion = HibernateUtil.getSessionFactory().getCurrentSession();
        laSesion.beginTransaction();

        Query q=laSesion.createQuery("select count(m) from Modulo m");
        Long n=(Long)q.uniqueResult();


        laSesion.getTransaction().commit();
        return n.intValue();
    }

    public static int codigo2() {
        Session laSesion = HibernateUtil.getSessionFactory().getCurrentSession();
        laSesion.beginTransaction();

        Query q=laSesion.createQuery("select count(m) from Modulo m where m.examenByIdModulo is not empty");
        Long n=(Long)q.uniqueResult();


        laSesion.getTransaction().commit();
        return n.intValue();
    }

    public static int codigo3() {
        Session laSesion = HibernateUtil.getSessionFactory().getCurrentSession();
        laSesion.beginTransaction();

        Query q=laSesion.createQuery("select round(avg(e.nota),0) from Examen e where e.moduloByIdModulo.nombre =:nombreModulo");
        q.setParameter("nombreModulo", "PRG");
        Double n=(Double)q.uniqueResult();


        laSesion.getTransaction().commit();
        return n.intValue();
    }

    public static int codigo4() {
        Session laSesion = HibernateUtil.getSessionFactory().getCurrentSession();
        laSesion.beginTransaction();

        Query q=laSesion.createQuery("select count(a) from Alumno a where a.apellidos like :filtroNombre" );
        q.setParameter("filtroNombre", "%Z%");
        Long n=(Long)q.uniqueResult();


        laSesion.getTransaction().commit();
        return n.intValue();
    }
}
