package com.app.Beans;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Min;
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
public class VaccineCount {
      
	  @NotNull
	  @Min(value = 0)
	  private Integer count;
	  private double price;
	  
}
