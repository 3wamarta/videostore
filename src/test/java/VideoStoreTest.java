import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VideoStoreTest {

  @BeforeEach
  protected void setUp() {
    customer = new Customer("Fred");
  }

  @Test
  public void testSingleNewReleaseStatement() {
    String title = "The Cell";
    Price price = new NewReleasePrice();
    int daysRented = 3;
    customer.addRental(getRental(title, price, daysRented));
    assertEquals("Rental Record for Fred\n\tThe Cell\t9.0\nYou owed 9.0\nYou earned 2 frequent renter points\n", customer.statement());
  }

  private Rental getRental(String title, Price price, int daysRented) {
    return new Rental(new Movie(title, price), daysRented);
  }

  @Test
  public void testDualNewReleaseStatement() {
    customer.addRental(getRental("The Cell", new NewReleasePrice(), 3));
    customer.addRental(getRental("The Tigger Movie", new NewReleasePrice(), 3));
    assertEquals("Rental Record for Fred\n\tThe Cell\t9.0\n\tThe Tigger Movie\t9.0\nYou owed 18.0\nYou earned 4 frequent renter points\n", customer.statement());
  }

  @Test
  public void testSingleChildrensStatement() {
    customer.addRental(getRental("The Tigger Movie", new ChildrenPrice(), 3));
    assertEquals("Rental Record for Fred\n\tThe Tigger Movie\t1.5\nYou owed 1.5\nYou earned 1 frequent renter points\n", customer.statement());
  }
  //test multiple children's statement

  @Test
  public void testMultipleRegularStatement() {
    customer.addRental(getRental("Plan 9 from Outer Space", new RegularPrice(), 1));
    customer.addRental(getRental("8 1/2", new RegularPrice(), 2));
    customer.addRental(getRental("Eraserhead", new RegularPrice(), 3));

    assertEquals("Rental Record for Fred\n\tPlan 9 from Outer Space\t2.0\n\t8 1/2\t2.0\n\tEraserhead\t3.5\nYou owed 7.5\nYou earned 3 frequent renter points\n", customer.statement());
  }

  private Customer customer;
}