public class Deposit extends Transaction{

    public Deposit(Account a, Double x, String s) {
        super (a, x, s);
    }

    @Override
    public void updateBalance() {
        account.deposit (amount);
    }

    public static void main(String[] args)
    {

    }
}
