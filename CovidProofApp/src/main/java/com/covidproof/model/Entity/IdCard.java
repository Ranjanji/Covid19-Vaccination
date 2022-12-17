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
	@NotNull(message = "name count cannot be null.")
	@NotBlank(message = "name status cannot be blank.")
	@NotEmpty(message = "name status cannot be empty.")
	@Size(min=3,max=15, message="Enter the First Name only")
	private String name;
	@NotNull(message = "gender count cannot be null.")
	@NotBlank(message = "gender status cannot be blank.")
	@NotEmpty(message = "gender status cannot be empty.")
	@Size(max=1, message="Enter M/F only")
	private String gender;
	@NotNull(message = "dob count cannot be null.")
	@NotBlank(message = "dob status cannot be blank.")
	@NotEmpty(message = "dob status cannot be empty.")
	@Past(message="DoB should be in past.")
	private LocalDate dob;
	
	private Integer age;
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Size(min=7,max=50, message="Enter your full address")
	private String address;
	@NotNull
	@NotBlank
	@NotEmpty
	private String city;
	@NotBlank
	@NotEmpty
	@NotNull
	private String state;
	@NotBlank
	@NotEmpty
	@NotNull
	@Size(min=6,max=6, message="Enter your 6digit pinCode")
	private String pincode;
	@NotNull
	@NotBlank
	@NotEmpty
	@Size(min=10,max=10, message="Mobile number should be of 10digit")
	private String mobile;
	@Embedded
	private PanCard pancard;
	@OneToOne
	@JoinColumn(name = "adNo")
	private AadharCard aadharcard;
	@OneToMany(cascade = CascadeType.ALL) //unidirectional
	@JoinColumn(name="id")
	private List<Dose> doses;
}
