package com.korea.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseUserDTO {
	private String token;
	private String usernaame;
	private String password;
	private String id;

}
