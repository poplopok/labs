package org.example.Commands;


import org.example.Data.Flat;
import org.example.utils.CollectionManager;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

public class CommandAddMin implements DefaultCommand{
    CommandAdd commandAdd=new CommandAdd();
    CollectionManager collectionManager=new CollectionManager();
    LinkedHashSet<Flat> collection=collectionManager.getCollection();
    public void execute(List<String> list, Scanner scanner) throws IOException {

        int min=11111110;

        for (Flat value : collection) {
            int x = Math.toIntExact(value.getNumberOfRooms());
            if (x < min) {
                min = x;
            }
        }
        Flat flat=commandAdd.inputAdd();
        if(flat.getNumberOfRooms()<min){
            collection.add(flat);
            System.out.println("Элемент успешно добавлен");
        }
        else             System.out.println("Элемент не добавлен, так как превышает минимальный элемент");

    }
    public String getName() {
        return "add if max";
    }}
