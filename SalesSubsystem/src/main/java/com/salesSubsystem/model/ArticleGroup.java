package com.salesSubsystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="articleGroup")
public class ArticleGroup {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private long id;

	@Column(name="name")
	private String name;

	@OneToMany(
			fetch = FetchType.EAGER,
			cascade = CascadeType.ALL
	)
	@JsonBackReference(value="articleGroup_pdv")
	private List<PDV> pdvs;

	public ArticleGroup(String name, List<PDV> pdvs) {
		this.name = name;
		this.pdvs = pdvs;
	}

	public ArticleGroup(long id, String name, List<PDV> pdvs) {
		super();
		this.id = id;
		this.name = name;
		this.pdvs = pdvs;
	}

	public ArticleGroup() {
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
	public List<PDV> getPdvs() {
		return pdvs;
	}
	public void setPdvs(List<PDV> pdvs) {
		this.pdvs = pdvs;
	}

}
