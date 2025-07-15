package org.wellcare.service;

import java.util.List;

import org.wellcare.entities.Doctor;

public interface DoctorService {

	List<Doctor> getAllDoctors(); 

	Doctor addDoctor(Doctor doctor);

	Doctor updateDoctor(Long id, Doctor doctor);

	String deleteDoctor(Long id);

	Doctor getDoctorById(Long id);


	

}
