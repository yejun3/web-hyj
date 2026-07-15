package com.korea.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentDTO {
	private int id;
	private String name;
	private String course;
	private String email;
	
}
