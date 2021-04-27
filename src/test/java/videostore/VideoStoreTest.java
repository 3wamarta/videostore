package videostore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static videostore.RentalBuilder.aRental;

public class VideoStoreTest {

    private static final ChildrenPrice CHILDREN_PRICE = new ChildrenPrice();
    private static final NewReleasePrice NEW_RELEASE_PRICE = new NewReleasePrice();
    private static final RegularPrice REGULAR_PRICE = new RegularPrice();
    private Customer customer;

    @BeforeEach
    protected void setUp() {
        customer = new Customer("Fred");
    }

    @Test
    public void testSingleNewReleaseStatement() {
        customer.addRental(aRental()
                .ofMovie("The Cell")
                .withPrice(NEW_RELEASE_PRICE)
                .forDays(3).build());
        assertEquals("Rental Record for Fred\n\tThe Cell\t9.0\nYou owed 9.0\nYou earned 2 frequent renter points\n", customer.statement());
    }


    @Test
    public void testDualNewReleaseStatement() {
        customer.addRental(aRental()
                .ofMovie("The Cell")
                .withPrice(NEW_RELEASE_PRICE)
                .forDays(3).build());
        customer.addRental(aRental()
                .ofMovie("The Tigger videostore.Movie")
                .withPrice(NEW_RELEASE_PRICE)
                .forDays(3).build());
        assertEquals("Rental Record for Fred\n\tThe Cell\t9.0\n\tThe Tigger videostore.Movie\t9.0\nYou owed 18.0\nYou earned 4 frequent renter points\n", customer.statement());
    }

    @Test
    public void testSingleChildrensStatement() {
        customer.addRental(aRental()
                .ofMovie("The Tigger videostore.Movie")
                .withPrice(CHILDREN_PRICE)
                .forDays(3).build());
        assertEquals("Rental Record for Fred\n\tThe Tigger videostore.Movie\t1.5\nYou owed 1.5\nYou earned 1 frequent renter points\n", customer.statement());
    }
    //test multiple children's statement

    @Test
    public void testMultipleRegularStatement() {
        customer.addRental(aRental()
                .ofMovie("Plan 9 from Outer Space")
                .withPrice(REGULAR_PRICE)
                .forDays(1).build());
        customer.addRental(aRental()
                .ofMovie("8 1/2")
                .withPrice(REGULAR_PRICE)
                .forDays(2).build());
        customer.addRental(aRental()
                .ofMovie("Eraserhead")
                .withPrice(REGULAR_PRICE)
                .forDays(3).build());

        assertEquals("Rental Record for Fred\n\tPlan 9 from Outer Space\t2.0\n\t8 1/2\t2.0\n\tEraserhead\t3.5\nYou owed 7.5\nYou earned 3 frequent renter points\n", customer.statement());
    }

    private Rental getRental(String title, Price price, int daysRented) {
        return aRental()
                .ofMovie(title)
                .withPrice(price)
                .forDays(daysRented).build();
    }

}
