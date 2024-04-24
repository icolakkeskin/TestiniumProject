package org.example.pages;


import org.example.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.example.elements.beymenElements.*;

public class beymenPages extends BasePage {

    public beymenPages(WebDriver driver){
        super(driver);
    }
    public beymenPages checkAnasayfa() throws Exception {
        urlAssertions();
        return this;
    }

    public beymenPages clickAccaptedCookies() {
        click(cookies);
        return this;
    }
    public beymenPages clickSearcBox(){
        click(clickSearchBox);
        return this;
    }

    public beymenPages waitASecond(){
        waitBySecond(2);
        return this;
    }

    public beymenPages importExcel(){
        readExcel(mainPageSearchBox);
        return this;
    }
    public beymenPages clickEnterKey(){
        clickEnter();
        return this;
    }

    public beymenPages randomClickItem(){
        randomClick(resultItemList);
        return this;
    }

    public beymenPages randomClickSize(){
        randomClick(chooseSize);
        return this;
    }

    public beymenPages SendToCard(){
        click(addToCard);
        return this;
    }

    public beymenPages goToBasket(){
        click(goToCard);
        return this;
    }

    public beymenPages exportToItemTxt(){
        sendToItemTxt(itemInfo,"C:\\Users\\icola\\IdeaProjects\\TestiniumProject\\src\\main\\resources\\Texts\\testinium.txt");
        return this;
    }

    public beymenPages addListFirstItem(){
        addListElement(resultItemListPrice);
        return this;
    }

    public beymenPages addListSecondItem(){
        addListElement(cardItemPrice);
        return this;
    }

    public beymenPages compareElements(){
        checkItems ();
        return this;
    }

    public beymenPages clickItemDropDown(){
        click(clickItemQuantity);
        return this;
    }

    public beymenPages chooseNewQuantity(){
        click(increaseItem);
        return this;
    }

    public beymenPages compareNewQuantity(){
        compareQuantity(clickItemQuantity);
        return this;
    }

    public beymenPages deleteToBasket(){
        click(deleteToCard);
        return this;
    }
}
