package menu.io.output;

import menu.common.dto.MenuPickResults;
import menu.io.writer.Writer;

public class OutputHandler {
	
	private final Writer writer;
	private final OutputParser outputParser;
	
	public OutputHandler(Writer writer, OutputParser outputParser) {
		this.writer = writer;
		this.outputParser = outputParser;
	}
	
	public void handleMenuPickResults(MenuPickResults menuPickResults) {
		String output = outputParser.parseMenuPickResults(menuPickResults);
		writer.write(output);
	}
}
