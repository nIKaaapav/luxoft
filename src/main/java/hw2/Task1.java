package hw2;

public class Task1 {
    static void printChars(char[] chars){
        for (char letter: chars ) {
            System.out.println(letter);
        }
    }

    static char[] intArrayToCharArray(int[] array){
        int length = array.length;
        char[] chars = new char[length];
        for (int i = 0; i < length; i++) {
            chars[i] = (char) array[i];
        }

        return chars;
    }

    static int isBiggerTwo(int a, int b){
        return a > b ? a : b;
    }

    static int isBiggerThree(int a, int b, int c){
        return isBiggerTwo(a, isBiggerTwo(b,c));
    }

    static int isBiggerFive(int a, int b, int c, int d, int e){
        return isBiggerTwo(a, isBiggerTwo(b, isBiggerTwo(c, isBiggerTwo(d,e))));
    }

    static String charToString(char[] array){
        String s = "";
        for (int i = 0; i < array.length; i++) {
            s+=array[i];
        }
        return s;
    }

    static int indexOf(int[] array, int num){
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num) return i;
        }
        return -1;
    }

    static int indexOfReverse(int[] array, int num){
        for (int i = array.length - 1; i == 0; i--) {
            if (array[i] == num) return i;
        }
        return -1;
    }


    static int factorial(int num){
        if (num == 1 || num == 0) return 1;
        return num * factorial(num - 1);
    }

    static boolean isLeapYear(int year){
        return year % 4 == 0 && year % 400 == 0 && year % 100 != 0;
    }

    static void multipleNumber(int[] array, int multiple){
        for (int number: array) {
            if (number % multiple == 0) System.out.println(number);
        }
    }

    static int[] sortedIntsArray(int[] array){
        int[] newArray = array.clone();

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (newArray[i] < newArray[j]){
                    int num = newArray[i];
                    newArray[i] = newArray[j];
                    newArray[j] = num;
                }
            }
        }
        return newArray;
    }

    static boolean isRepitedElements(byte[] bytes){
        for (int i = 0; i < bytes.length; i++) {
            for (int j = 0; j < bytes.length; j++) {
                if (bytes[i] == bytes[j] && i != j) return true;
            }
        }
        return false;
    }

    static int[] multipliedArrays(int[] intsOne, int[] intsTwo){
        int[] intsNew = new int[intsOne.length];
        if (intsOne.length != intsTwo.length) return intsNew;
        for (int i = 0; i < intsNew.length; i++) {
            intsNew[i] = intsOne[i] * intsTwo[i];
        }
        return intsNew;
    }

    static boolean isContains(int[] ints, int num){
        for (int j = 0; j < ints.length; j++) {
            if (ints[j] == num) return true;
        }
        return false;
    }

    static int[] arraysIsNotRepitedValue(int[] intsOne, int[] intsTwo){
        int[] intsNew = new int[intsOne.length + intsTwo.length];
        int k = 0;

        for (int i = 0; i < intsTwo.length; i++) {
            if (!isContains(intsOne,intsTwo[i])) intsNew[k++] = intsTwo[i];
        }

        for (int i = 0; i < intsOne.length; i++) {
            if (!isContains(intsTwo,intsOne[i])) intsNew[k++] = intsOne[i];
        }

        int newLength = 0;

        for (int i = 0; i < intsNew.length - 1; i++) {
            if (intsNew[i] == 0 && intsNew[i + 1] == 0) newLength = i;
        }

        int[] intsFinish = new int[newLength];

        for (int i = 0; i < newLength; i++) {
            intsFinish[i] = intsNew[i];
        }

        return intsFinish;
    }

    static int[] reverseIntsArray(int[] array){
        int[] intsNew = new int[array.length];
        int k = 0;

        for (int i = array.length - 1; k < array.length; i--) {
            intsNew[i] = array[k++];
        }
        return intsNew;
    }

    static int[] randomValueArray(int length, int maxValue, int minValue){
        int[] ints = new int[length];
        int delta = maxValue - minValue;
        for (int i = 0; i <length ; i++) {
            double random = Math.random();
            ints[i] =(int) (random * delta + minValue);
        }

        return ints;
    }


    static boolean isRepitedCharCombination(char[] containtsArray, char[] substring){
        int count = 0;
        for (int i = 0; i < containtsArray.length; i++) {
            if (count == substring.length) return true;
            if (containtsArray[i] == substring[count]) count++;
            else count = 0;
        }

        return count == substring.length;
    }

}
