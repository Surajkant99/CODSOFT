import java.util.*;
public class No_game {
    public static void main(String[] args) {
        int count,guess,random,score;
        String a="Y";//for 1st game
        Scanner sc=new Scanner(System.in);
        Random r=new Random();
        while(a.equalsIgnoreCase("Y"))//for new game if user presses Y
        {
            count=1;
            score=10;
            random=r.nextInt(100);//random no. generation
            System.out.println("You have total 7 chances to guess the number");
            //System.out.println(random);
            do//5 chances to guess
            {
                System.out.println((7-count+1)+" more chances left");
                System.out.println("Guess the nunber(between 0 and 100) :");
                guess=sc.nextInt();//user input
                if(guess<random)
                {
                    System.out.println("You should think of some greater number");
                }
                else if(guess>random)
                {
                    System.out.println("You should think of some smaller number");
                }
                else
                {
                    System.out.println("You guessed it in "+count+" attempts");
                    System.out.println("Your score is "+score+" out of 10");
                }
                count++;
                score--;
            }while(count!=8&&guess!=random);
            if(count >=8)//if user can't guess
            {
                System.out.println("Your score is 0");
                System.out.println("The number was "+random);
            }
            System.out.println("Do you want to play again (Press Y for Yes/N for No)");
            String s=sc.next();
            a=s;
            if(s.equalsIgnoreCase("N"))//if user press N, exit
            {
                System.exit(0);
            }
            for(int i=0;i<2;i++)//for limiting the input attempts of Y/N(if user press anything else other than Y or N)
            {
                if(!(s.equalsIgnoreCase("Y")||s.equalsIgnoreCase("N")))
                {
                    System.out.println("Please reply by pressing Y or N only, "+(3-(i+1))+" chances more left");
                    s=sc.next();
                    a=s;
                }
            }
        }
        System.out.println("You exceeded limit");
    }
}
