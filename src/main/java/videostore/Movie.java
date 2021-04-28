package videostore;

public class Movie {

    private String title;

    private Price price;

    public Movie(String title, Price price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    double amount(int daysRented) {
        return price.amount(daysRented);
    }

    public int frequentRenterPoints(int daysRented) {
        return price.frequentRenterPoints(daysRented);
    }

}