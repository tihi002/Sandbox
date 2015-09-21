import org.apache.wicket.ajax.AjaxRequestTarget;

public class HomePage extends BasePage {


    private SomeStuffPanel someStuffPanel;
    private SomeStuffInputPanel someStuffInputPanel;
    private SomeStuff someStuff = new SomeStuff("sss", 1, 2);

    public HomePage() {
        someStuff = new SomeStuff("sss", 1, 2);
        someStuffPanel = new SomeStuffPanel("SomeStuffPanel", someStuff);

        someStuffInputPanel = new SomeStuffInputPanel("SomeStuffInputPanel") {
            @Override
            void ajaxSubmit(AjaxRequestTarget target) {
                someStuffPanel = new SomeStuffPanel("SomeStuffPanel", someStuff);;
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