package docs;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CssXpathExamples {

    void cssXpathExamples() {

        //group: https://t.me/xpath_help
        //hints: https://devhints.io/xpath

        // <input type="email" class="inputtext login_form_input_box" name="email" id="email" data-testid="royal_email">
        $("[data-testid=\"royal_email\"]").setValue("some@user.ru");
        $(by("data-testid", "royal_email")).setValue("some@user.ru");


        // <input type="email" class="inputtext login_form_input_box" name="email" id="email">
        $("[id=\"email\"]").setValue("some@user.ru");
        $("[id='email']").setValue("some@user.ru");
        $("[id=email]").setValue("some@user.ru");
        $("#email").setValue("some@user.ru");                // <- best off the best. "#" - for id.
        $(byId("#email")).setValue("some@user.ru");
        $("input[id=email]").setValue("some@user.ru");
        $("input#id=email").setValue("some@user.ru");
        $(by("id","email")).setValue("some@user.ru");
        //xpath
        $x("//input[@id='email']").setValue("some@user.ru");
        $x("//*[@name='email']").setValue("some@user.ru");
        $(byXpath("//*[@name='email']")).setValue("some@user.ru");


        // <input type="email" class="inputtext login_form_input_box" name="email">
        $("[name='email']").setValue("some@user.ru");
        $("input[name='email']").setValue("some@user.ru");
        $(by("name","email")).setValue("some@user.ru");
        $(byName("email")).setValue("some@user.ru");                // <- best off the best


        // <input type="email" class="inputtext login_form_input_box">
        $(byClassName("login_form_input_box")).setValue("some@user.ru");
        $(".login_form_input_box").setValue("some@user.ru"); // <- best off the best. "." - for - class.
        $("input.inputtext.login_form_input_box").setValue("some@user.ru");
        $("input.inputtext.login_form_input_box[type='email']").setValue("some@user.ru");
        //xpath
        $x("//*[@class='login_form_input_box']").setValue("some@user.ru");


        // <div type="email" class="inputtext">
        //      <input class='login_form_input_box">
        // </div>
        $("input. inputtext.login_form_input_box").setValue("some@user.ru");
        $("input. inputtext").$("login_form_input_box").setValue("some@user.ru");
        $("input. inputtext").find("login_form_input_box").setValue("some@user.ru");
    }
}
