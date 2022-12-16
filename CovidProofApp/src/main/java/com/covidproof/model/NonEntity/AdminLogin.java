// package com.covidproof.model.NonEntity;


// import javax.validation.constraints.NotBlank;
// import javax.validation.constraints.NotEmpty;
// import javax.validation.constraints.NotNull;
// import javax.validation.constraints.Pattern;
// import javax.validation.constraints.Size;

// import lombok.AllArgsConstructor;
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;
// import lombok.ToString;

// @NoArgsConstructor
// @AllArgsConstructor
// @ToString
// @Getter
// @Setter
// public class AdminLogin {
// 	@NotNull
// 	@NotBlank
// 	@NotEmpty
// 	@Size(min=10,max=10, message="Mobile number should be of 10digit")
// 	private String mobile;
// 	@NotNull
// 	@Pattern(regexp = "^[a-zA-Z0-9]{8}",message="Length length must be 8 character")
// 	private String password;
// }
