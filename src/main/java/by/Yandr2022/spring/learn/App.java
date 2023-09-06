package by.Yandr2022.spring.learn;


import by.Yandr2022.spring.learn.model.Item;
import by.Yandr2022.spring.learn.model.Person;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Item.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {

            session.beginTransaction();

//            Person person = session.get(Person.class, 7);
//            System.out.println(person);
//            List<Item> items = person.getItems();
//            items.stream().forEach(System.out::println);
//            System.out.println("*******************");
//
//            Item item = session.get(Item.class,11);
//            System.out.println(item);
//            System.out.println(item.getOwner());

//            Person person = session.get(Person.class, 5);
//            Item item = new Item (person, "TestItem");
//            session.save(item);
//            person.getItems().add(item);//only for hibernate cache, not important for Schema - best practice

            Person person = new Person("Test person", 35);
            Item item = new Item(person, "TestItem2");

            //only for hibernate cache, not important for Schema - best practice
            person.setItems(new ArrayList<>(Collections.singletonList(item)));

            session.save(person);
            session.save(item);

            session.getTransaction().commit();

        } finally {
            session.close();
        }

    }
}
