package seany;

import org.jbehave.core.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static junit.framework.Assert.assertEquals;

public class BMI {

    BMI() {
        System.out.println("Bmi2!!!");
    }

    WebDriver driver = null;


    // Why isnt this being called?
    @BeforeScenario
    public void scenarioSetup() {
        System.out.println("SC BEGIN!!!");
    }




    @BeforeStory
    public void storySetup() {
        System.out.println("BMI STORY START");
        driver = new FirefoxDriver();

        
    }

    @When("I open BMI Calculator Home Page")
    public void IOpen()
    {
        System.out.println("open!!!");


        String url = "file:///" + System.getProperty("user.dir") + "/src/main/resources/pages/bmi.html";


        System.out.println("Opening... " + url);
        driver.get(url);
//        driver.get("file:///Users/sean/Programming/DBS/at/bmi/index.html");
    }

    @When("I enter height as <height>")
    public void IEnterHeight(@Named("height") String height)
    {
        driver.manage().window();
        WebElement heightCMS = driver.findElement(By.
                id("height"));
        heightCMS.sendKeys(height);
    }
    @When("I enter weight as <weight>")
    public void IEnterWeight(@Named("weight") String weight)
    {
        WebElement weightKg = driver.findElement(By.
                id("weight"));
        weightKg.sendKeys(weight);
    }
    @When("I click on the Calculate button")
    public void IClickOnTheButton()
    {
        WebElement button = driver.findElement(By.id("submit"));
        button.click();
    }
    @Then("I should see bmi as <bmi>")
            public void IShouldBmiAndCategory(@Named("bmi") String bmi_exp)
    {
        WebElement bmi = driver.findElement(By.id("bmi"));

        assertEquals(bmi_exp,
                bmi.getAttribute("innerHTML"));


    }

    @AfterStory
    public void afterStory() {
        System.out.println("BMI STORY END");
        driver.quit();
    }


    // Why isnt this being called?
    @AfterScenario(uponOutcome=AfterScenario.Outcome.SUCCESS)
    public void afterScenario (){
        System.out.println("SC END!!!");
    }
}