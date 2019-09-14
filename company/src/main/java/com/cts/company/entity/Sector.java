package com.cts.company.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sector")
public class Sector {

//	@OneToOne(mappedBy = "sector")
//	private Company company;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
	private int sectorId;
	
	@Column(name="sec_name", nullable = false, length = 20, unique = true)
	private String secName;
	
	@Column(name="sec_brief")
	private String sectorBrief;

	public String getSecName() {
		return secName;
	}

	public void setSecName(String secName) {
		this.secName = secName;
	}

	public String getSectorBrief() {
		return sectorBrief;
	}

	public void setSectorBrief(String sectorBrief) {
		this.sectorBrief = sectorBrief;
	}

	public int getSectorId() {
		return sectorId;
	}

	public void setSectorId(int sectorId) {
		this.sectorId = sectorId;
	}

	@Override
	public String toString() {
		return "Sector [sectorId=" + sectorId + ", secName=" + secName + ", sectorBrief=" + sectorBrief + "]";
	}

	public Sector(int sectorId, String secName, String sectorBrief) {
		super();
		this.sectorId = sectorId;
		this.secName = secName;
		this.sectorBrief = sectorBrief;
	}

	public Sector() {
		super();
	}
}
