package edu.matc.week10exercise;

import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class RileyHouse {
    private final Logger log = Logger.getLogger(this.getClass());

    private int maxNumberChildren;
    private List<Child> childList;

    public RileyHouse()
    {
        maxNumberChildren = 10;
        childList = new LinkedList<Child>();
    }

    public void handOutCandy()
    {
        Child child;

        synchronized (childList)
        {

            while(childList.size()==0)
            {
                log.info("Riley watches TV");
                try
                {
                    childList.wait();
                }
                catch(InterruptedException iex)
                {
                    log.error("Interrupted Exception encountered", iex);
                }
            }
            log.info("Riley answers the door");
            child = (Child)((LinkedList<?>) childList).poll();
        }

        try
        {
            log.info("Riley gives candy to " + child.getName());
            TimeUnit.SECONDS.sleep(3);
        }
        catch(InterruptedException iex)
        {
            log.error("Interrupted Exception encountered", iex);
        }
    }

    public void add(Child child)
    {
        log.info(child.getName() + " is created");

        synchronized (childList)
        {
            if(childList.size() == maxNumberChildren)
            {
                log.info("Too many kids at house waiting for candy. " + child.getName() + " is bypassing house.");
                return ;
            }

            ((LinkedList<Child>) childList).offer(child);
            log.info(child.getName() + " rings the doorbell");

            if(childList.size() == 1)
                childList.notify();
        }
    }
}
