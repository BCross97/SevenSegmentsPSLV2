package co.edu.icesi;

import jdk.nashorn.internal.objects.NativeArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;

public class PreProcessor {

    public ArrayList<String> numbers() {
        ArrayList<String> numbers = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] readings = new String[3];
        try {
            readings[0] = br.readLine();
            readings[1] = br.readLine();
            readings[2] = br.readLine();

            for (int i = 0; i < readings[0].length(); i += 4) {
                if(i >= 24)
                    numbers = numbers;

                String top = readings[0].substring(i, i + 3);
                String mid = readings[1].substring(i, i + 3);
                String bot = readings[2].substring(i, i + 3);
                numbers.add(top + mid + bot);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        for(String numb : numbers){
            System.out.println(numb);
            System.out.println();
        }

        return numbers;
    }

}
