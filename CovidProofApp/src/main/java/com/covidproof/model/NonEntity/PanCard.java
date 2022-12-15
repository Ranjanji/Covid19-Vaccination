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
	@NotNull
	@Pattern(regexp = "^[A-Z0-9]{8}",message="Length length must be 10 character")
	private String panNumber;
}
