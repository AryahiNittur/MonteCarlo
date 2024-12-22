import components.random.Random;
import components.random.Random1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Monte Carlo Estimate: estimates the area of the quarter of the circle of
 * radius 2 centered at (0.0,0.0) and contained in the [0.0,2.0) x [0.0,2.0)
 * square.
 *
 * @author Aryahi Nittur
 *
 */
public final class RevisedMonteCarlo {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private RevisedMonteCarlo() {
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

        final double num = 4.0;

        while (ptsInInterval < numberOfPoints) {

            double xrandomDouble = 2 * rnd.nextDouble();
            double yrandomDouble = 2 * rnd.nextDouble();
            ptsInInterval++;

            //check if point is in circle and increment counter if it is

            if ((xrandomDouble) * (xrandomDouble)
                    + (yrandomDouble) * (yrandomDouble) <= num) {
                ptsInSubinterval++;
            }
        }

        final int three = 3;

        double estimate = (num * ptsInSubinterval) / numberOfPoints;
        out.print("Estimation of the percentage of points:");
        out.print(estimate, three, false);
        in.close();
        out.close();
    }

}
