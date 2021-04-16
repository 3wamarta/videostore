public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private int priceCode;
    private Price price;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
        this.price = new Price(priceCode);
    }

    public Movie(String title, Price price) {
        this.title = title;
        this.price = price;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public String getTitle() {
        return title;
    }

    public Price getPrice() {
        return price;
    }

    double amount(int daysRented) {
        return getPrice().amount(daysRented);
    }

    public int frequentRenterPoints(int daysRented) {
        return getPrice().frequentRenterPoints(daysRented);
    }

    private class Price {
        private final int priceCode;

        public Price(int priceCode) {
            this.priceCode = priceCode;
        }

        public int getPriceCode() {
            return priceCode;
        }

        private double amount(int daysRented) {
            double thisAmount = 0;
            switch (getPriceCode()) {
                case REGULAR:
                    thisAmount += 2;
                    if (daysRented > 2)
                        thisAmount += (daysRented - 2) * 1.5;
                    break;
                case NEW_RELEASE:
                    thisAmount += daysRented * 3;
                    break;
                case CHILDRENS:
                    thisAmount += 1.5;
                    if (daysRented > 3)
                        thisAmount += (daysRented - 3) * 1.5;
                    break;
            }
            return thisAmount;
        }

        private int frequentRenterPoints(int daysRented) {
            if (getPriceCode() == NEW_RELEASE
                    && daysRented > 1)
                return 2;
            return 1;
        }
    }
}