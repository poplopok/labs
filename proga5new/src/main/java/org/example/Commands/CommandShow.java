package org.example.Commands;

import org.example.Data.Flat;
import org.example.utils.CollectionManager;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

public class CommandShow implements DefaultCommand{

    CollectionManager collectionManager=new CollectionManager();
    LinkedHashSet<Flat> collection=collectionManager.getCollection();

    public void execute(List<String> list, Scanner scanner) {
        System.out.println("коллекция Flat: \n"+collection);
    }

    public String getName() {
        return "show";
    }
}
