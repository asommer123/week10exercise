package edu.matc.week10exercise;

public class week10exercise {

    public static void main(String a[])
    {
        RileyHouse rileyHouse = new RileyHouse();

        Riley riley = new Riley(rileyHouse);
        ChildGenerator childGenerator = new ChildGenerator(rileyHouse);

        Thread threadRiley = new Thread(riley);
        Thread threadChild = new Thread(childGenerator);
        threadChild.start();
        threadRiley.start();
    }

}
