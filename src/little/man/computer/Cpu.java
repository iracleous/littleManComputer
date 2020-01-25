package little.man.computer;

import javax.swing.*;
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
    private JTextArea textArea;

    public Cpu(JTextArea textArea){
        this.textArea=textArea;
    }

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
            textArea.append(i+":= "+dataMemory[i]+ " \n");
    }


    public void executeProgram() {
        instructionRegister = 0;

        do{
            String instruction = codeMemory[instructionRegister];
            if (instruction == null ) break;

            instruction = instruction.trim().toUpperCase();
            if (instruction.equals("HLT") ) break;
            textArea.append("The instruction is   " + instruction+ " \n");

            instructionRegister ++;

            String instr[] = instruction.split(" ");
            if (instr.length == 1) process(instruction.trim());
            if (instr.length == 2) process(instr[0].trim(), instr[1].trim());
        } while (true);


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
            case "BRZ":
                if (accumulator == 0)
                    instructionRegister = Integer.parseInt(parameter);
                break;
            case "BRP":
                if (accumulator >= 0)
                     instructionRegister = Integer.parseInt(parameter);
                break;
            case "BRA":
                instructionRegister = Integer.parseInt(parameter);
                break;
            default:
                textArea.append("do not know"+ "\n");
        }
    }


    public void process(String instruction) {
        switch (instruction) {
            case "INP":
              String value=  JOptionPane.showInputDialog(null,
                        "Give value for the accumulator");
               accumulator = Integer.parseInt(value);
                break;
            case "OUT":
                textArea.append("Accumulator= " + accumulator + "\n");
                break;
            case "HLT":
                textArea.append("The program ends"+ "\n");
                break;
            default:
                textArea.append("do not know"+ "\n");

        }
    }
}
