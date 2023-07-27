package org.example.Data;

import java.util.Date;

public class Flat {

    public static int uniqId=0;
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private float area; //Максимальное значение поля: 670, Значение поля должно быть больше 0
    private long numberOfRooms; //Значение поля должно быть больше 0
    private Boolean furniture; //Поле не может быть null
    private Long timeToMetroOnFoot; //Значение поля должно быть больше 0
    private Transport transport; //Поле может быть null
    private House house; //Поле может быть null
    Date date= new Date();

    public Flat(){}

    public Flat(String name, Coordinates coordinates, double area, Integer numberOfRooms,
                boolean furniture, int timeToMetroOnFoot, Transport transport, House house){
        uniqId++;
        id=uniqId;
        this.name=name;
        this.coordinates=coordinates;
        this.area= (float) area;
        this.numberOfRooms=numberOfRooms;
        this.furniture=furniture;
        this.timeToMetroOnFoot= (long) timeToMetroOnFoot;
        this.transport=transport;
        this.house=house;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public long getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(long numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public Boolean getFurniture() {
        return furniture;
    }

    public void setFurniture(Boolean furniture) {
        this.furniture = furniture;
    }

    public Long getTimeToMetroOnFoot() {
        return timeToMetroOnFoot;
    }

    public void setTimeToMetroOnFoot(Long timeToMetroOnFoot) {
        this.timeToMetroOnFoot = timeToMetroOnFoot;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public Date setTime(Date date){
        return this.date=date;
    }

    public Date time(){
        return date;
    }

    @Override
    public String toString() {
        return "\n Flat{" +
                "id=" + id +
                " name='" + name + '\'' +"\n"+
                " coordinates=" + coordinates +","+
                " creationDate=" + date +
                " area=" + area +", "+"\n"+
                " numberOfRooms=" + numberOfRooms +
                " furniture=" + furniture +
                " timeToMetroOnFoot=" + timeToMetroOnFoot +", "+"\n"+
                " transport=" + transport +
                " house=" + house +
                '}'+"\n";
    }
}