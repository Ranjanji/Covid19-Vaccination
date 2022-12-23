package com.covidproof.model.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
public class AdminPasswordDTO {
	
	@NotNull(message="Mobile no should not be null")
	@Pattern(regexp = "^[0-9]{10}",message="Mobile number length must consist 10 digits")
	private String mobile;
	
	@NotNull(message = "Old Password cannot be null.")
	@Pattern(regexp = "^[a-zA-Z0-9]{8}",message="Old Password length must be 8 character")
	private String old_pass;
	
	@NotNull(message = "New Password cannot be null.")
	@Pattern(regexp = "^[a-zA-Z0-9]{8}",message="New Password length must be 8 character")
	private String new_pass;
}
