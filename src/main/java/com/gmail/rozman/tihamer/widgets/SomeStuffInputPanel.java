package com.gmail.rozman.tihamer.widgets;

import com.gmail.rozman.tihamer.validators.IntValidator;
import com.gmail.rozman.tihamer.POJOs.SomeStuff;
import com.gmail.rozman.tihamer.validators.StringValidator;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.feedback.ComponentFeedbackMessageFilter;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

/**
 * Created by trozman on 2015. 09. 21......
 */
public abstract class SomeStuffInputPanel extends GenericPanel<SomeStuff> {


    private IModel<String> someTextModel = new PropertyModel<String>(getDefaultModel(), "someText");
    private IModel<String> firstNumberModel = new PropertyModel<String>(getDefaultModel(), "theFirstNumber");
    private IModel<String> secondNumberModel = new PropertyModel<String>(getDefaultModel(), "theSecondNumber");

    public SomeStuffInputPanel(String id, IModel<SomeStuff> model) {
        super(id, model);
        initializeComponents();

    }

    private void initializeComponents() {

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

    protected abstract void ajaxSubmit(AjaxRequestTarget target);









}
