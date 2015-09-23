package com.gmail.rozman.tihamer.pages;

import com.gmail.rozman.tihamer.MySession;
import com.gmail.rozman.tihamer.POJOs.User;
import com.gmail.rozman.tihamer.widgets.LogInPanel;
import org.apache.wicket.model.Model;

public class HomePage extends BasePage {




    public HomePage() {




    }

    @Override
    public String getPageTitle() {
        return "Home page";
    }

    protected boolean getFirstLinkVisibility() {
        return false;
    }





}