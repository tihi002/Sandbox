package com.gmail.rozman.tihamer.pages;

import com.gmail.rozman.tihamer.MySession;
import com.gmail.rozman.tihamer.POJOs.User;
import com.gmail.rozman.tihamer.widgets.LogInPanel;
import org.apache.wicket.model.Model;

/**
 * Created by trozman on 2015. 09. 23..
 */
public class LoginPage extends BasePage {

    private LogInPanel logInPanel;

    public LoginPage() {
        logInPanel = new LogInPanel("logg", new Model<User>(new User("ss", "ss"))) {
            @Override
            protected void logIn() {

                System.out.print(getModelObject().toString());
                User user = new User(getModelObject().getUserName(), getModelObject().getUserPassword());
                ((MySession)getSession()).setUser(user);

            }
        };

        add(logInPanel);
    }

    @Override
    public String getPageTitle() {
        return "Login page";
    }
}
