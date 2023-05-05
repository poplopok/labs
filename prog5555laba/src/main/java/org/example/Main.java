package org.example;

import java.io.IOException;
import java.util.*;

import org.example.data.Flat;


/**
 * The type Main.
 */
public class Main {
    static Date date=new Date();

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */

    public static void main(String[] args) throws IOException {
        String nameFile = "";
        try {
              nameFile=args[0];
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Аргумент командной строки не передан, попробуйте еще раз");
        }
        LinkedHashSet<Flat> collection = new LinkedHashSet<>();
        Scanner scanner=new Scanner(System.in).useDelimiter("\n");
        List<String> list=new ArrayList<>();
        Commands commands= new Commands(collection);
        ConsoleInput c=new ConsoleInput(collection, commands);
        System.out.println("вывести справку по доступным командам можно введя help\n");
        c.load(nameFile);
        while (c.work){
            Commands.ident=0;
            System.out.print("Введите команду >>> ");

            String line = "";
            line=scanner.next();
            String[] cmd = line.split(" ");
            list.add(cmd[0]);
            if (cmd.length>1){list.add(cmd[1]);}
            c.Command(list);
                list.clear();
        }
    }
}
