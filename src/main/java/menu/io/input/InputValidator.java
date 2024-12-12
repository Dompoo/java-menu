package menu.io.input;

import menu.common.exceptin.CustomExceptions;

import java.util.regex.Pattern;

public class InputValidator {
	
	private static final Pattern LAUNCH_MATE_NAMES_PATTERN = Pattern.compile("(.+,)*.+");
	private static final Pattern NO_EAT_MENU_NAMES_PATTERN = Pattern.compile("(.+,)*.+");
	
	public void validateLaunchMateNames(String input) {
		if (!LAUNCH_MATE_NAMES_PATTERN.matcher(input).matches()) {
			throw CustomExceptions.INVALID_LAUNCH_MATES_NAME_FORMAT.get();
		}
	}
	
	public void validateNoEatMenuNames(String input) {
		if (!NO_EAT_MENU_NAMES_PATTERN.matcher(input).matches()) {
			throw CustomExceptions.INVALID_NO_EAT_MENU_NAME_FORMAT.get();
		}
	}
}
