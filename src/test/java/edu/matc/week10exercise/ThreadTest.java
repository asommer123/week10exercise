package edu.matc.week10exercise;

import org.junit.Test;
import org.apache.log4j.Logger;

import java.util.Date;

public class ThreadTest {
    private final Logger log = Logger.getLogger(this.getClass());

    @Test
    public void createChildThread() throws Exception {
        RileyHouse rileyHouse = new RileyHouse();
        Child child = new Child(rileyHouse);

        child.setInTime(new Date());

        Thread childThread = new Thread(child);
        child.setName("ThreadTest Child " + childThread.getId());

        log.info("ThreadTest - Before starting child thread");

        childThread.start();

    }

    @Test
    public void createRileyThread() throws Exception {
        RileyHouse rileyHouse = new RileyHouse();
        Riley riley = new Riley(rileyHouse);

        Thread rileyThread = new Thread(riley);

        log.info("ThreadTest - Before starting riely thread");

        rileyThread.start();
    }
}
