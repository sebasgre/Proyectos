import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import Programacion4.Parcial1.Parte2.Pregunta1;

public class Pregunta1Test {
    @Test
    public void test1() throws IOException {
        makeTest("testcases\\input1.txt", "testcases\\output1.txt");
    }

    @Test
    public void test2() throws IOException {
        makeTest("testcases\\input2.txt", "testcases\\output2.txt");
    }

    @Test
    public void test3() throws IOException {
        makeTest("testcases\\input3.txt", "testcases\\output3.txt");
    }

    @Test
    public void test4() throws IOException {
        makeTest("testcases\\input4.txt", "testcases\\output4.txt");
    }

    @Test
    public void test5() throws IOException {
        makeTest("testcases\\input5.txt", "testcases\\output5.txt");
    }

    @Test
    public void test6() throws IOException {
        makeTest("testcases\\input6.txt", "testcases\\output6.txt");
    }

    @Test
    public void test7() throws IOException {
        makeTest("testcases\\input7.txt", "testcases\\output7.txt");
    }

    @Test
    public void test8() throws IOException {
        makeTest("testcases\\input8.txt", "testcases\\output8.txt");
    }

    @Test
    public void test9() throws IOException {
        makeTest("testcases\\input9.txt", "testcases\\output9.txt");
    }

    @Test
    public void test10() throws IOException {
        makeTest("testcases\\input10.txt", "testcases\\output10.txt");
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
