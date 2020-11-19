package com.capg.hcs.repository;

import java.math.BigInteger;
import java.time.LocalDateTime;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capg.hcs.entity.AppointmentManagement;

/*******************************************************************************************************************************
-Author                   :     Mohammad Ikram
-Created/Modified Date    :     15-11-2020
-Description              :     

*******************************************************************************************************************************/
@Repository
public interface IAppointmentRepo extends JpaRepository<AppointmentManagement, BigInteger> {
    @Query("FROM AppointmentManagement where centreId = ?1")
	public List<AppointmentManagement> findAll(String centreId);

	public AppointmentManagement getAppointmentByDateTimeAndTestId(LocalDateTime dateTime, String testId);
	

}
