package com.spring.models;

import java.util.Arrays;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "Reports")
public class Report {

	@Id
	@GeneratedValue
	private int ReportId;
	@NonNull
    private String Description;
	
	//@Column(columnDefinition = "TEXT")
	@Lob
    private byte[] Picture;
    @NonNull
    private double Latitude;
    @NonNull
    private double Longitude;
    @NonNull
    private Long DateTimeReport;
    private String Solution;
    private Long DateTimeSolution;
    private int StatusCode;
    private String UserId;
    private String AdminId;
    
	public int getReportId() {
		return ReportId;
	}
	public void setReportId(int reportId) {
		ReportId = reportId;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public byte[] getPicture() {
		return Picture;
	}
	public void setPicture(byte[] picture) {
		Picture = picture;
	}
	public double getLatitude() {
		return Latitude;
	}
	public void setLatitude(double latitude) {
		Latitude = latitude;
	}
	public double getLongitude() {
		return Longitude;
	}
	public void setLongitude(double longitude) {
		Longitude = longitude;
	}
	public Long getDateTimeReport() {
		return DateTimeReport;
	}
	public void setDateTimeReport(Long dateTimeReport) {
		DateTimeReport = dateTimeReport;
	}
	public String getSolution() {
		return Solution;
	}
	public void setSolution(String solution) {
		Solution = solution;
	}
	public Long getDateTimeSolution() {
		return DateTimeSolution;
	}
	public void setDateTimeSolution(Long dateTimeSolution) {
		DateTimeSolution = dateTimeSolution;
	}
	public int getStatusCode() {
		return StatusCode;
	}
	public void setStatusCode(int statusCode) {
		StatusCode = statusCode;
	}
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public String getAdminId() {
		return AdminId;
	}
	public void setAdminId(String adminId) {
		AdminId = adminId;
	}
	@Override
	public String toString() {
		return "Report [ReportId=" + ReportId + ", Description=" + Description + ", Picture=" + Arrays.toString(Picture)
				+ ", Latitude=" + Latitude + ", Longitude=" + Longitude + ", DateTimeReport=" + DateTimeReport
				+ ", Solution=" + Solution + ", DateTimeSolution=" + DateTimeSolution + ", StatusCode=" + StatusCode
				+ ", UserId=" + UserId + ", AdminId=" + AdminId + "]";
	}
    
    
    
}
