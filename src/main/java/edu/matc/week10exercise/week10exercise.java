package edu.matc.week10exercise;

public class week10exercise {

    public static void main(String a[])
    {
        RileyHouse rileyHouse = new RileyHouse();

        Riley riley = new Riley(rileyHouse);
        ChildGenerator childGenerator = new ChildGenerator(rileyHouse);

        Thread thbarber = new Thread(riley);
        Thread thcg = new Thread(childGenerator);
        thcg.start();
        thbarber.start();
    }

    //Barber = Riley
    //Customer = Child
    //CustomerGenerator = ChildGenerator
    //Bshop = RileyHouse
}
