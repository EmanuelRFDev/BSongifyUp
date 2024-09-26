package com.example.apirestsongifyup.presentation.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class MusicDto {

	private Long id;
	
	private String song;
	
	private String artist;
	
	private String gender;
	
}
