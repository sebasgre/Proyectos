import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import Programacion4.Parcial2.primeraParte.Pregunta1;

public class TestPregunta1 {
    @Test
    public void test1() throws IOException {
        //Vale 15 puntos
        makeTest("input\\input1.txt", "input\\output1.txt");
    }

    @Test
    public void test2() throws IOException {
        //Vale 35 puntos
        makeTest("input\\input2.txt", "input\\output2.txt");
    }

    private void makeTest(String inputFile, String outputFile) throws IOException {
        FileInputStream in = new FileInputStream(new File(inputFile));

        FileInputStream expectedOutput = new FileInputStream(new File(outputFile));
        BufferedReader br = new BufferedReader(new InputStreamReader(expectedOutput));

        List<Integer> expected = new ArrayList<>();
        String line = br.readLine();
        while (line != null) {
            line = line.trim();
            expected.add(Integer.parseInt(line));

            line = br.readLine();
        }

        Pregunta1 obj = new Pregunta1();

        List<Integer> actual = obj.resolver(in);

        Assert.assertArrayEquals(expected.toArray(new Integer[0]), actual.toArray(new Integer[0]));
    }
}

