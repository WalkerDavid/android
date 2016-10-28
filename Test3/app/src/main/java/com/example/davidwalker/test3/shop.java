package com.example.davidwalker.test3;

/**
 * Created by David Walker on 28/10/2016.
 */

public class shop {
    private int id;
    private String name;
    private String address;

    // Default class constructor
    public shop()
    {
    }

    // Constructor method with arguments
    public shop(int id,String name,String address)
    {
        this.id=id;
        this.name=name;
        this.address=address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public int getId() {
        return id;
    }
    public String getAddress() {
        return address;
    }
    public String getName() {
        return name;
    }
}
