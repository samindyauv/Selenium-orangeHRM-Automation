package PositiveScenarios_OrangeHRM;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.baseTest;

import java.io.IOException;

public class login extends baseTest {

    @BeforeMethod
    public void open() throws IOException, InterruptedException {
        loadUrl();
    }

    @Test
    public void loginWithValidCredentials() throws InterruptedException {
        webSteps.loginSystem();
        System.out.println("Success");
        boolean urlVerification = driver.getCurrentUrl().contains("dashboard");
        Assert.assertTrue(urlVerification,"Expecting login success but not navigated to dashboard");
    }

    @AfterMethod
    public void close(){
        tearDown();
    }
}
