package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.*;

import org.example.data.Flat;
import com.google.gson.*;

public class Commands {
    static String removestr="";
    public static int ident=0;
    LinkedHashSet<Flat> collection;
    Gson serializer = new GsonBuilder().setPrettyPrinting().create();
    File json_collection = null;
    public Commands(LinkedHashSet<Flat> collection){
        this.collection=collection;
    }
    public void groupCountingById() {
        try {
            json_collection=new File(ConsoleInput.loadFile);
        }catch (NullPointerException e){
            System.out.println("файл не найден");
            System.exit(0);
        }
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
    public void save() throws IOException {
        PrintWriter writer;
        try{json_collection=new File(ConsoleInput.loadFile);} catch (NullPointerException e){
        System.out.println("файл не найден");
        System.exit(0);
    }
        try {
            writer = new PrintWriter(json_collection);
            writer.write(serializer.toJson(collection));
            writer.close();
        }catch (NullPointerException e) {
            System.out.println("Ошибка, файл не найден! проверьте путь к файлу и перезапустите программу.");
            System.exit(0);
        }
        System.out.println("Коллекция успешно сохранена в файл");
    }
    int counte=0;
    public void executeScript(String str,List<String> list) throws IOException {
        counte++;
        try {
            Files.write(Paths.get(str), "\n".getBytes(), StandardOpenOption.APPEND);
        }catch (IOException e) {
            System.out.println("Файл не найден, попробуйте снова после перезапуска");
            System.exit(0);
        }

        ConsoleInput c=new ConsoleInput(collection);
        BufferedInputStream bis=null;
        System.out.println("Введите файл");
        System.out.println(str);
        removestr=str;
        try {
            bis = new BufferedInputStream(new FileInputStream(str));
        }catch (FileNotFoundException e){
            System.out.println("Файл не найден, попробуйте снова после перезапуска.");
            System.exit(0);
        }
        int bufferSize = 1024;
        int count=0;
        byte[] buffer = new byte[bufferSize];
        int bytesRead;
        String line = "";
        int count_execute=0;
        // Читаем файл построчно и выводим каждую строку на экран
        while ((bytesRead = bis.read(buffer)) != -1) {
            String chunk = new String(buffer, 0, bytesRead);
            int lineBreakIndex = chunk.indexOf('\n');
            while (lineBreakIndex != -1) {
                if (ident==0){
                    line += chunk.substring(0, lineBreakIndex);
                list.add(line);
                line = "";
                chunk = chunk.substring(lineBreakIndex + 1);
                lineBreakIndex = chunk.indexOf('\n');}
                if (ident>=1){
                    if(count>0){
                        ConsoleInput.count_list=ConsoleInput.count_list+count_execute;
                    }
                    count++;
                    line += chunk.substring(0, lineBreakIndex);
                    list.add(ConsoleInput.count_list,line);
                    line = "";
                    chunk = chunk.substring(lineBreakIndex + 1);
                    lineBreakIndex = chunk.indexOf('\n');
                    if (count>0){ConsoleInput.count_list=ConsoleInput.count_list-count_execute;}
                    count_execute++;
                }
            }
            if (chunk.length() > 0) {
                line += chunk;
            }

        }
        if(ident>=1){list.remove(removestr);}
        while (list.size()>=ConsoleInput.count_list){
            if (ident==0){ident=1;}
            c.Command(list);
        }
        ident=2;
    }


















    public void printDescending(){
        LinkedHashSet<Flat> flat = new LinkedHashSet<>();
        Flat flatok=null;
        int z=0;
        for (Flat elem:collection){
            int x=0;
            int y= collection.size();
            y=y+z;
            for (Flat value : collection) {
                x=x+1;
                if (x == y){
                    flatok = value;
                }
            }
            z=z-1;
            flat.add(flatok);
        }
        collection=flat;
        System.out.println(collection);
    }
    public void filterStartsWithName(String name){
        ConsoleInput.count_list++;
        int i=0;
        for(Flat elem: collection){
            String str=".*"+name+".*";
            if (elem.getName().matches(str)){
                System.out.println(elem);
                i=1;
            }
        }
        if (i!=1){
            System.out.println("Такой подстроки нет.");
        }
    }
    public void removeLower(Flat flat){
        Integer value=flat.getNumberOfRooms();
        collection.removeIf(elem -> elem.getNumberOfRooms() < value);
        System.out.println("Все элементы меньшие, чем заданный, удалаены");
    }
    public void addIfMin(Flat flat){
        Integer min=1132323122;
        for (Flat value : collection) {
            Integer x = value.getNumberOfRooms();
            if (x < min) {
                min = x;
            }
        }
        if (flat.getNumberOfRooms()<min) {
            collection.add(flat);
            System.out.println("Элемент успешно добавлен");
        } else {
            System.out.println("Элемент не добавлен, так как он превышает минимальный элемент");
        }
    }
    public void addIfMax(Flat flat){
        Integer max=0;
        for (Flat value : collection) {
            Integer x = value.getNumberOfRooms();
            if (x > max) {
                max = x;
            }
        }
        if (flat.getNumberOfRooms()>max){
            collection.add(flat);
            System.out.println("Элемент успешно добавлен");
        } else {
            System.out.println("Элемент не добавлен, так как не превышает максимальный элемент");
        }
    }
    public void exit(){
        if(ident>=1){
            System.out.println("exit");
        }
        System.out.println("Программа завершена");
        System.exit(0);
    }
    public void clear(){
        collection.clear();
        System.out.println("Коллекция успешно очищена");
    }
    public void removeById(long id){
        int l=0;
        if(ident>=1){ConsoleInput.count_list++;}
        for(Flat elem:collection){
            if (elem.getId()==id){
                System.out.println("элемент успешно удален");l++;
            }
        }
        if(l==0){
            System.out.println("Элемента с таким id не существует");
        }
        collection.removeIf(flat -> flat.getId() == id );

    }
    public void update(long id,Flat flat){
        collection.removeIf(flat1 -> flat1.getId() == id);
        collection.add(flat);
        flat.setId(id);
        System.out.println("Элемент коллекции обновлен");
    }

    public void add(Flat flat){
        try{
        collection.add(flat);}catch (NullPointerException e){
        }
    }

    public void show(){
        try {
            for (Flat iter : collection) {
                System.out.print(iter);
            }
            if (collection.isEmpty()) {
                System.out.println("Коллекция пуста");
            }
        }catch (NullPointerException e){}
    }
    public void info(){
        System.out.print("Тип коллекции: java.util.LinkedHashSet\n" +
                "Дата инициализации: "+Main.date+"\n"+
                "Количество элементов в коллекции- "+collection.size()+"\n");
    }
    public void help(){
        System.out.print(
                "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n"+
                "help : вывести справку по доступным командам \n" +
                "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                "add {element} : добавить новый элемент в коллекцию\n" +
                "update {element} : обновить значение элемента коллекции, id которого равен заданному\n" +
                "removeById id : удалить элемент из коллекции по его id\n" +
                "clear : очистить коллекцию\n" +
                "save : сохранить коллекцию в файл\n" +
                "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
                "exit : завершить программу (без сохранения в файл)\n" +
                "addIfMax {element} : добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции\n" +
                "addIfMin {element} : добавить новый элемент в коллекцию, если его значение меньше значение наименьшено элемента этой коллекции\n" +
                "removeLower {element} : удалить из коллекции все элементы, заданный\n" +
                "filterStartsWithName name : вывести элементы, значение поля name которых начинается с заданной подстроки\n" +
                "groupCountingById : сгруппировать элементы коллекции по значению поля id, вывести количество элементов в каждой группе\n" +
                "printDescending : вывести элементы коллекции в порядке убывания\n");
    }
}
