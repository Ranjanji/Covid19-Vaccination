package com.covidproof.model.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
@Entity
public class VaccineCenter {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer centerCode;
	
	@NotNull(message = "center name cannot be null.")
	@NotBlank(message = "center name cannot be blank.")
	@NotEmpty(message = "center name cannot be empty.")
	@Size(min=3,max=30, message="center name should of 3-30 characters")
	private String centerName;
	
	@NotNull(message = "address details cannot be null.")
	@NotBlank(message = "address details cannot be blank.")
	@NotEmpty(message = "address details cannot be empty.")
	@Size(min=5,max=50, message="Enter Center's full address of 5-50 characters")
	private String address;
	
	@NotNull(message = "city name cannot be null.")
	@NotBlank(message = "city name cannot be blank.")
	@NotEmpty(message = "city name cannot be empty.")
	@Size(min=3, message="Enter city name must consist of 3 characters.")
	private String city;
	
	@NotNull(message = "state name cannot be null.")
	@NotBlank(message = "state name cannot be blank.")
	@NotEmpty(message = "state name cannot be empty.")
	@Size(min=3, message="Enter state name must consist of 3 characters.")
	private String state;
	
	@NotNull(message="pincode should not be null")
	@Pattern(regexp = "^[0-9]{6}",message="PinCode Length must be 6 digits")
	private String pincode;
}
