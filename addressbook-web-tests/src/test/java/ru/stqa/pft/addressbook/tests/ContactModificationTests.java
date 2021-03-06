package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test(enabled = false)
  public void testContactCreation() {
    app.goTo().homePage();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("tst_name", "test_surname", null), false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();

  }
}
