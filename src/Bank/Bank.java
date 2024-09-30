package Bank;

public class Bank {

    int balance;


    public synchronized void increaceBalance() {
        this.balance += 1;
    }

    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                bank.increaceBalance();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final balance: " + bank.balance );
    }

}




