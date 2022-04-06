package Day3;

import java.util.Scanner;

public class SumOfNeighbours {

    public static void main(String[] args) {

        readInput();
        
    }

    public static void readInput() {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("What are the dimensions of the array? ");

            int firstDim = sc.nextInt();
            int secondDim = sc.nextInt();

            int[][] array = new int[firstDim][secondDim];

            System.out.println("Populate the dimensions " + firstDim + " x " + secondDim);
            
            for (int i = 0; i < array.length; i++) {
                System.out.println("Enter the row: ");
                for (int j = 0; j < array.length; j++) {
                array[i][j] = sc.nextInt();
                }
            }

            for (int i =0; i < array.length; i++) {
                
                if (!inputValidator(array[i])) {
                    displayResult(null);
                }
            }
            
            int[][] newArray = computeSumOfNeighbors(array);
            displayResult(newArray);
        }

        

    }

    public static boolean inputValidator(int[] set) {
        if (set.length > 1) {
        return true;
        } else {
            return false;
        }
    }

    public static int[][] computeSumOfNeighbors(int[][] set) {
    // calculates diagonally and up/down, left/right
    // had help to get this working
        int getSum = 0;
        int[][] sum = new int[set.length][set[0].length];

        for(int row = 0; row < set.length; row++){
            for (int col=0; col < set[row].length; col++){
                for(int i = row -1; i < set.length; i++) {
                    for (int j = col -1; j < set[row].length; j++) {
                        if (!(i == row && j == col) && (i >= 0) && (j >= 0) && (i <= row + 1) && (j <= col +1)) {
                            getSum += set[i][j];
                        }
                    }
                }
                sum[row][col] = getSum;
                getSum = 0;
            }
        } return sum;
    }

    public static void displayResult(int[][] set) {

        if (set == null) {
            System.out.println("Give proper input");
        } else {
            for (int i = 0; i < set.length; i++) {
                for (int j = 0; j < set[0].length; j++) {
                    System.out.print(set[i][j] + " ");
                }
                System.out.println();
            }    
        }
    }
}
    

