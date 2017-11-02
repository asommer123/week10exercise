package edu.matc.week10exercise;

import org.apache.log4j.Logger;

import java.util.Date;

public class Child implements Runnable {
    private final Logger log = Logger.getLogger(this.getClass());

    private String name;
    private Date inTime;

    RileyHouse rileyHouse;

    public Child(RileyHouse rileyHouse)
    {
        this.rileyHouse = rileyHouse;
    }

    public String getName() {
        return name;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public void run()
    {
        goForHairCut();
    }
    private synchronized void goForHairCut()
    {
        rileyHouse.add(this);
    }
}
