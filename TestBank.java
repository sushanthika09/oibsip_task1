package bank;

import java.util.Scanner;
public class TestBank {

    public static void main(String[] args) {
        Atm b1 = new Atm(5);
        Scanner input = new Scanner(System.in);
        boolean stop=true;

        do {
            System.out.println("******************************");
            System.out.println("* 1- Add Client.              *");
            System.out.println("* 2- Close a client account.  *");
            System.out.println("* 3- Deposit.                 *");
            System.out.println("* 4- Withdraw.                *");
            System.out.println("* 5- Transfer.                *");
            System.out.println("* 6- Display balance.         *");
            System.out.println("* 7- Exit.                     *");
            System.out.println("******************************");
            System.out.print("=> ");
            int x = input.nextInt();


            if (x == 1) {
                System.out.print("Enter name and balance:");
                String name = input.next();
                double balance = input.nextDouble();
                if (b1.addClient(name, balance)) {
                    System.out.println("DONE");
                } else
                    System.out.println("ERROR");

            }
            if (x == 2) {
                System.out.print("Enter name:");
                String name = input.next();
                if (b1.deleteClient(name)) {
                    System.out.println("DONE");
                } else
                    System.out.println("ERROR");

            }
            if (x == 3) {
                System.out.print("Enter name and amount:");
                String name = input.next();
                double balance = input.nextDouble();
                if (b1.deposit(name, balance))
                    System.out.println("DONE");
            else
                System.out.println("ERROR");
        }
            if(x==4){
                System.out.print("Enter name and amount:");
                String name = input.next();
                double balance = input.nextDouble();
                if (b1.withdraw(name, balance))
                    System.out.println("DONE");
                else
                    System.out.println("ERROR");


            }
            if (x==5) {
                System.out.print("Enter from name, to name, and amount:");
                String name = input.next();
                String name2 = input.next();
                double balance = input.nextDouble();
                if (b1.transfer(name, name2, balance))
                    System.out.println("DONE");
                else
                    System.out.println("ERROR");


            }if (x==6){
                System.out.print("Enter name:");
                String name = input.next();
                b1.display(name);

            
            }
            if (x==7){
                stop=false;
                System.out.print("GoodBye :)");
            }

        }while (stop);
    }

}