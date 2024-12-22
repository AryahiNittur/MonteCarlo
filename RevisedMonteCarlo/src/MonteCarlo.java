import components.random.Random;
import components.random.Random1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Monte Carlo Estimate: generates 2-dimensional points in the [0.0,2.0) x
 * [0.0,2.0) square and estimates the area of the circle of radius 1 centered at
 * (1.0,1.0).
 *
 * @author Aryahi Nittur
 *
 */
public final class MonteCarlo {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private MonteCarlo() {
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        //ask user for number of points to generate
        out.println("Number of points to be generated: ");
        int numberOfPoints = in.nextInteger();

        //declare and initialize counters

        int ptsInInterval = 0, ptsInSubinterval = 0;

        //create a rng

        Random rnd = new Random1L();

        //generate points and count how many fall in the circle

        while (ptsInInterval < numberOfPoints) {

            //generate pseudeo-random number in [0.0, 1.0) square interval

            double xrandomDouble = 2 * rnd.nextDouble();
            double yrandomDouble = 2 * rnd.nextDouble();

            //increment total number of generated points

            ptsInInterval++;

            //check if point is in circle and increment counter if it is

            if ((xrandomDouble - 1) * (xrandomDouble - 1)
                    + (yrandomDouble - 1) * (yrandomDouble - 1) <= 1.0) {
                ptsInSubinterval++;
            }
        }

        //Estimate percentage of points generated in [0.0,2.0) square interval in
        //the circle of radius 1 centered at (1.0,1.0).

        final int three = 3;
        final double num = 4.0;

        double estimate = (num * ptsInSubinterval) / numberOfPoints;
        out.print("Estimation of the percentage of points generated in the square "
                + "that fall in the circle with radius 1:");
        out.print(estimate, three, false);
        in.close();
        out.close();
    }

}
