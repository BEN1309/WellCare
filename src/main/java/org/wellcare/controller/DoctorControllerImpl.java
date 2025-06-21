package org.wellcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.wellcare.model.Doctor;
import org.wellcare.service.DoctorService;

@CrossOrigin
@RestController
@RequestMapping("/doctor")
public class DoctorControllerImpl {

	@Autowired
	private DoctorService doctorservice;

	@GetMapping("/getAll")
	public ResponseEntity<List<Doctor>> getAllDoctors() {
		List<Doctor> allDoctors = doctorservice.getAllDoctors();
		return ResponseEntity.ok(allDoctors);
	}

	@PostMapping("/add")
	public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
		Doctor addDoc = doctorservice.addDoctor(doctor);
		return ResponseEntity.status(HttpStatus.CREATED).body(addDoc);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Doctor> updateDoctor(@PathVariable Long id, @RequestBody Doctor doctor) {
		Doctor updateDoc = doctorservice.updateDoctor(id, doctor);
		return ResponseEntity.ok(updateDoc);
	}

	@GetMapping("/docById/{id}")
	public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) {
		return ResponseEntity.ok(doctorservice.getDoctorById(id));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteDoctor(@PathVariable Long id) {
		doctorservice.deleteDoctor(id);
		return ResponseEntity.noContent().build();
	}

}
