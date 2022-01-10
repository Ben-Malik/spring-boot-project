package com.notlarim.notlarimltd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("unused")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

	private String username;
	private String firstName;
	private String lastName;
	private String email;
	
}
