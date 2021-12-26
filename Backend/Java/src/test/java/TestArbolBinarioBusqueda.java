
import java.io.FileInputStream;
import java.util.List;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

import Programacion4.Parcial2.segundaParte.abb.ArbolBinarioBusqueda;
public class TestArbolBinarioBusqueda {
    @Test
    public void test1(){
        makeTest("files\\input1.txt", "files\\output1.txt");
    }

    @Test
    public void test2(){
        makeTest("files\\input2.txt", "files\\output2.txt");
    }

    @Test
    public void test3(){
        makeTest("files\\input3.txt", "files\\output3.txt");
    }

    @Test
    public void test4(){
        makeTest("files\\input4.txt", "files\\output4.txt");
    }

    @Test
    public void test5(){
        makeTest("files\\input5.txt", "files\\output5.txt");
    }

    @Test
    public void test6(){
        makeTest("files\\input6.txt", "files\\output6.txt");
    }

    @Test
    public void test7(){
        makeTest("files\\input7.txt", "files\\output7.txt");
    }

    @Test
    public void test8(){
        makeTest("files\\input8.txt", "files\\output8.txt");
    }

    @Test
    public void test9(){
        makeTest("files\\input9.txt", "files\\output9.txt");
    }

    @Test
    public void test10(){
        makeTest("files\\input10.txt", "files\\output10.txt");
    }

    private void makeTest(String inputFile, String outputFile)  {
        try {
            FileInputStream in = new FileInputStream(inputFile);

            Scanner scanner = new Scanner(in);

            ArbolBinarioBusqueda<Integer> arbol = new ArbolBinarioBusqueda<>();
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                int value = scanner.nextInt();
                arbol.insertar(value);
            }
            int toSearch = scanner.nextInt();
            List<Integer> result = arbol.getRecorridoHasta(toSearch);

            FileInputStream out = new FileInputStream(outputFile);
            scanner = new Scanner(out);
            n = scanner.nextInt();
            Integer[] expected = new Integer[n];
            for (int i = 0; i < n; i++) {
                int value = scanner.nextInt();
                expected[i] = value;
            }
            Integer[] actual = result == null ? null : result.toArray(new Integer[0]);
            Assert.assertArrayEquals(expected, actual);

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
