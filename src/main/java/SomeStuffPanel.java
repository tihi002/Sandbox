import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

/**
 * Created by trozman on 2015. 09. 18..
 */
public class SomeStuffPanel extends Panel {

    private static final String SOME_TEXT = "someText";
    private static final String FIRST_NUMBER = "firstNumber";
    private static final String SECOND_NUMBER = "secondNumber";


    private SomeStuff someStuff = new SomeStuff("init", 0, 0);

    public SomeStuffPanel(String id) {
        super(id);

        initializeComponents();
    }
    public SomeStuffPanel(String id, SomeStuff someStuff, int index) {
        super(id);
        this.someStuff = someStuff;

        initializeComponents();



        if((index % 2)  == 0) {
            get(SOME_TEXT).setVisible(false);
        }

    }

    public SomeStuffPanel(String id, SomeStuff someStuff) {
        super(id);
        this.someStuff = someStuff;
        setOutputMarkupId(true);
        setMarkupId("test");
        initializeComponents();

    }

    void initializeComponents() {
        Label someTextlabel = new Label(SOME_TEXT, new Model<String>() {

            @Override
            public String getObject() {
                return someStuff.getSomeText();
            }

        });
        Label firstNumberLabel = new Label(FIRST_NUMBER, new Model<String>() {

            @Override
            public String getObject() {
                return String.valueOf(someStuff.getTheFirstNumber());
            }

        });

        Label secondNumberLabel = new Label(SECOND_NUMBER, new Model<String>() {

            @Override
            public String getObject() {
                return String.valueOf(someStuff.getTheSecondNumber());
            }

        });
        add(someTextlabel);
        add(firstNumberLabel);
        add(secondNumberLabel);

    }

    public SomeStuff getSomeStuff() {
        return someStuff;
    }

    public void setSomeStuff(SomeStuff someStuff) {
        this.someStuff = someStuff;
    }
}
