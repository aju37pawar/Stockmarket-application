package com.cts.company.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "company")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "comp_code")
	private int companyId;

	@Column(name = "comp_name", nullable = false, length = 40, unique = true)
	private String companyName;

	@Column(name = "comp_turnover")
	private double turnover;

	@Column(name = "comp_ceo", nullable = false, length = 40)
	private String ceo;

	@Column(name = "comp_bod")
	private String boardOfDirectors;

	@Column(name = "comp_about")
	private String about;

	@Column(name = "activation", nullable = false)
	private int activation;

	@OneToOne
	@JoinColumn(name = "sector_id")
	private Sector sector;

//	@OneToOne(cascade = CascadeType.ALL)
//	@PrimaryKeyJoinColumn
//	private IpoDetail ipoDetail;

//	public IpoDetail getIpoDetail() {
//		return ipoDetail;
//	}
//
//	public void setIpoDetail(IpoDetail ipoDetail) {
//		this.ipoDetail = ipoDetail;
//	}

	public int getActivation() {
		return activation;
	}

	public void setActivation(int activation) {
		this.activation = activation;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public double getTurnover() {
		return turnover;
	}

	public void setTurnover(double turnover) {
		this.turnover = turnover;
	}

	public String getCeo() {
		return ceo;
	}

	public void setCeo(String ceo) {
		this.ceo = ceo;
	}

	public String getBoardOfDirectors() {
		return boardOfDirectors;
	}

	public void setBoardOfDirectors(String boardOfDirectors) {
		this.boardOfDirectors = boardOfDirectors;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	public Company(int companyId, String companyName, double turnover, String ceo, String boardOfDirectors,
			String about, int activation, Sector sector) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.turnover = turnover;
		this.ceo = ceo;
		this.boardOfDirectors = boardOfDirectors;
		this.about = about;
		this.activation = activation;
		this.sector = sector;
	}

	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyName=" + companyName + ", turnover=" + turnover + ", ceo="
				+ ceo + ", boardOfDirectors=" + boardOfDirectors + ", about=" + about + ", activation=" + activation
				+ ", sector=" + sector + "]";
	}

	public Company() {
		super();
	}

//	@Override
//	public String toString() {
//		return "Company [companyId=" + companyId + ", companyName=" + companyName + ", turnover=" + turnover + ", ceo="
//				+ ceo + ", boardOfDirectors=" + boardOfDirectors + ", about=" + about + ", sector=" + sector + "]";
//	}
//
//	public Company(int companyId, String companyName, double turnover, String ceo, String boardOfDirectors,
//			String about, Sector sector) {
//		super();
//		this.companyId = companyId;
//		this.companyName = companyName;
//		this.turnover = turnover;
//		this.ceo = ceo;
//		this.boardOfDirectors = boardOfDirectors;
//		this.about = about;
//		this.sector = sector;
//	}

}
