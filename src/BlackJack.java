import java.util.*;

//Space complexity- O(n)
//Time Complexity- O(n^2)
interface Option
{
    void play(); //base condition for playing the game and adding the cards also takes place here
    boolean hit(); //to hit when the player chooses the option to hit the game
    void dstand(); //to hit by the dealer and leads to the end of the game
    void Stand(); //to stand, the end of the game
}
class Game implements Option{
    Scanner sc=new Scanner(System.in);
    static ArrayList <Integer> dealer=new ArrayList<Integer>(); //Arrayist that holds dealer cards
    static ArrayList <String> dealer_cardname=new ArrayList<String>(); //ArrayList that holds dealer card names
    static ArrayList <Integer> player=new ArrayList<Integer>(); //ArrayList that holds player cards
    static ArrayList <String> player_cardname=new ArrayList<String>(); //ArrayList that holds player card names

    static  ArrayList <String> cardname=new ArrayList<String>(); //ArrayList that holds cardnames
    static ArrayList<Integer> cards=new ArrayList<Integer>(); //ArrayList that holds the card values
    int pgamepoint; //to set the game point for the player
    int dgamepoint; //to set the game point for the dealer
    static int dtotal=0; //total of the cards that dealer holds
    static int ptotal=0; //total of the cards that player holds
    public void play() {
        System.out.println("Enter the game point:\n(Game point should be greater than or equal to 21)");
        pgamepoint=sc.nextInt(); //to get the game point from the user
        dgamepoint=pgamepoint-5; //decrementing the game point by 5 in order to set the hit limit for the dealer
        for (int i = 0; i < 4; i++) { //loop to add cards
            if(i==0) //Spade cards
            {
                int j = 1;
                while (j < 12) {
                    String k = "Spade " + j;
                    if(j==1)
                    {
                        cardname.add("Spade Ace");
                    }
                    else
                    if (j > 10) {
                        cardname.add("Spade King");
                        cardname.add("Spade Queen");
                        cardname.add("Space Jack");
                    } else {
                        cardname.add(k);
                    }
                    j++;
                }
            }
            else if(i==1) //Club cards
            {
                int j = 1;
                while (j < 12) {
                    String k = "Club " + j;
                    if(j==1)
                    {
                        cardname.add("Club Ace");
                    }
                    else
                    if (j > 10) {
                        cardname.add("Club King");
                        cardname.add("Club Queen");
                        cardname.add("Club Jack");
                    } else {
                        cardname.add(k);
                    }
                    j++;
                }
            }
            else if(i==2) //Heart cards
            {
                int j = 1;
                while (j < 12) {
                    String k = "Heart " + j;
                    if(j==1)
                    {
                        cardname.add("Heart Ace");
                    }
                    else
                    if (j > 10) {
                        cardname.add("Heart King");
                        cardname.add("Heart Queen");
                        cardname.add("Heart Jack");
                    } else {
                        cardname.add(k);
                    }
                    j++;
                }
            }
            else {  //Diamond cards
                int j = 1;
                while (j < 12) {
                    String k = "Diamond " + j;
                    if(j==1)
                    {
                        cardname.add("Diamond Ace");
                    }
                    else
                    if (j > 10) {
                        cardname.add("Diamond King");
                        cardname.add("Diamond Queen");
                        cardname.add("Diamond Jack");
                    } else {
                        cardname.add(k);
                    }
                    j++;
                }
            }
        }
        for (int i = 0; i < 4; i++) {  //Adding card values to the ArrayList
            int j = 1;
            while (j < 14) {
                if (j > 10) {
                    cards.add(10);
                } else {
                    cards.add(j);
                }
                j++;
            }
        }
        Random rand=new Random();
        if(dealer.size()==0)   //to pick 1st two random cards for the dealer
        {
            for(int i=0;i<2;i++)
            {
                int randind=rand.nextInt(cards.size());
                dealer.add(cards.get(randind));
                dealer_cardname.add(cardname.get(randind));
                cards.remove(randind);
                cardname.remove(randind);
            }
        }
        if(player.size() == 0)   //to pick 1st two random cards for the player
        {
            for(int i=0;i<2;i++)
            {
                int randind=rand.nextInt(cards.size());
                player.add(cards.get(randind));
                player_cardname.add(cardname.get(randind));
                cards.remove(randind);
                cardname.remove(randind);
            }
        }
        for(int i=1;i<dealer.size();i++)  //total of the dealer card with one card hidden
        {
            dtotal=dtotal+dealer.get(i);
        }
        for(int i=0;i< player.size();i++) //total of the cards that player holds
        {
            ptotal=ptotal+ player.get(i);
        }
        System.out.print("Your cards are:["); //to display the cards of the player
        for(int i=0;i<player.size();i++)
        {
            if(i==player.size()-1)
            {
                System.out.print(player_cardname.get(i)+"]");
            }
            else{

            System.out.print(player_cardname.get(i)+",");
            }
        }
        System.out.println();
        System.out.println("Your total is "+ptotal); //total of the player cards
        System.out.println("Dealer's one card is hidden and the total of other cards is "+dtotal); //total of the dealer cards with one card hidden
    }

