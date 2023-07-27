package org.example.Commands;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public interface DefaultCommand {
    String getName();

    default String getDescription() {
        return "Что-то в interface DefaultCommand";
    }

    void execute(List<String> list, Scanner scanner) throws IOException;
}
