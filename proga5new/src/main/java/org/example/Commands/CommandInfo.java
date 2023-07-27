package org.example.Commands;

import org.example.Main;
import org.example.Data.Flat;
import org.example.utils.CollectionManager;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

public class CommandInfo implements DefaultCommand{

    CollectionManager collectionManager=new CollectionManager();
    LinkedHashSet<Flat> collection;

    public void execute(List<String> list, Scanner scanner) {

        collection=collectionManager.getCollection();

        System.out.print("Тип коллекции: java.util.LinkedHashSet\n" +
                "Дата инициализации: "+ Main.date +"\n"+
                "Количество элементов в коллекции- "+collection.size()+"\n");
    }

    public String getName() {
        return "info";
    }
}
