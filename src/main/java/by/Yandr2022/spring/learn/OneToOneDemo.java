package by.Yandr2022.spring.learn;


import by.Yandr2022.spring.learn.model.Item;
import by.Yandr2022.spring.learn.model.Passport;
import by.Yandr2022.spring.learn.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneDemo {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class)
                .addAnnotatedClass(Passport.class).addAnnotatedClass(Item.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {

            session.beginTransaction();
//            Passport passport = session.get(Passport.class, 13);
//            System.out.println(passport);
//            System.out.println(passport.getPerson());
//            Person person = passport.getPerson();
//            person.getPassport().setPassportNumber(111111);
//            System.out.println(person.getPassport());
//            session.remove(person);
//            Person person = new Person("new test person",54);
//            Passport passport =  new Passport(12456897);
//            person.setPassport(passport);

            session.remove(session.get(Person.class, 17));

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
