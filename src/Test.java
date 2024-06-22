public class Test extends Vehicle {
    private static int x = 0;
//    public Test(){
//        x++;
//    }
    public void drive(){
       System.out.println("Drive from test");
    }
    public void drive(int count){
        for (int i = 0; i < count; i++) {
            System.out.println("Drive from test loop");

        }
    }
//    public static int getCount(){
//        return x;
//    }
}
