package co.edu.icesi;

import jdk.nashorn.internal.objects.NativeArray;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;

public class PreProcessor {

    public String[] numbers() {
        String[] numbers = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        return getStrings(numbers, br);
    }

    private String[] getStrings(String[] numbers, BufferedReader br) {
        try {
            String line = br.readLine();
            while (line != null || !line.equals("")) {

                int n = line.length() / 4;
                numbers = new String[n];
                for (int s = 0; s < n; s++) {
                    int a = s * 4;
                    int b = (s + 1) * 4;
                    numbers[s] += line.substring(a, b);
                    line = br.readLine();
                }

            }
        } catch (Exception e) {

        }
        return numbers;
    }

    public String[] numbers(String input) {
        String[] numbers = null;
        BufferedReader br = new BufferedReader(new StringReader(input));

        return getStrings(numbers, br);
    }
}
