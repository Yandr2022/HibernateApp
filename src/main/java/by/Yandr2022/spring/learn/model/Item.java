package by.Yandr2022.spring.learn.model;

import javax.persistence.*;

@Entity
@Table(name="item")
public class Item {
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
@ManyToOne
@JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person owner;
    @Column(name = "name")
    private String name;

    public Item() {
    }

    public Item(Person person, String name) {
        this.name = name;
        this.owner=person;
    }
    public Item( String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item{" +
                "owner=" + owner +
                ", name='" + name + '\'' +
                '}';
    }
}
