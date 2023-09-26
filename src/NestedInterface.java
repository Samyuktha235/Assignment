


interface Project
{
    interface Title
    {
        void display();
    }
}


 class Projectreview implements Project.Title {
    public void display()
    {
        System.out.println("The Nested Interface is called");
    }
}
class ProjectClass
{
    interface ProjectInterface
    {
        void show();
    }
}
class ProjectShow implements ProjectClass.ProjectInterface {
    public void show()
    {
        System.out.println("Interface inside class is called");
    }
}

interface projectDisplay
{
    class preview{
        public void display(){
            System.out.println("Class inside Interface is called");
        }
    }
}
public class NestedInterface {
    public static void main(String args[])
    {

        Project.Title obj=new Projectreview();
        obj.display();
        ProjectClass.ProjectInterface ab= new ProjectShow() ;
         ab.show();
         projectDisplay.preview ob=new projectDisplay.preview();
         ob.display();
    }


}
