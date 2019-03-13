package co.edu.icesi;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class Controller {

    private Compiler compiler;
    private File code;

    public Controller() {
        compiler = new Compiler(readCode());

    }

    public String readCode() {
        System.out.println("Write the brainfuck code!!");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String code = "";
        try {

            code = br.readLine();


        } catch (Exception e) {

        }
        return code;
    }

}
