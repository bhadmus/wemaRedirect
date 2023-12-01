package redirectTests;

import io.qameta.allure.Description;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import redirectobject.RedirectObjectPage;
import redirectobject.Selectors;

public class redirectPageTests {
    RedirectObjectPage rdr = new RedirectObjectPage();

    @BeforeTest
    public void openPage(){
        rdr.setUp();
        rdr.scrollDownToElementLink();
        rdr.changeTab();
    }

    @Test
    @Description("joined email list, filled in name, " +
            "email and selected language")
    public void joinEmailList(){
        rdr.insertText(Selectors.emailField, Selectors.emailText);
        rdr.joinMailingList();
        rdr.insertText(Selectors.nameField, Selectors.nameText);
        rdr.selectJava();
    }

    @AfterTest
    public void closePage(){
        rdr.tearDown();
    }
}
