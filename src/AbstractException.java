import java.util.*;
interface Operation{
    public void div(int a,int b) throws Exception;
}
class Opt implements Operation
{
    public void div(int a,int b)
    {
        try
        {
            int c=a/b;
            System.out.println(c);
        }
        catch (RuntimeException e)
        {
            System.out.println("Enter the valid number,divisor cannoy be zero");
        }
        finally {
            System.out.println("the operation is completed");
        }
    }
}
public class AbstractException {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        Operation ob=new Opt();
        try {
            ob.div(a,b);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
