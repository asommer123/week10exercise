package edu.matc.week10exercise;

import org.apache.log4j.Logger;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ChildGenerator implements Runnable {
    private final Logger log = Logger.getLogger(this.getClass());

    private RileyHouse rileyHouse;

    public ChildGenerator(RileyHouse rileyHouse)
    {
        this.rileyHouse = rileyHouse;
    }

    public void run()
    {
        while(true)
        {
            Child child = new Child(rileyHouse);
            child.setInTime(new Date());
            Thread threadChild = new Thread(child);
            child.setName("Child " + threadChild.getId());
            threadChild.start();

            try
            {
                TimeUnit.SECONDS.sleep((long)(Math.random()*10));
            }
            catch(InterruptedException iex)
            {
                log.error("Interrupted Exception encountered", iex);
            }
        }
    }
}
