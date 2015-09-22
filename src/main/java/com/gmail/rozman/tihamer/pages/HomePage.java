package com.gmail.rozman.tihamer.pages;

import com.gmail.rozman.tihamer.POJOs.SomeStuff;
import com.gmail.rozman.tihamer.widgets.SomeStuffInputPanel;
import com.gmail.rozman.tihamer.widgets.SomeStuffPanel;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.model.Model;

public class HomePage extends BasePage {

    private SomeStuffPanel someStuffPanel;
    private SomeStuffInputPanel someStuffInputPanel;

    private Model<SomeStuff> someStuffModel = new Model<SomeStuff>( new SomeStuff("s111ss", "1", "2"));

    public HomePage() {

        someStuffPanel = new SomeStuffPanel("com.gmail.rozman.tihamer.widgets.SomeStuffPanel", someStuffModel);
        someStuffInputPanel = new SomeStuffInputPanel("com.gmail.rozman.tihamer.widgets.SomeStuffInputPanel", someStuffModel) {
            @Override
            protected void ajaxSubmit(AjaxRequestTarget target) {
                someStuffPanel = new SomeStuffPanel("com.gmail.rozman.tihamer.widgets.SomeStuffPanel", someStuffModel);
                HomePage.this.addOrReplace(someStuffPanel);
                target.add(someStuffPanel);
            }
        };
        add(someStuffPanel);
        add(someStuffInputPanel);
    }

    @Override
    public String getPageTitle() {
        return "Home page";
    }

    protected boolean getFirstLinkVisibility() {
        return false;
    }





}