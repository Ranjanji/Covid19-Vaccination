package com.covidproof.model.Entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

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
	private String name;
	private String gender;
	private LocalDate dob;
	private String address;
	private String city;
	private String state;
	private String pincode;
	private String mobile;
	@Embedded
	private PanCard pancard;
	@OneToOne
	@PrimaryKeyJoinColumn
	private AadharCard aadharcard;
	@OneToMany(mappedBy = "idCard",cascade = CascadeType.ALL)//bydirctional
	private Set<Dose> doses;
}
