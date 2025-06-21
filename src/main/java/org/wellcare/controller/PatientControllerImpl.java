package org.wellcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.wellcare.model.Patient;
import org.wellcare.service.PatientService;

@CrossOrigin
@RestController
@RequestMapping("/patient")
public class PatientControllerImpl {

	@Autowired
	PatientService patientService;

	@GetMapping("/allPat")
	public ResponseEntity<List<Patient>> getAllPatient() {
		List<Patient> allPatient = patientService.getAllPatient();
		return ResponseEntity.ok(allPatient);
	}

	@PostMapping("/add")
	public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
		Patient newPatient = patientService.addPatient(patient);
		return ResponseEntity.status(HttpStatus.CREATED).body(newPatient);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Patient> updatePatient(@PathVariable long id, @RequestBody Patient patient) {
		Patient updatePat = patientService.updatePatient(id, patient);
		return ResponseEntity.ok(updatePat);
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable long id) {
		return ResponseEntity.ok(patientService.getPatientById(id));
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deletePatient(@PathVariable long id) {
		patientService.deletePatient(id);
		return ResponseEntity.noContent().build();
	}

}
