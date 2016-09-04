package com.lintCode.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Ordering;
import com.google.common.collect.Range;
import com.google.common.primitives.Ints;

/**
 * Created by Yanliang Han on 2016/5/29.
 */
public class GuavaTester {
    public static void main(String args[]) {
        testRange();
//        testObjects();
//        testOptional();
//        testPreconditions();
//        testOrdering();
    }

    private static void testRange() {
        //create a range [a,b] = { x | a <= x <= b}
        Range<Integer> range1 = Range.closed(0, 9);
        System.out.print("[0,9] : ");
        printRange(range1);

        System.out.println("5 is present: " + range1.contains(5));
        System.out.println("(1,2,3) is present: " + range1.containsAll(Ints.asList(1, 2, 3)));
        System.out.println("Lower Bound: " + range1.lowerEndpoint());
        System.out.println("Upper Bound: " + range1.upperEndpoint());

        //create a range (a,b) = { x | a < x < b}
        Range<Integer> range2 = Range.open(0, 9);
        System.out.print("(0,9) : ");
        printRange(range2);

        //create a range (a,b] = { x | a < x <= b}
        Range<Integer> range3 = Range.openClosed(0, 9);
        System.out.print("(0,9] : ");
        printRange(range3);

        //create a range [a,b) = { x | a <= x < b}
        Range<Integer> range4 = Range.closedOpen(0, 9);
        System.out.print("[0,9) : ");
        printRange(range4);

        //create an open ended range (9, infinity
        Range<Integer> range5 = Range.greaterThan(9);
        System.out.println("(9,infinity) : ");
        System.out.println("Lower Bound: " + range5.lowerEndpoint());
        System.out.println("Upper Bound present: " + range5.hasUpperBound());

        Range<Integer> range6 = Range.closed(3, 5);
        printRange(range6);

        //check a subrange [3,5] in [0,9]
        System.out.println("[0,9] encloses [3,5]:" + range1.encloses(range6));

        Range<Integer> range7 = Range.closed(9, 20);
        printRange(range7);

        //check ranges to be connected
        System.out.println("[0,9] is connected [9,20]:" + range1.isConnected(range7));

        Range<Integer> range8 = Range.closed(5, 15);

        //intersection
        printRange(range1.intersection(range8));

        //span
        printRange(range1.span(range8));
    }

    private static void printRange(Range<Integer> range) {

        System.out.print("[ ");

        for (int grade : ContiguousSet.create(range, DiscreteDomain.integers())) {
            System.out.print(grade + " ");
        }
        System.out.println("]");
    }

    public static void testObjects() {
        Student s1 = new Student("Mahesh", "Parashar", 1, "VI");
        Student s2 = new Student("Suresh", null, 3, null);

        System.out.println(s1.equals(s2));
        System.out.println(s1.hashCode());
        System.out.println(
                Objects.toStringHelper(s1)
                        .add("Name", s1.getFirstName() + " " + s1.getLastName())
                        .add("Class", s1.getClassName())
                        .add("Roll No", s1.getRollNo())
                        .toString());
    }

    public static void testOptional() {
        Integer value1 = null;
        Integer value2 = new Integer(10);

        //Optional.fromNullable - allows passed parameter to be null.
        Optional<Integer> a = Optional.fromNullable(value1);

        //Optional.of - throws NullPointerException if passed parameter is null
        Optional<Integer> b = Optional.of(value2);

        System.out.println(sum(a, b));
    }

    public static Integer sum(Optional<Integer> a, Optional<Integer> b) {
        //Optional.isPresent - checks the value is present or not
        System.out.println("First parameter is present: " + a.isPresent());

        System.out.println("Second parameter is present: " + b.isPresent());

        //Optional.or - returns the value if present otherwise returns
        //the default value passed.
        Integer value1 = a.or(new Integer(0));

        //Optional.get - gets the value, value should be present
        Integer value2 = b.get();

        return value1 + value2;
    }

    private static void testPreconditions() {
        try {
            System.out.println(sqrt(-3.0));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(sum(null, 3));
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(getValue(6));
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public static double sqrt(double input) throws IllegalArgumentException {
        Preconditions.checkArgument(input > 0.0,
                "Illegal Argument passed: Negative value %s.", input);
        return Math.sqrt(input);
    }

    public static int sum(Integer a, Integer b) {

        a = Preconditions.checkNotNull(a, "Illegal Argument passed: First parameter is Null.");
        b = Preconditions.checkNotNull(b, "Illegal Argument passed: Second parameter is Null.");

        return a + b;
    }

    public static int getValue(int input) {
        int[] data = {1, 2, 3, 4, 5};
        Preconditions.checkElementIndex(input, data.length, "Illegal Argument passed: Invalid index.");

        return 0;
    }

    public static void testOrdering() {
        List<Integer> numbers = new ArrayList<Integer>();

        numbers.add(new Integer(5));
        numbers.add(new Integer(2));
        numbers.add(new Integer(15));
        numbers.add(new Integer(51));
        numbers.add(new Integer(53));
        numbers.add(new Integer(35));
        numbers.add(new Integer(45));
        numbers.add(new Integer(32));
        numbers.add(new Integer(43));
        numbers.add(new Integer(16));
        Ordering<Integer> natural = Ordering.natural();

        System.out.println("Input List: ");
        System.out.println(numbers);

        Collections.sort(numbers, natural);
        System.out.println("Sorted List: ");
        System.out.println(numbers);

        System.out.println("======================");
        System.out.println("List is sorted: " + natural.isOrdered(numbers));
        System.out.println("Minimum: " + natural.min(numbers));
        System.out.println("Maximum: " + natural.max(numbers));

        Collections.sort(numbers, natural.reverse());
        System.out.println("Reverse: " + numbers);

        numbers.add(null);
        System.out.println("Null added to Sorted List: ");
        System.out.println(numbers);

        Collections.sort(numbers, natural.nullsFirst());
        System.out.println("Null first Sorted List: ");
        System.out.println(numbers);
        System.out.println("======================");

        List<String> names = new ArrayList<String>();

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

        System.out.println("Another List: ");
        System.out.println(names);

        Ordering<String> naturalString = Ordering.natural();
        Collections.sort(names, naturalString.nullsFirst().reverse());
        System.out.println("Null first then reverse sorted list: ");
        System.out.println(names);
    }

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

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public int getRollNo() {
            return rollNo;
        }

        public void setRollNo(int rollNo) {
            this.rollNo = rollNo;
        }

        public String getClassName() {
            return className;
        }

        public void setClassName(String className) {
            this.className = className;
        }
    }
}