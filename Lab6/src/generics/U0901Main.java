package generics;

public class U0901Main {
    public static void main(String[] args) {
        Integer intArr[] = {10, 20, 15};
        int float_numbers = 3;
        Float floatArr[] = new Float[float_numbers];
        
        System.out.println("Float array: ");
        for (int i = 0; i < float_numbers; i++) {
            float rand_num = (float) Math.random() * 100;
            System.out.print(rand_num + " ");
            floatArr[i] = rand_num;
        }
        U0901WorkArray<Integer> workArrayInt = new U0901WorkArray<>(intArr);
        U0901WorkArray<Float> workArrayFloat = new U0901WorkArray<>(floatArr);
        
        System.out.println();
        System.out.println("int array sum: " + workArrayInt.sum());
        System.out.println("float array sum: " + workArrayFloat.sum());
        
//        String[] array_for_error = {"sdf", "sdfsag", "sdfsrev"};
//        generics.U0901WorkArray<Integer> insWorkArrayString = new generics.U0901WorkArray<Integer>(array_for_error);
    }
}