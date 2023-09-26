

public class Inheritance {
    public static void main(String args[])
    {
         Rectangle rec=new Rectangle();
         Circle cir=new Circle();
         Shape sh=new Shape();
         sh.draw();
         cir.size();
         rec.size();
         cir.round();
         rec.length();
    }
}

class Shape
{
    int a;
    int b;
    public Shape(){
        a=10;
        b=10;
    }

    public Shape(int a, int b) {
        this.a=a;
        this.b=b;
    }

    public static void draw()
    {
        System.out.println("The draw method in shape class is called");
    }
    public void length()
    {
        System.out.println("The length of shape class is called");
    }
}

class Rectangle extends Shape{
    public Rectangle(){
        super(2,3);
        System.out.println("a="+a+" b="+b+" of the Rectangle");
    }
    public static void size()
    {
        System.out.println("the Rectangle class is called");
    }
   public void length()
   {
       System.out.println("the method is overriden from rectangle class");
       super.length();
   }
}

class Circle extends Shape{
    public Circle(){
        super();
        System.out.println("a="+a+" b="+b+" of the circle");
    }
    public static void size()
    {
        System.out.println("The Cirle class is called");
    }
    public void round()
    {
        System.out.println("the method is overriden from circle class");
        super.draw();
    }
}