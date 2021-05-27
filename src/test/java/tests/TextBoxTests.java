package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void setUp() {
        Configuration.startMaximized = true;
    }

    @Test
    void successfulSubmitFormTest() {
        open("https://demoqa.com/text-box");

        $("[id=userName]").setValue("some user");
        $("[id=userEmail]").setValue("some@user.ru");
        $("[id=currentAddress]").setValue("some user address 74");
        $("[id=permanentAddress]").setValue("some user no i dont have");
        $("[id=submit]").click();

        $("[id=name]").shouldHave(text("Name:"), text("some user"));
        $("[id=email]").shouldHave(text("Email:"), text("some@user.ru"));
        $("[id=currentAddress]",1).shouldHave(
                text("Current Address :"), text("some user address 74"));
        $("p[id=permanentAddress]").shouldHave(
                text("Permananet Address :"), text("some user no i dont have"));
    }

    @Test
    void successfulSubmitFormWithVariablesTest() {
        String username = "some user";

        open("https://demoqa.com/text-box");

        $("[id=userName]").setValue(username);
        $("[id=userEmail]").setValue("some@user.ru");
        $("[id=currentAddress]").setValue("some user address 74");
        $("[id=permanentAddress]").setValue("some user no i dont have");
        $("[id=submit]").click();

        $("[id=name]").shouldHave(text("Name:"), text(username));
        $("[id=email]").shouldHave(text("Email:"), text("some@user.ru"));
        $("[id=currentAddress]",1).shouldHave(
                text("Current Address :"), text("some user address 74"));
        $("p[id=permanentAddress]").shouldHave(
                text("Permananet Address :"), text("some user no i dont have"));
    }

    @Test
    void successfulSubmitFormWithSeachOutputTest() {
        String username = "some user";

        open("https://demoqa.com/text-box");

        $("[id=userName]").setValue(username);
        $("[id=userEmail]").setValue("some@user.ru");
        $("[id=currentAddress]").setValue("some user address 74");
        $("[id=permanentAddress]").setValue("some user no i dont have");
        $("[id=submit]").click();

        $("[id=output]").shouldHave(text(username), text("some@user.ru"),
                text("some user address 74"), text("some user no i dont have"));
    }

    @Test
    void successfulSubmitFormWithSeachBadLocatorsTest() {
        String username = "some user";

        open("https://demoqa.com/text-box");

        $("[id=userName]").setValue(username);
        $("[placeholder=\"name@example.com\"]").setValue("some@user.ru");
        $("textarea").setValue("some user address 74");
        $(".form-control", 3).setValue("some user no i dont have");
        $(byText("Submit")).click();

        $("[id=output]").shouldHave(text(username), text("some@user.ru"),
                text("some user address 74"), text("some user no i dont have"));
    }
}
