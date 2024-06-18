package Shape;

public class Circle extends Shape{
    double radius;

    @Override
    public double calculateArea(){
        return Math.PI * radius * radius;
    }
    public Circle(double radius){
        this.radius = radius;
    }
}
