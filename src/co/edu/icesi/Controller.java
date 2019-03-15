package co.edu.icesi;

import com.sun.javaws.progress.PreloaderPostEventListener;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Controller {

    private Compiler compiler;
    //private File code;
    PreProcessor preProcessor;
    String code;

    public Controller() {
        String absolutePath = new File("src/resources/solution.bf").getAbsolutePath();
        //code = new File(absolutePath);
        preProcessor = new PreProcessor();
        ArrayList<String> numbers = preProcessor.numbers();
        code = giveCode();
        for (String number : numbers) {
            compiler = new Compiler(code + "", number + "");
            System.out.println(compiler.compile());
        }
    }

    static String readFile(String path) {
        try {
            FileReader code = new FileReader(path);

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

    public String giveCode(){
        return "     _  _       _   _  _   _   _   _ \n" +
                "  |  _| _| |_| |_  |_   | |_| |_| | |\n" +
                "  | |_  _|   |  _| |_|  | |_|   | |_|\n" +
                "*\n" +
                "SETUP\n" +
                "+>+>+>+>+>+>+>+>+\n" +
                "<<<<<<<<\n" +
                "[\n" +
                "    ,>\n" +
                "]\n" +
                "[\n" +
                "    <\n" +
                "]\n" +
                "The previous sets number values in the first 9 positions of the memory\n" +
                "[\n" +
                "    >\n" +
                "] Ends in position 9\n" +
                "*\n" +
                "SET POSITION = 18 AND SET 18TH VALUE = 1\n" +
                ">>>>>>>>>\n" +
                "+\n" +
                "*\n" +
                "START OF THE PROGRAM\n" +
                "*\n" +
                "If memory position 6 == 124 then we can identify 2 6 8 0 as possible\n" +
                "candidates making the list smaller\n" +
                "*\n" +
                "COPY VALUE OF 6TH POSITION TO 16TH POSITION\n" +
                "<<<<<<<<<<<<\n" +
                "![\n" +
                "    >>>>>>>>>+>+<<<<<<<<<<-\n" +
                "]\n" +
                "!>>>>>>>>>\n" +
                "[\n" +
                "    <<<<<<<<<+>>>>>>>>>-\n" +
                "]\n" +
                "*\n" +
                "SET ACTUAL POSITION TO 16TH\n" +
                ">\n" +
                "*\n" +
                "SET 14TH SLOT WITH VALUE = 124\n" +
                "This is made by placing 8 in the 12th slot then 31 in the 13th and finally\n" +
                "124 in the 14th\n" +
                "!<<<<++++++++\n" +
                "[\n" +
                "    >++++<-\n" +
                "]\n" +
                ">-\n" +
                "[\n" +
                "    >++++<-\n" +
                "]> 124 in 14th\n" +
                "*\n" +
                "SUBSTRACT 124 TO 16TH CELL\n" +
                "[\n" +
                "    >>-<<-\n" +
                "]\n" +
                "*\n" +
                "CHECK IF 16TH == 0\n" +
                "This might leave the marker either in the 18th cell (With value 1) or in\n" +
                "the 19th cell (with value 0)\n" +
                "!>>[>]>>\n" +
                "[\n" +
                "    If memory position 3 == 124 then we can identify 6 8 0 as possible\n" +
                "    candidates making the list smaller\n" +
                "    *\n" +
                "    COPY VALUE OF 3RD POSITION TO 16TH POSITION\n" +
                "    <<<<<<<<<<<<<<<\n" +
                "    ![\n" +
                "        >>>>>>>>>>>>+>+<<<<<<<<<<<<<-\n" +
                "    ]\n" +
                "    >>>>>>>>>>>>\n" +
                "    ![\n" +
                "        <<<<<<<<<<<<+>>>>>>>>>>>>-\n" +
                "    ]\n" +
                "    *\n" +
                "    SET ACTUAL POSITION TO 16TH\n" +
                "    >\n" +
                "    *\n" +
                "    SET 14TH SLOT WITH VALUE = 124\n" +
                "    This is made by placing 8 in the 12th slot then 31 in the 13th and finally\n" +
                "    124 in the 14th\n" +
                "    !<<<<++++++++\n" +
                "    [\n" +
                "        >++++<-\n" +
                "    ]\n" +
                "    >-\n" +
                "    ![\n" +
                "        >++++<-\n" +
                "    ]> 124 in 14th\n" +
                "    *\n" +
                "    SUBSTRACT 124 TO 16TH CELL\n" +
                "    [\n" +
                "        >>-<<-\n" +
                "    ]\n" +
                "    *\n" +
                "    CHECK IF 16TH == 0\n" +
                "    This might leave the marker either in the 18th cell (With value 1) or \n" +
                "    in the 19th cell (with value 0)\n" +
                "    !>>[>]>>\n" +
                "    [\n" +
                "        If memory position 5 == 124 then we can identify 8 0 as possible\n" +
                "        candidates making the list smaller\n" +
                "        *\n" +
                "        COPY VALUE OF 5TH POSITION TO 16TH POSITION\n" +
                "        <<<<<<<<<<<<<\n" +
                "        ![\n" +
                "            >>>>>>>>>>+>+<<<<<<<<<<<-\n" +
                "        ]\n" +
                "        >>>>>>>>>>\n" +
                "        [\n" +
                "            <<<<<<<<+>>>>>>>>-\n" +
                "        ]\n" +
                "        *\n" +
                "        SET ACTUAL POSITION TO 16TH\n" +
                "        >\n" +
                "        *\n" +
                "        SET 14TH SLOT WITH VALUE = 124\n" +
                "        This is made by placing 8 in the 12th slot then 31 in the 13th and finally\n" +
                "        124 in the 14th\n" +
                "        !<<<<++++++++\n" +
                "        [\n" +
                "            >++++<-\n" +
                "        ]\n" +
                "        >-\n" +
                "        [\n" +
                "            >++++<-\n" +
                "        ]> 124 in 14th\n" +
                "        *\n" +
                "        SUBSTRACT 124 TO 16TH CELL\n" +
                "        [\n" +
                "            >>-<<-\n" +
                "        ]\n" +
                "        *\n" +
                "        CHECK IF 16TH == 0\n" +
                "        This might leave the marker either in the 18th cell (With value 1) or in\n" +
                "        the 19th cell (with value 0)\n" +
                "        >>[>]>>\n" +
                "        [\n" +
                "            If memory position 4 == 95 then we can identify 8 as our number or 4 if\n" +
                "            the condition does not apply\n" +
                "            *\n" +
                "            COPY VALUE OF 4TH POSITION TO 16TH POSITION\n" +
                "            <<<<<<<<<<<<<<\n" +
                "            ![\n" +
                "                >>>>>>>>>>>+>+<<<<<<<<<<<<-\n" +
                "            ]\n" +
                "            >>>>>>>>>>>\n" +
                "            ![\n" +
                "                <<<<<<<<<<<+>>>>>>>>>>>-\n" +
                "            ]\n" +
                "            *\n" +
                "            SET ACTUAL POSITION TO 16TH\n" +
                "            >\n" +
                "            *\n" +
                "            SET 14TH SLOT WITH VALUE = 95\n" +
                "            This is made by placing 5 in the 13th slot then 95 in the 14th\n" +
                "            <<<+++++\n" +
                "            [\n" +
                "                >+++++++++++++++++++<-\n" +
                "            ]> 95 in 14th\n" +
                "            *\n" +
                "            SUBSTRACT 95 TO 16TH CELL\n" +
                "            [\n" +
                "                >>-<<-\n" +
                "            ]\n" +
                "            *\n" +
                "            CHECK IF 16TH == 0\n" +
                "            This might leave the marker either in the 18th cell (With value 1) or in\n" +
                "            the 19th cell (with value 0)\n" +
                "            >>[>]>>\n" +
                "            [\n" +
                "                This validates the necessary conditions for finding the number EIGHT\n" +
                "                *\n" +
                "                PRINT NUMBER EIGHT\n" +
                "                [-]\n" +
                "                ++\n" +
                "                [\n" +
                "                    >++<-\n" +
                "                ]>\n" +
                "                [\n" +
                "                    >++<-\n" +
                "                ]>\n" +
                "                .\n" +
                "                *\n" +
                "                END PROGRAM\n" +
                "                #\n" +
                "            ]\n" +
                "            This validates the necessary conditions for finding the number ZERO\n" +
                "            *\n" +
                "            PRINT NUMBER CERO\n" +
                "            [-]\n" +
                "            +-\n" +
                "            .\n" +
                "            *\n" +
                "            END PROGRAM\n" +
                "            #\n" +
                "        ]\n" +
                "        This validates the necessary conditions for finding the number SIX\n" +
                "        *\n" +
                "        PRINT NUMBER SIX\n" +
                "        [-]\n" +
                "        !++\n" +
                "        [\n" +
                "            >+++<-\n" +
                "        ]>\n" +
                "        .\n" +
                "        *\n" +
                "        END PROGRAM\n" +
                "        #\n" +
                "    ]\n" +
                "    This validates the necessary conditions for finding the number TWO\n" +
                "    *\n" +
                "    PRINT NUMBER TWO\n" +
                "    [-]\n" +
                "    !++\n" +
                "        \n" +
                "    .\n" +
                "    *\n" +
                "    END PROGRAM\n" +
                "    #\n" +
                "] Is in 19th posititon \n" +
                "*\n" +
                "*\n" +
                "*\n" +
                "Before anything, we need to set to zero the value for the memory position\n" +
                "number 16\n" +
                "*\n" +
                "SET 19TH SLOT TO ZERO\n" +
                "<<<[-]<\n" +
                "*\n" +
                "*\n" +
                "*\n" +
                "If memory position 3 == 124 then we can identify 4 5 9 as possible\n" +
                "candidates making the list smaller\n" +
                "*\n" +
                "COPY VALUE OF 3RD POSITION TO 16TH POSITION\n" +
                "<<<<<<<<<<<<<<<\n" +
                "![\n" +
                "    >>>>>>>>>>>>+>+<<<<<<<<<<<<<-\n" +
                "]\n" +
                ">>>>>>>>>>>>\n" +
                "![\n" +
                "    <<<<<<<<<<<<+>>>>>>>>>>>>-\n" +
                "]\n" +
                "*\n" +
                "SET ACTUAL POSITION TO 16TH\n" +
                ">\n" +
                "*\n" +
                "SET 14TH SLOT WITH VALUE = 124\n" +
                "This is made by placing 8 in the 12th slot then 31 in the 13th and finally\n" +
                "124 in the 14th\n" +
                "!<<<<++++++++\n" +
                "[\n" +
                "    >++++<-\n" +
                "]\n" +
                ">-\n" +
                "![\n" +
                "    >++++<-\n" +
                "]> 124 in 14th\n" +
                "*\n" +
                "SUBSTRACT 124 TO 16TH CELL\n" +
                "[\n" +
                "    >>-<<-\n" +
                "]\n" +
                "*\n" +
                "CHECK IF 16TH == 0\n" +
                "This might leave the marker either in the 18th cell (With value 1) or \n" +
                "in the 19th cell (with value 0)\n" +
                "!>>[>]>>\n" +
                "[\n" +
                "    If memory position 5 == 124 then we can identify 4 9 as possible\n" +
                "    candidates making the list smaller\n" +
                "    *\n" +
                "    COPY VALUE OF 5TH POSITION TO 16TH POSITION\n" +
                "    <<<<<<<<<<<<<\n" +
                "    ![\n" +
                "        >>>>>>>>>>+>+<<<<<<<<<<<-\n" +
                "    ]\n" +
                "    >>>>>>>>>>\n" +
                "    [\n" +
                "        <<<<<<<<+>>>>>>>>-\n" +
                "    ]\n" +
                "    *\n" +
                "    SET ACTUAL POSITION TO 16TH\n" +
                "    >\n" +
                "    *\n" +
                "    SET 14TH SLOT WITH VALUE = 124\n" +
                "    This is made by placing 8 in the 12th slot then 31 in the 13th and finally\n" +
                "    124 in the 14th\n" +
                "    !<<<<++++++++\n" +
                "    [\n" +
                "        >++++<-\n" +
                "    ]\n" +
                "    >-\n" +
                "    [\n" +
                "        >++++<-\n" +
                "    ]> 124 in 14th\n" +
                "    *\n" +
                "    SUBSTRACT 124 TO 16TH CELL\n" +
                "    [\n" +
                "        >>-<<-\n" +
                "    ]\n" +
                "    *\n" +
                "    CHECK IF 16TH == 0\n" +
                "    This might leave the marker either in the 18th cell (With value 1) or in\n" +
                "    the 19th cell (with value 0)\n" +
                "    >>[>]>>\n" +
                "    [\n" +
                "        If memory position 1 == 95 then we can identify 8 as our number or 4 if\n" +
                "        the condition does not apply\n" +
                "        *\n" +
                "        COPY VALUE OF 1ST POSITION TO 16TH POSITION\n" +
                "        <<<<<<<<<<<<<<<<<<<\n" +
                "        ![\n" +
                "            >>>>>>>>>>>>>>>>>+>+<<<<<<<<<<<<<<<<<-\n" +
                "        ]\n" +
                "        >>>>>>>>>>>>>>\n" +
                "        ![\n" +
                "            <<<<<<<<<<<+>>>>>>>>>>>-\n" +
                "        ]\n" +
                "        *\n" +
                "        SET ACTUAL POSITION TO 16TH\n" +
                "        >\n" +
                "        *\n" +
                "        SET 14TH SLOT WITH VALUE = 95\n" +
                "        This is made by placing 5 in the 13th slot then 95 in the 14th\n" +
                "        <<<+++++\n" +
                "        [\n" +
                "            >+++++++++++++++++++<-\n" +
                "        ]> 95 in 14th\n" +
                "        *\n" +
                "        SUBSTRACT 95 TO 16TH CELL\n" +
                "        [\n" +
                "            >>-<<-\n" +
                "        ]\n" +
                "        *\n" +
                "        CHECK IF 16TH == 0\n" +
                "        This might leave the marker either in the 18th cell (With value 1) or in\n" +
                "        the 19th cell (with value 0)\n" +
                "        >>[>]>>\n" +
                "        [\n" +
                "            This validates the necessary conditions for finding the number FIVE\n" +
                "            *\n" +
                "            PRINT NUMBER NINE\n" +
                "            [-]\n" +
                "            !+++\n" +
                "            [\n" +
                "                >+++<-\n" +
                "            ]>\n" +
                "            .\n" +
                "            *\n" +
                "            END PROGRAM\n" +
                "            #\n" +
                "        ]\n" +
                "        This validates the necessary conditions for finding the number FIVE\n" +
                "        *\n" +
                "        PRINT NUMBER FOUR\n" +
                "        [-]\n" +
                "        !++\n" +
                "        [\n" +
                "            >++<-\n" +
                "        ]>\n" +
                "        +\n" +
                "        .\n" +
                "        *\n" +
                "        END PROGRAM\n" +
                "        #\n" +
                "    ]\n" +
                "    This validates the necessary conditions for finding the number FIVE\n" +
                "    *\n" +
                "    PRINT NUMBER FIVE\n" +
                "    [-]\n" +
                "    !++\n" +
                "    [\n" +
                "        >++<-\n" +
                "    ]>\n" +
                "    +\n" +
                "    .\n" +
                "    *\n" +
                "    END PROGRAM\n" +
                "    #\n" +
                "] Is in 19th posititon \n" +
                "*\n" +
                "*\n" +
                "*\n" +
                "Before anything, we need to set to zero the value for the memory position\n" +
                "number 16\n" +
                "*\n" +
                "SET 19TH SLOT TO ZERO\n" +
                "<<<[-]<\n" +
                "*\n" +
                "*\n" +
                "*\n" +
                "If memory position 1 == 95 then we can identify 7 as our number or 1 if\n" +
                "the condition does not apply\n" +
                "*\n" +
                "COPY VALUE OF 1ST POSITION TO 16TH POSITION\n" +
                "<<<<<<<<<<<<<<<<<<<\n" +
                "![\n" +
                "    >>>>>>>>>>>>>>>>>+>+<<<<<<<<<<<<<<<<<-\n" +
                "]\n" +
                ">>>>>>>>>>>>>>\n" +
                "![\n" +
                "    <<<<<<<<<<<+>>>>>>>>>>>-\n" +
                "]\n" +
                "*\n" +
                "SET ACTUAL POSITION TO 16TH\n" +
                ">\n" +
                "*\n" +
                "SET 14TH SLOT WITH VALUE = 95\n" +
                "This is made by placing 5 in the 13th slot then 95 in the 14th\n" +
                "<<<+++++\n" +
                "[\n" +
                "    >+++++++++++++++++++<-\n" +
                "]> 95 in 14th\n" +
                "*\n" +
                "SUBSTRACT 95 TO 16TH CELL\n" +
                "[\n" +
                "    >>-<<-\n" +
                "]\n" +
                "*\n" +
                "CHECK IF 16TH == 0\n" +
                "This might leave the marker either in the 18th cell (With value 1) or in\n" +
                "the 19th cell (with value 0)\n" +
                ">>[>]>>\n" +
                "[\n" +
                "    This validates the necessary conditions for finding the number FIVE\n" +
                "    *\n" +
                "    PRINT NUMBER SEVEN\n" +
                "    [-]\n" +
                "    !+++\n" +
                "    [\n" +
                "        >++<-\n" +
                "    ]>\n" +
                "    +\n" +
                "    .\n" +
                "    *\n" +
                "    END PROGRAM\n" +
                "    #\n" +
                "]\n" +
                "*\n" +
                "FIVE\n" +
                "*\n" +
                "This validates the necessary conditions for finding the number FIVE\n" +
                "*\n" +
                "PRINT NUMBER FIVE\n" +
                "[-]\n" +
                "!+\n" +
                ".\n" +
                "*\n" +
                "END PROGRAM\n" +
                "#\n" +
                "     _  _       _   _  _   _   _   _ \n" +
                "  |  _| _| |_| |_  |_   | |_| |_| | |\n" +
                "  | |_  _|   |  _| |_|  | |_|   | |_|\n";
    }

}
