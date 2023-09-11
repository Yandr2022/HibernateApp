package by.Yandr2022.spring.learn.homework2_OneToOne;

import by.Yandr2022.spring.learn.homework2_OneToOne.model.Principal;
import by.Yandr2022.spring.learn.homework2_OneToOne.model.School;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Demo {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Principal.class)
                .addAnnotatedClass(School.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        try (sessionFactory; Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

//            task1: getting Principal & his School
            Principal principal = session.get(Principal.class, 2);
            School school = principal.getSchool();
            System.out.println(principal);
            System.out.println(school);

//            task2: getting School & her Principal
            School school1 = session.get(School.class, 4);
            Principal principal1 = school1.getPrincipal();
            System.out.println(school1);
            System.out.println(principal1);

//            task3: creating new Principal & his School
            Principal principal2 = new Principal("Bob",54);
            principal2.setSchool(new School(87));
            session.save(principal2);

//            task3: change Principal for School
            School school2 = session.get(School.class,4);
            school2.setPrincipal(session.get(Principal.class,5));

//            task3: add second School for Principal (error)
            School school3 = session.get(School.class,4);
            school3.setPrincipal(session.get(Principal.class,3));

            session.getTransaction().commit();
        }

    }
}
