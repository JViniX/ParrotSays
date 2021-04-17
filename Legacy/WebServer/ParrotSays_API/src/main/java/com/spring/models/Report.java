package com.spring.models;

import java.util.Arrays;

//import javax.persistence.Column;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "Reports")
public class Report {

	@Id
	@GeneratedValue
	private int reportId;
	@NotEmpty
    private String description;
	
	//@Column(columnDefinition = "TEXT")
	@Lob
    private byte[] picture;
	@NonNull
    private double latitude;
	@NonNull
    private double longitude;
	@NonNull
    private Long dateTimeReport;
    private String solution;
    private Long dateTimeSolution;
    @NonNull
    private Status statusCode;

	@ManyToOne
	@JoinColumn(name="userId")
	private User user;

	@ManyToOne
	@JoinColumn(name="adminId")
	private User admin;
    
    public Report() {}
    
	public Report(int reportId, String description, double latitude, double longitude, Long dateTimeReport,
				  Status statusCode) {
		super();
		this.reportId = reportId;
		this.description = description;
		this.latitude = latitude;
		this.longitude = longitude;
		this.dateTimeReport = dateTimeReport;
		this.statusCode = statusCode;
	}

	public int getReportId() {
		return reportId;
	}
	public void setReportId(int reportId) {
		this.reportId = reportId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public byte[] getPicture() {
		return picture;
	}
	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public Long getDateTimeReport() {
		return dateTimeReport;
	}
	public void setDateTimeReport(Long dateTimeReport) {
		this.dateTimeReport = dateTimeReport;
	}
	public String getSolution() {
		return solution;
	}
	public void setSolution(String solution) {
		this.solution = solution;
	}
	public Long getDateTimeSolution() {
		return dateTimeSolution;
	}
	public void setDateTimeSolution(Long dateTimeSolution) {
		this.dateTimeSolution = dateTimeSolution;
	}
	public Status getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Status statusCode) {
		this.statusCode = statusCode;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getAdmin() {
		return admin;
	}

	public void setAdmin(User admin) {
		this.admin = admin;
	}
}
