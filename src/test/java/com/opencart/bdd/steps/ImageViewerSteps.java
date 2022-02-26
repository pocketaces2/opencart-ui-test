package com.opencart.bdd.steps;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


import com.opencart.bdd.pageObjects.HomePage;
import com.opencart.bdd.pageObjects.ProductPage;
import com.opencart.bdd.pageObjects.SearchResultsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class ImageViewerSteps {

    SetupSteps setupSteps;
    WebDriver driver;

    public ImageViewerSteps(SetupSteps setupSteps){
        this.setupSteps = setupSteps;
        this.driver = setupSteps.getDriver();
    }


    @Given("^I search for a (.*) product$")
    public void searchProduct(String product) {
        HomePage homePage = new HomePage(driver).get();
        homePage.setSearchBarText(product);
        homePage.clickSearchBtn();
    }

    @Given("^I click on the first search result$")
    public void clickFirstResult(){
        var searchResultsPage = new SearchResultsPage(driver).get();
        searchResultsPage.clickFirstSearchResult();
    }

    @When("^I click on the product image$")
    public void enlargeProductImage() {
        var productPage = new ProductPage(driver).get();
        productPage.clickPrimaryImageThumbNail();
    }

    @Then("^The product image is enlarged on screen$")
    public void checkProductImageEnlarged() {
        var productPage = new ProductPage(driver).get();
        assertThat("product image is not enlarged on the screen",productPage.enlargedImageIsPresent());
    }

    @Then("^I can scroll through (.*) images$")
    public void scrollThroughImages(int numOfImages) {
        var productPage = new ProductPage(driver).get();

        for(int i = 1; i < numOfImages + 1; i++){
            assertThat("Image number does not match expected image counter displayed on page", productPage.getEnlargedImageCount(), equalTo(i));
            productPage.scrollToNextEnlargedImageByRightArrow();
        }

    }

}
