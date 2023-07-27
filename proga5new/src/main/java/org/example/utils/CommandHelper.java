package org.example.utils;

import java.io.Serializable;
import java.util.HashMap;
import org.example.Commands.*;

public class CommandHelper implements Serializable {

    public HashMap<String, String> commandList() {

        HashMap<String,String> map=new HashMap<String,String>();
        map.put("add", "add new element to the collection");
        map.put("add_if_max", "add a new element to the collection, if its value is greater than the value of the largest element of this collection");
        map.put("add_if_min", "add a new element to the collection, if its value is lower than the value of the minimal element of this collection");
        map.put("clear", "clear the collection");
        map.put("execute_script", "execute script from specified file");
        map.put("exit", "terminate program");
        map.put("filter_starts_with_name", "display elements whose name field value starts with the given substring");
        map.put("group","show quantity");
        map.put("help","print help for all available commands");
        map.put("info", "display information about the collection");
        map.put("print_descending","show elements in reverse order");
        map.put("remove_by_id", "remove item from collection by ID");
        map.put("remove_lower", "remove from the collection all elements smaller than the given one");
        map.put("save","save collection");
        map.put("show", "display all elements of the collection");
        map.put("update", "update collection element value by ID");

        return map;
    }

    public HashMap<String , DefaultCommand> argCheckMap(){

        HashMap<String, DefaultCommand> map = new HashMap<String, DefaultCommand>();


        map.put("add", new CommandAdd());
        map.put("add_if_max", new CommandAddMax());
        map.put("add_if_min", new CommandAddMin());
        map.put("clear", new CommandClear());
        map.put("filter_starts_with_name", new CommandFilters());
        map.put("help", new CommandHelp());
        map.put("info", new CommandInfo());
        map.put("group", new CommandGroup());
        map.put("remove_by_id", new CommandRemove());
        map.put("show", new CommandShow());
        map.put("save", new CommandSave());
        map.put("exit", new CommandExit());
        map.put("update", new CommandUpdate());
        map.put("execute_script",new CommandExecute());
        map.put("print_descending",new CommandPrintDescending());
        return map;
    }

}
