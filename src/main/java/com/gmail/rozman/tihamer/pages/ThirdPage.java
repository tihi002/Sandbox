package com.gmail.rozman.tihamer.pages;

import com.gmail.rozman.tihamer.POJOs.SomeStuff;
import com.gmail.rozman.tihamer.widgets.SomeStuffInputPanel;
import com.gmail.rozman.tihamer.widgets.SomeStuffPanel;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.navigation.paging.AjaxPagingNavigation;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PageableListView;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.util.*;

import java.util.ArrayList;


/**
 * Created by trozman on 2015. 09. 17..
 */
public class ThirdPage extends BasePage {

    private static final String LIST_ID = "theList";
    private static final String SOME_TEXT = "someText";
    private static final String FIRST_NUMBER = "firstNumber";
    private static final String SECOND_NUMBER = "secondNumber";

    private SomeStuffInputPanel someStuffInputPanel;

    public ThirdPage() {

        final ArrayList<SomeStuff> someStuffs = new ArrayList<SomeStuff>();
        SomeStuff stuff;
        for (int i = 0; i <= 10; i++) {
            stuff = new SomeStuff();
            stuff.generateFields();
            someStuffs.add(stuff);
        }

        final WebMarkupContainer container = new WebMarkupContainer("container");

        ListModel<SomeStuff> listModel = new ListModel<SomeStuff>(someStuffs);
        final PageableListView<SomeStuff> list = new PageableListView<SomeStuff>(LIST_ID, listModel, 5) {
            @Override
            protected void populateItem(ListItem<SomeStuff> item) {
                item.add(new SomeStuffPanel("com.gmail.rozman.tihamer.widgets.SomeStuffPanel", item.getIndex(), item.getModel()));
            }
        };

        list.setOutputMarkupId(true);
        container.add(list);
        container.add(new AjaxPagingNavigation("navigation", list));
        container.setOutputMarkupId(true);
        container.setVersioned(false);
        add(container);


        Model<SomeStuff> someStuffModel = new Model<SomeStuff>(new SomeStuff("s111ss", "1", "2"));

        someStuffInputPanel = new SomeStuffInputPanel("com.gmail.rozman.tihamer.widgets.SomeStuffInputPanel", someStuffModel) {
            @Override
            protected void ajaxSubmit(AjaxRequestTarget target) {
                SomeStuff someStuffModelObject = someStuffInputPanel.getModelObject();
                someStuffs.add(new SomeStuff(someStuffModelObject.getSomeText(), someStuffModelObject.getTheFirstNumber(), someStuffModelObject.getTheSecondNumber()));
                target.add(container);
            }
        };
        add(someStuffInputPanel);
    }

    @Override
    public String getPageTitle() {
        return "Third page";
    }

    protected boolean getThirdLinkVisibility() {
        return false;
    }
}
