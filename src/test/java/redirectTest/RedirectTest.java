package redirectTest;

import io.qameta.allure.Description;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import redirectobject.RedirectObjectPage;
import redirectobject.Selectors;

public class RedirectTest {
    RedirectObjectPage rdr = new RedirectObjectPage();

    @BeforeTest
    public void openPage(){
        rdr.setUp();
        rdr.scrollDownToElementLink();
        rdr.changeTab();
    }

    @Test
    @Description("Please join our mailing list, with your name, " +
            "email and selected input")
    public void joinEmailList(){
        rdr.insertText(Selectors.email, Selectors.emailAdd);
        rdr.joinMailingList();
        rdr.insertText(Selectors.fieldName, Selectors.fieldAdd);
        rdr.selectJava();
    }

    @AfterTest
    public void closePage(){
        rdr.tearDown();
    }
}
