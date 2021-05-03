package videostore;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private final String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        StatementBuilder statement = StatementBuilder.statementForUser(getName());

        rentals.stream().forEach(rental -> statement.addRental(rental));

        return statement
                .amount(calculateTotalAmount())
                .frequentRenterPoints(calculateFrequentRenterPoints())
                .build();
    }

    private Integer calculateFrequentRenterPoints() {
        return rentals.stream().map(Rental::frequentRenterPoints)
                .reduce(0, Integer::sum);
    }

    private Double calculateTotalAmount() {
        return rentals.stream().map(Rental::amount)
                .reduce(0.0, Double::sum);
    }

}
