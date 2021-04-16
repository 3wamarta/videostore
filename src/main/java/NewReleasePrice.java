public class NewReleasePrice extends Price {
    public NewReleasePrice(int priceCode) {
        super(priceCode);
    }

    @Override
    public double amount(int daysRented) {
        return daysRented * 3;
    }
}
