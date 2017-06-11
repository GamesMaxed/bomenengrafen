package ui;

import domain.Graph;

public class UICombined {
    public static void main() {
    }

    public static void dijkstra() {
        int[][] gewichtenMatrix = {
                { 0, 5, 9, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE,
                        Integer.MAX_VALUE, Integer.MAX_VALUE },
                { 5, 0, 3, 8, 10, 11, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE },
                { 9, 3, 0, 2, Integer.MAX_VALUE, Integer.MAX_VALUE, 7, Integer.MAX_VALUE, Integer.MAX_VALUE },
                { Integer.MAX_VALUE, 8, 2, 0, Integer.MAX_VALUE, 3, 7, Integer.MAX_VALUE, Integer.MAX_VALUE },
                { Integer.MAX_VALUE, 10, Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 1, Integer.MAX_VALUE, 8,
                        Integer.MAX_VALUE },
                { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 3, 1, 0, 5, 10, Integer.MAX_VALUE },
                { Integer.MAX_VALUE, Integer.MAX_VALUE, 7, 7, Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 12,
                        Integer.MAX_VALUE },
                { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 8, 10, 12, 0,
                        Integer.MAX_VALUE },
                { 1, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE,
                        Integer.MAX_VALUE, Integer.MAX_VALUE, 0 } };
        Graph g = new Graph(gewichtenMatrix);
        System.out.println(g.berekenPaden(1));
    }

    public static void oef1() {
        int[][] m = {{0,7,0,6,0,0,0,0},{7,0,4,0,2,6,0,0},{3,4,0,0,0,0,0,0},{6,0,1,0,0,0,0,9},{0,0,5,0,0,3,8,0},{0,6,0,0,3,0,6,0},{0,0,0,0,8,6,0,7},{0,0,0,9,4,0,0,0}};

        Graph g = new Graph(m);

        System.out.println(g.berekenPaden(3));
    }
}