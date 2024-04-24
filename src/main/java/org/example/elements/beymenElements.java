package org.example.elements;

import org.openqa.selenium.By;

public class beymenElements {

    public static final By mainPageSearchBox = By.id("o-searchSuggestion__input");
    public static final By clickSearchBox = By.xpath("//input[@class='o-header__search--input']");
    public static final By cookies = By.id("onetrust-accept-btn-handler");
    public static final By resultItemList = By.className("m-productImageList__item");
    public static final By chooseSize = By.cssSelector("#sizes .m-variation__item:not([class*='-disabled'])");
    public static final By addToCard = By.id("addBasket");
    public static final By goToCard = By.xpath("//button[@class='m-notification__button btn']");
    public static final By itemInfo = By.xpath("//strong[@class='m-basket__productInfoCategory']");
    public static final By resultItemListPrice = By.xpath("//ins[@id='priceNew']");
    public static final By cardItemPrice = By.cssSelector(".priceBox__salePrice");
    public static final By clickItemQuantity =By.id("quantitySelect0-key-0");
    public static final By increaseItem = By.cssSelector("option[value='2']");
    public static final By deleteToCard = By.id("removeCartItemBtn0-key-0");


}
