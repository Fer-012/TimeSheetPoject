package com.project.TimeSheet.TimeProject.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.util.Set;

@Entity
@Table(name="PROJECTS")
public class Projects {
	@Id
	@Column(name="PROJECT_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String description;
	private String client;
	private String dateStart;
	private String dateEnd;
	private byte fileTimeShet;
	
	@OneToOne(cascade=CascadeType.ALL, optional=false)
	@JoinColumn(name="consultant_id", nullable=true)
	private User idConsultant;
	
	private boolean isShown;
	private boolean adminDecision;
	

	
	public Projects() {
		
	}

	public Projects(String title, String description, String client, String dateStart, String dateEnd,
			byte fileTimeShet, User idConsultant) {
		super();
		this.title = title;
		this.description = description;
		this.client = client;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.fileTimeShet = fileTimeShet;
		
		this.idConsultant = idConsultant;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getDateStart() {
		return dateStart;
	}

	public void setDateStart(String dateStart) {
		this.dateStart = dateStart;
	}

	public String getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}

	public byte getFileTimeShet() {
		return fileTimeShet;
	}

	public void setFileTimeShet(byte fileTimeShet) {
		this.fileTimeShet = fileTimeShet;
	}

	public User getIdConsultant() {
		return idConsultant;
	}

	public void setIdConsultant(User idConsultant) {
		this.idConsultant = idConsultant;
	}

	@Override
	public String toString() {
		return "Projects [id=" + id + ", title=" + title + ", description=" + description + ", client=" + client
				+ ", dateStart=" + dateStart + ", dateEnd=" + dateEnd + ", fileTimeShet=" + fileTimeShet
				+ ", idConsultant=" + idConsultant + "]";
	}

	public boolean isShown() {
		return isShown;
	}

	public void setShown(boolean isShown) {
		this.isShown = isShown;
	}

	public boolean isAdminDecision() {
		return adminDecision;
	}

	public void setAdminDecision(boolean adminDecision) {
		this.adminDecision = adminDecision;
	}
	
	
	
	
		
}
