import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

import javax.accessibility.AccessibleTableModelChange;
public class Atm {
    static int amt1;
    static String pin;
    public static void main(String[] args) {
        try
        {
            Scanner sc=new Scanner(System.in);
            File file=new File("acc.txt");
            File file1=new File("pin.txt");
            Scanner reader=new Scanner(file);
            Scanner reader1=new Scanner(file1);
            System.out.println("WELCOME\n");
            System.out.println("1.CREATE ACCOUNT(SET PIN)\n2.LOGIN\n3.CHANGE PIN/MODIFY BALANCE");
            int ch=sc.nextInt();
            if(ch>3)
            {
                System.out.println("Invalid choice");
                System.exit(0);
            }
            if(ch==1&&file1.length()!=0)
            {
                System.out.println("Account already exists");
                System.exit(0);
            }
            if(((file.length()!=0)&&(file1.length()!=0))&&ch!=1)
            {
                String rs=reader.nextLine();
                amt1=Integer.parseInt(rs);
                pin=reader1.nextLine();
            }
            FileWriter fw=new FileWriter(file);
            FileWriter fw1=new FileWriter(file1);
            if(ch!=1)
            {
                fw.write(Integer.toString(amt1));
                fw.close();
                fw1.write(pin);
                fw1.close();
            }
            User u=new User();
            if(ch==1)
            {
                System.out.println("Set the pin(4-digit):");
                pin=sc.next();
                fw1.write(pin);
                fw1.close();
                System.out.println("First deposit some amount to proceed further");
                System.out.println("Enter the amount to deposit:");
                amt1=sc.nextInt();
            }
            if(ch==2||ch==1)
            {
                System.out.println("Enter the pin(4-digit):");
                String pincheck=sc.next();
                if(pin.equals(pincheck))
                {
                    System.out.println("1.WITHDRAW\n2.DEPOSIT\n3.CHECK BALANCE\n4.EXIT");
                    System.out.println("Enter your choice:");
                    int choice=sc.nextInt();
                    switch(choice)
                    {
                        case 1 :
                            System.out.println("Enter the amount you want to withdraw:");
                            int wamt=sc.nextInt();
                            withdraw(wamt);
                            fw=new FileWriter(file);
                            fw.write(Integer.toString(amt1));
                            fw.close();
                            break;
                        case 2 :
                            System.out.println("Enter the amount you want to deposit:");
                            int damt=sc.nextInt();
                            deposit(damt);
                            fw=new FileWriter(file);
                            fw.write(Integer.toString(amt1));
                            fw.close();
                            break;
                        case 3 :
                            balance();
                            fw=new FileWriter(file);
                            fw.write(Integer.toString(amt1));
                            fw.close();
                            break;
                        case 4 :
                            fw=new FileWriter(file);
                            fw.write(Integer.toString(amt1));
                            fw.close();
                            System.exit(0);
                        default :
                            System.out.println("Invalid choice");
                            fw=new FileWriter(file);
                            fw.write(Integer.toString(amt1));
                            fw.close();
                            System.exit(0);
                    }
                }
                else
                {
                    System.out.println("INCORRECT PIN !!!");
                }
            }
            if(ch==3)
            {
                u.useraccount();
                if(u.ch1==1)
                {
                    fw1=new FileWriter(file1);
                    fw1.write(pin);
                    fw1.close();
                }
                else if(u.ch1==2)
                {
                    fw=new FileWriter(file);
                    fw.write(Integer.toString(amt1));
                    fw.close();
                    balance();
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Please create account first");
        }
    }
    static void withdraw(int wamt)
    {
        amt1=amt1-wamt;
        balance();
    }
    static void deposit(int damt)
    {
        amt1=amt1+damt;
        balance();
    }
    static void balance()
    {
        System.out.println("Your account balance is "+amt1);
    }
}
class User
{
    int ch1;
    Atm a=new Atm();
    String pin2=a.pin;
    Scanner sc=new Scanner(System.in);
    int amt=a.amt1;
    void useraccount()
    {
        System.out.println("1.CHANGE PIN\n2.MODIFY ACCOUNT BALANCE");
        ch1=sc.nextInt();
        switch(ch1)
        {
            case 1 :
                {
                    System.out.println("Set new pin(4-digit):");
                    pin2=sc.next();
                    a.pin=pin2;
                    System.out.println("Your pin is changed successfully");
                    break;
                }
            case 2 :
                {
                    System.out.println("Enter the new account balance:");
                    amt=sc.nextInt();
                    a.amt1=amt;
                    System.out.println("Your account balance is modified successfully");
                    break;
                }
            default :
                System.out.println("Please enter valid choice");
                break;
        }
    }
}
