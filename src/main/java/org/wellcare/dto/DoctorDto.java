package org.wellcare.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDto {

	@NotBlank(message = "Doctor Name is Required")
	private String name;

	@NotBlank(message = "Specialization is required")
	private String specialization;

	@Builder.Default
	private boolean available = true;

}
