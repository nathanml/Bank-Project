public class Withdrawal extends Transaction {

    public Withdrawal(Account a, Double x, String s) {
        super (a, x, s);
    }

    @Override
    public void updateBalance() {
        account.withdrawal (amount);
    }

    public static void main(String[] args)
    {

    }
}
