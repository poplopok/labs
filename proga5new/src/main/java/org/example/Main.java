package org.example;

import java.io.IOException;
import java.util.*;

import org.example.Data.Flat;
import org.example.utils.CollectionManager;
import org.example.utils.CommandHelper;

public class Main {
    public static Date date=new Date();
    public static String pathname;

    public static void main(String[] args) throws IOException {
        App app=new App();
        LinkedHashSet<Flat> collection;
        Scanner scanner=new Scanner(System.in).useDelimiter("\n");
        pathname=args[0];

        CollectionManager collectionManager=new CollectionManager();
        try {
            collection = collectionManager.load(pathname);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("В строку не передано файла");
        }
        while (true) {
            app.run(scanner);
        }
    }
}

