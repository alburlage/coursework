//DO NOT REMOVE PACKAGE LINE
//Without this line authograder will not run correctly
//You can comment it while you work on the problem
//When everything works - uncomment and submit!
//package com.gradescope.hw5;

/*Header
/HW 5
/Name:
*/
import java.io.IOException;

public class Query {
    public static int Query0(Iterable<FlightRecord> input) {
        int sum = 0;

        // There are two common methods of iterating over an Iterable

        // 1. Use the Iterator from the Iterable
        //Uncomment to see fow it works
        /*
        Iterator<FlightRecord> it = input.iterator();
        while(it.hasNext()) {
           FlightRecord r = it.next();
           if (r.ORIGIN.equals("LAX") && r.DEST.equals("ORD") && r.MONTH == 8) {
                sum++;
            }
        }
         */

        // 2. Use Java's "for each" syntax.
        // Read this as "for each FlightRecord r from input"
        for (FlightRecord r : input) {
            if (r.ORIGIN.equals("LAX") && r.DEST.equals("ORD") && r.MONTH == 8) {
                sum++;
            }
        }
        return sum;
    }

    public static int Query1(Iterable<FlightRecord> input) { return -1;}
    public static Iterable<String> Query2(Iterable<FlightRecord> input) { return null;}
    public static int Query3(Iterable<FlightRecord> input) {
        return -1;
    }
    public static Iterable<String> Query4(Iterable<FlightRecord> input) {
        return null;
    }
    public static String Query5(Iterable<FlightRecord> input) {
        return null;
    }
    public static String Query6(Iterable<FlightRecord> input) {
        return null;
    }
    public static Iterable<String> Query7(Iterable<FlightRecord> input) {
        return null;
    }
    public static Iterable<String> Query8(Iterable<FlightRecord> input) {
        return null;
    }
    public static Iterable<String> Query9(Iterable<FlightRecord> input) {
        return null;
    }
    public static Iterable<String> Query10(Iterable<FlightRecord> input) {
        return null;
    }

    public static void main(String[] args) throws IOException {
        //This will run Query0 provided by us on flights1990.csv
        Iterable<FlightRecord> input = DataImporter.getData("flights/flights1990.csv");
        int result = Query0(input);
        System.out.println(result);
    }
}
