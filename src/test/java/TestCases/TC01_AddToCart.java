package TestCases;

import Pages.P01_HomePage;
import Pages.P02_SearchResultPage;
import Pages.P03_ProductPage;
import Pages.P04_Cart;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static Util.Utility.getSingleJsonData;
import static Util.Utility.returnDataPath;

public class TC01_AddToCart extends TestBase {

    String searchedItem = getSingleJsonData(returnDataPath("searchForItem.json"), "itemName");
    String itemNumber = getSingleJsonData(returnDataPath("searchForItem.json"), "itemNumber");

    public TC01_AddToCart() throws IOException, ParseException {
    }


    @Test(priority = 1, description = "check that i can add an item in the cart")
    public void addItemToCart_P() {

        new P01_HomePage(driver).searchInSearchBar(searchedItem);
        new P02_SearchResultPage(driver).selectItemByNumber(itemNumber);
        softAssert.assertTrue(new P03_ProductPage(driver).imageAppear(), "Image is not displayed.");

        new P03_ProductPage(driver).clickOnAddToCart().openMyCart();
        Assert.assertTrue(new P04_Cart(driver).cartAppear());


    }
}
