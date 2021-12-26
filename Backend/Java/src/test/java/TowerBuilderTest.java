import static org.junit.Assert.assertArrayEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.junit.Test;

import Programacion4.Parcial1.Parte1.TowerBuilder;

public class TowerBuilderTest {
    @Test
    public void test1() throws IOException {

        makeTests("inputs\\input1.txt", "inputs\\output1.txt");

    }

    @Test
    public void test2() throws IOException {

        makeTests("inputs\\input2.txt", "inputs\\output2.txt");

    }

    @Test
    public void test3() throws IOException {

        makeTests("inputs\\input3.txt", "inputs\\output3.txt");

    }

    @Test
    public void test4() throws IOException {

        makeTests("inputs\\input4.txt", "inputs\\output4.txt");

    }

    @Test
    public void test5() throws IOException {

        makeTests("inputs\\input5.txt", "inputs\\output5.txt");

    }

    @Test
    public void test6() throws IOException {

        makeTests("inputs\\input6.txt", "inputs\\output6.txt");

    }

    @Test
    public void test7() throws IOException {

        makeTests("inputs\\input7.txt", "inputs\\output7.txt");

    }

    @Test
    public void test8() throws IOException {

        makeTests("inputs\\input8.txt", "inputs\\output8.txt");

    }

    @Test
    public void test9() throws IOException {

        makeTests("inputs\\input9.txt", "inputs\\output9.txt");

    }

    @Test
    public void test10() throws IOException {

        makeTests("inputs\\input10.txt", "inputs\\output10.txt");

    }


    private void makeTests(String inputFile, String outputFile) throws IOException {
        FileInputStream in = new FileInputStream(new File(inputFile));

        TowerBuilder builder = new TowerBuilder();
        ArrayList<ArrayList<Integer>> discosInstalados = builder.build(in);

        Integer[][] actual = new Integer[discosInstalados.size()][];
        int j = 0;
        for (ArrayList<Integer> sublist : discosInstalados) {
            actual[j] = sublist.toArray(new Integer[0]);
            j++;
        }

        FileInputStream expectedOutput = new FileInputStream(new File(outputFile));
        BufferedReader br = new BufferedReader(new InputStreamReader(expectedOutput));

        ArrayList<Integer[]> discosInstaladosEsperados = new ArrayList();
        String line = br.readLine();
        while (line != null) {
            line = line.trim();
            if (line.isEmpty()) {
                discosInstaladosEsperados.add(new Integer[0]);
            } else {
                String[] strNumbers = line.trim().split(" ");
                Integer[] numbers = new Integer[strNumbers.length];
                for (int i = 0; i < strNumbers.length; i++) {
                    numbers[i] = Integer.parseInt(strNumbers[i].trim());
                }

                discosInstaladosEsperados.add(numbers);
            }


            line = br.readLine();
        }
        Integer[][] expected = discosInstaladosEsperados.toArray(new Integer[0][]);

        assertArrayEquals(expected, actual);
    }
}
