package menu.domain;

import menu.common.dto.MenuPickResult;
import menu.common.dto.MenuPickResults;
import menu.common.exceptin.CustomExceptions;
import menu.service.numberPicker.NumberPicker;
import menu.service.objectPicker.StringShuffler;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LaunchMates {
	
	private static final int MIN_MATES_SIZE = 2;
	private static final int MAX_MATES_SIZE = 5;
	private static final List<String> LAUNCH_PICKING_DAYS = List.of("월", "화", "수", "목", "금");
	
	private final List<LaunchMate> mates;
	
	public LaunchMates(List<LaunchMate> mates) {
		Objects.requireNonNull(mates);
		validateMatesSize(mates);
		validateMatesNameNoDuplicated(mates);
		this.mates = mates;
	}
	
	private static void validateMatesSize(List<LaunchMate> mates) {
		if (mates.size() < MIN_MATES_SIZE || mates.size() > MAX_MATES_SIZE) {
			throw CustomExceptions.ILLEGAL_LAUNCH_MATES_SIZE.get(MIN_MATES_SIZE, MAX_MATES_SIZE);
		}
	}
	
	private void validateMatesNameNoDuplicated(List<LaunchMate> mates) {
		int noDuplicationMateNames = mates.stream()
				.map(LaunchMate::getName)
				.collect(Collectors.toSet())
				.size();
		if (noDuplicationMateNames != mates.size()) {
			throw CustomExceptions.LAUNCH_MATES_NAME_DUPLICATED.get();
		}
	}
	
	public MenuPickResults pickMenus(NumberPicker numberPicker, StringShuffler stringShuffler) {
		List<MenuType> menuTypes = MenuType.pickMenuTypes(LAUNCH_PICKING_DAYS.size(), numberPicker);
		List<MenuPickResult> menuPickResults = new ArrayList<>();
		for (LaunchMate mate : mates) {
			menuPickResults.add(mate.pickMenus(menuTypes, stringShuffler));
		}
		List<String> menuTypeNames = menuTypes.stream()
				.map(Enum::name)
				.collect(Collectors.toList());
		return new MenuPickResults(LAUNCH_PICKING_DAYS, menuTypeNames, menuPickResults);
	}
}
