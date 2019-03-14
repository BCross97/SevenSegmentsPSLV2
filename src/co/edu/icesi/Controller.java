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

    Lectura del numero!
            >+>+>+>+>+>+>+>+
            <<<<<<<<
            [
            ,>
            ]
            [
    <
]
    Tras esto el numero queda escrito en las primeras 9 posiciones!
            [
            .>
            ]
            #
            1234567891


    public String readCode() {
        System.out.println("Write the brainfuck code!!\nWrite a line beggining with # for changing to file input\n");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String code = "";
        String input = "";
        try {

            // code = br.readLine();
            boolean reading = true;
            while (reading) {
                String temp = br.readLine();
                if (temp.charAt(0) == '#') {
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
