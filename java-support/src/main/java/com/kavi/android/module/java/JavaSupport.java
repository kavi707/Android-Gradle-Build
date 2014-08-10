package com.kavi.android.module.java;

import org.apache.commons.math3.analysis.function.Sqrt;
import org.apache.commons.math3.util.MathUtils;

/**
 * JavaSupport.java
 *
 * @author Kavimal Wijewardana <kavi707@gmail.com>
 */
public class JavaSupport {

    public String supportMethod() {
        return "Enter the no. to get square root";
    }

    public Double getSquareRoot(double number) {
        Double squareRoot = 0.0;

        Sqrt sqrt = new Sqrt();
        squareRoot = sqrt.value(number);

        return squareRoot;
    }
}
