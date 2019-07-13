/**
 * javadoc
 */

public class Main {
    public static void main(String[] args) {
        
        //TASK 1
        System.out.println("Starting project");
        
        //TASK 2
        byte v_byte = 120;
        short v_short = 129;
        char v_char = 'a';
        int v_int = 65999;
        long v_long = 4294967296L;
        float v_float = 0.33333334f;
        double v_double = 0.3333333333333333;
        boolean v_bool = true;
        
        System.out.println("This is a byte: " + v_byte);
        System.out.println("This is a short: " + v_short);
        System.out.println("This is a char: " + v_char);
        System.out.println("This is a int: " + v_int);
        System.out.println("This is a long: " + v_long);
        System.out.println("This is a float: " + v_float);
        System.out.println("This is a double: " + v_double);
        System.out.println("This is a boolean: " + v_bool);
        
        
        for (char i = 'f'; i < 'q'; i++) {
            System.out.println(i);
        }
        
        //TASK 3
        for (int i = 0; i < 26; i++) {
            System.out.print((char) ('a' + i));
        }
        System.out.println();
        
        System.out.print("Time with int variable: ");
        long begin = new java.util.Date().getTime();
        for (int i = 0; i <= 100000000; i++) {
        }
        long end = new java.util.Date().getTime();
        System.out.println(end - begin);
        
        System.out.print("Time with long variable: ");
        begin = new java.util.Date().getTime();
        for (long i = 0; i <= 100000000; i++) {
        }
        end = new java.util.Date().getTime();
        System.out.println(end - begin);
        
        
        //TASK 5-1
        int[] mas = {12, 43, 12, -65, 778, 123, 32, 76};
        int max = mas[0];
        for (int i = 1; i < mas.length; i++) {
            if (mas[i] > max) {
                max = mas[i];
            }
        }
        System.out.println("Max: " + max);
        
        
        //TASK 5-2
        int[][] matrix = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = (int) Math.round(Math.random() * 10);
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[j][i] + " ");
            }
            System.out.println();
        }
        
    }
}
