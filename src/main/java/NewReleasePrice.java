public class NewReleasePrice extends Price {

    @Override
    public double amount(int daysRented) {
        return daysRented * 3;
    }

    @Override
    public int frequentRenterPoints(int daysRented) {
        if (daysRented > 1)
            return 2;
        return 1;
    }
}
