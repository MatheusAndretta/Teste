package main.fibonacci;

public class Fibonacci {

    private static final int MAX_ELEMENTS = 100;
    private static final int[] fibElements = new int[MAX_ELEMENTS];

    public static int findElementDP(int elementNumber) {
        
        for (int i = 0; i < MAX_ELEMENTS; i++) {
            fibElements[i] = -1;
        }
        return findElement(elementNumber);
    }

    public static int findElement(int elementNumber) {
        if (fibElements[elementNumber] == -1) {
            if (elementNumber <= 1) {
                fibElements[elementNumber] = elementNumber;
            } else {
                fibElements[elementNumber] = findElement(elementNumber - 1) + findElement(elementNumber - 2);
            }
        }
        return fibElements[elementNumber];
    }
}