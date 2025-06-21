package org.wellcare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.wellcare.model.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

	
	Doctor findByName(String name);
	
	List<Doctor> findByAvailable(Boolean available);
	
	
}
