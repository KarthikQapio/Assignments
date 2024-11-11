import jdk.jfr.Description;
import org.example.Base.LoginPage;
import org.example.Base.Registrationpage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


@Test
public class FacebookTest extends AbstractFacebookTest{

    LoginPage loginPage = new LoginPage();
    Registrationpage registrationpage = new Registrationpage();

    @Test(enabled = true)
    @Description("Tc-01-launch The Browser and Enter The valid email and Password")
    public void launchTheBrowser() throws InterruptedException {
        loginPage.launchWebsite();
        loginPage.enterAEmailAndPassword();


    }
    @Test(enabled = true)
    @Description("TC-02-Launch The Browser and Fill The Registration Page")
    public void createTheRegistrationPage() throws InterruptedException {
        loginPage.launchWebsite();
        registrationpage.registerPage();




    }





    }

