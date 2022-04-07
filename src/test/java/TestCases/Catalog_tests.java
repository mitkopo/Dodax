package TestCases;

import PageFactory.dodax.categoriesPageFactory;
import PageFactory.dodax.homepagePageFactory;
import base.baseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.ParseException;

public class Catalog_tests extends baseClass {


    @Test(priority = 1, groups = {"noLogin"})
    public void catalogPageListView() throws ParseException {
        homepagePageFactory homepagePF = new homepagePageFactory(driver);
        categoriesPageFactory catPF = new categoriesPageFactory(driver);

        homepagePF.openCategoryAll();
        catPF.clickComputers();
        catPF.clickListView();
        catPF.waitForPagination();
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



    }

    @Test(priority = 0, groups = {"noLogin"})
    public void checkPagination() {
        homepagePageFactory homepagePF = new homepagePageFactory(driver);
        categoriesPageFactory catPF = new categoriesPageFactory(driver);


        homepagePF.searchBoxText("book");
        homepagePF.pressEnterSearhBox();
        catPF.checkPagination();

    }

}
