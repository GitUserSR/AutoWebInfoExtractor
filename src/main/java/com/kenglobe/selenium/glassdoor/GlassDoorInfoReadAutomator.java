package com.kenglobe.selenium.glassdoor;

/**
 * Created by srapolu on 8/2/17.
 */
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

/**
 * Created by srapolu on 8/2/17.
 */
public class GlassDoorInfoReadAutomator {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--window-size=1920,1080");
        System.setProperty("webdriver.chrome.driver", "/Users/srapolu/Documents/Work/LocalSetup/IntelliJWS/AutoWebInfoExtractor/src/main/resources/chromedriver");
        WebDriver chromeDriver = new ChromeDriver(chromeOptions);


        //open webpage
        chromeDriver.get("https://www.glassdoor.com/index.htm");
        Thread.sleep(2000);

        //SignIn Element
        chromeDriver.findElement(By.xpath("//*[@id=\"TopNav\"]/nav/div[2]/ul[3]/li[2]/a")).click();
        Thread.sleep(2000);

        //Enter email id and password
        WebElement signInEmailId = chromeDriver.findElement(By.xpath("//*[@id=\"signInUsername\"]"));
        signInEmailId.sendKeys("sri803@yahoo.com");
        WebElement signInPassword = chromeDriver.findElement(By.xpath("//*[@id=\"signInPassword\"]"));
        signInPassword.sendKeys("Test123$");
        WebElement signInButton = chromeDriver.findElement(By.xpath("//*[@id=\"signInBtn\"]/span"));
        signInButton.click();
        Thread.sleep(2000);

        //Click on Company Reviews link
        WebElement companyReviews = chromeDriver.findElement(By.xpath("//*[@id=\"TopNav\"]/nav/div[2]/ul[2]/li[3]/a"));
        companyReviews.click();
        Thread.sleep(5000);

        //Enter company name
        WebElement companyNameWebElement = chromeDriver.findElement(By.xpath("//*[@id=\"KeywordSearch\"]"));
        if (chromeDriver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) chromeDriver).executeScript("document.getElementById('HeroSearchButton').setAttribute('target', '_self');");
        }
        String companyName = "Accela";
        companyNameWebElement.sendKeys(companyName);

        WebElement searchButton = chromeDriver.findElement(By.xpath("//*[@id=\"HeroSearchButton\"]"));
        searchButton.click();

        /*
        Actions builder = new Actions(chromeDriver);
        builder.moveToElement(searchButton).click(searchButton);
        builder.perform();
        */

        /*
        WebDriverWait wait = new WebDriverWait(chromeDriver, 15, 100);
        WebElement myElement = wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        myElement.sendKeys(Keys.ENTER);
        */

        ArrayList<String> tabs2 = new ArrayList<String>(chromeDriver.getWindowHandles());
        chromeDriver.switchTo().window(tabs2.get(1));


        WebElement numberOfReviewsWebElement = chromeDriver.findElement(By.xpath("//*[@id=\"MainCol\"]/div[1]/div[2]/div[2]/a[1]/span[1]"));
        String numberOfReviews = numberOfReviewsWebElement.getText();

        WebElement numberOfReviewsWebElementClickable = chromeDriver.findElement(By.xpath("//*[@id=\"MainCol\"]/div[1]/div[2]/div[2]/a[1]"));
        numberOfReviewsWebElementClickable.click();

        Thread.sleep(2000);

        WebElement overallRatingWebElement = chromeDriver.findElement(By.xpath("//*[@id=\"EmpStats\"]/div/div[1]/div[1]"));
        String overallRating = overallRatingWebElement.getText();

        Thread.sleep(1000);
        /*WebElement recommendAFirendRatingWebElement = chromeDriver.findElement(By.xpath("//*[@id=\"EmpStats_Recommend\"]/svg/text"));
        String recommendAFirendRating= recommendAFirendRatingWebElement.getText();*/

        WebElement ratingTrendsWebElement = chromeDriver.findElement(By.xpath("//*[@id=\"EmpStats\"]/div/div[1]/div[2]/span[5]"));
        ratingTrendsWebElement.click();

       /* WebElement div = chromeDriver.findElement(By.xpath("/html/body/div[2]/div/div[1]"));
        div.getLocation();

        WebElement clickableLinkOnPopup = chromeDriver.findElement(By.xpath("//*[@id=\"DonutRatings\"]/div[1]/span"));
        System.out.println(clickableLinkOnPopup.getText());
        Thread.sleep(1000);
        */

         WebElement svg = chromeDriver.findElement(By.xpath("//*[@id=\"Recommend\"]"));
        System.out.println("test");



        /*
        WebElement recommendAFriendRatingWebElement =  chromeDriver.findElement(By.xpath("//*[@id=\"highcharts-60\"]/svg/text/tspan"));//*[@id="highcharts-60"]/svg/text/tspan
        String recommendAFriendRating = recommendAFriendRatingWebElement.getText(); //*[@id="highcharts-60"]/svg/text/tspan
        System.out.println(recommendAFriendRatingWebElement.getLocation());
                //recommendAFriendRatingWebElement.getAttribute("data-percentage");

        WebElement ceoApprovalRatingWebElement = chromeDriver.findElement(By.xpath("//*[@id=\"EmpStats_Approve\"]"));
        String ceoApprovalRating = ceoApprovalRatingWebElement.getAttribute("data-percentage");


        WebElement positiveOutlookRatingWebElement = chromeDriver.findElement(By.xpath(""));
        String positiveOutlookRating = positiveOutlookRatingWebElement.getText();



        System.out.println("Company Name:"+ "  " +"Reviews"+ "  " +"Overall Rating"+ "  " +"Recommend a Friend%"+ "  " +
                "CEO Approval %"+ "  " +"Positive Outlook");
        System.out.println(companyName+ "  " +numberOfReviews+ "  " +overallRating+ "  " +recommendAFriendRating +
                "  " + ceoApprovalRating+ "  ");
        */
    }
}
//*[@id="sc.keyword"]
//Company Name, Reviews#, Overall Rating, Recommend a Friend%, CEO Approval %, Positive Outlook %