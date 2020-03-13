// # IGNORE THIS FILE; NOT BEING USED ANYMORE
// # ALL STEPS MOVED INTO BMI FILE.
package seany;

import org.jbehave.core.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static junit.framework.Assert.assertEquals;

public class Add {

    Add() {
        System.out.println("Add!!!");
    }

    WebDriver driver = null;

    private char sign;
    private String a;
    private String b;
    private String result;

    // Why isnt this being called?
    @BeforeScenario
    public void scenarioSetup() {
        System.out.println("SC BEGIN!!!");
    }




    @BeforeStory
    public void storySetup() {
        System.out.println("Add STORY START");
        driver = new FirefoxDriver();

        
    }


    @Given("a adder website")
    public void givenACalculatorClassWithTheOperationSignAssign() {

        String url = "file:///" + System.getProperty("user.dir") + "/src/main/resources/pages/add.html";


        System.out.println("Opening... " + url);
        driver.get(url);
    }

    @When("I give the first number as <number1>")
    public void whenIGiveTheFirstNumberAsnumber1(@Named("number1") String a) {
        this.a = a;

        driver.manage().window();
        WebElement heightCMS = driver.findElement(By.
                id("num1"));
        heightCMS.sendKeys(a);
    }

    @When("I give the second number as <number2>")
    public void whenIGiveTheSecondNumberAsnumber2(@Named("number2") String b) {
        this.b = b;

        driver.manage().window();
        WebElement heightCMS = driver.findElement(By.
                id("num2"));
        heightCMS.sendKeys(b);
    }

    @When("I click on the Click button")
    public void IClickOnTheButton()
    {
        WebElement button = driver.findElement(By.id("click"));
        button.click();
    }


    @Then("I should get the result as <result>")
    public void thenIShouldGetTheResultAsresult(@Named("result") String result) {

        WebElement bmi = driver.findElement(By.id("result"));

        assertEquals(result,
                bmi.getAttribute("innerHTML"));


    }




    @AfterStory
    public void afterStory() {
        System.out.println("ADD STORY END");
        driver.quit();
    }


    // Why isnt this being called?
    @AfterScenario(uponOutcome=AfterScenario.Outcome.SUCCESS)
    public void afterScenario (){
        System.out.println("SC END!!!");
    }
}