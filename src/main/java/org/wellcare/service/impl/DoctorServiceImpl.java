package org.wellcare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wellcare.exception.ResourceNotFoundException;
import org.wellcare.model.Doctor;
import org.wellcare.repository.DoctorRepository;
import org.wellcare.service.DoctorService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;

	private static final String DOCTOR_NOT_FOUND = "Doctor not found with ID: ";

	@Override
	public List<Doctor> getAllDoctors() {
		return doctorRepository.findAll();
	}

	@Override
	public Doctor addDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}

	@Override
	public Doctor updateDoctor(Long id, Doctor doctor) {
		Doctor exsitingDoc = doctorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(DOCTOR_NOT_FOUND + id));
		exsitingDoc.setName(doctor.getName());
		exsitingDoc.setSpecialization(doctor.getSpecialization());

		return doctorRepository.save(exsitingDoc);
	}

	@Override
	public String deleteDoctor(Long id) {
		if (!doctorRepository.existsById(id)) {
			throw new ResourceNotFoundException(DOCTOR_NOT_FOUND + id);
		}
		doctorRepository.deleteById(id);
		return "Doctor Id : " + id + " Deleted Successfully.";
	}

	@Override
	public Doctor getDoctorById(Long id) {
		return doctorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(DOCTOR_NOT_FOUND + id));
	}

}
