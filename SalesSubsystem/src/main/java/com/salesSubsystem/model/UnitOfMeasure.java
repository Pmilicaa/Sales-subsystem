package com.salesSubsystem.model;

import javax.persistence.*;

@Entity
@Table(name="unitOfMeasure")
public class UnitOfMeasure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="shortName")
    private String shortName;

    public UnitOfMeasure(long id, String name, String shortName) {
        super();
        this.id = id;
        this.name = name;
        this.shortName = shortName;
    }

    public UnitOfMeasure() {
        super();
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getShortName() {
        return shortName;
    }
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}
