package org.wellcare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wellcare.entities.Patient;
import org.wellcare.exception.ResourceNotFoundException;
import org.wellcare.repository.PatientRepository;
import org.wellcare.service.PatientService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

	@Autowired
	PatientRepository patientRepository;
	
	
	private static final String PATIENT_NOT_FOUND = "Patient Not found with ID : ";

	@Override
	public List<Patient> getAllPatient() {
		return patientRepository.findAll();
	}

	@Override
	public Patient addPatient(Patient patient) {
		return patientRepository.save(patient);
	}

	@Override
	public Patient updatePatient(long id, Patient patient) {
		Patient existingPat = patientRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(PATIENT_NOT_FOUND + id));
		existingPat.setName(patient.getName());
		existingPat.setEmail(patient.getEmail());
		existingPat.setPhone(patient.getPhone());
		existingPat.setAddress(patient.getAddress());
		return patientRepository.save(existingPat);
	}

	@Override
	public String deletePatient(long id) {
		if (!patientRepository.existsById(id)) {
			throw new ResourceNotFoundException(PATIENT_NOT_FOUND + id);
		}
		patientRepository.deleteById(id);
		return "Patient Id : " + id + "Deleted Successfully";
	}

	@Override
	public Patient getPatientById(long id) {
		return patientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(PATIENT_NOT_FOUND + id));

	}
}
