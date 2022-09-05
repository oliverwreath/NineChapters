package com.util;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Ordering;
import com.google.common.collect.Range;
import com.google.common.primitives.Ints;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Created by Yanliang Han on 2016/5/29.
 */
@Slf4j
public class GuavaTest {
  @Test void testRange() {
    //create a range [a,b] = { x | a <= x <= b}
    Range<Integer> range1 = Range.closed(0, 9);
    log.debug(String.valueOf(range1));
    Assertions.assertTrue(range1.contains(5));
    Assertions.assertTrue(range1.containsAll(Ints.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)));
    Assertions.assertEquals(0, range1.lowerEndpoint());
    Assertions.assertEquals(9, range1.upperEndpoint());

    //create a range (a,b) = { x | a < x < b}
    Range<Integer> range2 = Range.open(0, 9);
    log.debug(String.valueOf(range2));
    Assertions.assertTrue(range2.containsAll(Ints.asList(1, 2, 3, 4, 5, 6, 7, 8)));
    Assertions.assertEquals(0, range2.lowerEndpoint());
    Assertions.assertEquals(9, range2.upperEndpoint());

    //create a range (a,b] = { x | a < x <= b}
    Range<Integer> range3 = Range.openClosed(0, 9);
    log.debug(String.valueOf(range3));
    Assertions.assertTrue(range3.containsAll(Ints.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)));
    Assertions.assertEquals(0, range3.lowerEndpoint());
    Assertions.assertEquals(9, range3.upperEndpoint());

    //create a range [a,b) = { x | a <= x < b}
    Range<Integer> range4 = Range.closedOpen(0, 9);
    log.debug(String.valueOf(range4));
    Assertions.assertTrue(range4.containsAll(Ints.asList(0, 1, 2, 3, 4, 5, 6, 7, 8)));
    Assertions.assertEquals(0, range4.lowerEndpoint());
    Assertions.assertEquals(9, range4.upperEndpoint());

    //create an open ended range (9, infinity)
    Range<Integer> range5 = Range.greaterThan(9);
    log.debug(String.valueOf(range5));
    Assertions.assertFalse(range5.contains(9));
    Assertions.assertTrue(range5.containsAll(Ints.asList(10, 11, 12, 13, 14, 15, 16, 17, 18, 19)));
    Assertions.assertTrue(range5.hasLowerBound());
    Assertions.assertEquals(9, range5.lowerEndpoint());
    Assertions.assertFalse(range5.hasUpperBound());

    Range<Integer> range6 = Range.closed(3, 5);
    log.debug(String.valueOf(range6));
    Assertions.assertTrue(range6.containsAll(Ints.asList(3, 4, 5)));
    Assertions.assertEquals(3, range6.lowerEndpoint());
    Assertions.assertEquals(5, range6.upperEndpoint());

    //check a subrange [3,5] in [0,9]
    Assertions.assertTrue(range1.encloses(range6));

    Range<Integer> range7 = Range.closed(9, 20);
    log.debug(String.valueOf(range7));

    //check ranges to be connected
    Assertions.assertTrue(range1.isConnected(range7));

    Range<Integer> range8 = Range.closed(5, 15);
    log.debug(String.valueOf(range8));

    //intersection
    log.debug(String.valueOf(range1.intersection(range8)));

    //span
    log.debug(String.valueOf(range1.span(range8)));
  }

  @Test void testObjects() {
    Student s1 = new Student("Mahesh", "Parashar", 1, "VI");
    Student s2 = new Student("Suresh", null, 3, null);

    Assertions.assertNotEquals(s1, s2);
    log.debug(String.valueOf(s1.hashCode()));
    log.debug(
            MoreObjects.toStringHelper(s1)
                    .add("Name", s1.getFirstName() + " " + s1.getLastName())
                    .add("Class", s1.getClassName())
                    .add("Roll No", s1.getRollNo())
                    .toString());
    log.debug(String.valueOf(s1));
  }

  @Test void testOptional() {
    Integer value1 = null;
    Integer value2 = 10;

    //Optional.fromNullable - allows passed parameter to be null.
    Optional<Integer> a = Optional.ofNullable(value1);
    //Optional.of - throws NullPointerException if passed parameter is null
    Optional<Integer> b = Optional.of(value2);
    //Optional.isPresent - checks the value is present or not
    Assertions.assertTrue(a.isEmpty());
    Assertions.assertTrue(b.isPresent());

    //Optional.or - returns the value if present otherwise returns
    //the default value passed.
    value1 = a.orElse(0);
    //Optional.get - gets the value, value should be present
    value2 = b.get();

    Assertions.assertEquals(10, value1 + value2);
  }

  @Test void testPreconditions() {
    try {
      log.debug(String.valueOf(sqrt(-3.0)));
    } catch (IllegalArgumentException e) {
      Assertions.assertEquals("Illegal Argument passed: Negative value -3.0.", e.getMessage());
    }

    try {
      log.debug(String.valueOf(sum(null, 3)));
    } catch (NullPointerException e) {
      Assertions.assertEquals("Illegal Argument passed: First parameter is Null.", e.getMessage());
    }

    try {
      log.debug(String.valueOf(getValue(6)));
    } catch (IndexOutOfBoundsException e) {
      Assertions.assertEquals("Illegal Argument passed: Invalid index. (6) must be less than size (5)", e.getMessage());
    }
  }

  public static double sqrt(double input) throws IllegalArgumentException {
    Preconditions.checkArgument(input > 0.0,
            "Illegal Argument passed: Negative value %s.", input);
    return Math.sqrt(input);
  }

  public static int sum(Integer a, Integer b) {
    Preconditions.checkNotNull(a, "Illegal Argument passed: First parameter is Null.");
    Preconditions.checkNotNull(b, "Illegal Argument passed: Second parameter is Null.");
    return a + b;
  }

  public static int getValue(int input) {
    int[] data = {1, 2, 3, 4, 5};
    Preconditions.checkElementIndex(input, data.length, "Illegal Argument passed: Invalid index.");

    return 0;
  }

  @Test void testOrdering() {
    List<Integer> numbers = new ArrayList<>();
    numbers.add(5);
    numbers.add(2);
    numbers.add(15);
    numbers.add(51);
    numbers.add(53);
    numbers.add(35);
    numbers.add(45);
    numbers.add(32);
    numbers.add(43);
    numbers.add(16);
    Ordering<Integer> natural = Ordering.natural();

    log.debug("Input List: ");
    log.debug(String.valueOf(numbers));

    Collections.sort(numbers, natural);
    log.debug("Sorted List: ");
    log.debug(String.valueOf(numbers));

    log.debug("======================");
    log.debug("List is sorted: " + natural.isOrdered(numbers));
    log.debug("Minimum: " + natural.min(numbers));
    log.debug("Maximum: " + natural.max(numbers));

    Collections.sort(numbers, natural.reverse());
    log.debug("Reverse: " + numbers);

    numbers.add(null);
    log.debug("Null added to Sorted List: ");
    log.debug(String.valueOf(numbers));

    Collections.sort(numbers, natural.nullsFirst());
    log.debug("Null first Sorted List: ");
    log.debug(String.valueOf(numbers));
    log.debug("======================");

    List<String> names = new ArrayList<>();

    names.add("Ram");
    names.add("Shyam");
    names.add("Mohan");
    names.add("Sohan");
    names.add("Ramesh");
    names.add("Suresh");
    names.add("Naresh");
    names.add("Mahesh");
    names.add(null);
    names.add("Vikas");
    names.add("Deepak");

    log.debug("Another List: ");
    log.debug(String.valueOf(names));

    Ordering<String> naturalString = Ordering.natural();
    Collections.sort(names, naturalString.nullsFirst().reverse());
    log.debug("Null first then reverse sorted list: ");
    log.debug(String.valueOf(names));
  }

  @Data
  private static class Student {
    private String firstName;
    private String lastName;
    private int rollNo;
    private String className;

    public Student(String firstName, String lastName, int rollNo, String className) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.rollNo = rollNo;
      this.className = className;
    }

    @Override
    public boolean equals(Object object) {
      if (!(object instanceof Student) || object == null) {
        return false;
      }
      Student student = (Student) object;
      // no need to handle null here
      // Objects.equal("com.lintCode.test", "com.lintCode.test") == true
      // Objects.equal("com.lintCode.test", null) == false
      // Objects.equal(null, "com.lintCode.test") == false
      // Objects.equal(null, null) == true
      return Objects.equal(firstName, student.firstName) // first name can be null
              && Objects.equal(lastName, student.lastName) // last name can be null
              && Objects.equal(rollNo, student.rollNo)
              && Objects.equal(className, student.className);// class name can be null
    }

    @Override
    public int hashCode() {
      //no need to compute hashCode by self
      return Objects.hashCode(className, rollNo);
    }

    @Override
    public String toString() {
      return new StringJoiner(", ", Student.class.getSimpleName() + "[", "]")
              .add("firstName='" + firstName + "'")
              .add("lastName='" + lastName + "'")
              .add("rollNo=" + rollNo)
              .add("className='" + className + "'")
              .toString();
    }
  }
}
