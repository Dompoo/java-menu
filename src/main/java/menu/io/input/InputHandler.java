package menu.io.input;

import menu.io.reader.Reader;
import menu.io.writer.Writer;

import java.util.List;

public class InputHandler {
	
	private final Reader reader;
	private final Writer writer;
	private final InputValidator inputValidator;
	private final InputParser inputParser;
	
	public InputHandler(Reader reader, Writer writer, InputValidator inputValidator, InputParser inputParser) {
		this.reader = reader;
		this.writer = writer;
		this.inputValidator = inputValidator;
		this.inputParser = inputParser;
	}
	
	public List<String> handleLaunchMateNames() {
		writer.write("코치의 이름을 입력해 주세요. (, 로 구분)");
		String input = reader.readLine();
		inputValidator.validateLaunchMateNames(input);
		return inputParser.parseLaunchMateNames(input);
	}
}
