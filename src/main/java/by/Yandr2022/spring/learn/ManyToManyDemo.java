package by.Yandr2022.spring.learn;


import by.Yandr2022.spring.learn.model2.Actor;
import by.Yandr2022.spring.learn.model2.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ManyToManyDemo {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Movie.class).addAnnotatedClass(Actor.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        try (sessionFactory; Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

//            Movie movie = new Movie("Pulp fiction", 1994);
//            Actor actor = new Actor("Harvey Keytel", 81);
//            Actor actor1 = new Actor("Samuel L.Jackson", 72);
//            movie.setActors(new ArrayList<>(List.of(actor,actor1)));
//            actor.setMovies(new ArrayList<>(Collections.singletonList(movie)));
//            actor1.setMovies(new ArrayList<>(Collections.singletonList(movie)));
//            session.save(movie);
//            session.save(actor);
//            session.save(actor1);

//            session.get(Movie.class,1).getActors().stream().forEach(System.out::println);

//            Movie movie = new Movie("Reservoir Dogs", 1992);
//            Actor actor = session.get(Actor.class, 1);
//            movie.setActors(new ArrayList<>(Collections.singletonList(actor)));
//            actor.getMovies().add(movie);
//            session.save(movie);

//            session.get(Actor.class, 1).getMovies().stream().forEach(System.out::println);

            Actor actor = session.get(Actor.class, 2);
            Movie movieToRemove = actor.getMovies().get(0);
            actor.getMovies().remove(movieToRemove);
            movieToRemove.getActors().remove(actor);

            session.getTransaction().commit();
        }
    }
}
