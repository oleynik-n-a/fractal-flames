package backend.academy.stream.handlers;

import java.io.InputStream;
import java.util.Scanner;

public final class InputHandler {
    public static final InputHandler INSTANCE = new InputHandler();
    private static Scanner scanner;

    private InputHandler() {
    }

    public void setInputStream(InputStream inputStream) {
        scanner = new Scanner(inputStream);
    }

    public Integer tryReadInteger() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public Long tryReadLong() {
        try {
            return Long.parseLong(scanner.nextLine());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public String readString() {
        return scanner.nextLine();
    }
}
