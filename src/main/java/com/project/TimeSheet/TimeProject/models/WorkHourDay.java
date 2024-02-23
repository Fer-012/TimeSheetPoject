package com.project.TimeSheet.TimeProject.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="WORKHOURDAY")
public class WorkHourDay {
	@Id
	@Column(name="WORKTIMEDAY_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String dateDay;
	private String sunday;
	private String monday;
	private String tuesday;
	private String wednesday;
	private String thursday;
	private String friday;
	private String saturday;
	private String numderHour ;
	private String timeIn;
	private String timeOut;
	private String restTime;
	private String durationRecess;
	
	public WorkHourDay() {
        // Default constructor
    }
	public WorkHourDay(String dateDay, String sunday, String monday, String tuesday, String wednesday, String thursday,
			String friday, String saturday, String numderHour, String timeIn, String timeOut, String restTime,
			String durationRecess) {
		super();
		this.dateDay = dateDay;
		this.sunday = sunday;
		this.monday = monday;
		this.tuesday = tuesday;
		this.wednesday = wednesday;
		this.thursday = thursday;
		this.friday = friday;
		this.saturday = saturday;
		this.numderHour = numderHour;
		this.timeIn = timeIn;
		this.timeOut = timeOut;
		this.restTime = restTime;
		this.durationRecess = durationRecess;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDateDay() {
		return dateDay;
	}
	public void setDateDay(String dateDay) {
		this.dateDay = dateDay;
	}
	public String getSunday() {
		return sunday;
	}
	public void setSunday(String sunday) {
		this.sunday = sunday;
	}
	public String getMonday() {
		return monday;
	}
	public void setMonday(String monday) {
		this.monday = monday;
	}
	public String getTuesday() {
		return tuesday;
	}
	public void setTuesday(String tuesday) {
		this.tuesday = tuesday;
	}
	public String getWednesday() {
		return wednesday;
	}
	public void setWednesday(String wednesday) {
		this.wednesday = wednesday;
	}
	public String getThursday() {
		return thursday;
	}
	public void setThursday(String thursday) {
		this.thursday = thursday;
	}
	public String getFriday() {
		return friday;
	}
	public void setFriday(String friday) {
		this.friday = friday;
	}
	public String getSaturday() {
		return saturday;
	}
	public void setSaturday(String saturday) {
		this.saturday = saturday;
	}
	public String getNumderHour() {
		return numderHour;
	}
	public void setNumderHour(String numderHour) {
		this.numderHour = numderHour;
	}
	public String getTimeIn() {
		return timeIn;
	}
	public void setTimeIn(String timeIn) {
		this.timeIn = timeIn;
	}
	public String getTimeOut() {
		return timeOut;
	}
	public void setTimeOut(String timeOut) {
		this.timeOut = timeOut;
	}
	public String getRestTime() {
		return restTime;
	}
	public void setRestTime(String restTime) {
		this.restTime = restTime;
	}
	public String getDurationRecess() {
		return durationRecess;
	}
	public void setDurationRecess(String durationRecess) {
		this.durationRecess = durationRecess;
	}
	@Override
	public String toString() {
		return "WorkHourDay [id=" + id + ", dateDay=" + dateDay + ", sunday=" + sunday + ", monday=" + monday
				+ ", tuesday=" + tuesday + ", wednesday=" + wednesday + ", thursday=" + thursday + ", friday=" + friday
				+ ", saturday=" + saturday + ", numderHour=" + numderHour + ", timeIn=" + timeIn + ", timeOut="
				+ timeOut + ", restTime=" + restTime + ", durationRecess=" + durationRecess + "]";
	}
	
	
}
