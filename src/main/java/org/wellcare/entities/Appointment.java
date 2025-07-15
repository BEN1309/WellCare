package org.wellcare.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;  // Unique appointment ID

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="patient_id",  nullable = false)
	private Patient patient;  // Patient booking the appointment

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="doctor_id",  nullable = false)
	private Doctor doctor;  // Doctor assigned to appointment

	private LocalDateTime appointmentTime;  // Scheduled date & time

	private boolean cancelled; // True if appointment has been cancelled
}
