package videostore;

import java.util.StringJoiner;

class StatementBuilder {
    public static final String TAB = "\t";
    private static final String NEW_LINE = "\n";

    private final String userName;
    private double amount;
    private int frequentRenterPoints;
    private StringJoiner rentals = new StringJoiner(NEW_LINE);

    private StatementBuilder(String name) {
        this.userName = name;
    }

    public static StatementBuilder statementForUser(String name) {
        return new StatementBuilder(name);
    }

    public StatementBuilder amount(double amount) {
        this.amount = amount;
        return this;
    }

    public StatementBuilder frequentRenterPoints(int frequentRenterPoints) {
        this.frequentRenterPoints = frequentRenterPoints;
        return this;
    }

    public StatementBuilder addRental(Rental rental) {
        rentals.add(TAB + rental.getMovie().getTitle() + TAB + rental.amount());
        return this;
    }

    public String build() {
        return "Rental Record for " + userName + NEW_LINE +
                rentals.toString() + NEW_LINE +
                "You owed " + amount + NEW_LINE +
                "You earned " + frequentRenterPoints + " frequent renter points" + NEW_LINE;
    }
}
