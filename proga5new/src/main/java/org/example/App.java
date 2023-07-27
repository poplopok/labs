package org.example;

import org.example.Data.Flat;
import org.example.utils.CollectionManager;
import org.example.utils.CommandHelper;

import java.io.IOException;
import java.util.*;

public class App {
    public static Date date=new Date();
    public static String pathname;

    public void run (Scanner scanner) throws IOException {
        CommandHelper commandHelper=new CommandHelper();
        String console_name = null;
        LinkedHashSet<Flat> collection=new CollectionManager().getCollection();

        List<String> list= new ArrayList<>();

        while (true) {
            list.clear();
            try {
                console_name = scanner.next();
            }catch (NoSuchElementException e){
                System.out.println("Файл выполнен");
                break;
            }
            String[] cmd = console_name.split(" ");
            list.add(cmd[0]);
            console_name=cmd[0];
            switch (cmd[0]){
                case "execute_script":{
                    if(cmd.length==1){
                        System.out.println("передайте агрумент после команды");
                        continue;
                    }
                    else list.add(cmd[1]);

                }
                case "update": {
                    if(cmd.length==1){
                        System.out.println("передайте агрумент после команды");
                        continue;
                    }else list.add(cmd[1]);
                }
                case "filter_starts_with_name":{
                    if(cmd.length==1){
                        System.out.println("передайте агрумент после команды");
                        continue;
                    }else list.add(cmd[1]);
                }
                case "remove_by_id":{
                    if(cmd.length==1){
                        System.out.println("передайте агрумент после команды");
                        continue;
                    }else list.add(cmd[1]);
                }
                default:{
                    if((cmd.length>1)&& list.size()==1){
                        System.out.println("такой команды нет");
                        continue;
                    }
                }
            }


            if ((commandHelper.argCheckMap().containsKey(console_name))) {
                commandHelper.argCheckMap().get(console_name).execute(list,scanner);
            } else System.out.println("команды " + console_name + " нету, воспользуйтесь командой help");
        }
    }
}
