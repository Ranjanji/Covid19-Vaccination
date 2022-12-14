package com.app.Beans;

import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class VaccineInventory {
	
	  @NotNull
	  private LocalDate date;
	  
}
