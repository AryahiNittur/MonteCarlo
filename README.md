# MonteCarlo

**Radius:** 2 units. <br>
**Region of Interest:** The quarter-circle is within the square [0.0, 2.0) x [0.0, 2.0). <br>
**Method:** The simulation generates random points uniformly distributed within the square. Points are then tested to determine whether they fall inside the quarter-circle based on the equation x^2 + y^2 <= r^2, where r = 2. <br>
**Estimation:** The ratio of points inside the quarter-circle to the total points in the square, multiplied by the area of the square (4), provides the estimate of the quarter-circle's area.
