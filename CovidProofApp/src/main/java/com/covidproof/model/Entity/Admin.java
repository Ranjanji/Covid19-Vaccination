package com.covidproof.model.Entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer AdminId;
	
	@NotNull(message = "Admin name cannot be null.")
	@Size(min = 5, message = "Admin name must be of atleast 5 character length.")
	private String name;
	
	@NotNull(message = "Admin mobile number cannot be null.")
	@Size(min = 10, max = 10, message = "Mobile number must be of 10 digits.")
	private String mobile;
	
	@NotNull(message = "Admin password cannot be null.")
	@Size(min = 5, max = 12, message = "Admin password must be minimum 5 & maximum 12 character length.")
	private String password;
}
