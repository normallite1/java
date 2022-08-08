package ua.kostia.social.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;


@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String login;
    private Integer pass;

    public User(int id, String login, Integer pass) {
        this.id = id;
        this.login = login;
        this.pass = pass;
    }
    public User(){

    }
}
