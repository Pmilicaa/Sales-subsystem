package com.salesSubsystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="unitOfMeasure")
public class UnitOfMeasure {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="shortName")
    private String shortName;

    @OneToMany(
            mappedBy = "id",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    @JsonBackReference(value="unitOfMeasure_article")
    private List<Article> articles;

    public UnitOfMeasure(long id, String name, String shortName, List<Article> articles) {
        super();
        this.id = id;
        this.name = name;
        this.shortName = shortName;
        this.articles = articles;
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
    public List<Article> getArticles() {return articles;}
    public void setArticles(List<Article> articles) {this.articles = articles;}
}
