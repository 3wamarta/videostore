package videostore;

class RentalBuilder {
    private String title = "";
    private Price price;
    private int daysRented = 0;

    public static RentalBuilder aRental() {
        return new RentalBuilder();
    }


    public RentalBuilder ofMovie(String title) {
        this.title = title;
        return this;
    }

    public RentalBuilder withPrice(Price price) {
        this.price = price;
        return this;
    }

    public Rental build() {
        return new Rental(new Movie(title, price), daysRented);
    }

    public RentalBuilder forDays(int daysRented) {
        this.daysRented = daysRented;
        return this;
    }
}
