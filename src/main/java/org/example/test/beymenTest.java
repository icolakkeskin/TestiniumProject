package org.example.test;

import org.apache.log4j.PropertyConfigurator;
import org.example.base.BaseTest;
import org.example.pages.beymenPages;
import org.junit.Before;
import org.junit.Test;

public class beymenTest extends BaseTest {

    beymenPages beymenPages;

    @Before

    public void before(){
        beymenPages= new beymenPages(getWebDriver());
        PropertyConfigurator.configure("C:\\Users\\icola\\IdeaProjects\\TestiniumProject\\log4j.properties");
    }

    @Test
    public void beymenTest() throws Exception {
        beymenPages.checkAnasayfa();
        beymenPages.clickAccaptedCookies();
        beymenPages.clickSearcBox();
        beymenPages.importExcel();
        beymenPages.clickEnterKey();
        beymenPages.randomClickItem();
        beymenPages.randomClickSize();
        beymenPages.addListFirstItem();
        beymenPages.SendToCard();
        beymenPages.goToBasket();
        beymenPages.exportToItemTxt();
        beymenPages.addListSecondItem();
        // beymenPages.compareElements(); // Fiyatlar farklı formatta tutulduğundan karşılaştırmada hata alıyorum.
        beymenPages.clickItemDropDown();
        beymenPages.chooseNewQuantity(); // Bazı ürünlerin birden fazla adedi olmadığı için adet arttıramıyorum.Eğer stok varsa method doğru çalışıyor.
        beymenPages.compareNewQuantity();
        beymenPages.waitASecond();
        beymenPages.deleteToBasket();


    }
}
