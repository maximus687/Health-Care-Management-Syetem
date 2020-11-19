package com.capg.hcs.entity;

import java.math.BigInteger;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

/*******************************************************************************************************************************
 * -Author                : Mohammad Ikram 
 * -Created/Modified Date : 14-11-2020 
 * -Description           :
 * 
 *******************************************************************************************************************************/
@Entity
public class AppointmentManagement {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private BigInteger appointmentId;
	@NotNull
	private String centreId;
	@NotNull
	String userId;
	@NotNull
	private String testId;
	@NotNull
	@DateTimeFormat(pattern = "yyyy/MM/ddThh:mm")
	private LocalDateTime dateTime;
	private Status status;

	public AppointmentManagement(BigInteger appointmentId, String centreId, String userId, String testId,
			LocalDateTime dateTime, Status status) {
		super();
		this.appointmentId = appointmentId;
		this.centreId = centreId;
		this.userId = userId;
		this.testId = testId;
		this.dateTime = dateTime;
		this.status = status;
	}
	
	

	public AppointmentManagement() {
		super();
	}



	public BigInteger getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(BigInteger appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getCentreId() {
		return centreId;
	}

	public void setCentreId(String centreId) {
		this.centreId = centreId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}



	public Status getStatus() {
		return status;
	}



	public void setStatus(Status status) {
		this.status = status;
	}

	

}
