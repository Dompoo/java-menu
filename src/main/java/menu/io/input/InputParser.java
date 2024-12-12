package menu.io.input;

import java.util.Arrays;
import java.util.List;

public class InputParser {
	
	public List<String> parseLaunchMateNames(String input) {
		return Arrays.stream(input.split(","))
				.map(String::trim)
				.toList();
	}
	
	public List<String> parseNoEatMenuNames(String input) {
		return Arrays.stream(input.split(","))
				.map(String::trim)
				.toList();
	}
}
