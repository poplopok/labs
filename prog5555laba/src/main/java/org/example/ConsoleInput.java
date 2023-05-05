package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import org.example.data.Coordinates;
import org.example.data.Flat;
import org.example.data.House;
import org.example.data.Transport;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ConsoleInput {
    List<String> list=new ArrayList<>();
    String idishnik="";
    Pattern pattern= Pattern.compile("");
    LinkedHashSet<Flat> collection = new LinkedHashSet<>();
    public boolean work;
    Long cmdstr;

    Commands command;
    Scanner scan=new Scanner(System.in);

    public ConsoleInput(LinkedHashSet<Flat> collection, Commands command) throws FileNotFoundException {
        this.collection = collection;
        this.command = command;
        work = true;
    }

    public ConsoleInput(LinkedHashSet<Flat> collection) throws FileNotFoundException {
        this.collection = collection;
        work = true;
    }

    Flat flat = new Flat();
    House house = new House();
    Coordinates coordinates = new Coordinates();
    int i = 0;
    String str;
    String s = null;
    static String loadFile;
    BufferedInputStream in;
    public void load(String fileLoad) throws IOException {//////////// ПОНЯТЬ ВСЕ    ////////
        LinkedHashSet<Flat> collection1 = new LinkedHashSet<>();
        loadFile=fileLoad;
        Coordinates coordinates = new Coordinates(1, 1);
        House house = new House("House", 1L, 1);
        Transport transport = Transport.valueOf("NONE");
        int count = 0;
        long max_id = 0;
        boolean massage = true;
        File json_collection = new File(fileLoad);
        BufferedReader deserialization = null;
        flat.setTime(flat.time());
        try {
            deserialization = new BufferedReader(new InputStreamReader(new BufferedInputStream(new FileInputStream(json_collection))));
        }catch (FileNotFoundException e){
            System.out.println("файл не найден.");
            System.exit(0);
        }
        String nextLine = "";
        String result = "";
        while ((nextLine = deserialization.readLine()) != null) {
            result = result + nextLine + "\n";

        }
        Type listType = new TypeToken<LinkedHashSet<Flat>>() {}.getType();
        try {

            collection = new Gson().fromJson(result, listType);

        } catch (JsonSyntaxException e) {
            System.out.println("Ошибка чтения файла, перезапишите его и попробуйте снова");
            System.exit(0);
        }
        deserialization.close();
        try {
            for (Flat elem : collection) {
                if (elem.getId() > max_id) {
                    max_id = elem.getId();
                }
                count++;
            }
        }catch (NullPointerException e) {
            System.out.println("Файл пуст");
        }
        long[] dublicate = new long[count];
        count = 0;
        try {
            for (Flat elem : collection) {
                dublicate[count] = elem.getId();
                if (elem.getId() <= 0) {
                    System.out.println("В файле содержаться отрицательный id, перезапишите файл и попробуйте еще раз");
                    System.exit(0);
                }
                if (elem.getName().equals("null")){
                    System.out.println("В файле содержиться name со значением null");
                    System.exit(0);
                }
                if(elem.getCoordinates().getX()>752){
                    System.out.println("В файле содержиться координата x больше 752");
                    System.exit(0);
                }
                if (String.valueOf(elem.getCoordinates().getY()).equals("null")){
                    System.out.println("координата Y не может быть null");
                    System.exit(0);
                }
                if(elem.time().equals("null")){
                    System.out.println("Дата не может быть null");
                    System.exit(0);
                }
                if(elem.getArea()<=0 || elem.getArea()>=671){
                    System.out.println("area должен быть больше 0 и меньше 671");
                    System.exit(0);
                }
                if(elem.getNumberOfRooms()<=0){
                    System.out.println("Значение NumberOfRooms должно быть больше 0");
                    System.exit(0);
                }
                if (elem.getTimeToMetroOnFoot()<=0){
                    System.out.println("Значение timeToMetroOnFoot должно быть больше 0");
                    System.exit(0);
                }
                if(elem.getHouse().equals(null)){
                    System.out.println();
                    System.exit(0);
                }
                if (elem.getHouse().getName().equals("null")){
                    System.out.println("Имя дома не может быть null");
                    System.exit(0);
                }
                if(elem.getHouse().getYear()<=0){
                    System.out.println("Значение поля Year должно быть больше 0");
                    System.exit(0);//проверить
                }
                if (elem.getHouse().getNumberOfLifts()<=0){
                    System.out.println("Значение поля NumberOfLifts должно быть больше 0");
                    System.exit(0);
                }
                count++;
            }
        } catch (NullPointerException e) {
            massage = false;
            System.out.println("Проверьте правильность данных, агружена остандартная коллекция");
            collection1.add(new Flat("standart", coordinates, 1, 1, true, 1, transport, house));
            collection = collection1;
        }
        for (int i = 0; i < count; i++) {
            for (int j = i + 1; j < count; j++) {
                if (dublicate[i] == dublicate[j]) {
                    System.out.println("В файле содержаться повторяющиеся id, перезапишите файл и попробуйте еще раз");
                    System.exit(0);
                }
            }
        }
        Flat.uniqId = max_id;
        if (massage) {
            System.out.println("Коллекция успешно загружена");
        }
    }
    String head;
    static int count_list=0;
    public void Command(List<String> cmd) throws IOException {
        if (Commands.ident==0){count_list=0;}
        try {
            head = String.valueOf(cmd.get(count_list)).trim();
        }catch (IndexOutOfBoundsException e){
            head="";
        }
        Commands com = new Commands(collection);
        switch (head) {
            case "help" : {com.help();count_list++;break;}//
            case "info" : {com.info();count_list++;break;}//
            case "show" :  {com.show();count_list++;break;}//
            case "groupCountingById" : {com.groupCountingById();count_list++;break;}//
            case "save" : {com.save();count_list++;break;}//
            case "printDescending" : {com.printDescending();count_list++;break;}//
            case "filterStartsWithName" : {if(Commands.ident>=1){
                System.out.println("filterStartsWithName");
            }
                System.out.println("Введите подстроку");
                com.filterStartsWithName(inputP(cmd));
                break;
            }
            case "removeLower" : {
                if(Commands.ident>=1){
                System.out.println("removeLower");
                }
                com.removeById(inputLong(cmd));break;

            }
            case "addIfMin" : {System.out.println("Введите название квартиры");com.addIfMin(inputAdd(cmd));break;}//
            case "addIfMax" : {System.out.println("Введите название квартиры");com.addIfMax(inputAdd(cmd));break;}//
            case "exit" : com.exit();//
            case "clear" : {com.clear();count_list++;break;}//
            case "removeById" : {

                if(Commands.ident>=1){
                    System.out.println("removeById");
                }
                while(true){
                try{
                    try {
                        com.removeById(Long.parseLong(cmd.get(1)));
                    }catch (IndexOutOfBoundsException w){
                        System.out.println("Введите значение Long, после команды. Попоробуйте снова");
                        break;
                    }
                }catch (NumberFormatException e){
                System.out.println("Введите значение типа int");
                break;
                }break;
            }
                break;}
            case "update" : {
                if(Commands.ident>=1){
                    System.out.println("update");
                    System.out.println(cmd.get(1));
                }
                long f = 0;
                try {
                    f= Long.parseLong(cmd.get(1));
                }catch (NumberFormatException | IndexOutOfBoundsException e){
                    System.out.println("Попробуйте еще раз");
                    break;
                }
                System.out.println("Введите название квартиры");
                Flat flt=inputAdd(cmd);
                while (true){
                try {
                    com.update(f, flt);
                    break;
                }catch (NumberFormatException e){
                    System.out.println("Введите значение типа int");
                }
                }
                break;
            }
            case "add" : {System.out.println("Введите название квартиры");try {
                com.add(inputAdd(cmd));
                System.out.println("Эелемент успешно добавлен");
            }catch (NumberFormatException e){
                System.out.println("adddddd");
            }
            break;
            }
            case "executeScript" : {
                if(Commands.ident==0){com.executeScript(scan.next(),list);}
                else {
                    System.out.println(head);
                    count_list++;
                    com.executeScript(cmd.get(count_list),cmd);
                }break;
            }//
            default : {
                System.out.println(head);
                if(Commands.ident!=0){count_list++;}
                System.out.println("команда не распознана, попробуйте еще раз");
                break;
            }
        }
    }
    public Flat inputAdd(List<String> list) throws IOException {
        Transport transport = null;
            s = null;
        while (true) {
            str = inputP(list);
            if (!str.equals("null")){
                flat.setName(str);
                break;
            }else {
                System.out.println("Название не должно быть null");
            }
            }
            i = 0;
            System.out.println("Введите координату x");
            while (true) {
                s = inputP(list);
                try {
                    i = Integer.parseInt(s);
                } catch (NumberFormatException e) {
                    System.out.println("Введите значние типа int");
                    continue;
                }
                if (i <= 752) {
                    coordinates.setX(i);
                    break;
                } else {
                    System.out.println("введите значение не превышающее 752");
                }

            }
            Long l = null;
            System.out.println("Введите координату y");
        while (l == null) {
                try {
                    l = inputLong(list);
                } catch (NumberFormatException e) {
                    System.out.println();
                    System.out.println("Вы ввели null или текст не соответствующий типу Long");
                }
                coordinates.setY(l);
        }
        double d = -1;
        System.out.println("введите area");
        while (d != flat.getArea()) {
            i = 0;
                try {
                    d = Double.parseDouble(inputP(list));
                } catch (NumberFormatException e) {
                    System.out.println("Введите значение типа 'Double'");
                    i++;
                }
                if ((d <= 0 || d >= 671) && i == 0) {
                    System.out.println("Введите значение больше 0,не превышающее 670");
                    i--;
                }
                flat.setArea(d);
        }
        System.out.println("введите количество комнат");
        while (true) {
            //>0 , null
                s = inputP(list);
                try {
                    i = Integer.parseInt(s);
                } catch (NumberFormatException e) {
                    System.out.println("Введите число типа Integer");
                    continue;
                }
                if (s.equals("null")) {
                    System.out.println("Не может быть null");
                    continue;
                }
                flat.setNumberOfRooms(i);
                break;
        }
        System.out.println("введите есть ли мебель(true/false)");
        while (true) {
                s = inputP(list);
                if (s.equals("true")) {
                    flat.setFurniture(true);
                    break;
                }
                if (s.equals("false")) {
                    flat.setFurniture(false);
                    break;
                }
                System.out.println("Введите true или false");
        }

        System.out.println("Введите расстояние до метро");
        while (true) {
                s = inputP(list);
                try {
                    i = Integer.parseInt(s);
                } catch (NumberFormatException e) {
                    System.out.println("Введите значение типа Integer");
                    continue;
                }
                if (i > 0) {
                    flat.setTimeToMetroOnFoot(i);
                    break;
                }
                System.out.println("Введите значение больше 0");
        }
        System.out.println("введите название дома");
        while (true) {
                s = inputP(list);
                if (s.equals("null")) {
                    System.out.println("Не может быть null");
                    continue;
                }
                house.setName(s);
                break;
        }
        Long lon;
        System.out.println("введите возраст дома");
        while (true) {
                s = inputP(list);
                try {
                    lon = Long.parseLong(s);
                } catch (NumberFormatException e) {
                    System.out.println("введите значение типа Long");
                    continue;
                }
                if (lon > 0) {
                    house.setYear(lon);
                    break;
                }
                System.out.println("Введите значение больше 0");
        }

        System.out.println("введите количество лифтов в доме");
        while (true) {
            i = 0;
                s = inputP(list);
                try {
                    i = Integer.parseInt(s);
                } catch (NumberFormatException e) {
                    System.out.println("введите значение типа int");
                    continue;
                }
                if (i > 0) {
                    house.setNumberOfLifts(i);
                    break;
                }
                System.out.println("Введите значение больше 0");

        }
            transport = null;
            System.out.println("введите тип транспорта");
            while (true) {
                s = inputP(list);
                if (s.equals("null")) {
                    System.out.println("Значение не должео быть null");
                    continue;
                }
                try {
                    transport = Transport.valueOf(s);
                } catch (IllegalArgumentException e) {
                    System.out.println("Введите предложенный тип : 'NONE', 'NORMAL', 'LITTLE', 'ENOUGH'");
                    continue;
                }
                break;
            }
        return new Flat(flat.getName(), coordinates, flat.getArea(), flat.getNumberOfRooms(), flat.getFurniture(), flat.getTimeToMetroOnFoot(), transport, house);
    }

    String line = "";
    public String inputP(List<String> list) throws IOException {
        if(Commands.ident==0){
            line = scan.next();
        }
        else {
            count_list++;
            try {
                System.out.println(list.get(count_list));
            }catch (IndexOutOfBoundsException e){
                System.out.println("Файл успешно выполнен, программа завершена");
                System.exit(0);
            }
            line=list.get(count_list);
        }
        return line;
    }

    public int inputInt(List<String> cmd) throws IOException {
        if (Commands.ident==0){
            try {
                i=Integer.parseInt(scan.next());
            }catch (NumberFormatException e){
                i=0;
            }
        }
        else {
            count_list++;
            try {
                System.out.println(cmd.get(count_list));
                i=Integer.parseInt(cmd.get(count_list));
            }catch (NumberFormatException e){
                System.out.println(cmd.get(count_list));
                i=0;
            }
        }
        return i;
    }
    long n=0;
    public long inputLong(List<String> cmd) throws IOException {
        while (true) {
            if(Commands.ident==0){
            try {
                n=Long.parseLong(scan.next());
            }catch (NumberFormatException e){
                System.out.println("Введите значение типа long");
                n=0;
                continue;
            }
            break;
        }
        else {
            count_list++;
            try {
                try {
                    n=Long.parseLong(cmd.get(count_list));
                    System.out.println(cmd.get(count_list));
                }catch (IndexOutOfBoundsException e){
                    System.out.println("Файл успешно выполнен, программа завершена");
                    System.exit(0);
                }
            }catch (NumberFormatException e){
                System.out.println(cmd.get(count_list));
                System.out.println("Введите значение типа long");
                n=0;
                continue;
            }
            break;
        }
        }
        return n;
    }
}