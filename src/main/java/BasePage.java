import org.apache.wicket.markup.html.WebPage;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.LoadableDetachableModel;

public abstract class BasePage extends WebPage {


    static final String LINK_TO_HOME_PAGE_ID = "linkToHomePage";
    static final String LINK_TO_SECOND_PAGE_ID = "linkToSecondPage";
    static final String LINK_TO_THIRD_PAGE_ID = "linkToThirdPage";
    static final String PAGE_TITLE_ID = "pageTitle";


    protected static Link linkToHomePage;
    protected static Link linkToSecondPage;
    protected static Link linkToThirdPage;
    protected static Label pageTitleLabel;


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

        add(linkToHomePage);
        add(linkToSecondPage);
        add(linkToThirdPage);
        add(pageTitleLabel);

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

}