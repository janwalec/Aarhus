package org.database;

import javax.persistence.*;


import java.time.LocalDate;

@Entity
public class Entry {
    @Id
    @Column(name = "Entry_ID", nullable = false)
    private Integer id;

    @Column(name = "Date", nullable = false)
    private LocalDate date;

    @Column(name = "Value", nullable = false, length = 32)
    private String value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Journal_ID")
    private org.database.Journal journal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public org.database.Journal getJournal() {
        return journal;
    }

    public void setJournal(org.database.Journal journal) {
        this.journal = journal;
    }

}