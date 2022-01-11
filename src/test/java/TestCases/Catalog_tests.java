package TestCases;

import PageFactory.dodax.categoriesPageFactory;
import PageFactory.dodax.homepagePageFactory;
import base.baseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.ParseException;

public class Catalog_tests extends baseClass {

    @Test(priority = 1)
    public void catalogPageListView() throws ParseException {
        homepagePageFactory homepagePF = new homepagePageFactory(driver);
        categoriesPageFactory catPF = new categoriesPageFactory(driver);

        homepagePF.openCategoryAll();
        catPF.clickComputers();


        catPF.clickListView();
        Assert.assertTrue(catPF.isListViewSelected());
        Assert.assertTrue(catPF.dropdownSelect());



        homepagePF.openCategory();
        homepagePF.clickBackToAllcat();
        homepagePF.test2();

        catPF.clickClothes();
        Assert.assertTrue(catPF.dropdownSelect());
        homepagePF.openCategory();
        homepagePF.clickBackToAllcat();
        homepagePF.test2();

        catPF.clickBabyNChild();

        Assert.assertTrue(catPF.dropdownSelect());


        //System.out.println(catPF.isListViewSelected());
        // problemi so lokatori, ne vrakja dobro za isSelected i isDisplayed
        // koristeni lokatori [class="c-viewSwitch__button js-c-viewSwitch__button--list btn-reset c-viewSwitch__button--activeView"]
        // [data-qa="searchResultPageGridViewIcon"]
        // [data-qa="searchResultPageListViewIcon"]

        // [class=\"c-viewSwitch__icon icon-list-view\"]"


    }

    @Test(priority = 0)
    public void checkPagination() {
        homepagePageFactory homepagePF = new homepagePageFactory(driver);
        categoriesPageFactory catPF = new categoriesPageFactory(driver);


        homepagePF.searchBoxText("book");
        homepagePF.pressEnterSearhBox();
        homepagePF.moveToBottom();
        catPF.checkPaginationNumber();

    }
}
