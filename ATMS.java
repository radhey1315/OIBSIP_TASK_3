
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

class user {

    public int balance = 0;
    Scanner input = new Scanner(System.in);
    ArrayList<String> entery = new ArrayList<>();

    public void TransactionsHistory() {

        if (entery.size() > 0) {
            for (int i = 0; i < entery.size(); i++) {
                System.out.println(entery.get(i));
            }
        } else {
            System.out.println("*** HERE NO ANY TRANSACTION ***");
        }

    }

    public void withdraw() {
        System.out.println("Enter withdraw rupee : ");
        int money1 = input.nextInt();

        if (money1 < balance) {
            balance = balance - money1;
            System.out.println("withdraw sucessful : " + money1 + " rupee");
            entery.add("withdraw : " + money1);
        } else {
            System.out.println("***worning***\n This amount is higher then your bank balance ");
        }

    }

    public void deposite() {
        System.out.println("Enter deposite rupee : ");
        int money = input.nextInt();
        balance = balance + money;
        System.out.println("you are deposite : " + money + " rupee");
        entery.add("deposite : " + money);
    }

    public void display() {
        System.out.println("your final balance is : " + balance + " rupee");
    }

    public int[] transfer(ArrayList<String> userid) {

        int s = 0;
        int a[] = new int[2];

        System.out.println("enter transfer money : ");
        int money2 = input.nextInt();

        System.out.println("enter reciver id : ");
        String reciver = input.next();

        if (money2 < balance) {

            balance = balance - money2;
            System.out.println("Sucessfully transfer " + money2 + " rupee");
            entery.add("transfer money : " + money2 + " rupee" + "\t reciver id is " + reciver);

            for (int i = 0; i < userid.size(); i++) {

                if ((userid.get(i)).equals(reciver)) {
                    s = i;
                    break;
                }
            }
            a[0] = s;
            a[1] = money2;

            return a;
        } else {
            System.out.println("***waring***\n\tyour money is less then your account balance ");
        }

        for (int i = 0; i < userid.size(); i++) {

            if ((userid.get(i)).equals(reciver)) {
                s = i;
                break;
            }
        }
        a[0] = s;
        a[1] = 0;

        return a;
    }

}

public class ATMS {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ArrayList<String> userid = new ArrayList<>();
        userid.add("x");
        userid.add("y");
        userid.add("z");

        ArrayList<String> userpin = new ArrayList<>();
        userpin.add("1111");
        userpin.add("2222");
        userpin.add("3333");

        user[] account_holder = new user[3];
        account_holder[0] = new user();
        account_holder[1] = new user();
        account_holder[2] = new user();
        boolean t = true;
        while (t = true) {

            A:
            {
                Scanner input1 = new Scanner(System.in);

                System.out.println("Enter your user id : ");
                String userid_input = input1.nextLine();

                System.out.println("Enter your pin : ");
                String userpin_input = input1.nextLine();

                boolean p = false;

                for (int i = 0; i < userid.size(); i++) {
                    if (userid.get(i).equals(userid_input) && userpin.get(i).equals(userpin_input)) {

                        System.out.println("logging sucessful");
                        p = true;

                        do {
                            System.out.println("\n1. Transactions History");
                            System.out.println("2. Withdraw");
                            System.out.println("3. Deposit");
                            System.out.println("4. Transfer");
                            System.out.println("5. display");
                            System.out.println("6. Quit");
                            System.out.println("7. account change");
                            int num = input.nextInt();

                            switch (num) {
                                case 1: {
                                    account_holder[i].TransactionsHistory();
                                    break;
                                }
                                case 2: {
                                    account_holder[i].withdraw();
                                    break;
                                }
                                case 3: {
                                    account_holder[i].deposite();
                                    break;
                                }
                                case 4: {
                                    int a[] = account_holder[i].transfer(userid);
                                    account_holder[a[0]].balance = account_holder[a[0]].balance + a[1];
                                    break;
                                }
                                case 5: {
                                    account_holder[i].display();
                                    break;

                                }
                                case 6: {

                                    break;

                                }
                                case 7: {
                                    break A;
                                }
                                default: {
                                    System.out.println("*** Enter only 1 to 7 ***");
                                }
                            }
                            if (num == 6) {
                                break;
                            }

                        } while (p = true);
                    }
                }
                if (!p) {
                    System.out.println("logging failed");

                }
                System.out.println("1.  you want to switch account : ");
                System.out.println("2. exit ");
                int num = input.nextInt();

                switch (num) {
                    case 1: {
                        continue;
                    }
                    case 2: {
                        break;
                    }
                    default: {
                        System.out.println("*** Enter only 1 or 2 ***");
                    }
                }
                break;
            }

        }
    }

}
