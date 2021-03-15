package com.company;

class School implements Comparable<School> {

    private int capacity; // school capacity
    private String name; // the name of the school

    public School(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    /**
     * Setter pentru capacitate
     * @param capacity
     */
    public void setCapacity(int capacity)
    {
        this.capacity = capacity;
    }
    /**
     * Setter pentru nume
     * @param Name
     */
    public void setName(String Name)
    {
        this.name = Name;
    }
    /**
     * Getter pentru capacitate
     * @return int
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Getter pentru nume
     * @return String
     */
    public String getName() {
        return name;
    }

    @Override
    public int compareTo(School o) {
        return this.name.compareTo(o.getName());//comparam numele
    }
}