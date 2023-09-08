package by.Yandr2022.spring.learn;

import by.Yandr2022.spring.learn.model.Item;
import by.Yandr2022.spring.learn.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;

public class CascadingDemo {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Item.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Person person = new Person("Test Cascading", 30);
            person.addItem(new Item("Test Item Cascade1")
                    , new Item("Test Item Cascade2"), new Item("Test Item Cascade3"));
            session.save(person);
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
