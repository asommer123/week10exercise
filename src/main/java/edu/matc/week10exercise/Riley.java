package edu.matc.week10exercise;

import org.apache.log4j.Logger;

public class Riley implements Runnable {
    private final Logger log = Logger.getLogger(this.getClass());

    private RileyHouse rileyHouse;

    public Riley(RileyHouse rileyHouse)
    {
        this.rileyHouse = rileyHouse;
    }
    public void run()
    {
        log.info("Trick-Or-Treating begins");
        while(true)
        {
            rileyHouse.handOutCandy();
        }
    }
}
