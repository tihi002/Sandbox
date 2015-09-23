package com.gmail.rozman.tihamer.pages;

import com.gmail.rozman.tihamer.MySession;
import com.gmail.rozman.tihamer.POJOs.User;
import org.apache.wicket.markup.html.WebPage;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;

public abstract class BasePage extends WebPage {

    static final String LINK_TO_HOME_PAGE_ID = "linkToHomePage";
    static final String LINK_TO_SECOND_PAGE_ID = "linkToSecondPage";
    static final String LINK_TO_THIRD_PAGE_ID = "linkToThirdPage";
    static final String LINK_TO_LOGIN_PAGE_ID = "linkToLoginPage";
    static final String PAGE_TITLE_ID = "pageTitle";

    protected static Link linkToHomePage;
    protected static Link linkToSecondPage;
    protected static Link linkToThirdPage;
    protected static Link linkToLoginPage;
    protected static Label pageTitleLabel;
    private static Label userNameLabel;


    public BasePage() {

        initializeWicketComponents();

    }

    private void initializeWicketComponents() {
        linkToHomePage = new Link(LINK_TO_HOME_PAGE_ID) {
            @Override
            public void onClick() {
                setResponsePage(HomePage.class, null);
            }
            @Override
            public boolean isVisible() {
                return getFirstLinkVisibility();
            }
        };
        linkToSecondPage = new Link(LINK_TO_SECOND_PAGE_ID) {
            @Override
            public void onClick() {
                setResponsePage(SecondPage.class, null);
            }
            @Override
            public boolean isVisible() {
                return getSecondLinkVisibility();
            }
        };
        linkToThirdPage = new Link(LINK_TO_THIRD_PAGE_ID) {
            @Override
            public void onClick() {
                setResponsePage(ThirdPage.class, null);
            }
            @Override
            public boolean isVisible() {
                return getThirdLinkVisibility();
            }
        };


        pageTitleLabel = new Label(PAGE_TITLE_ID, new LoadableDetachableModel<String>() {
            @Override
            protected String load() {
                return getPageTitle();
            }
        });

        linkToLoginPage = new Link(LINK_TO_LOGIN_PAGE_ID) {
            @Override
            public void onClick() {

                System.out.println("ssss");
            }
            @Override
            public boolean isVisible() {
                return  (! isLoggedIn());
            }
        };


        IModel<String> usernameLabelModel = new IModel<String>() {
            public void detach() {

            }

            public String getObject() {
                return getActiveUser().getUserName();
            }

            public void setObject(String object) {

            }
        };

        userNameLabel = new Label("userNameLabel", usernameLabelModel) {
            @Override
            public boolean isVisible() {
                return  isLoggedIn();
            }

        };

        add(linkToHomePage);
        add(linkToSecondPage);
        add(linkToThirdPage);
        add(linkToLoginPage);
        add(pageTitleLabel);
        add(userNameLabel);

    }



    protected boolean getFirstLinkVisibility() {
        return true;
    }

    protected boolean getSecondLinkVisibility() {
        return true;
    }

    protected boolean getThirdLinkVisibility() {
        return true;
    }


    public abstract String getPageTitle();

    protected User getActiveUser() {
        return ((MySession)getSession()).getUser();
    }
    protected boolean isLoggedIn() {
        return (getActiveUser() != null);
    }

}