package org.wellcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.wellcare.model.Appointment;
import org.wellcare.service.AppointmentService;

@CrossOrigin
@RestController
@RequestMapping("/appointment")
public class AppointmentControllerImpl {

	@Autowired
	AppointmentService appointmentService;

	@GetMapping("/allApp")
	public ResponseEntity<List<Appointment>> getAllAppointment() {
		List<Appointment> allApp = appointmentService.getAllAppointment();
		return ResponseEntity.ok(allApp);
	}

	@PostMapping("/add")
	public ResponseEntity<Appointment> addAppointment(@RequestBody Appointment appointment) {
		Appointment newApp = appointmentService.addAppointment(appointment);
		return ResponseEntity.status(HttpStatus.CREATED).body(newApp);
	}

	@PutMapping("/updateApp/{id}")
	public ResponseEntity<Appointment> updateAppointment(@PathVariable long id, @RequestBody Appointment appointment) {
		Appointment updateApp = appointmentService.updateAppointment(id, appointment);
		return ResponseEntity.ok(updateApp);
	}

	@GetMapping("/appById/{id}")
	public ResponseEntity<Appointment> getAppointmentById(@PathVariable long id) {
		return ResponseEntity.ok(appointmentService.getAppointmentById(id));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteAppointment(@PathVariable long id) {
		appointmentService.deleteAppointment(id);
		return ResponseEntity.noContent().build();
	}

}
