package little.man.computer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Cpu {

    private int programCounter;
    private int accumulator;
    private int instructionRegister;
    private int addressRegister;

    private String[] codeMemory = new String[200];
    private int[] dataMemory = new int[200];


    public void loadProgram(String filename) {
        int position = 0;
        try {
            Scanner br = new Scanner(new FileReader(filename));
            while (br.hasNext())
                codeMemory[position++] = br.nextLine();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void printMemory()
    {
        for (int i=20;i<30;i++)
            System.out.println(i+":= "+dataMemory[i]+ " ");
    }


    public void executeProgram() {
        for (String instruction : codeMemory) {
            if (instruction==null) break;
            System.out.println("The instruction is   " + instruction);
           instruction = instruction.trim();
            String instr[] = instruction.split(" ");
            if (instr.length == 1) process(instruction.trim());
            if (instr.length == 2) process(instr[0].trim(), instr[1].trim());
        }
    }

    public void process(String instruction, String parameter) {
        int position = Integer.parseInt(parameter);
        switch (instruction) {
            case "STA":
                dataMemory[position] = accumulator;
                break;
            case "LDA":
                accumulator = dataMemory[position];
                break;
            case "ADD":
                accumulator += dataMemory[position];
                break;
            case "SUB":
                accumulator -= dataMemory[position];
                break;
            default:
                System.out.println("do not know");
        }
    }


    public void process(String instruction) {
        switch (instruction) {
            case "INP":
                System.out.println("Give value for the accumulator");
                Scanner sc = new Scanner(System.in);
                accumulator = sc.nextInt();
                break;
            case "OUT":
                System.out.println("Accumulator= " + accumulator);
                break;

            case "HLT":
                System.out.println("The program ends");
                break;
            default:
                System.out.println("do not know");

        }
    }
}
