package hw3;

import java.util.Arrays;

public class Tusk1 {
    //Принимает двумерный (квадратный) массив интов, возвращает сумму диалогалей
    static int sumDiagonals(int[][] array){
        int length = array.length;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i == j  || i == length - j - 1) {
                    sum +=array[i][j];
                }
            }
        }
        return sum;
    }

    //Принимает двумерный массив long и двумерный массив булеан,
    // возвращает одномерный массив лонгов который состоит из элементов первого массива.
    // По индексам по которым в массиве булеан хранятся значения тру.
    static int[] arrayIfBooleanTrue(int[][] arrayInts, boolean[][] arrayBoolean){
        int lengthIntsArray = arrayInts.length;
        int lengthBoolean = arrayBoolean.length;
        int size = 0;
        for (int i = 0; i < lengthBoolean; i++) {
            for (int j = 0; j < lengthBoolean; j++) {
                if (arrayBoolean[i][j]) {
                    size++;
                }
            }
        }

        int[] ints = new int[size];
        int k = 0;

        for (int i = 0; i < lengthIntsArray; i++) {
            for (int j = 0; j < lengthIntsArray; j++) {
                if (arrayBoolean[i][j]){
                    ints[k++] = arrayInts[i][j];
                }
            }
        }

        return ints;
    }

    static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
       int[][] arrayInts = {
               {1,1,1},
               {0,1,1},
               {1,1,1},
       };

       boolean[][] booleansArray = {
               {true, false, false},
               {true, false, true},
               {true, false, false},
       };

       System.out.println(sumDiagonals(arrayInts));

        int[] ints = arrayIfBooleanTrue(arrayInts, booleansArray);

        System.out.println(Arrays.toString(ints));

        printArray(arrayInts);
    }
}
