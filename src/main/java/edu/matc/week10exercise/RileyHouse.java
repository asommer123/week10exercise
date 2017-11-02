package edu.matc.week10exercise;

import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

//Barber = Riley
//Customer = Child
//CustomerGenerator = ChildGenerator
//Bshop = RileyHouse
public class RileyHouse {
    private final Logger log = Logger.getLogger(this.getClass());

    private int numberChildren;
    private List<Child> childList;

    public RileyHouse()
    {
        numberChildren = 10;
        childList = new LinkedList<Child>();
    }

    public void cutHair()
    {
        Child customer;
        log.info("Barber waiting for lock.");
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
            System.out.println("Barber found a customer in the queue.");
            customer = (Child)((LinkedList<?>) childList).poll();
        }
        long duration=0;
        try
        {
            System.out.println("Cuting hair of Customer : " + customer.getName());
            duration = (long)(Math.random()*10);
            TimeUnit.SECONDS.sleep(duration);
        }
        catch(InterruptedException iex)
        {
            iex.printStackTrace();
        }
        System.out.println("Completed Cuting hair of Customer : "+customer.getName() + " in "+duration+ " seconds.");
    }

    public void add(Child customer)
    {
        System.out.println("Customer : "+customer.getName()+ " entering the shop at "+customer.getInTime());

        synchronized (childList)
        {
            if(childList.size() == numberChildren)
            {
                System.out.println("No chair available for customer "+customer.getName());
                System.out.println("Customer "+customer.getName()+"Exists...");
                return ;
            }

            ((LinkedList<Child>) childList).offer(customer);
            System.out.println("Customer : "+customer.getName()+ " got the chair.");

            if(childList.size()==1)
                childList.notify();
        }
    }
}
