import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.feedback.ComponentFeedbackMessageFilter;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * Created by trozman on 2015. 09. 21..
 */
public abstract class SomeStuffInputPanel<SomeStuff> extends Panel {

    private Model<String> someTextModel = new Model<String>("initial");
    private Model<String> firstNumberModel = new Model<String>("1");
    private Model<String> secondNumberModel = new Model<String>("2");

//    private SomeStuff someStuff = new SomeStuff("sss", 1, 2);

    public SomeStuffInputPanel(String id, IModel<SomeStuff> model) {
        super(id, model);
    }

    private void initializeComponents() {
//        someStuff = new SomeStuff("sss", 1, 2);

        final TextField<String> someText = new TextField<String>("someText", someTextModel);
        final TextField<String> firstNumber = new TextField<String>("firstNumber", firstNumberModel);
        final TextField<String> secondNumber = new TextField<String>("secondNumber", secondNumberModel);

        IntValidator validator = new IntValidator();

        firstNumber.add(validator);
        secondNumber.add(validator);

        StringValidator stringValidator = new StringValidator();
        someText.add(stringValidator);

        final FeedbackPanel someTextFeedBackPanel = new FeedbackPanel("feedback1", new ComponentFeedbackMessageFilter(someText));
        final FeedbackPanel firstNumberFeedBackPanel = new FeedbackPanel("feedback2", new ComponentFeedbackMessageFilter(firstNumber));
        final FeedbackPanel secondNumberFeedBackPanel = new FeedbackPanel("feedback3", new ComponentFeedbackMessageFilter(secondNumber));

        someTextFeedBackPanel.setOutputMarkupId(true);
        firstNumberFeedBackPanel.setOutputMarkupId(true);
        secondNumberFeedBackPanel.setOutputMarkupId(true);

        someText.setRequired(true);
        firstNumber.setRequired(true);
        secondNumber.setRequired(true);

        Form form = new Form("someStuffForm");

        form.add(someText);
        form.add(firstNumber);
        form.add(secondNumber);
        form.add(someTextFeedBackPanel);
        form.add(firstNumberFeedBackPanel);
        form.add(secondNumberFeedBackPanel);

        form.add(new AjaxSubmitLink("ajaxSubmit", form) {
            @Override
            protected void onSubmit(AjaxRequestTarget target, Form form) {

                super.onSubmit(target, form);
//                someStuff = new SomeStuff(someTextModel.getObject(), Integer.parseInt(firstNumberModel.getObject()), Integer.parseInt(secondNumberModel.getObject()));
                target.add(someTextFeedBackPanel);
                target.add(firstNumberFeedBackPanel);
                target.add(secondNumberFeedBackPanel);
                ajaxSubmit(target);

            }
            @Override
            protected void onError(final AjaxRequestTarget target, final Form form) {

                target.add(someTextFeedBackPanel);
                target.add(firstNumberFeedBackPanel);
                target.add(secondNumberFeedBackPanel);

            }
        });

        add(form);

    }

    abstract void ajaxSubmit(AjaxRequestTarget target);

//    SomeStuff getSomeStuff() {
//        return someStuff;
//    }







}
