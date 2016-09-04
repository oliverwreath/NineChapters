package com.lintCode.test;

import java.io.IOException;

import com.google.common.base.Throwables;

/**
 * Created by Yanliang Han on 2016/5/29.
 */
public class GuavaThrowables {
    public static void main(String args[]) {

        GuavaThrowables tester = new GuavaThrowables();

        try {
            tester.showcaseThrowables();

        } catch (InvalidInputException e) {
            //get the root cause
            System.out.println(Throwables.getRootCause(e));

        } catch (Exception e) {
            //get the stack trace in string format
            System.out.println(Throwables.getStackTraceAsString(e));
        }

        try {
            tester.showcaseThrowables1();

        } catch (Exception e) {
            System.out.println(Throwables.getStackTraceAsString(e));
        }
    }

    public void showcaseThrowables() throws InvalidInputException {
        try {
            sqrt(-3.0);
        } catch (Throwable e) {
            //check the type of exception and throw it
            Throwables.propagateIfInstanceOf(e, InvalidInputException.class);
            Throwables.propagate(e);
        }
    }

    public void showcaseThrowables1() {
        try {
            int[] data = {1, 2, 3};
            getValue(data, 4);
        } catch (Throwable e) {
            Throwables.propagateIfInstanceOf(e, IndexOutOfBoundsException.class);
            Throwables.propagate(e);
        }
    }

    public double sqrt(double input) throws InvalidInputException {
        if (input < 0) throw new InvalidInputException();
        return Math.sqrt(input);
    }

    public double getValue(int[] list, int index) throws IndexOutOfBoundsException {
        return list[index];
    }

    public void dummyIO() throws IOException {
        throw new IOException();
    }
}

class InvalidInputException extends Exception {
}