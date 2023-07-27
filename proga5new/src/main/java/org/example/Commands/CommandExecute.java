package org.example.Commands;

import org.example.App;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommandExecute implements DefaultCommand{
    public void execute(List<String> list, Scanner scanner1) throws IOException {
        try {
            Files.write(Paths.get(list.get(1)), "\n".getBytes(), StandardOpenOption.APPEND);
        }catch (IOException e) {
            System.out.println("Файл не найден, попробуйте снова после перезапуска");
            System.exit(0);
        }
        String fileName = list.get(1);
        List<String> lines = new ArrayList<>();


        App app=new App();
        app.run(new Scanner(new File(fileName)).useDelimiter("\n"));
    }

    public String getName() {
        return "execute Script";
    }
}
