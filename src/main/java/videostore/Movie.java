package videostore;

import videostore.Price;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;

    private Price price;

    public Movie(String title, Price price) {
        this.title = title;
        this.price = price;
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

}