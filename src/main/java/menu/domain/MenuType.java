package menu.domain;

import menu.common.exceptin.CustomExceptions;
import menu.service.numberPicker.NumberPicker;

import java.util.ArrayList;
import java.util.List;

public enum MenuType {
	
	일식(1),
	한식(2),
	중식(3),
	아시안(4),
	양식(5),
	;
	
	private final int typePickNumber;
	
	MenuType(int typePickNumber) {
		this.typePickNumber = typePickNumber;
	}
	
	private static final int MAX_DUPLICATION = 2;
	private static final int MIN_TYPE_PICK_NUMBER = 1;
	private static final int MAX_TYPE_PICK_NUMBER = 5;
	
	public static List<MenuType> pickMenuTypes(int size, NumberPicker numberPicker) {
		if (size > calculateMaxPickSize()) {
			throw CustomExceptions.ILLEGAL_MENU_TYPE_PICK_SIZE.get(calculateMaxPickSize());
		}
		List<MenuType> menuTypes = new ArrayList<>();
		while(menuTypes.size() != size) {
			int pickedNumber = numberPicker.pickNumberInRange(MIN_TYPE_PICK_NUMBER, MAX_TYPE_PICK_NUMBER);
			for (MenuType menuType : MenuType.values()) {
				if (menuType.typePickNumber == pickedNumber && calculateMenuTypeCount(menuType, menuTypes) < MAX_DUPLICATION) {
					menuTypes.add(menuType);
				}
			}
		}
		return menuTypes;
		
	}
	
	private static int calculateMenuTypeCount(MenuType menuType, List<MenuType> menuTypes) {
		int count = 0;
		for (MenuType type : menuTypes) {
			if (type == menuType) count++;
		}
		return count;
	}
	
	private static int calculateMaxPickSize() {
		return (MAX_TYPE_PICK_NUMBER - MIN_TYPE_PICK_NUMBER + 1) * MAX_DUPLICATION;
	}
}
