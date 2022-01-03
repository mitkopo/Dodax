package TestCases;

import PageFactory.dodax.categoriesPageFactory;
import PageFactory.dodax.homepagePageFactory;
import base.baseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Catalog_tests extends baseClass {

    @Test
    public void catalogPageListView() throws InterruptedException {
        homepagePageFactory homepagePF = new homepagePageFactory(driver);
        categoriesPageFactory catPF = new categoriesPageFactory(driver);

        homepagePF.openCategoryAll();
        catPF.clickComputers();
        Thread.sleep(3000);
        catPF.clickListView();
        Assert.assertTrue(catPF.dropdownSelect());

        Thread.sleep(3000);

        homepagePF.openCategory();
        homepagePF.clickBackToAllcat();
        homepagePF.test2();
        Thread.sleep(3000);
        catPF.clickClothes();
        Assert.assertTrue(catPF.dropdownSelect());
        homepagePF.openCategory();
        homepagePF.clickBackToAllcat();
        homepagePF.test2();
        Thread.sleep(3000);
        catPF.clickBabyNChild();
        Thread.sleep(3000);
        Assert.assertTrue(catPF.dropdownSelect());


        //System.out.println(catPF.isListViewSelected());
        // problemi so lokatori, ne vrakja dobro za isSelected i isDisplayed
        // koristeni lokatori [class="c-viewSwitch__button js-c-viewSwitch__button--list btn-reset c-viewSwitch__button--activeView"]
        // [data-qa="searchResultPageGridViewIcon"]
        // [data-qa="searchResultPageListViewIcon"]
        // [class=\"c-viewSwitch__icon icon-list-view\"]"


    }

    @Test
    public void checkPagination() {
        homepagePageFactory homepagePF = new homepagePageFactory(driver);
        categoriesPageFactory catPF = new categoriesPageFactory(driver);

        homepagePF.clickCookiesPF();
        homepagePF.searchBoxText("book");
        homepagePF.pressEnterSearhBox();
        homepagePF.moveToBottom();
        Assert.assertTrue(catPF.checkPaginationNumber());

    }
}
