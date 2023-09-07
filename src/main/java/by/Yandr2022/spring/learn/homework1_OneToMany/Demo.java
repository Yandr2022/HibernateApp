package by.Yandr2022.spring.learn.homework1_OneToMany;


import by.Yandr2022.spring.learn.homework1_OneToMany.model.Director;
import by.Yandr2022.spring.learn.homework1_OneToMany.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        Configuration configuration
                = new Configuration().addAnnotatedClass(Director.class).addAnnotatedClass(Movie.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();

            session.get(Director.class, 2).getMovies().stream().forEach(System.out::println);

            Director director = session.get(Movie.class, 5).getDirector();
            System.out.println(director);

            Movie movie = new Movie(director, "The Age of Innocence", 1993);
            director.getMovies().add(movie);
            session.save(movie);

            Director director1 = new Director("Aaron Schneider",58);
            session.save(director1);
            Movie movie1 = new Movie(director1, "Greyhound", 2020);
            director1.setMovies(new ArrayList<>(Collections.singletonList(movie1)));
            session.save(movie1);

            Movie movie2 = session.get(Movie.class, 1 );
            Director director2 = session.get(Director.class, 2 );
            movie2.getDirector().getMovies().remove(movie2);
            movie2.setDirector(director2);
            director2.getMovies().add(movie2);

            Movie movie3 = session.get(Movie.class, 1);
            movie3.getDirector().getMovies().remove(movie3);
            session.remove(movie3);


            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
