package org.example.Commands;

import org.example.Data.Flat;
import org.example.utils.CollectionManager;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

public class CommandUpdate implements DefaultCommand{

    CommandAdd commandAdd=new CommandAdd();
    CollectionManager collectionManager=new CollectionManager();
    LinkedHashSet<Flat> collection=collectionManager.getCollection();
    boolean flag=true;

    public void execute(List<String> list, Scanner scanner) throws IOException {
            int i=0;
            int j=collection.size();
            for (Flat flat : collection) {
                if (flat.getId() == Integer.parseInt(list.get(1))) {
                    collection.remove(flat);

                    collection.add(commandAdd.inputAdd());
                    for (Flat elem:collection){
                        i++;
                        if(i==j){
                        elem.setId(Integer.parseInt(list.get(1)));
                    }
                    }
                    flag=false;
                    break;

                    }
                }
            collectionManager.setCollection(collection);
            if (flag){System.out.println("Элемента с id "+list.get(1)+" нет");}

    }

    public String getName() {
        return "update";
    }
}
