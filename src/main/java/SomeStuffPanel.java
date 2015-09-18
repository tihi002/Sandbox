import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

/**
 * Created by trozman on 2015. 09. 18..
 */
public class SomeStuffPanel extends Panel {

    private static final String SOME_TEXT = "someText";
    private static final String FIRST_NUMBER = "firstNumber";
    private static final String SECOND_NUMBER = "secondNumber";

    public SomeStuffPanel(String id) {
        super(id);
    }
    public SomeStuffPanel(String id, SomeStuff stuff, int index) {
        super(id);
        Label someTextlabel = new Label(SOME_TEXT, stuff.getSomeText());

        if((index % 2)  == 0) {
            someTextlabel.setVisible(false);
        }
        add(someTextlabel);
        add(new Label(FIRST_NUMBER, stuff.getTheFirstNumber() ));
        add(new Label(SECOND_NUMBER, stuff.getTheSecondNumber()));


    }
}
