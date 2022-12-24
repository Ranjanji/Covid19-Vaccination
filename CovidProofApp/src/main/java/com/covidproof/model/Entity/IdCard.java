package com.covidproof.model.Entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.covidproof.model.NonEntity.PanCard;

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
public class IdCard {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotNull(message = "name cannot be null.")
	@NotBlank(message = "name cannot be blank.")
	@NotEmpty(message = "name cannot be empty.")
	@Size(min=3,max=15, message="Name should be of 3 to 15 characters")
	private String name;
	
	@NotNull(message = "gender cannot be null.")
	@NotBlank(message = "gender cannot be blank.")
	@NotEmpty(message = "gender cannot be empty.")
	@Size(max=1, message="Enter M/F only")
	private String gender;
	
	@NotNull(message = "dob cannot be null.")
	@Past(message="DoB should be in past.")
	private LocalDate dob;
	
	//Verified accordingly as per DOB
	private Integer age;
	
	@NotNull(message = "address details cannot be null.")
	@NotBlank(message = "address details cannot be blank.")
	@NotEmpty(message = "address details cannot be empty.")
	@Size(min=7,max=70, message="Enter your full address")
	private String address;
	
	@NotNull(message = "city name cannot be null.")
	@NotBlank(message = "city name cannot be blank.")
	@NotEmpty(message = "city name cannot be empty.")
	private String city;
	
	@NotNull(message = "state name cannot be null.")
	@NotBlank(message = "state name cannot be blank.")
	@NotEmpty(message = "state name cannot be empty.")
	private String state;
	
	@NotNull(message="pincode should not be null")
	@Pattern(regexp = "^[0-9]{6}",message="Pincode Length must be 6 digits")
	private String pincode;
	
	@NotNull(message="Mobile no should not be null")
	@Pattern(regexp = "^[0-9]{10}",message="Mobile number length must be 10 digits")
	private String mobile;
	
	
	@Embedded
	private PanCard pancard;  //For saving PanCard details of Applicant 
	
	@OneToOne
	@JoinColumn(name = "adNo")
	private AadharCard aadharcard;   //unidirectional relation with AadharCard Entity
	
	@OneToMany(cascade = CascadeType.ALL) //unidirectional relation with Dose Entity
	@JoinColumn(name="id")
	private List<Dose> doses;
}
