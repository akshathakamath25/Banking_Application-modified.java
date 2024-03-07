package bankingapplication;
import java.util.Scanner;
class Fd{
    public void invest(){

        {
            int Count = 0;
            double Rate = 0;
            double Total = 0;


            Scanner sc = new Scanner(System.in);

            System.out.println("How much money do you want to invest?");
            int Invest = sc.nextInt();

            System.out.println("How many years will your term be?");
            int Term = sc.nextInt();

            System.out.println("Investing: " + Invest);
            System.out.println(" Term: " + Term);
               if (Term <= 1)
            {
            Rate = .3;
            }

            else if (Term <= 2)
            {
            Rate = .45;
            }

            else if (Term <= 3)
            {
            Rate = .95;
            }
   int count = 1;
                    while(count <= 3)
                {

                    Total = Invest + (Invest * (Rate) / (100.0));

                    System.out.println("Value after year " + count + ": " + Total);
                    count++;
                }
        }
        
}
}
