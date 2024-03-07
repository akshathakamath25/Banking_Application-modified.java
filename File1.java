package bankingapplication;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;
public class File1 {
    public static void main(String[]args)throws IOException{
        File f1=new File("Bankdetails.txt");
        Scanner sc1=new Scanner(f1);
        String s1=sc1.nextLine();
        System.out.println(s1);     
     
    }
    }
