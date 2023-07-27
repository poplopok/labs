package org.example.Commands;

import org.example.Data.Flat;
import org.example.utils.CollectionManager;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

public class CommandFilters implements DefaultCommand{

    CollectionManager collectionManager=new CollectionManager();
    LinkedHashSet<Flat> collection=collectionManager.getCollection();

    public void execute(List<String> list, Scanner scanner) {
        int i=0;
        for(Flat elem: collection){
            String str=".*"+list.get(1)+".*";
            if (elem.getName().matches(str)){
                System.out.println(elem);
                i=1;
            }
        }
        if (i!=1){
            System.out.println("Такой подстроки нет.");
        }
    }

    public String getName() {
        return "filter ";
    }
}
