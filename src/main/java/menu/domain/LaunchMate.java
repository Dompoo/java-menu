package menu.domain;

import menu.CustomExceptions;
import menu.common.dto.MenuPickResult;
import menu.service.objectPicker.ObjectPicker;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LaunchMate {
	
	private static final int MIN_NAME_LENGTH = 2;
	private static final int MAX_NAME_LENGTH = 4;
	private static final int MAX_NO_EAT_MENU = 2;
	
	private final String name;
	private final List<Menu> noEatMenu;
	
	public LaunchMate(String name, List<Menu> noEatMenu) {
		Objects.requireNonNull(name);
		Objects.requireNonNull(noEatMenu);
		validateNameLength(name);
		validateNoEatMenuSize(noEatMenu);
		this.name = name;
		this.noEatMenu = noEatMenu;
	}
	
	private static void validateNameLength(String name) {
		if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
			throw CustomExceptions.ILLEGAL_LAUNCH_MATE_NAME_LENGTH.get(MIN_NAME_LENGTH, MAX_NAME_LENGTH);
		}
	}
	
	private static void validateNoEatMenuSize(List<Menu> noEatMenu) {
		if (noEatMenu.size() > MAX_NO_EAT_MENU) {
			throw CustomExceptions.ILLEGAL_NO_EAT_MENU_SIZE.get(MAX_NO_EAT_MENU);
		}
	}
	
	public static LaunchMate of(String name, List<String> noEatMenuNames) {
		List<Menu> noEatMenus = new ArrayList<>();
		for (String noEatMenuName : noEatMenuNames) {
			noEatMenus.add(Menu.from(noEatMenuName));
		}
		return new LaunchMate(name, noEatMenus);
	}
	
	public MenuPickResult pickMenus(List<MenuType> menuTypes, ObjectPicker<Menu> menuObjectPicker) {
		List<Menu> menus = new ArrayList<>();
		for (MenuType menuType : menuTypes) {
			Menu menu = Menu.pickMenu(menuType, noEatMenu, menuObjectPicker);
			noEatMenu.add(menu);
			menus.add(menu);
		}
		List<String> menuNames = menus.stream()
				.map(Menu::getFormatedMenuName)
				.toList();
		return new MenuPickResult(name, menuNames);
	}
	
	public String getName() {
		return name;
	}
}
