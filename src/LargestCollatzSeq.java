
        import java.util.*;
        public class LargestCollatzSeq {
            public static void main(String args[]){
                Scanner sc=new Scanner(System.in);
                int n=sc.nextInt();
                boolean flag=true;
                while(flag)
                {
                    if(n==1)
                    {
                        flag=false;
                        break;
                    }
                    if(n%2==0)
                    {
                        n=n/2;
                        if(n==1)
                        {
                            System.out.println("1");
                        }
                        else {
                        System.out.print(n+"-->");
                        }
                    }
                    else
                    {
                        if(n==1)
                        {
                            System.out.println("1");
                        }
                        else {
                        n=(3*n)+1;
                        System.out.print(n+"-->");
                        }
                    }
                }
            }
        }
