package menu.controller;

import menu.common.dto.MenuPickResults;
import menu.common.retry.RetryHandler;
import menu.domain.LaunchMate;
import menu.domain.LaunchMates;
import menu.domain.Menu;
import menu.io.input.InputHandler;
import menu.io.output.OutputHandler;
import menu.service.numberPicker.NumberPicker;
import menu.service.objectPicker.ObjectPicker;

import java.util.ArrayList;
import java.util.List;

public class Controller {
	
	private final RetryHandler retryHandler;
	private final InputHandler inputHandler;
	private final OutputHandler outputHandler;
	private final NumberPicker numberPicker;
	private final ObjectPicker<Menu> menuPicker;
	
	public Controller(RetryHandler retryHandler, InputHandler inputHandler, OutputHandler outputHandler, NumberPicker numberPicker, ObjectPicker<Menu> menuPicker) {
		this.retryHandler = retryHandler;
		this.inputHandler = inputHandler;
		this.outputHandler = outputHandler;
		this.numberPicker = numberPicker;
		this.menuPicker = menuPicker;
	}
	
	public void run() {
		List<LaunchMate> mates = new ArrayList<>();
		
		List<String> names = retryHandler.tryUntilSuccess(inputHandler::handleLaunchMateNames);
		
		for (String name : names) {
			retryHandler.tryUntilSuccess(() -> {
				List<String> noEatMenuNames = inputHandler.handleNoEatMenuNames(name);
				return mates.add(LaunchMate.of(name, noEatMenuNames));
			});
		}
		
		MenuPickResults result = retryHandler.tryUntilSuccess(() -> {
			LaunchMates launchMates = new LaunchMates(mates);
			return launchMates.pickMenus(numberPicker, menuPicker);
		});
		
		outputHandler.handleMenuPickResults(result);
	}
}
