package compte2;

class WithdrawMoney extends Thread
{Compte c;
	public WithdrawMoney (Compte c)
	{
		this.c=c;
	}
    public void run()
    {
        c.withdraw (100,this.getName());
        System.out.println (this.getName()+"Il reste " + c.getBalance() + " euros sur le compte");
    }
}
