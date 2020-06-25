package com.codenation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventDTO {

	private Long id;
	private String description;
	private String errorLevel;
	private String origin;
	private String createdAt;
}
