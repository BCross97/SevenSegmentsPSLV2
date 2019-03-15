package co.edu.icesi;

import java.io.*;

public class Compiler {

    // CONSTANTS OR INSTRUCTIONS IN THIS CASE
    public static final char INC_PTR = '>';
    public static final char DEC_PTR = '<';
    public static final char INC_VAL = '+';
    public static final char DEC_VAL = '-';
    public static final char BGN_LPP = '[';
    public static final char END_LPP = ']';
    public static final char IN_CHAR = ',';
    public static final char OT_CHAR = '.';


    // VARIABLES
    private byte[] memoryBlocks;
    private int memorySize;
    private int memoryPointer;
    private String fuckedUpCode;
    private int codePointer;
    private boolean running;
    private BufferedReader br;
    private BufferedWriter bw;
    private StringWriter sw;
    private String numberResult;

    @Deprecated
    public Compiler(String fuckedUpCode) {
        memorySize = 30000;
        memoryBlocks = new byte[memorySize];
        memoryPointer = 0;
        this.fuckedUpCode = fuckedUpCode;
        codePointer = 0;
        running = checkBrackets();
        if (!running)
            System.out.println("Failed to run");
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        compile();
    }

    public Compiler(String fuckedUpCode, String number) {
        memorySize = 30000;
        memoryBlocks = new byte[memorySize];
        memoryPointer = 0;
        this.fuckedUpCode = fuckedUpCode;
        codePointer = 0;
        running = checkBrackets();
        if (!running)
            System.out.println("Failed to run");
        br = new BufferedReader(new StringReader(number));
        sw = new StringWriter();
        bw = new BufferedWriter(sw);
        //compile();
    }

    public boolean checkBrackets() {
        int n = 0;
        for (Character c : fuckedUpCode.toCharArray()) {
            if (c == BGN_LPP)
                n++;
            if (c == END_LPP)
                n--;
            if (n < 0)
                return false;
        }
        return n == 0;
    }

    public String compile() {
        System.out.println("Run started");
        // System.out.println("Now enter the input for your code");
        while (running && codePointer < fuckedUpCode.length()) {
            memoryPointer = memoryPointer % memorySize;
            read();
        }
        try {
            bw.flush();
            String genNumber = sw.toString();
            bw.close();
            System.out.println();
            return genNumber;
        } catch (Exception e) {
        }
        return "";
        // System.out.println("Run ended");
    }

    public void read() {

        // Check if the code pointer is within the code
        if (codePointer >= fuckedUpCode.length()) {
            running = false;
            return;
        }

        // Detect the instruction that's going to be processed
        char inst = fuckedUpCode.charAt(codePointer);
        switch (inst) {
            case '#':
                running = false;
                break;
            case '?':
                codePointer++;
                break;
            case '!':
                codePointer++;
                break;
            case INC_PTR:
                codePointer++;
                memoryPointer = (memoryPointer + 1) % memoryBlocks.length;
                break;
            case DEC_PTR:
                codePointer++;
                memoryPointer = (memoryPointer - 1) == -1 ? memoryBlocks.length - 1 : memoryPointer - 1;
                break;
            case INC_VAL:
                codePointer++;
                memoryBlocks[memoryPointer]++;
                break;
            case DEC_VAL:
                codePointer++;
                memoryBlocks[memoryPointer]--;
                break;
            case BGN_LPP:
                if (memoryBlocks[memoryPointer] == 0) {
                    int opennings = 1;
                    while (codePointer < fuckedUpCode.length() && opennings > 0) {
                        codePointer++;
                        if (fuckedUpCode.charAt(codePointer) == BGN_LPP) {
                            opennings++;
                        }
                        if (fuckedUpCode.charAt(codePointer) == END_LPP) {
                            opennings--;
                        }
                    }
                    break;
                }
                codePointer++;
                break;
            case END_LPP:
                if (memoryBlocks[memoryPointer] == 0) {
                    codePointer++;
                    break;
                }
                while (codePointer != 0 && fuckedUpCode.charAt(codePointer) != BGN_LPP) {
                    codePointer--;
                }
                if (codePointer == -1) {
                    System.out.println("FAILED TO FIND LOOP START");
                    running = false;
                }
                break;
            case IN_CHAR:
                try {
                    byte ch = (byte) br.read();
                    memoryBlocks[memoryPointer] = ch;
                    codePointer++;
                } catch (Exception e) {
                    System.out.println("FAILED TO READ FROM INPUT");
                    e.printStackTrace();
                    running = false;
                }
                break;
            case OT_CHAR:
                try {
                    int ch = (int) memoryBlocks[memoryPointer];
                    bw.write((int) ch + " ");
                    codePointer++;
                } catch (Exception e) {
                    System.out.println("FAILED TO WRITE TO OUTPUT");
                    e.printStackTrace();
                    running = false;
                }
                break;
            default:
                codePointer++;
                break;
        }
    }

    public void loadCode(String fuckedUpCode) {
        this.fuckedUpCode = fuckedUpCode;
        codePointer = 0;
    }

    public void cleanMemory() {
        memoryBlocks = new byte[memorySize];
        memoryPointer = 0;
    }

    public void setMemorySize(int memorySize) {
        this.memorySize = memorySize;
    }

    public byte[] getMemoryBlocks() {
        return memoryBlocks;
    }

    public int getCodePointer() {
        return codePointer;
    }

    public int getMemoryPointer() {
        return memoryPointer;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public String getFuckedUpCode() {
        return fuckedUpCode;
    }

    public void setMemoryBlocks(byte[] memoryBlocks) {
        this.memoryBlocks = memoryBlocks;
    }
}

