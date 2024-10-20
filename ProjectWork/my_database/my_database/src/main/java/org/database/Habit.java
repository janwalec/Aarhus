package org.database;

import javax.persistence.*;

@Entity
public class Habit {
    @Id
    @Column(name = "Habit_ID", nullable = false)
    private Integer id;

    @Column(name = "Name", nullable = false, length = 64)
    private String name;

    @Column(name = "Description", nullable = false, length = 1024)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Habit_Cat_ID")
    private org.database.HabitCategory habitCat;

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

    public org.database.HabitCategory getHabitCat() {
        return habitCat;
    }

    public void setHabitCat(org.database.HabitCategory habitCat) {
        this.habitCat = habitCat;
    }

}