package com.salesSubsystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="pdv")
public class PDV {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private long id;

	@Column(name="valid_from")
	private Date validFrom;

	@Column(name="pdv_assessment")
	private double pdvAssessment;

	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name = "article_group_pdv", referencedColumnName = "id", nullable = false)
	@JsonBackReference
	private ArticleGroup articleGroups;

	public PDV(long id, Date validFrom, double pdvAssessment, ArticleGroup articleGroups) {
		this.id = id;
		this.validFrom = validFrom;
		this.pdvAssessment = pdvAssessment;
		this.articleGroups = articleGroups;
	}

	public PDV() {
		super();
	}

	public long getId() {return id;}
	public void setId(long id) {
		this.id = id;
	}
	public ArticleGroup getArticleGroups() {
		return articleGroups;
	}
	public void setArticleGroups(ArticleGroup articleGroups) {
		this.articleGroups = articleGroups;
	}
	public Date getValidFrom() {
		return validFrom;
	}
	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}
	public double getPdvAssessment() {
		return pdvAssessment;
	}
	public void setPdvAssessment(double pdvAssessment) {
		this.pdvAssessment = pdvAssessment;
	}
}
