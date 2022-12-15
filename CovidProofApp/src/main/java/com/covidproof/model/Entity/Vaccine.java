package com.covidproof.model.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
public class Vaccine {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer vaccineId;
	
	@NotNull(message = "Vaccine name cannot be null.")
	@NotBlank(message = "Vaccine name cannot be blank.")
	@NotEmpty(message = "Vaccine name cannot be empty.")
	private String name;
	
	@NotNull(message = "Vaccine description cannot be null.")
	private String description;
}
