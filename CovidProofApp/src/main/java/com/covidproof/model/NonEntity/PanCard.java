package com.covidproof.model.NonEntity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
public class PanCard {
	
	@Pattern(regexp = "^[A-Z0-9]{8}",message="Length must be 8 character [0-9/A-Z]")
	private String panNumber;
}
