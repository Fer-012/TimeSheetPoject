package com.project.TimeSheet.TimeProject.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TIMESHEET")
public class TimeWork {
	@Id
	@Column(name="TIME_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String workHours;
	private String displayTime;
	private String hourStart;
	private String currentTime;
	private String dateDuJour;
	
	@OneToOne(cascade=CascadeType.ALL, optional=false)
	@JoinTable(name = "timesheet_projet",
    joinColumns = @JoinColumn(name = "timesheet_id"),
    inverseJoinColumns = @JoinColumn(name = "projet_id"))
	private Projects idproject;
	
	private String note;
	private String titleProject;

	
	
	public String getTitleProject() {
		return titleProject;
	}


	public void setTitleProject(String titleProject) {
		this.titleProject = titleProject;
	}


	public TimeWork() {
        // Default constructor
    }


	


	public TimeWork(String workHours, String displayTime, String hourStart, String currentTime, String dateDuJour,
			Projects idproject, String note, String titleProject) {
		super();
		this.workHours = workHours;
		this.displayTime = displayTime;
		this.hourStart = hourStart;
		this.currentTime = currentTime;
		this.dateDuJour = dateDuJour;
		this.idproject = idproject;
		this.note = note;
		this.titleProject = titleProject;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getWorkHours() {
		return workHours;
	}


	public void setWorkHours(String workHours) {
		this.workHours = workHours;
	}


	public String getDisplayTime() {
		return displayTime;
	}


	public void setDisplayTime(String displayTime) {
		this.displayTime = displayTime;
	}


	public String getHourStart() {
		return hourStart;
	}


	public void setHourStart(String hourStart) {
		this.hourStart = hourStart;
	}


	public String getCurrentTime() {
		return currentTime;
	}


	public void setCurrentTime(String currentTime) {
		this.currentTime = currentTime;
	}


	public String getDateDuJour() {
		return dateDuJour;
	}


	public void setDateDuJour(String dateDuJour) {
		this.dateDuJour = dateDuJour;
	}


	public Projects getIdproject() {
		return idproject;
	}


	public void setIdproject(Projects idproject) {
		this.idproject = idproject;
	}


	public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}


	@Override
	public String toString() {
		return "TimeWork [id=" + id + ", workHours=" + workHours + ", displayTime=" + displayTime + ", hourStart="
				+ hourStart + ", currentTime=" + currentTime + ", dateDuJour=" + dateDuJour + ", idproject=" + idproject
				+ ", note=" + note + ", titleProject=" + titleProject + "]";
	}


	


	
	
}
