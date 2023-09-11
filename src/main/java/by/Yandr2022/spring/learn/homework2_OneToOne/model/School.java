package by.Yandr2022.spring.learn.homework2_OneToOne.model;

import javax.persistence.*;

@Entity
@Table(name="school")
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="school_number")
    private int number;


    @OneToOne
    @JoinColumn(name="principal_id", referencedColumnName = "id")
    private Principal principal;

    public School() {
    }

    public School(int number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Principal getPrincipal() {
        return principal;
    }

    public void setPrincipal(Principal principal) {
        this.principal = principal;
    }

    @Override
    public String toString() {
        return "School{" +
                "number=" + number +
                ", principal=" + principal.getName() +
                '}';
    }
}
