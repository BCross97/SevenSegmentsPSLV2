package co.edu.icesi;

import com.sun.javaws.progress.PreloaderPostEventListener;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Controller {

    private Compiler compiler;
    //private File code;
    PreProcessor preProcessor;
    String code;

    public Controller() {
        //String absolutePath = new File("resources/solution.bf").getAbsolutePath();
        //code = new File(absolutePath);
        preProcessor = new PreProcessor();
        String[] numbers = preProcessor.numbers();
        for (String number : numbers) {
            compiler = new Compiler(code + "", number + "");
        }
    }

    static String readFile(String path) {
        try {
            FileReader code = new FileReader("resources/solution.bf");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String readCode() {
        System.out.println("Write the brainfuck code!!\nWrite a line beggining with $ for changing to file input\n");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String code = "";
        String input = "";
        try {

            // code = br.readLine();
            boolean reading = true;
            while (reading) {
                String temp = br.readLine();
                if (temp.charAt(0) == '$') {
                    reading = false;

                } else {
                    code += temp;
                }
            }


        } catch (Exception e) {

        }

        return code;
    }

}
