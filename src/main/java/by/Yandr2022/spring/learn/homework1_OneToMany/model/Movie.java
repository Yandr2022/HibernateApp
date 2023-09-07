package by.Yandr2022.spring.learn.homework1_OneToMany.model;

import by.Yandr2022.spring.learn.model.Person;

import javax.persistence.*;
@Entity
@Table(name="movie")
public class Movie {
    @Column(name="movie_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "director_id", referencedColumnName = "director_id")
    private Director director;
    @Column(name = "name")
    private String name;

    @Column(name = "year_of_production")
    private int year;

    public Movie() {
    }

    public Movie(Director director, String name, int year) {
        this.director = director;
        this.name = name;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Movie{ name='" + name + '\'' +
                ", year=" + year +
                '}';
    }
}
