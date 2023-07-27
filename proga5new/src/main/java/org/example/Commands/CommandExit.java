package org.example.Commands;

import java.util.List;
import java.util.Scanner;

public class CommandExit implements DefaultCommand{
    public void execute(List<String> list, Scanner scanner) {
        System.out.println("Программа завершена.");
        System.exit(0);
    }

    public String getName() {
        return "exit";
    }
}
