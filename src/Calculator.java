interface Calci{
           void Addition(int a,int b);
           void Addition(int a,float b);
           void Addition(float a,float b);
           void Addition(float a,int b);
           void Subtraction(int a,int b);
           void Subtraction(float a,int b);
           void Subtraction(float a,float b);
           void Subtraction(int a,float b);
           void Multiplication(int a,int b);
           void Multiplication(float a,int b);
           void Multiplication(float a,float b);
           void Multiplication(int a,float b);
           void Division(int a,int b);
           void Division(int a,float b);
           void Division(float a,float b);
           void Division(float a,int b);


        }
class Abstraction implements Calci
        {
               public void Addition(int a, int b)
               {
                   int c=a+b;
                   System.out.println(a+"+"+b+"="+c);
               }
               public void Addition(int a,float b)
               {
                   float c=a+b;
                   System.out.println(a+"+"+b+"="+c);
               }
               public void Addition(float a,float b)
               {
                   float c=a+b;
                   System.out.println(a+"+"+b+"="+c);
               }
               public void Addition(float a,int b)
               {
                   float c=a+b;
                   System.out.println(a+"+"+b+"="+c);
               }
               public void Subtraction(int a,int b)
               {
                   int c=a-b;
                   System.out.println(a+"-"+b+"="+c);
               }
               public void Subtraction(float a,int b)
               {
                   float c=a-b;
                   System.out.println(a+"-"+b+"="+c);
               }
               public void Subtraction(float a,float b)
               {
                   float c=a-b;
                   System.out.println(a+"-"+b+"="+c);
               }
               public void Subtraction(int a,float b)
               {
                   float c=a-b;
                   System.out.println(a+"-"+b+"="+c);
               }
               public void Multiplication(int a,int b)
               {
                   int c=a*b;
                   System.out.println(a+"*"+b+"="+c);
               }
               public void Multiplication(float a,int b)
               {
                   float c=a*b;
                   System.out.println(a+"*"+b+"="+c);
               }
               public void Multiplication(float a,float b)
               {
                   float c=a*b;
                   System.out.println(a+"*"+b+"="+c);
               }
               public void Multiplication(int a,float b)
               {
                   float c=a*b;
                   System.out.println(a+"*"+b+"="+c);
               }

               public void Division(int a,int b)
               {
                   if(b==0)
                   {
                       System.out.println("Divisor cannot be zero");
                       return;
                   }
                   int c=a/b;
                   System.out.println(a+"/"+b+"="+c);
               }
               public void Division(float a,int b)
               {
                   if(b==0)
                   {
                       System.out.println("Divisor cannot be zero");
                       return;
                   }
                   float c=a/b;
                   System.out.println(a+"/"+b+"="+c);
               }
               public void Division(int a,float b)
               {
                   if(b==0)
                   {
                       System.out.println("Divisor cannot be zero");
                       return;
                   }
                   float c=a/b;
                   System.out.println(a+"/"+b+"="+c);
               }
               public void Division(float a,float b)
               {
                   if(b==0)
                   {
                       System.out.println("Divisor cannot be zero");
                       return;
                   }
                   float c=a/b;
                   System.out.println(a+"/"+b+"="+c);
               }
        }
public class Calculator {
       public static void main(String args[])
       {
           Calci ob=new Abstraction();
           ob.Addition(2,3);
           ob.Addition(2.5f,3.5f);
           ob.Addition(2.5f,3);
           ob.Addition(2, 3.5F);
           ob.Subtraction(10,5);
           ob.Subtraction(10.5f,5.5f);
           ob.Subtraction(10,5.5f);
           ob.Subtraction(10.5f,5);
           ob.Multiplication(2,3);
           ob.Multiplication(3.2f,2.3f);
           ob.Multiplication(2,3.2f);
           ob.Multiplication(2.3f,3);
           ob.Division(10,5);
           ob.Division(10.5f,5);
           ob.Division(2.6f,1.3f);
           ob.Division(6.3f,2);

       }
}
