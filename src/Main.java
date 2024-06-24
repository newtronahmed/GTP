import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        Vehicle newTest1 = new Test();
//        newTest1.drive();
//        ((Test) newTest1).drive(3);
//        Test newTest = new Test();
//        Test newTest2 = new Test();
//            int [] arr = {5,2,8,1,4};
//            Arrays.sort(arr);
            String str1 = "hello";
            str1.concat("world");
            String str2 = "Hello";
         int [] arr = {1, 2, 3,};
         int [] arr2 = arr.clone();
            System.out.println(Arrays.toString(arr2));
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == j) {
                    System.out.println(matrix[i][j]);
                }
            }
        }
//        int index = Arrays. binarySearch(arr, 3);
//        System.out.println(index);
//        System.out.println(Test.getCount());

        System.out.print("Eid Mubarak!");
//        Test newTest = new Test(5);
//        Test shape = new Test(10);
//        shape.draw();
//        newTest.display();




//        for (int i = 1; i <= 5; i++) {
//            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
//            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//            System.out.println("i = " + i);
//        }
    }
}