package org.database;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "User")
public class User {
    @Id
    @Column(name = "UserName", nullable = false, length = 64)
    private String userName;

    @Column(name = "Name", nullable = false, length = 64)
    private String name;

    @Column(name = "Surname", nullable = false, length = 64)
    private String surname;

    @Column(name = "Age", nullable = false)
    private Integer age;

    public User(){}

    public User(String userName, String name, String surname, Integer age) {
        this.userName = userName;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User u = (User) o;
        return Objects.equals(userName, u.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, userName, age);
    }

    @Override
    public String toString() {
        return ("{User: " + this.userName + " Name:" + this.name + " Surname:" + this.surname + " Age:" + this.age + "}");
    }

}