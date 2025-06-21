package org.wellcare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wellcare.exception.ResourceNotFoundException;
import org.wellcare.model.Appointment;
import org.wellcare.repository.AppointmentRepository;
import org.wellcare.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	private static final String APPOINTMENT_NOT_FOUND = "Appointment Not found with ID : ";
	@Autowired
	AppointmentRepository appointmentRepository;

	@Override
	public List<Appointment> getAllAppointment() {
		return appointmentRepository.findAll();
	}

	@Override
	public Appointment addAppointment(Appointment appointment) {
		return appointmentRepository.save(appointment);
	}

	@Override
	public Appointment getAppointmentById(Long id) {
		return appointmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(APPOINTMENT_NOT_FOUND + id));
	}

	@Override
	public Appointment updateAppointment(long id, Appointment appointment) {
		Appointment existingApp = appointmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(APPOINTMENT_NOT_FOUND + id));
		existingApp.setPatient(appointment.getPatient());
		existingApp.setDoctor(appointment.getDoctor());
		existingApp.setAppointmentTime(appointment.getAppointmentTime());
		existingApp.setCancelled(appointment.isCancelled());
		return appointmentRepository.save(existingApp);
	}

	@Override
	public String deleteAppointment(long id) {
		if (!appointmentRepository.existsById(id)) {
			throw new ResourceNotFoundException(APPOINTMENT_NOT_FOUND + id);
		}
		appointmentRepository.deleteById(id);
		return "Appoointment Id : " + id + "Deleted Successfully";
	}

}
