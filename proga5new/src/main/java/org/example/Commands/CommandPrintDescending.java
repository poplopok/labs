package org.example.Commands;

import org.example.Data.Flat;
import org.example.utils.CollectionManager;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

public class CommandPrintDescending implements DefaultCommand{

    CollectionManager collectionManager=new CollectionManager();
    LinkedHashSet<Flat> collection=collectionManager.getCollection();

    public void execute(List<String> list, Scanner scanner) {
        LinkedHashSet<Flat> flat = new LinkedHashSet<>();
        Flat flatok=null;
        int z=0;
        for (Flat elem:collection){
            int x=0;
            int y= collection.size();
            y=y+z;
            for (Flat value : collection) {
                x=x+1;
                if (x == y){
                    flatok = value;
                }
            }
            z=z-1;
            flat.add(flatok);
        }
        collection=flat;
        System.out.println(collection);
    }

    public String getName() {
        return "print descending";
    }
}
