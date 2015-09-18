
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;

import java.util.ArrayList;

/**
 * Created by trozman on 2015. 09. 17..
 */
public class ThirdPage extends BasePage {

    private static final String LIST_ID = "theList";
    private static final String SOME_TEXT = "someText";
    private static final String FIRST_NUMBER = "firstNumber";
    private static final String SECOND_NUMBER = "secondNumber";



    public ThirdPage() {

        final ArrayList<SomeStuff> someStuffs = new ArrayList<SomeStuff>();
        SomeStuff stuff;
        for(int i=0; i<=10; i++) {
            stuff = new SomeStuff();
            stuff.generateFields();
            someStuffs.add(stuff);
        }


        ListView<SomeStuff> list = new ListView<SomeStuff>(LIST_ID, someStuffs) {
            @Override
            protected void populateItem(ListItem<SomeStuff> item) {

                item.add(new SomeStuffPanel("SomeStuffPanel", item.getModelObject(), item.getIndex()));

            }
        };
        add(list);


    }
    @Override
    public String getPageTitle() {
        return "Third page";
    }
    protected boolean getThirdLinkVisibility() {
        return false;
    }
}
