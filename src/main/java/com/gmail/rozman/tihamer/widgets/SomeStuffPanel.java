package com.gmail.rozman.tihamer.widgets;

import com.gmail.rozman.tihamer.POJOs.SomeStuff;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

/**
 * Created by trozman on 2015. 09. 18..
 */
public class SomeStuffPanel extends Panel {

    private static final String SOME_TEXT = "someText";
    private static final String FIRST_NUMBER = "firstNumber";
    private static final String SECOND_NUMBER = "secondNumber";

    private IModel<String> someTextModel = new PropertyModel<String>(getDefaultModel(), "someText");
    private IModel<String> firstNumberModel = new PropertyModel<String>(getDefaultModel(), "theFirstNumber");
    private IModel<String> secondNumberModel = new PropertyModel<String>(getDefaultModel(), "theSecondNumber");

    public SomeStuffPanel(String id) {
        super(id);
        initializeComponents();
    }
    public SomeStuffPanel(String id, int index, IModel<SomeStuff> model) {
        super(id, model);

        initializeComponents();

        if((index % 2)  == 0) {
            get(SOME_TEXT).setVisible(false);
        }

    }

    public SomeStuffPanel(String id, IModel<SomeStuff> model) {
        super(id, model);

        setOutputMarkupId(true);
        setMarkupId("test");
        initializeComponents();

    }

    void initializeComponents() {

        Label someTextlabel = new Label(SOME_TEXT, someTextModel);
        Label firstNumberLabel = new Label(FIRST_NUMBER, firstNumberModel);
        Label secondNumberLabel = new Label(SECOND_NUMBER, secondNumberModel);

        add(someTextlabel);
        add(firstNumberLabel);
        add(secondNumberLabel);

    }

}
