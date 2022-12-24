package com.covidproof.model.NonEntity;



import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class ApplicantLogin {
	
	@Pattern(regexp = "^[0-9]{10}",message="Mobile number length must be 10 digits [0-9]")
	private String mobile;
	
	@NotNull(message = "dob cannot be null.")
	@Past(message="DoB should be in past.")
	private LocalDate dob;
}
