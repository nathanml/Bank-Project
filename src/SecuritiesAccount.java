public class SecuritiesAccount extends Account {

    public SecuritiesAccount(String name, double balance, Currency c) {
        super (name, balance, c);
    }

    public static void main(String[] args)
    {

    }
    public String print()
    {
        return "Account Name: " + name + ", Account Balance: " + balance + ", Account type: Securities Account";
    }
}
