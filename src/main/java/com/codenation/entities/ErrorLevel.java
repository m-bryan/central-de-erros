package com.codenation.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorLevel {

	ERROR("ERROR"), WARNING("WARNING"), INFO("INFO");

	private String description;

	public static ErrorLevel get(final String value) {
		for (final ErrorLevel e : ErrorLevel.values()) {
			if (e.getDescription().equalsIgnoreCase(value) || e.name().equalsIgnoreCase(value)) {
				return e;
			}
		}
		throw new IllegalArgumentException("Cannot convert '" + value + "' to ErrorLevel");
	}
}
