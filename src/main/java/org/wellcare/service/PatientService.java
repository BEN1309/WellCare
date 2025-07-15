package org.wellcare.service;

import java.util.List;

import org.wellcare.entities.Patient;

public interface PatientService {

	List<Patient> getAllPatient();

	Patient addPatient(Patient patient);

	Patient getPatientById(long id);

	Patient updatePatient(long id, Patient patient);

	String deletePatient(long id);

}
