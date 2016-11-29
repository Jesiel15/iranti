package iranti;

import iranti.entity.Iranti;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Principal {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Iranti.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        
        try {
            Date data = new Date(System.currentTimeMillis());
            Iranti iranti = new Iranti("Primeiro Iranti", "Blablabla", data, data);
            
            //start transaction
            session.beginTransaction();
            //save the students
            session.save(iranti);
            //commit 
            session.getTransaction().commit();
        } catch (Exception e) {
            factory.close();
        }
    }
    
}
