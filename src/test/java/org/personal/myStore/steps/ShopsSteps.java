package org.personal.myStore.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.personal.myStore.core.pages.BestSellersPage;
import org.personal.myStore.core.pages.CartSummaryPage;
import org.personal.myStore.core.pages.IndexPage;
import org.personal.myStore.core.pages.ItemAddedPage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class ShopsSteps {
    private IndexPage shopPage;
    private BestSellersPage bestSellersPage;
    private ItemAddedPage itemAddedPage;
    private CartSummaryPage cartSummaryPage;

    public ShopsSteps(IndexPage shopPage, BestSellersPage bestSellersPage) {
        this.shopPage = shopPage;
        this.bestSellersPage = bestSellersPage;
    }

    @When("I select the best sellers option")
    public void iSelectTheBestSellersOption() {
        bestSellersPage = shopPage.clickOnBestSellerOption();
    }

    @Then("The {string} should be has {string}% of discount")
    public void theShouldBeHasOfDiscount(String articleName, String discountPercentage) {
        Assert.assertEquals(bestSellersPage.getArticle(articleName).getText(), articleName);
        Assert.assertEquals(bestSellersPage.getPriceReduction(articleName), discountPercentage);
    }

    @When("I add {string} to the cart")
    public void iAddToTheCart(String articleName) {
        itemAddedPage = bestSellersPage.clickOnAddToCart(articleName);
    }

    @And("I select {string}")
    public void iSelectContinueShopping(String option) {
        shopPage = itemAddedPage.clickOnOption(option);
    }

    @Then("The selected items should be displayed in the summary table with availability display {string}")
    public void theSelectedItemsShouldBeDisplayedInTheSummaryTableWithAvailabilityDisplay(String itemStatus, List<String> elements) {
        SoftAssert softAssert = new SoftAssert();
        for (String item :
                elements) {
            softAssert.assertEquals(cartSummaryPage.getAvailableValue(item), itemStatus,
                    String.format("The %s item is not available", item));
        }
        softAssert.assertAll();
    }

    @And("I select {string} from cart dropdown")
    public void iSelectFromDropdown(String option) {
        cartSummaryPage = shopPage.SelectFromCart(option);
    }

    @When("I remove the {string} from the cart")
    public void iRemoveTheFromTheCart(String itemName) {
        cartSummaryPage = cartSummaryPage.removeItem(itemName);
    }

    @Then("The {string} item should not be longer displayed in the summary table")
    public void theItemShouldNotBeLongerDisplayedInTheSummaryTable(String itemName) {
        Assert.assertTrue(!cartSummaryPage.doesItemExist(itemName));
    }

    @And("The total amount to pay should be ${string}")
    public void theTotalAmountToPayShouldBe$(String totalPay) {
        Assert.assertEquals(cartSummaryPage.getTotalPay(), totalPay, "The total pay is not than expected");
    }
}
