package little.man.computer;

import java.math.BigInteger;

public class TestNumbers {

    public static void main(String[] args) {

        int n = Integer.MAX_VALUE;

        BigInteger nn= new BigInteger("202147483647");
        BigInteger nn1=  nn.add(new BigInteger("1"));

        System.out.println(nn);
        System.out.println(nn1);
    }
}
