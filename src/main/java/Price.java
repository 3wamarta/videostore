abstract class Price {
    private final int priceCode;

    public Price(int priceCode) {
        this.priceCode = priceCode;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public abstract double amount(int daysRented);

    public int frequentRenterPoints(int daysRented) {
        if (getPriceCode() == Movie.NEW_RELEASE
                && daysRented > 1)
            return 2;
        return 1;
    }
}
