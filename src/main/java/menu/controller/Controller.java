package menu.controller;

import menu.common.dto.MenuPickResults;
import menu.domain.LaunchMate;
import menu.domain.LaunchMates;
import menu.domain.Menu;
import menu.io.input.InputHandler;
import menu.io.output.OutputHandler;
import menu.service.numberPicker.NumberPicker;
import menu.service.numberPicker.RandomNumberPicker;
import menu.service.objectPicker.ObjectPicker;

import java.util.ArrayList;
import java.util.List;

public class Controller {
	
	private final InputHandler inputHandler;
	private final OutputHandler outputHandler;
	private final NumberPicker numberPicker;
	private final ObjectPicker<Menu> menuPicker;
	
	public Controller(InputHandler inputHandler, OutputHandler outputHandler, RandomNumberPicker numberPicker, ObjectPicker<Menu> menuPicker) {
		this.inputHandler = inputHandler;
		this.outputHandler = outputHandler;
		this.numberPicker = numberPicker;
		this.menuPicker = menuPicker;
	}
	
	public void run() {
		List<LaunchMate> mates = new ArrayList<>();
		List<String> names = inputHandler.handleLaunchMateNames();
		for (String name : names) {
			List<String> noEatMenuNames = inputHandler.handleNoEatMenuNames(name);
			mates.add(LaunchMate.of(name, noEatMenuNames));
		}
		LaunchMates launchMates = new LaunchMates(mates);
		MenuPickResults result = launchMates.pickMenus(numberPicker, menuPicker);
		outputHandler.handleMenuPickResults(result);
	}
}
