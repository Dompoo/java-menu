package menu.domain;

import menu.CustomExceptions;

import java.util.List;
import java.util.Objects;

public class Coach {
	
	private static final int MIN_NAME_LENGTH = 2;
	private static final int MAX_NAME_LENGTH = 4;
	private static final int MAX_NO_EAT_MENU = 2;
	
	private final String name;
	private final List<Menu> noEatMenu;
	
	public Coach(String name, List<Menu> noEatMenu) {
		Objects.requireNonNull(name);
		Objects.requireNonNull(noEatMenu);
		validateNameLength(name);
		validateNoEatMenuSize(noEatMenu);
		this.name = name;
		this.noEatMenu = noEatMenu;
	}
	
	private static void validateNameLength(String name) {
		if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
			throw CustomExceptions.ILLEGAL_COACH_NAME_LENGTH.get(MIN_NAME_LENGTH, MAX_NAME_LENGTH);
		}
	}
	
	private static void validateNoEatMenuSize(List<Menu> noEatMenu) {
		if (noEatMenu.size() > MAX_NO_EAT_MENU) {
			throw CustomExceptions.ILLEGAL_NO_EAT_MENU_SIZE.get(MAX_NO_EAT_MENU);
		}
	}
}