    public boolean hit(){
        Random rand=new Random(); //to pick and add the card to the player
        int randind2=rand.nextInt(cards.size());
        player_cardname.add(cardname.get(randind2));
        player.add(cards.get(randind2));
        cardname.remove(randind2);
        cards.remove(randind2);
        ptotal=0;
        for(int i=0;i< player.size();i++)
        {
            ptotal=ptotal+ player.get(i); //total value of player cards
        }
        /*for(int i=1;i<dealer.size();i++)
        {
            dtotal=dtotal+dealer.get(i); //total value of dealer cards except one card
        }*/
        if(ptotal<=pgamepoint)
        {

            System.out.print("Your cards are: ["); //displaying players cards
            for(int i=0;i<player_cardname.size();i++)
            {
                if(i==player_cardname.size()-1)
                {
                    System.out.print(player_cardname.get(i)+"]");
                }
                else{

                    System.out.print(player_cardname.get(i)+",");
                }
            }
            System.out.println();
            System.out.println("Your total is "+ptotal); //total value of the player cards
            System.out.println("Dealer's one card is hidden and the total of other cards is "+dtotal);
            return true;
        }
        return false;
    }

    public void dstand()
    {
        int d1total=0;
        for (Integer i : dealer) { //total value of dealer cards
            d1total = d1total + i;
        }

        if(d1total>dgamepoint) //to set the game point for the dealer
        {
            Stand();
        }
        else {
            Random rand=new Random(); //adding one card to the dealer
            int randindex=rand.nextInt(cards.size());
            dealer.add(cards.get(randindex));
            dealer_cardname.add(cardname.get(randindex));
            cardname.remove(randindex);
            cards.remove(randindex);
            dstand();
        }

    }

    public void Stand() {
        int player_total=0;
        int dealer_total=0;

        for(int i=0;i<player.size();i++)
        {
            player_total=player_total+player.get(i);
        }
        for(int i=0;i<dealer.size();i++)
        {
            dealer_total=dealer_total+dealer.get(i);
        }

        System.out.print("Your cards are:[");
        for(int i=0;i< player_cardname.size();i++)
        {
            if(i==player_cardname.size()-1)
            {
                System.out.print(player_cardname.get(i)+"]");
            }
            else{
                System.out.print(player_cardname.get(i)+",");
            }
        }
        System.out.println();
        System.out.print("Dealer cards are:[");
        for(int i=0;i<dealer_cardname.size();i++)
        {
            if(i==dealer_cardname.size()-1)
            {
                System.out.print(dealer_cardname.get(i)+"]");
            }
            else{

                System.out.print(dealer_cardname.get(i)+",");
            }
        }
        System.out.println();
        if(dealer_total==player_total) {
            System.out.println("Your total is " + player_total + " & Dealer's total is " + dealer_total);
            System.out.println("Game tie!!! Dealer Won");
        }
        else if(player_total<=pgamepoint)
        {
            if(player_total>dealer_total)
            {
                System.out.println("Your total is "+player_total+" & Dealer's total is "+dealer_total);
                System.out.println("You Won");
            }
            else if(dealer_total<=pgamepoint)
            {
                System.out.println("Your total is "+player_total+" & Dealer's total is "+dealer_total);
                System.out.println("Dealer Won");
            }
            else {
                System.out.println("Your total is "+player_total+" & Dealer's total is "+dealer_total);
                System.out.println("You Won");
            }

        }
        else if(dealer_total<=pgamepoint)
        {
            System.out.println("Your total is "+player_total+" & Dealer's total is "+dealer_total);
            System.out.println("Dealer Won");
        }
        else {
            System.out.println("Draw!");
        }

    }
}


public class BlackJack {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to Black Jack");
        Game ob=new Game();
        ob.play();
        boolean flag=true; //to call the hit or stand repeatedly
        while(flag)
        {
            System.out.println("Do you want to Hit or Stand");
            System.out.println("1.Hit\n2.Stand");
            int a=sc.nextInt();
            switch (a) //to choose whether to hit or stand
            {
                case 1:
                {
                    if(!ob.hit())
                    {
                        ob.dstand(); //if the players total is above 21 calling the dealer's chance
                        flag=false;
                    }
                    break;
                }
                case 2:
                {
                    ob.dstand();//once the player hit calling the dealer's chance
                    flag=false;
                    break;
                }
            }
        }
    }
}
