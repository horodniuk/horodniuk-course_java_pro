package hometask.hibernate.util;

import hometask.hibernate.entity.Student;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Slf4j
@UtilityClass
public class HibernateSession {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        log.debug("try building session factory");
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                configuration.addAnnotatedClass(Student.class);
                configuration.configure();
                sessionFactory = configuration.buildSessionFactory();
            } catch (Throwable ex) {
                log.error("Initial SessionFactory creation failed. {}", ex);
                throw new ExceptionInInitializerError(ex);
            }
        }
        return sessionFactory;
    }
}
