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
        double totalAmount = 0;
        int totalFrequentRenterPoints = 0;
        String result = "Rental Record for " + getName() + "\n";

        for (Rental rental : rentals) {
            totalFrequentRenterPoints += rental.frequentRenterPoints();

            double thisAmount = rental.amount();
            result += "\t" + rental.getMovie().getTitle() + "\t"
                    + thisAmount + "\n";
            totalAmount += thisAmount;
        }

        result += "You owed " + totalAmount + "\n";
        result += "You earned " + totalFrequentRenterPoints + " frequent renter points\n";

        return result;
    }


}