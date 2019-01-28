/* 
Link to problemm : https://www.hackerrank.com/challenges/sock-merchant/problem

*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.IntStream;
import java.util.ArrayList;

public class Solution {
 
    static int sockMerchant(int n, int[] ar) {
        ArrayList checked = new ArrayList(); 
        int countPair=0;
        int countTotal=0; 
        for (int i=0; i<n; i++) { 
            if (!checked.contains(ar[i])) {
                checked.add(ar[i]); 

                for (int j=i; j<n; j++) {
                    if (ar[i]==ar[j]) {
                        countPair++; 
                    }
                        
                } 
                countTotal+= countPair/2;
                countPair=0; //reset the counter
            }
            else
                continue;
        }

        return countTotal;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
