package menu.domain;

import menu.CustomExceptions;

import java.util.List;
import java.util.Objects;

public class LaunchMate {
	
	private static final int MIN_MATES_SIZE = 2;
	private static final int MAX_MATES_SIZE = 5;
	
	private final List<Coach> mates;
	
	public LaunchMate(List<Coach> mates) {
		Objects.requireNonNull(mates);
		validateMatesSize(mates);
		this.mates = mates;
	}
	
	private static void validateMatesSize(List<Coach> mates) {
		if (mates.size() < MIN_MATES_SIZE || mates.size() > MAX_MATES_SIZE) {
			throw CustomExceptions.ILLEGAL_LAUNCH_MATES_SIZE.get(MIN_MATES_SIZE, MAX_MATES_SIZE);
		}
	}
}
