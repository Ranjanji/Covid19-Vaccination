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
	@NotNull(message = "slot count cannot be null.")
	@NotBlank(message = "slot status cannot be blank.")
	@NotEmpty(message = "slot status cannot be empty.")
	@Size(min=10,max=10, message="Mobile number should be of 10 digit")
	private String mobileNo;
	@NotNull
	@FutureOrPresent(message="Appointment should be present date or future")
	private LocalDate date;
	@NotNull(message = "slot count cannot be null.")
	@NotBlank(message = "slot status cannot be blank.")
	@NotEmpty(message = "slot status cannot be empty.")
	@Size(max=1,message = "Slot can be Between 1 to 9")
	private String slot;
	
	private String bookingStatus;
}
