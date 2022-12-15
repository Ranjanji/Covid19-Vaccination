package com.covidproof.model.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
	@NotBlank
	@NotEmpty
	@NotNull
	@Size(min=3,max=30, message="Enter center name")
	private String centerName;
	@NotBlank
	@NotEmpty
	@NotNull
	@Size(min=7,max=50, message="Enter Center's full address")
	private String address;
	@NotBlank
	@NotEmpty
	@NotNull
	@Size(min=3, message="Enter city")
	private String city;
	@NotBlank
	@NotEmpty
	@NotNull
	@Size(min=3, message="Enter state")
	private String state;
	@NotBlank
	@NotEmpty
	@NotNull
	@Size(min=6,max=6, message="Enter the 6digit pinCode")
	private String pincode;
}
