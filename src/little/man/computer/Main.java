package little.man.computer;

public class Main {

   public static void main(String[] args) {
        System.out.println("Little man Computer started");
        Cpu cpu = new Cpu();
        cpu.loadProgram("code.txt");
        cpu.executeProgram();
        cpu.printMemory();
    }

}
