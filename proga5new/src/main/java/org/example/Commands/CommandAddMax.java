package org.example.Commands;


import org.example.Data.Flat;
import org.example.utils.CollectionManager;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

public class CommandAddMax implements DefaultCommand{
    CommandAdd commandAdd=new CommandAdd();
    CollectionManager collectionManager=new CollectionManager();
    LinkedHashSet<Flat> collection=collectionManager.getCollection();
    public void execute(List<String> list, Scanner scanner) throws IOException {

        int max=0;

        for (Flat value : collection) {
            int x = Math.toIntExact(value.getNumberOfRooms());
            if (x > max) {
                max = x;
            }
        }
        Flat flat=commandAdd.inputAdd();
        if(flat.getNumberOfRooms()>max){
        collection.add(flat);
        System.out.println("Элемент успешно добавлен");
        }
        else             System.out.println("Элемент не добавлен, так как не превышает максимальный элемент");

    }
    public String getName() {
        return "add if max";
    }}
