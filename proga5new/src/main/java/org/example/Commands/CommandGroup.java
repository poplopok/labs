package org.example.Commands;

import org.example.Data.Flat;
import org.example.utils.CollectionManager;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

public class CommandGroup implements DefaultCommand{
        CollectionManager collectionManager=new CollectionManager();
        LinkedHashSet<Flat> collection=collectionManager.getCollection();

    public void execute(List<String> list, Scanner scanner) {
        LinkedHashSet<Flat> col1 = new LinkedHashSet<>();
        LinkedHashSet<Flat> col2 = new LinkedHashSet<>();
        int sum1=0;
        int sum2=0;
        for(Flat elem:collection){
            if (elem.getId()%2==1){
                //НЕЧЕТНЫЕ Id
                sum1++;
                col1.add(elem);
            }
            if (elem.getId()%2==0){
                //ЧЕТНЫЕ Id
                col2.add(elem);
                sum2++;
            }
        }
        System.out.println("Количество элементов в первой группе: "+sum1+"\n"+"Количество элементов в первой группе: "+sum2);

    }

    public String getName() {
        return "group";
    }
}
