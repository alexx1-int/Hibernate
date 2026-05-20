package util;

import entity.Student;
import entity.StudentGroup;
import entity.StudyPlan;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            StandardServiceRegistry registry =
                    new StandardServiceRegistryBuilder()
                            .configure()
                            .build();

            Metadata metadata = new MetadataSources(registry)
                    .addAnnotatedClass(Student.class)
                    .addAnnotatedClass(StudentGroup.class)
                    .addAnnotatedClass(StudyPlan.class)
                    .getMetadataBuilder()
                    .build();

            return metadata.buildSessionFactory();
        } catch (Exception e) {
            throw new RuntimeException("SessionFactory creation failed!", e);
        }
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        sessionFactory.close();
    }
}
