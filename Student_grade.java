import java.util.*;
public class Student_grade {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in); 
        System.out.println("Enter the number of subjects:");
        int n=sc.nextInt();
        int marks[]=new int[n];
        float total=0;
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter the marks obtained in subject "+(i+1)+"(out of 100):");
            marks[i]=sc.nextInt();
            while(marks[i]>100||marks[i]<0)
            {
                System.out.println("Invalid mark!");
                System.out.println("Please enter marks between 0 and 100 only:");
                marks[i]=sc.nextInt();
            }
            total+=marks[i];
        }
        float percentage=total/n;
        char grade[]=new char[n];
        for(int i=0;i<n;i++)
        {
            if(marks[i]<=100&&marks[i]>=90)
            {
                grade[i]='A';
            }
            else if(marks[i]<90&&marks[i]>=80)
            {
                grade[i]='B';
            }
            else if(marks[i]<80&&marks[i]>=70)
            {
                grade[i]='C';
            }
            else if(marks[i]<70&&marks[i]>=60)
            {
                grade[i]='D';
            }
            else
            {
                grade[i]='E';
            }
        }
        System.out.println("REPORT");
        System.out.println();
        System.out.println("SUBJECTS\tMARKS\tGRADE");
        for(int i=0;i<n;i++)
        {
            System.out.println("   "+(i+1)+"\t\t "+marks[i]+"\t  "+grade[i]);
        }
        System.out.println("Overall average percentage is: "+percentage);
    }
}
