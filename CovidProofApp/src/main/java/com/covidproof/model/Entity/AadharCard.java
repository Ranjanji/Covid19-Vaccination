package com.covidproof.model.Entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
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
public class AadharCard {
	@Id
	@NotNull
	private Long adNo;
	@NotNull
	@NotBlank
	@NotEmpty
	@Size(min=10,max=10, message="Mobile number should be of 10digit")
	private String mobile;
//	@OneToOne(mappedBy = "aadharcard",cascade = CascadeType.ALL) //bydirctional
//	@JoinColumn(name = "adNo")
//	private IdCard idCard;
}
