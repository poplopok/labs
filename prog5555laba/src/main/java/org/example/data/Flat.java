package org.example.data;

import java.util.Date;

/**
 * The type Flat.
 */

public class Flat {
    public static long uniqId=0;
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null,`` Значение этого поля должно генерироваться автоматически
    private double area; //Максимальное значение поля: 670, Значение поля должно быть больше 0
    private Integer numberOfRooms; //Поле может быть null, Значение поля должно быть больше 0
    private boolean furniture; //Поле не может быть null
    private Integer timeToMetroOnFoot; //Значение поля должно быть больше 0
    private Transport transport; //Поле может быть null
    private House house; //Поле не может быть null
    Date date= new Date();
//    Date nowDate;

    /** Constructs a new Flat. */
    public Flat(){}
    public Flat(String name, Coordinates coordinates, double area, Integer numberOfRooms,
                boolean furniture, int timeToMetroOnFoot, Transport transport, House house){
        uniqId++;
        id=uniqId;
        this.name=name;
        this.coordinates=coordinates;
        this.area=area;
        this.numberOfRooms=numberOfRooms;
        this.furniture=furniture;
        this.timeToMetroOnFoot=timeToMetroOnFoot;
        this.transport=transport;
        this.house=house;
            }
    /**
     * Getter for property 'name'.
     *
     * @return Value for property 'name'.
     */

    public String getName(){
        return name;
    }

    /**
     * Getter for property 'coordinates'.
     *
     * @return Value for property 'coordinates'.
     */

    public Coordinates getCoordinates(){
        return coordinates;
    }

    /**
     * Getter for property 'area'.
     *
     * @return Value for property 'area'.
     */

    public double getArea(){
        return area;
    }

    /**
     * Getter for property 'numberOfRooms'.
     *
     * @return Value for property 'numberOfRooms'.
     */

    public Integer getNumberOfRooms(){
        return numberOfRooms;
    }

    /**
     * Getter for property 'furniture'.
     *
     * @return Value for property 'furniture'.
     */

    public boolean getFurniture(){
        return furniture;
    }

    /**
     * Getter for property 'timeToMetroOnFoot'.
     *
     * @return Value for property 'timeToMetroOnFoot'.
     */

    public int getTimeToMetroOnFoot(){
        if (timeToMetroOnFoot==null){System.out.println("значение не может быть null, перепишите файл и попробуйте снова");
        System.exit(0);}

        return timeToMetroOnFoot;
    }

    /**
     * Getter for property 'transport'.
     *
     * @return Value for property 'transport'.
     */

    public Transport getTransport(){
        return transport;
    }

    /**
     * Getter for property 'house'.
     *
     * @return Value for property 'house'.
     */

    public House getHouse(){
        return house;
    }

    /**
     * Getter for property 'id'.
     *
     * @return Value for property 'id'.
     */

    public long getId(){
        return id;
    }


    public Date time(){
        return date;
    }
    public Date setTime(Date date){
        return this.date=date;
    }

    /**
     * Setter for property 'name'.
     *
     * @param name Value to set for property 'name'.
     */

    public void setName(String name){
        if(!name.equals("null")){
            this.name=name;
        }
    }

    /**
     * Setter for property 'area'.
     *
     * @param area Value to set for property 'area'.
     */

    public void setArea(double area) {
        if(area>0 && area<671){
            this.area=area;
        }
    }

    /**
     * Setter for property 'numberOfRooms'.
     *
     * @param numberOfRooms Value to set for property 'numberOfRooms'.
     */

    public void setNumberOfRooms(Integer numberOfRooms){
        if(numberOfRooms>0||numberOfRooms.equals(null)){
        this.numberOfRooms=numberOfRooms;}
    }
    /**
     * Setter for property 'furniture'.
     *
     * @param furniture Value to set for property 'furniture'.
     */
    public void setFurniture(boolean furniture){
        this.furniture=furniture;
    }
    /**
     * Setter for property 'timeToMetroOnFoot'.
     *
     * @param timeToMetroOnFoot Value to set for property 'timeToMetroOnFoot'.
     */
    public void setTimeToMetroOnFoot(int timeToMetroOnFoot){
        if(timeToMetroOnFoot>0){
            this.timeToMetroOnFoot=timeToMetroOnFoot;
        }
    }
    /**
     * Setter for property 'id'.
     *
     * @param id Value to set for property 'id'.
     */
    public void setId(long id){
        if(id>0){
            this.id=id;
        }
    }
    /** {@inheritDoc} */
    @Override
    public String toString(){
        return "Flat : name - "+name+", coordinates - "+coordinates+", area - "+area+", numberOfRooms - "+numberOfRooms+", \nfurniture - "+
                furniture+", timeToMetroOnFoot - "+timeToMetroOnFoot+",\n transport - "+transport+", house - "+house+"\n"+"id= "+id+"\n";
    }
}
