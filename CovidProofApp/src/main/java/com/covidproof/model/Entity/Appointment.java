package com.covidproof.model.Entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GeneratorType;

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
@Entity
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookingid;
	
	@NotNull(message="Mobile no should not be null")
	@Pattern(regexp = "^[0-9]{10}",message="Mobile number length must be 10 digits")
	private String mobile;
	
	@NotNull
	@FutureOrPresent(message="Appointment should be present date or future")
	private LocalDate date;
	
	@NotNull(message = "slot count cannot be null.")
	@NotBlank(message = "slot status cannot be blank.")
	@NotEmpty(message = "slot status cannot be empty.")
	private String slot; 
	
	//BookingStatus will update accordingly
	private String bookingStatus;
}
