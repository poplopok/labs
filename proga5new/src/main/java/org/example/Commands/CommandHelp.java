package org.example.Commands;

import org.example.utils.CommandHelper;

import java.util.List;
import java.util.Scanner;

public class CommandHelp implements DefaultCommand{
    public void execute(List<String> list, Scanner scanner) {
        CommandHelper commandHelper=new CommandHelper();
        int mxintshtushki=1;
        for (String name:commandHelper.argCheckMap().keySet()){
            if(mxintshtushki<name.length()){
                mxintshtushki=name.length();
            }
        }
            for (String name:commandHelper.argCheckMap().keySet()){

            int intshtushki=mxintshtushki-name.length();
            String shuchki="";
            for(int i=0;i<intshtushki;i++){
                shuchki=shuchki+"-";
            }
            System.out.println(name+" "+shuchki+"-> "+commandHelper.commandList().get(name));
        }
    }

    public String getName() {
        return "help";
    }
}
