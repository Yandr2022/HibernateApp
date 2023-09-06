package by.Yandr2022.spring.learn;


import by.Yandr2022.spring.learn.model.Person;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {

            session.beginTransaction();
//            List<Person> people = new ArrayList<>() {{
//                add(new Person("Test1", 30));
//                add(new Person("Test2", 40));
//                add(new Person("Test3", 50));
//            }};
//
//            for (Person p : people) {
//                session.save(p);
//            }
//            Person person = session.get(Person.class, 2);
//            System.out.println(person.getName() + ", " + person.getAge());
//            person.setName("New test name");
//            System.out.println(person.getName() + ", " + person.getAge());
//            session.delete(person);
//            System.out.println(session.get(Person.class, 2));
//            for (Person p : ((List<Person>) session.createQuery("FROM Person WHERE age>30 AND name like 'T%'")
//                    .getResultList())) {
//                System.out.println(p);
//            }
            for (Person p : ((List<Person>) session.createQuery("FROM Person ").getResultList())){
                System.out.println(p);
            }

            session.createQuery("DELETE from Person  WHERE age<60 ").executeUpdate();

            session.getTransaction().commit();
        } finally {
            session.close();
        }

    }
}
