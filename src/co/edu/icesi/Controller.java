package co.edu.icesi;

import com.sun.javaws.progress.PreloaderPostEventListener;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Controller {

    private Compiler compiler;
    private File code;
    PreProcessor preProcessor;


    public Controller() {
        String absolutePath = new File("resources/solution.bf").getAbsolutePath();
        code = new File(absolutePath);
        String solutionBF = code.toString();
        preProcessor = new PreProcessor();
        String[] numbers = preProcessor.numbers();
        for (String number : numbers) {
            compiler = new Compiler(readCode(), number);
        }
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
