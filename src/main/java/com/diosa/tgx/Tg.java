package com.diosa.tgx;

import java.math.BigInteger;

public class Tg {
    public static Double decomposition(double x, int m) {
        if (x <= -Math.PI/2 || x >= Math.PI/2) {
            throw new IllegalArgumentException("Аргумент не попадаетс в область определения");
        }

        double result = 0;

        for (int n = 1; n <= m; n++) {
            result += (Math.pow(-1, n + 1) * Math.pow(2, 2 * n) * (Math.pow(2, 2 * n) - 1) * Math.pow(x, 2 * n - 1) * getBernoulli(2 * n)) / getFactorial(2 * n);
        }

        return result;

    }

    public static double getBernoulli(int n) {
        double[] points = new double[] {1.000000000, -0.500000000, 0.166666666, 0.000000000, -0.033333333, 0.000000000, 0.023809523, 0.000000000, -0.033333333,
        0.000000000, 0.0757575, 0.000000000, -0.25311355311, 0.000000000, 1.1666666667, 0.000000000, -7.09215686, 0.000000000, 54.97117794, 0.000000000, -529.1242424,
        0.000000000, 6192.123188406, 0.000000000, -86580.25311355, 0.000000000, 1425517.166666667, 0.000000000, -27298231.067816, 0.000000000, 601161127.2680017};
        return points[n];
//        if (n == 0) {
//            return 1;
//        }
//
//        if (n % 2 == 1 && n != 1) {
//            return 0;
//        }
//
//        double[] dp = new double[n + 1];
//        dp[0] = 1;
//         dp[1] = -0.5;
//
//        for (int i = 2; i <= n; i += 2) {
//            dp[i] = 0;
//            for (int j = 0; j < i; j++) {
//                dp[i] += dp[j] * getBinomial(i + 1, i + 1 - j);
//            }
//            dp[i] *= (double) -1 / (i + 1) ;
//        }
//
//        return dp[n];
    }

    public static long getBinomial(int n, int k) {
        return getFactorial(n) / (getFactorial(k) * getFactorial(n - k));
    }

    public static long getFactorial(int f) {
        long result = 1;
        for (long i = 1; i <= f; i++) {
            result = result * i;
        }
        return result;
    }
}
