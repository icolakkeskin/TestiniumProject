package org.example.base;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

public class BasePage {

    private static Logger logger= LogManager.getLogger(BasePage.class);
    List<String> listOfAllWebElements = new ArrayList<String>();

    WebDriver driver=null;
    WebDriverWait wait=null;

    public BasePage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver,60);
    }
    public WebElement findElement(By by){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return driver.findElement(by);
    }
    public void click(By by){
        wait.until(ExpectedConditions.elementToBeClickable(by));
        findElement(by).click();
    } 
    public void sendKeys(By by,String text){
        findElement(by).sendKeys(text);
        logger.info(text + " keyi gönderildi");
    }
    public void urlAssertions() throws Exception{
        String url="https://www.beymen.com/";
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String strUrl= driver.getCurrentUrl();
        logger.info("current"+ strUrl);
        assertEquals(url,strUrl);
    }
    public void clickEnter(){
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.ENTER).build().perform();
    }


    public void randomClick(By by){
        List<WebElement> links=driver.findElements(by);
        WebElement random=links.get(new Random().nextInt(links.size()));
        random.click();
    }
    public void waitSecond(){
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    }

    public void waitBySecond(long seconds) {
        try {
            Thread.sleep(seconds*1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info(seconds + "saniye beklendi");
    }
    public void addListElement(By by){
        listOfAllWebElements.add(driver.findElement(by).getText());
    }

    public void compareQuantity(By by) {

        String element = driver.findElement(by).getText();
        String quantity= "2 adet";
        boolean result = element.contains(quantity);
        if (result){
            logger.info("2 adet ürün var");
        }
        else {
            logger.info("2 adet ürün seçilmedi");
        }

    }
    public void checkItems(){
        assertEquals(listOfAllWebElements.get(0),listOfAllWebElements.get(1));
        logger.info(listOfAllWebElements.get(0));
        logger.info(listOfAllWebElements.get(1));
        logger.info(listOfAllWebElements.get(0) + listOfAllWebElements.get(1) + "birbirine eşittir");
    }

    public void clearElement(By by) {

        findElement(by).clear();
    }

public void sendToItemTxt(By by, String filePath){
    String elementText = driver.findElement(by).getText();
    try (FileWriter writer = new FileWriter(filePath)) {

        writer.write(elementText);
        System.out.println("Element text successfully written to file: " + filePath);
    } catch (IOException e) {

        System.err.println("An error occurred while writing to the file: " + e.getMessage());
    }
   }

   public void readExcel(By by) {

       String excelFilePath = "C:\\Users\\icola\\IdeaProjects\\TestiniumProject\\src\\main\\resources\\Excel\\items.xlsx";

       FileInputStream excelFile = null;
       Workbook workbook = null;

       try {
           excelFile = new FileInputStream(excelFilePath);
           workbook = new XSSFWorkbook(excelFile);

           Sheet sheet = workbook.getSheetAt(0);

           for (Row row : sheet) {

               for (Cell cell : row) {

                   WebElement element = driver.findElement(by);

                   element.clear();

                   element.sendKeys(cell.getStringCellValue());

                   System.out.print(cell.getStringCellValue() + "\t");
               }
               System.out.println();
           }
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       } finally {

           if (workbook != null) {
               try {
                   workbook.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
           if (excelFile != null) {
               try {
                   excelFile.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
       }
   }
   }




