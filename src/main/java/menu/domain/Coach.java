package menu.domain;

import menu.CustomExceptions;

import java.util.Objects;

public class Coach {
	
	private static final int MIN_NAME_LENGTH = 2;
	private static final int MAX_NAME_LENGTH = 4;
	
	private final String name;
	
	public Coach(String name) {
		Objects.requireNonNull(name);
		validate(name);
		this.name = name;
	}
	
	private static void validate(String name) {
		if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
			throw CustomExceptions.ILEEGAL_COACH_NAME_LENGTH.get(MIN_NAME_LENGTH, MAX_NAME_LENGTH);
		}
	}
}
