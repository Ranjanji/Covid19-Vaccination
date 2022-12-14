package com.app.Beans;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class VaccinationCenter {
	  private Integer code;
	  private String centerName;
	  private String address;
	  private String city;
	  private String state;
	  private String pincode;
	  
	  
}
