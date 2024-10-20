package org.database;

import javax.persistence.*;


@Entity
@Table(name = "User_Habit")
public class UserHabit {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserName")
    private User userName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Habit_ID")
    private Habit habit;
    @Id
    private Long id;

    public User getUserName() {
        return userName;
    }

    public void setUserName(User userName) {
        this.userName = userName;
    }

    public Habit getHabit() {
        return habit;
    }

    public void setHabit(Habit habit) {
        this.habit = habit;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}