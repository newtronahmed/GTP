package Shape;

public class Main {
    public static void main(String[] args){
        Rectangle rect = new Rectangle(4, 10);
        Circle circle = new Circle(5);
        circle.display();
        System.out.println("The area of the circle is " + circle.calculateArea());
        rect.display();
        System.out.println("The area of the rectangle is " + rect.calculateArea());
    }
}
