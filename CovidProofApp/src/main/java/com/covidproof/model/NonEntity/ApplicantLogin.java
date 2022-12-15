package com.covidproof.model.NonEntity;



import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
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
	@NotNull
	@NotBlank
	@NotEmpty
	@Size(min=10,max=10, message="Mobile number should be of 10digit")
	private String mobile;
	@NotNull
	@Past
	private LocalDate dob;
}
