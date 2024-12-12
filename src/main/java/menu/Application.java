package menu;

import menu.common.exceptin.ExceptionHandler;
import menu.common.retry.RetryHandler;
import menu.controller.Controller;
import menu.io.input.InputHandler;
import menu.io.input.InputParser;
import menu.io.input.InputValidator;
import menu.io.output.OutputHandler;
import menu.io.output.OutputParser;
import menu.io.reader.ConsoleReader;
import menu.io.writer.ConsoleWriter;
import menu.io.writer.Writer;
import menu.service.numberPicker.RandomNumberPicker;
import menu.service.objectPicker.RandomObjectPicker;

public class Application {
    public static void main(String[] args) {
        Writer writer = new ConsoleWriter();
        new Controller(
                new RetryHandler(new ExceptionHandler(writer)),
                new InputHandler(new ConsoleReader(), writer, new InputValidator(), new InputParser()),
                new OutputHandler(writer, new OutputParser()),
                new RandomNumberPicker(),
                new RandomObjectPicker<>()
        ).run();
    }
}
