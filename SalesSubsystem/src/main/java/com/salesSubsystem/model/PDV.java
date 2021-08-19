package com.salesSubsystem.model;

import java.util.Date;
import java.util.List;

public class PDV {

	private Date validFrom;
	private double pdvAssessment;
	private List<ArticleGroup> articleGroups;

	public PDV(Date validFrom, double pdvAssessment, List<ArticleGroup> articleGroups) {
		super();
		this.validFrom = validFrom;
		this.pdvAssessment = pdvAssessment;
		this.articleGroups = articleGroups;
	}

	public PDV() {
		super();
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
