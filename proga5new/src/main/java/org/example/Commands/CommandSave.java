package org.example.Commands;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.Main;
import org.example.Data.Flat;
import org.example.utils.CollectionManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

public class CommandSave implements DefaultCommand{
    public void execute(List<String> list, Scanner scanner) {

        Gson serializer = new GsonBuilder().setPrettyPrinting().create();
        CollectionManager collectionManager=new CollectionManager();
        LinkedHashSet<Flat> collection=collectionManager.getCollection();
        PrintWriter writer;
        File json_collection = null;

        try{json_collection=new File(Main.pathname);} catch (NullPointerException e){
                System.out.println("файл не найден");
                System.exit(0);
            }
            try {
                writer = new PrintWriter(json_collection);
                writer.write(serializer.toJson(collection));
                writer.close();
            }catch (NullPointerException | FileNotFoundException e) {
                System.out.println("Ошибка, файл не найден! проверьте путь к файлу и перезапустите программу.");
                System.exit(0);
            }
            System.out.println("Коллекция успешно сохранена в файл");
        }


    public String getName() {
        return "save";
    }
}
