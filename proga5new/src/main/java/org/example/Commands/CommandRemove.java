package org.example.Commands;

import org.example.Data.Flat;
import org.example.utils.CollectionManager;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

public class CommandRemove implements DefaultCommand{

    CollectionManager collectionManager=new CollectionManager();
    LinkedHashSet<Flat> collection=collectionManager.getCollection();

    public void execute(List<String> list, Scanner scanner) {
        boolean flag=false;

        int id = -1;
        try {
            id= Integer.parseInt(list.get(1));
        }catch (NumberFormatException e){
            System.out.println("id должен быть числом(int)");
            flag=true;
        }

        for (Flat flat: collection){
            if(flat.getId()==id){
                collection.remove(flat);
                System.out.println("Элемент с id "+list.get(1)+" успешно удален");
                flag=true;
                break;
            }
        }

        if(!flag){
            System.out.println("Элемента с id "+id+" не существует");
        }
    }

    public String getName() {
        return "remove";
    }
}
