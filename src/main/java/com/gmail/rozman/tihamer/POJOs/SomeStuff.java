package com.gmail.rozman.tihamer.POJOs;

import java.io.Serializable;
import java.util.Random;

/**
 * Created by trozman on 2015. 09. 17..
 */
public class SomeStuff implements Serializable {
    private static final Random r = new Random();

    String someText;
    String theFirstNumber;
    String theSecondNumber;

    public SomeStuff() {

    }

    public SomeStuff(String someText, String firstNumber, String secondNumber) {
        this.someText = someText;
        this.theFirstNumber = firstNumber;
        this.theSecondNumber = secondNumber;
    }


    public void generateFields() {
        someText = "kiskutya";
        theFirstNumber = String.valueOf(r.nextInt(10));
        theSecondNumber = String.valueOf(r.nextInt(10));
    }


    public String getSomeText() {
        return someText;
    }

    public void setSomeText(String someText) {
        this.someText = someText;
    }

    public String getTheFirstNumber() {
        return theFirstNumber;
    }

    public void setTheFirstNumber(String theFirstNumber) {
        this.theFirstNumber = theFirstNumber;
    }

    public String getTheSecondNumber() {
        return theSecondNumber;
    }

    public void setTheSecondNumber(String theSecondNumber) {
        this.theSecondNumber = theSecondNumber;
    }
}
