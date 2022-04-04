package com.company;

public class Main {
    public static void main(String[] args) {
        System.out.println("Ball:");
        drawBall(6);
        System.out.println("");
        System.out.println("Circle:");
        drawCircle(8);
    }

    public static void drawCircle(int number) {
        int[] x = new int[number];
        int[] y = new int[number];

        System.out.print("points: ");
        for(int i = 0; i < x.length; i++) {
            x[i] = (int) Math.round((Math.random() * 100) - 50);
            y[i] = (int) Math.round((Math.random() * 100) - 50);
            System.out.print("/(" + x[i] + "; " + y[i] + "/)");
        }
        System.out.println("");

        int d = 0;

        int x1 = 0;
        int x2 = 0;

        int y1 = 0;
        int y2 = 0;

        for(int i = 0; i < number; i ++) {
            for(int j = 0; j <= i; j++) {
                int s = fdist(x[i], x[j], y[i], y[j]);
                if(s > d) {
                    d = s;
                    x1 = x[i];
                    x2 = x[j];
                    y1 = y[i];
                    y2 = y[j];
                }
            }
        }

        int max = 0;

        int x0 = (x1 + x2) / 2;//Central point
        int y0 = (y1 + y2) / 2;

        for (int i = 0; i < number; i++) {
                int s = fdist(x0, x[i], y0, y[i]);
                if (max < s) {
                    max = s;
                }
        }

        System.out.println("Center of circle - " + "/(" + x0 + "/; " + y0 + "/)");
        System.out.println("Diameter - " + max);
    }

    public static int fdist (int x1, int x2, int y1, int y2) {
        int resultx = x1 - x2;
        int resulty = y1 - y2;
        int result = ((resultx * resultx) + (resulty * resulty));

        return (int) Math.sqrt(result);
    }

    public static void drawBall(int d) {
        double[] x = new double[d];
        double[] y = new double[d];
        double[] z = new double[d];

        System.out.print("points: ");
        for(int i = 0; i < d; i++) {
            x[i] =  Math.round((Math.random() * 100) - 50);
            y[i] = Math.round((Math.random() * 100) - 50);
            z[i] = Math.round((Math.random() * 100) - 50);
            System.out.print("/(" + x[i] + "/; " + y[i] + "/; " + z[i] + "/)");
        }
        System.out.println("");

        double max = 0;

        double x1 = 0;
        double x2 = 0;
        double x3 = 0;

        double y1 = 0;
        double y2 = 0;
        double y3 = 0;

        double z1 = 0;
        double z2 = 0;
        double z3 = 0;

        for(int i = 0; i < d; i++) {
            for(int j = 0; j <= i; j++) {
                for(int k = 0; k <= j; k++) {
                    double s = fdist(x[i], x[j], x[k], y[i], y[j], y[k],z[i], z[j], z[k]);
                    if(s > max) {
                        max = s;

                        x1 = x[i];
                        x2 = x[j];
                        x3 = x[k];

                        y1 = y[i];
                        y2 = y[j];
                        y3 = y[k];

                        z1 = z[i];
                        z2 = z[j];
                        z3 = z[k];
                    }
                }
            }
        }

        double x0 = (x1 + x2 + x3) / 3;
        double y0 = (y1 + y2 + y3) / 3;
        double z0 = (z1 + z2 + z3) / 3;

        System.out.println("Center of ball - " + "/(" + x0 + "/; " + y0 + "/; " + z0 + "/)");
        System.out.println("Diameter - " + max);
    }

    public static double fdist (double x1, double x2, double x3, double y1, double y2, double y3,
                                double z1, double z2, double z3) {
        double resultx = x1 - x2 - x3;
        double resulty = y1 - y2 - y3;
        double resultz = z1 - z2 - z3;
        double result = ((resultx * resultx) + (resulty * resulty) + (resultz * resultz));

        return (double) Math.sqrt(result);
    }
}
