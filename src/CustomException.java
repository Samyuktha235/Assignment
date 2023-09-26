import java.util.*;

interface CustExcep
{
    void MyException() throws Exception;
}

class MyException extends Exception
{
    public MyException(String message) {
        super(message);
    }
}
public class CustomException {
    public static void main(String args[]) throws MyException
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter a positive number");
        int a=sc.nextInt();
        try
        {
            if(a<0)
            {
                throw new MyException("This is the custom Exception");
            }
            else
            {
                System.out.println("the number is "+a);
            }
        }
            catch (Exception e)
            {
                System.out.println("the exception is caught"+e.getMessage());
            }
    }
}
