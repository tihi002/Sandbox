import java.io.Serializable;
import java.util.Random;

/**
 * Created by trozman on 2015. 09. 17..
 */
public class SomeStuff implements Serializable {
    private static final Random r = new Random();


    String someText;
    int theFirstNumber;
    int theSecondNumber;

    void generateFields() {
        someText = "kiskutya";
        theFirstNumber = r.nextInt(10);
        theSecondNumber = r.nextInt(10);
    }

    public String getSomeText() {
        return someText;
    }

    public void setSomeText(String someText) {
        this.someText = someText;
    }

    public int getTheFirstNumber() {
        return theFirstNumber;
    }

    public void setTheFirstNumber(int theFirstNumber) {
        this.theFirstNumber = theFirstNumber;
    }

    public int getTheSecondNumber() {
        return theSecondNumber;
    }

    public void setTheSecondNumber(int theSecondNumber) {
        this.theSecondNumber = theSecondNumber;
    }



}
