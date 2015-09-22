package com.gmail.rozman.tihamer;

import com.gmail.rozman.tihamer.pages.HomePage;
import org.apache.wicket.protocol.http.WebApplication;

/**
 * Created by trozman on 2015. 09. 15..
 */
public class WebbApp extends WebApplication {
    public WebbApp() {

    }

    @Override
    protected void init() {
        super.init();
        getMarkupSettings().setStripWicketTags(true);
    }

    @Override
    public Class getHomePage() {
        return HomePage.class;
    }
}
