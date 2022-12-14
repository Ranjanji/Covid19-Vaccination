package com.covidproof.model.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

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
public class Dose {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer doseId;
	private Integer doseCount;
	private String doseStatus;
	
	@ManyToOne                           //bydirectional
	@JoinColumn(name="id")
	private IdCard idCard;
	
	@ManyToOne(cascade = CascadeType.ALL)//unidirection
	@JoinColumn(name = "vaccineId")
	private Vaccine vaccine;
	
	@ManyToOne(cascade = CascadeType.ALL)//unidirection
	@JoinColumn(name = "bookingid")
	private Appointment appointment;
	
	@ManyToOne(cascade = CascadeType.ALL)//unidirection
	@JoinColumn(name = "centerCode")
	private VaccineCenter center;
}







