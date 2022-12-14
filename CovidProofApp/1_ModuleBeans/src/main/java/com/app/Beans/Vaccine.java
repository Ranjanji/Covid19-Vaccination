package com.app.Beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Vaccine {
	
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer vaccineId;
  private String vaccineName;
  private String description;
}
