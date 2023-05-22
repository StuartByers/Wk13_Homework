class GiftCard implements IChargeable {
    private double balance;

    public GiftCard(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public void charge(double amount) {
        balance -= amount;
    }
}