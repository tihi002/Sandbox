package com.gmail.rozman.tihamer.pages;

/**
 * Created by trozman on 2015. 09. 17..
 */
public class SecondPage extends BasePage {

    public SecondPage() {

    }

    @Override
    public String getPageTitle() {
        return "Second page";
    }

    protected boolean getSecondLinkVisibility() {
        return false;
    }

}
