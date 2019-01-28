/* 
Link to problemm : https://www.hackerrank.com/challenges/2d-array/problem

*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
 
    static int hourglassSum(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;
        int maxSum = -99999;
        int sum = 0;
        
        for (int i=1; i<rows-1;i++) {
            for (int j=1; j<cols-1; j++) {
                sum = arr[i-1][j-1] + arr[i-1][j] + arr[i-1][j+1] +
                        arr[i][j] +
                        arr[i+1][j-1] + arr[i+1][j] + arr[i+1][j+1];                
                
                if (sum > maxSum)
                    maxSum = sum;             
            }
        }
        
        return maxSum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
