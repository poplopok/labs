package org.example.utils;

import org.example.Data.*;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.LinkedHashSet;

public class CollectionManager implements Serializable {

    public static LinkedHashSet<Flat> collection= new LinkedHashSet<>();

    public LinkedHashSet<Flat> getCollection(){
        return collection;
    }

    public void setCollection(LinkedHashSet<Flat> flats){
         collection=flats;
    }























    public LinkedHashSet<Flat> load(String fileLoad) throws IOException {//////////// ПОНЯТЬ ВСЕ    ////////
        Flat flat = new Flat();
        LinkedHashSet<Flat> collection1 = new LinkedHashSet<>();
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
        Flat.uniqId = (int) max_id;
        if (massage) {
            System.out.println("Коллекция успешно загружена");
        }
        return collection;
    }
}
