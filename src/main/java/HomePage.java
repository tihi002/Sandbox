import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;

public class HomePage extends BasePage {

    private Label label;

    private String valueToOutput = "empty";

    private Model<String> someTextModel = new Model<String>("initial");
    private Model<String> firstNumberModel = new Model<String>("1");
    private Model<String> secondNumberModel = new Model<String>("2");

    public HomePage() {

        label = new Label("someStuff", new Model<String>() {
            @Override
            public String getObject() {
                return valueToOutput;
            }
        });

        add(label);


        add(new FeedbackPanel("feedback"));

        final TextField<String> someText = new TextField<String>("someText", someTextModel).ad;
        final TextField<String> firstNumber = new TextField<String>("firstNumber", firstNumberModel);
        final TextField<String> secondNumber = new TextField<String>("secondNumber", secondNumberModel);
        someText.setRequired(true);
        firstNumber.setRequired(true);
        secondNumber.setRequired(true);
//        username.add(new UsernameValidator());


        Form<SomeStuff> form = new Form<SomeStuff>("someStuffForm") {

            @Override
            protected void onSubmit() {

//                final String someTextValue = someText.getModelObject();
//                final int firstnumberValue = Integer.parseInt(firstNumberModel.getModelObject());
//                final int secondNumberValue = Integer.parseInt(secondNumberModel.getModelObject());

                  valueToOutput = someTextModel.getObject() + " " + firstNumberModel.getObject() + " " + secondNumberModel.getObject();
//                PageParameters pageParameters = new PageParameters();
//                pageParameters.add("someText", someTextValue);
//                pageParameters.add("firstNumberModel", firstnumberValue);
//                pageParameters.add("secondNumberModel", secondNumberValue);
//                setResponsePage(HomePage.class, pageParameters);
            }

        };


        form.add(someText);
        form.add(firstNumber);
        form.add(secondNumber);


        add(form);



    }

    @Override
    public String getPageTitle() {
        return "Home page";
    }

    protected boolean getFirstLinkVisibility() {
        return false;
    }





}