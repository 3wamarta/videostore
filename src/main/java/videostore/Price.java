package videostore;

abstract class Price {

    public abstract double amount(int daysRented);

    public int frequentRenterPoints(int daysRented) {
        return 1;
    }
}
