package com.covidproof.model.Entity;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class CurrentSession {
	//foreign key for login users
	@Id
	private Integer userId;
	
	//User Unique Id
	private String uuid;
	
	//Current session login time
	private LocalDateTime localDateTime;	
}

