package com.gmail.rozman.tihamer.widgets;

import com.gmail.rozman.tihamer.POJOs.User;
import com.gmail.rozman.tihamer.validators.UserNameValidator;
import com.gmail.rozman.tihamer.validators.UserPasswordValidator;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.feedback.ComponentFeedbackMessageFilter;
import org.apache.wicket.markup.html.form.*;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;


/**
 * Created by trozman on 2015. 09. 23..
 */

public abstract class LogInPanel extends GenericPanel<User> {

    private PropertyModel<String> userNameModel = new PropertyModel<String>(getDefaultModelObject(), "userName");
    private PropertyModel<String> userPasswordModel = new PropertyModel<String>(getDefaultModelObject(), "userPassword");

    private TextField<String> userNameTextArea = new TextField<String>("userName", userNameModel);
    private PasswordTextField userPasswordTextArea = new PasswordTextField("userPassword", userPasswordModel);

    private Form form = new Form("loginForm");

    public LogInPanel(String id, IModel<User> userModel) {

        super(id, userModel);

        form.add(userNameTextArea);
        form.add(userPasswordTextArea);

        final FeedbackPanel userNameFeedBackPanel = new FeedbackPanel("userNameValidationFeedback", new ComponentFeedbackMessageFilter(userNameTextArea));
        final FeedbackPanel passwordFeedBackPanel = new FeedbackPanel("userPassValidationFeedback", new ComponentFeedbackMessageFilter(userPasswordTextArea));

        userNameFeedBackPanel.setOutputMarkupId(true);
        passwordFeedBackPanel.setOutputMarkupId(true);

        form.add(userNameFeedBackPanel);
        form.add(passwordFeedBackPanel);

        form.add(new AjaxSubmitLink("submit", form) {
            @Override
            public void onSubmit(AjaxRequestTarget target, Form f) {
                super.onSubmit(target, f);
                target.add(userNameFeedBackPanel);
                target.add(passwordFeedBackPanel);
                logIn();
            }
            @Override
            protected void onError(final AjaxRequestTarget target, final Form form) {

                target.add(userNameFeedBackPanel);
                target.add(passwordFeedBackPanel);

            }
        });
        add(form);

        userNameTextArea.add(new UserNameValidator());
        userPasswordTextArea.add(new UserPasswordValidator());





    }

    protected abstract void logIn();



}
