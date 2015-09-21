import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by trozman on 2015. 09. 17..
 */
public class ThirdPage extends BasePage {

    private static final String LIST_ID = "theList";
    private static final String SOME_TEXT = "someText";
    private static final String FIRST_NUMBER = "firstNumber";
    private static final String SECOND_NUMBER = "secondNumber";

    public ThirdPage() {

        final SomeStuffInputPanel inputPanel = new SomeStuffInputPanel("SomeStuffInputPanel") {
            @Override
            void ajaxSubmit(AjaxRequestTarget target) {

            }
        };
        add(inputPanel);

        final List<SomeStuff> someStuffs = new ArrayList<SomeStuff>();
        SomeStuff stuff;
        for(int i=0; i<=10; i++) {
            stuff = new SomeStuff();
            stuff.generateFields();
            someStuffs.add(stuff);
        }

        IModel<List<SomeStuff>> listIModel = new IModel<List<SomeStuff>>() {
            public void detach() {

            }

            public List<SomeStuff> getObject() {
                return someStuffs;
            }

            public void setObject(List<SomeStuff> object) {
                someStuffs.clear();
                someStuffs.addAll(object);

            }

        };
        ListView<SomeStuff> list = new ListView<SomeStuff>(LIST_ID, listIModel) {
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
