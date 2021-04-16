public class Rental {

    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double amount() {
        return movie.amount(getDaysRented());
    }

    public int frequentRenterPoints() {
        int daysRented = getDaysRented();
        Movie movie = getMovie();
        int frequentRenterPoints = movie.frequentRenterPoints(daysRented);
        return frequentRenterPoints;
    }

}