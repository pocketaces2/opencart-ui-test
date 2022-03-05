package com.opencart.bdd.steps;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


import com.opencart.bdd.context.TestContext;
import com.opencart.bdd.pageObjects.ProductPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ImageViewerSteps {

    TestContext testContext;
    ProductPage productPage;


    public ImageViewerSteps(TestContext testContext){
        this.testContext = testContext;
        productPage = testContext.getPageObjectManager().getProductPage();
    }

    @When("^I click on the product image$")
    public void enlargeProductImage() {
        productPage.get().clickPrimaryImageThumbNail();
    }

    @Then("^The product image is enlarged on screen$")
    public void checkProductImageEnlarged() {
        assertThat("product image is not enlarged on the screen",productPage.enlargedImageIsPresent());
    }

    @Then("^I can scroll through (.*) images$")
    public void scrollThroughImages(int numOfImages) {

        for(int i = 1; i < numOfImages + 1; i++){
            assertThat("Image number does not match expected image counter displayed on page", productPage.getEnlargedImageCount(), equalTo(i));
            productPage.get().scrollToNextEnlargedImageByRightArrow();
        }

    }

}
