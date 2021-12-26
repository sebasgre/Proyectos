package Programacion4.Practico5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Dos {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);

        BigInteger zero = new BigInteger("0");
        BigInteger limit = new BigInteger("2147483647");

        String text = reader.readLine();

        while(text != null) {


            text = text.replaceAll("[\\s,]","")
                    .replaceAll("[oO]","0")
                    .replaceAll("[l]","1")
                    .trim();
            if(text.isEmpty()){
                System.out.println("error");
                text = reader.readLine();
                continue;
            }

            try{
                BigInteger value =new BigInteger(text);
                if(value.compareTo(zero) >= 0 && value.compareTo(limit) <= 0) {
                    System.out.println(value);
                }else{
                    System.out.println("error");
                }
            }catch (Exception e){
                System.out.println("error");
            }

            text = reader.readLine();
        }
    }
}
