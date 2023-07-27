package org.example.Commands;

import org.example.Data.*;
import org.example.utils.CollectionManager;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CommandAdd implements DefaultCommand{

    CollectionManager collectionManager=new CollectionManager();
    LinkedHashSet<Flat> collection =collectionManager.getCollection();
    Coordinates coordinates=new Coordinates(0,0);
    Scanner scanner;
    Flat flat;

    public void execute(List<String> list,Scanner scanner) throws IOException {
        this.scanner=scanner;
        flat=inputAdd();
        if(flat!=null){
        collection.add(flat);
        System.out.println("Элемент создан");}
    collectionManager.setCollection(collection);

    }
    //сюда


        public Flat inputAdd() throws IOException {
            pop:
            {
                System.out.println("Введите название дома");
                Transport transport = null;
                String name1 = null;
                while (true) {
                    try {
                        name1 = scanner.next();
                    } catch (NullPointerException e) {
                        scanner = new Scanner(System.in);
                        continue;
                    }
                    try {
                        if (!name1.equals("null")) {
                            break;
                        } else {
                            System.out.println("Название не должно быть null");
                        }
                    } catch (NullPointerException e) {

                        System.out.println("файл выполнен");
                        scanner = new Scanner(System.in);
                        continue;
                    }
                }
                long i = 0;
                System.out.println("Введите координату x");
                String str;
                while (true) {
                    str = scanner.next();
                    try {
                        i = Integer.parseInt(str);
                    } catch (NumberFormatException e) {
                        System.out.println("Введите значние типа int");
                        continue;
                    }
                    if (i <= 752) {
                        coordinates.setX((int) i);
                        break;
                    } else {
                        System.out.println("введите значение не превышающее 752");
                    }

                }
                Long l = null;
                System.out.println("Введите координату y");
                while (l == null) {
                    try {
                        l = Long.valueOf(scanner.next());
                    } catch (NumberFormatException | NullPointerException e) {
                        System.out.println();
                        System.out.println("Вы ввели null или текст не соответствующий типу Long");
                    }
                    coordinates.setY(l);
                }
                double d = -1;
                double area3 = 0;
                System.out.println("введите area");
                while (true) {
                    i = 0;
                    try {
                        d = Double.parseDouble(scanner.next());
                    } catch (NumberFormatException e) {
                        System.out.println("Введите значение типа 'Double'");
                        continue;
                    }
                    if ((d <= 0 || d >= 671) && i == 0) {
                        System.out.println("Введите значение больше 0,не превышающее 670");
                        continue;
                    }
                    area3 = d;
                    break;
                }

                long number4;
                System.out.println("введите количество комнат");
                str = "";

                while (true) {
                    str = scanner.next();
                    try {
                        i = Integer.parseInt(str);
                    } catch (NumberFormatException e) {
                        System.out.println("Введите число типа Integer");
                        continue;
                    }
                    if (str.equals("null")) {
                        System.out.println("Не может быть null");
                        continue;
                    }
                    number4 = i;
                    break;
                }

                System.out.println("введите есть ли мебель(true/false)");
                boolean furnitura5 = false;

                while (true) {
                    try {
                        str = scanner.next();
                    } catch (NoSuchElementException e) {
                        System.out.println("файл выполнен");
                        break pop;
                    }
                    if (str.equals("true")) {
                        furnitura5 = true;
                        break;
                    }
                    if (str.equals("false")) {
                        furnitura5 = false;
                        break;
                    }
                    System.out.println("Введите true или false");
                }

                int metro6 = 0;

                System.out.println("Введите расстояние до метро");
                while (true) {
                    try {
                        str = scanner.next();
                    } catch (NoSuchElementException e) {
                        break pop;
                    }
                    try {
                        metro6 = Integer.parseInt(str);
                    } catch (NumberFormatException e) {
                        System.out.println("Введите значение типа Integer");
                        continue;
                    }
                    if (metro6 > 0) {
                        break;
                    }
                    System.out.println("Введите значение больше 0");
                }

                House house = new House(null, null, null);
                System.out.println("введите название дома");
                while (true) {
                    try {
                        str = scanner.next();
                    } catch (NoSuchElementException e) {
                        break pop;
                    }
                    if (str.equals("null")) {
                        System.out.println("Не может быть null");
                        continue;
                    }
                    house.setName(str);
                    break;
                }

                Long lon;
                System.out.println("введите возраст дома");
                while (true) {
                    try {
                        str = scanner.next();
                    } catch (NoSuchElementException e) {
                        break pop;
                    }
                    try {
                        lon = Long.parseLong(str);
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
                    try {
                        str = scanner.next();
                    } catch (NoSuchElementException e) {
                        break pop;
                    }
                    try {
                        i = Integer.parseInt(str);
                    } catch (NumberFormatException e) {
                        System.out.println("введите значение типа int");
                        continue;
                    }
                    if (i > 0) {
                        house.setNumberOfFloors((int) i);
                        break;
                    }
                    System.out.println("Введите значение больше 0");

                }
                transport = null;
                System.out.println("введите тип транспорта");
                while (true) {
                    try {
                        str = scanner.next();
                    } catch (NoSuchElementException e) {
                        System.out.println("Файл выполнен");
                        scanner = new Scanner(System.in);
                        break pop;
                    }
                    if (str.equals("null")) {
                        System.out.println("Значение не должео быть null");
                        continue;
                    }
                    try {
                        transport = Transport.valueOf(str);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Введите предложенный тип : 'NONE', 'NORMAL', 'LITTLE', 'ENOUGH'");
                        continue;
                    }
                    break;
                }
                return new Flat(name1, coordinates, area3, (int) number4, furnitura5, metro6, transport, house);
            }
            return null;
        }


    public String getName() {
    return "add";
    }
}
