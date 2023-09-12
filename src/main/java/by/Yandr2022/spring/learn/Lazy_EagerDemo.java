package by.Yandr2022.spring.learn;

import by.Yandr2022.spring.learn.model.Item;
import by.Yandr2022.spring.learn.model.Passport;
import by.Yandr2022.spring.learn.model.Person;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Lazy_EagerDemo {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Item.class)
                .addAnnotatedClass(Passport.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        try (sessionFactory) {
            //default - Lazy
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Person person = session.get(Person.class, 4);
            System.out.println(person);
//            Hibernate.initialize(person.getItems());//loading lazy entities

            //default - Eager
//           Item item = session.get(Item.class, 10);
//            System.out.println(item);
//            System.out.println(item.getOwner());

            session.getTransaction().commit();
            //default - session.close()
            System.out.println("session.close()");


            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            System.out.println("session.beginTransaction();");
//            person = (Person) session.merge(person);
//            Hibernate.initialize(person.getItems());
            List<Item> itemList = session.createQuery("select i from Item i where i.owner.id=:personId", Item.class)
                    .setParameter("personId",person.getId()).getResultList();
            itemList.stream().forEach(System.out::println);
            session.getTransaction().commit();

//            person.getItems().stream().forEach(System.out::println);


        }
    }
}
