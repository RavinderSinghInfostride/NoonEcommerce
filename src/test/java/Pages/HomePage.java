package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    List<WebElement> allRecommendedForYouItems;

    String recommendedForYouItems = "//div//h3[contains(text(),'Recommended for you')]//following::div[contains(@class,'sc-iqGgem')][1]//div[@class='swiper-wrapper']//div[contains(@class,'sc-d1b8c49c-0')]";
    //    String recommendedForYouItems = "//h3[contains(text(), 'Recommended for you')]//following::div[@class='sc-iqGgem dYEdOB'][1]//div[@class='sc-d1b8c49c-0 cQZZJh grid']";
    //String recommendedForYouItems = "//div[@class='sc-f8165ac8-15 bkbUJe']";
    By recommendedForYouCarouselArrow = By.xpath("(//div[contains(@class,'swiper-button-next')])[4]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void fetchRecommendedForYouItems() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0, 1050)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(recommendedForYouItems)));
//        while(true){
//            if(driver.findElement(By.xpath("//div//h3[contains(text(),'Recommended for you')]//following::div[contains(@class,'sc-iqGgem')][1]/div[contains(@class,'swiper-button-disabled')]")).isDisplayed()){
//                break;
//            }
//            driver.findElement(By.xpath("//div//h3[contains(text(),'Recommended for you')]//following::div[contains(@class,'sc-iqGgem')][1]/div[contains(@class,'swiper-button-next')]")).click();
//        }
        allRecommendedForYouItems = driver.findElements(By.xpath(recommendedForYouItems));
        int number = allRecommendedForYouItems.size();
        System.out.println(number);

        for (int i = 0; i <= number; i++) {
            String data = allRecommendedForYouItems.get(i).getText();
            System.out.println(data);
            Thread.sleep(3000);
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(recommendedForYouItems)));
            System.out.println(i);
            if (i % 5 == 0 && i != 0) {
                driver.findElement(recommendedForYouCarouselArrow).click();
                Thread.sleep(3000);
            }
        }
    }
}