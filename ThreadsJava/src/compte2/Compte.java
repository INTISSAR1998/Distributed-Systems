package compte2;

public class Compte
{
    private int balance = 200;
 
    public int getBalance()
    {
        return balance;
    }
 
    public void withdraw (int amount, String name)
    {
        if (amount <= balance)
        {
            balance -= amount;
            System.out.println ("Compte débité de " + amount + " euros  par"+name);
        }
    }
    /*public static void main ( String [] args)
    {
        // Le compte bancaire partagé
        Compte account = new Compte();
     
        // Alice veut retirer 200 euros
        account.withdraw (200);
        System.out.println ("Il reste " + account.getBalance() + " euros sur le compte");
     
        // Bob veut retirer 200 euros
        account.withdraw (200);
        System.out.println ("Il reste " + account.getBalance() + " euros sur le compte");
    }*/
    public static void main (String[] args)
    {
        // Le compte bancaire partagé
         final Compte account = new Compte();
        // Alice et Bob veulent retirer 200 euros
         WithdrawMoney alice=new WithdrawMoney(account);
        alice.setName("Alice");
        WithdrawMoney bob=new WithdrawMoney(account);
        bob.setName("Bob");
        alice.start();bob.start();
    }
}
