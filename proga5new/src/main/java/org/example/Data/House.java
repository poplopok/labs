package org.example.Data;

public class House {
    private String name; //Поле не может быть null
    private Long year; //Значение поля должно быть больше 0
    private Integer numberOfFloors; //Значение поля должно быть больше 0

    public House(String name, Long year, Integer numberOfFloors) {
        this.name=name;
        this.year=year;
        this.numberOfFloors=numberOfFloors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public int getNumberOfLifts() {
        return numberOfFloors;
    }

    @Override
    public String toString() {
        return "House{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", numberOfFloors=" + numberOfFloors +
                '}';
    }
}