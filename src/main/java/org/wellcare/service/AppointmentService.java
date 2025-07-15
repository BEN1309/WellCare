package org.wellcare.service;

import java.util.List;

import org.wellcare.entities.Appointment;

public interface AppointmentService {

	List<Appointment> getAllAppointment();

	Appointment addAppointment(Appointment appointment);
	
	Appointment getAppointmentById(Long id);

	Appointment updateAppointment(long id, Appointment appointment);

	String deleteAppointment(long id);

}
