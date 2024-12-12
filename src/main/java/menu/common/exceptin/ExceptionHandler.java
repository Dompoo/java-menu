package menu.common.exceptin;

import menu.io.writer.Writer;

public class ExceptionHandler {
	
	private final Writer writer;
	
	public ExceptionHandler(final Writer writer) {
		this.writer = writer;
	}
	
	public void handleException(final Exception exception) {
		writer.write("[ERROR] " + exception.getMessage() + "\n");
	}
}
