package menu.io.output;

import menu.common.dto.MenuPickResult;
import menu.common.dto.MenuPickResults;

import java.util.StringJoiner;

public class OutputParser {
	
	public String parseMenuPickResults(MenuPickResults menuPickResults) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(parsePickingDay(menuPickResults));
		stringBuilder.append("\n");
		stringBuilder.append(parseMenuTypeNames(menuPickResults));
		stringBuilder.append("\n");
		for (MenuPickResult menuPickResult : menuPickResults.menuPickResult()) {
			stringBuilder.append(parseMenus(menuPickResult, stringBuilder));
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}
	
	private static String parseMenus(MenuPickResult menuPickResult, StringBuilder stringBuilder) {
		StringJoiner menuJoiner = new StringJoiner(" | ", "[ ", " ]");
		menuJoiner.add(menuPickResult.coachName());
		for (String menuName : menuPickResult.menuName()) {
			menuJoiner.add(menuName);
		}
		return menuJoiner.toString();
		
	}
	
	private static String parsePickingDay(MenuPickResults menuPickResults) {
		StringJoiner pickingDayJoiner = new StringJoiner(" | ", "[ ", " ]");
		pickingDayJoiner.add("구분");
		for (String menuPickingDayName : menuPickResults.menuPickingDayNames()) {
			pickingDayJoiner.add(menuPickingDayName);
		}
		return pickingDayJoiner.toString();
	}
	
	private static String parseMenuTypeNames(MenuPickResults menuPickResults) {
		StringJoiner categoryJoiner = new StringJoiner(" | ", "[ ", " ]");
		categoryJoiner.add("카테고리");
		for (String menuTypeName : menuPickResults.menuTypeNames()) {
			categoryJoiner.add(menuTypeName);
		}
		return categoryJoiner.toString();
	}
}
