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
		writer.write("코치의 이름을 입력해 주세요. (, 로 구분)\n");
		String input = reader.readLine();
		inputValidator.validateLaunchMateNames(input);
		return inputParser.parseLaunchMateNames(input);
	}
	
	public List<String> handleNoEatMenuNames(String mateName) {
		writer.write("%s(이)가 못 먹는 메뉴를 입력해 주세요.\n".formatted(mateName));
		String input = reader.readLine();
		inputValidator.validateNoEatMenuNames(input);
		return inputParser.parseNoEatMenuNames(input);
	}
}
