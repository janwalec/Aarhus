package org.database;

import javax.persistence.*;


@Entity
public class HabitCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Habit_Cat_ID", nullable = false)
    private Integer id;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Description", length = 1024)
    private String description;

    public HabitCategory() {};

    public HabitCategory(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "[HabitCategory\n" + "\tname: " + name + " ID: " + id +
                "\n\tDescription: " + description + "]";
    }


}