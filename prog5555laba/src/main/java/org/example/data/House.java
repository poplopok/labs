package org.example.data;

public class House {
    private String name; //Поле не может быть null
    private Long year; //Значение поля должно быть больше 0
    private int numberOfLifts; //Значение поля должно быть больше 0
    /** Constructs a new House. */
    public House(){}
    /**
     * Setter for property 'name'.
     *
     * @param name Value to set for property 'name'.
     */
    public void setName(String name) {
        if(!name.equals(null)){
        this.name = name;
        }
    }

    /**
     * Setter for property 'year'.
     *
     * @param year Value to set for property 'year'.
     */
    public void setYear(Long year) {

        this.year = year;
    }

    /**
     * Setter for property 'numberOfLifts'.
     *
     * @param numberOfLifts Value to set for property 'numberOfLifts'.
     */
    public void setNumberOfLifts(int numberOfLifts) {
        this.numberOfLifts = numberOfLifts;
    }

    public House(String name, Long year, int numberOfLifts){
        this.name=name;
        this.year=year;
        this.numberOfLifts=numberOfLifts;
    }
    /**
     * Getter for property 'name'.
     *
     * @return Value for property 'name'.
     */
    public String getName(){
        return name;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "House{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", numberOfLifts=" + numberOfLifts +
                '}';
    }

    /**
     * Getter for property 'year'.
     *
     * @return Value for property 'year'.
     */
    public Long getYear(){
        return year;
    }
    /**
     * Getter for property 'numberOfLifts'.
     *
     * @return Value for property 'numberOfLifts'.
     */
    public int getNumberOfLifts(){
        return numberOfLifts;
    }
}
