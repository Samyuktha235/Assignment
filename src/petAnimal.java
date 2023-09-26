public class petAnimal {
    String Animal;
    String soundType;
    int soundVol;
    int height;

    petAnimal(String Animal,int soundVol)
    {
        this.Animal=Animal;
        this.soundVol=soundVol;
    }

    petAnimal(String Animal,int soundVol,String soundType)
    {
        this.Animal=Animal;
        this.soundVol=soundVol;
        this.soundType=soundType;
    }

    petAnimal(String Animal,int soundVol,String soundType,int height)
    {
        this(Animal); //Constructor Chaining
       // this(soundVol,soundType); this should be at the 1st line
        System.out.println(soundType+" and "+soundVol+" are the sound and sound level of the animal");
        System.out.println(height+" is the height of the animal");
        System.out.println("constructor chaining is completed");
    }
    petAnimal(String Animal) {
        System.out.println(Animal + "is the name of the animal");
    }
    petAnimal(petAnimal a)
    {
        this.Animal=a.Animal;
        this.soundVol=a.soundVol;
    }
    void display()
    {
        System.out.println(Animal+" "+soundVol+" "+soundType);
    }
    public static void main(String args[])
    {
       /* petAnimal ob=new petAnimal();  //default constructor
        ob.display();*/
        System.out.println("Constructor overloading");
        petAnimal a=new petAnimal("dog",10);  //constructor overloading
        petAnimal b=new petAnimal("dog",8,"barks");
        a.display();
        b.display();
        System.out.println("Constructor chaining");
        petAnimal c=new petAnimal("dog",10,"bark",50);
        petAnimal d=new petAnimal(a);
        System.out.println("Copy Constructor");
        d.display(); //copy constructor
    }
}
