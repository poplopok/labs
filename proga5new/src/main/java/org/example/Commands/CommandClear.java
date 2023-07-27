package org.example.Commands;

import org.example.Data.Flat;
import org.example.utils.CollectionManager;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

public class CommandClear implements DefaultCommand{
    CollectionManager collectionManager=new CollectionManager();
    LinkedHashSet<Flat> collection=collectionManager.getCollection();
    public void execute(List<String> list, Scanner scanner) {

    collection.clear();
    collectionManager.setCollection(collection);
        System.out.println("Коллекция успешно очищена");
    }

    public String getName() {
        return "clear";
    }
}
