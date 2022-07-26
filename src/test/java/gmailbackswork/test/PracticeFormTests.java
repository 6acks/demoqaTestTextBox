package gmailbackswork.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class PracticeFormTests {
    @BeforeAll
    static void setUp(){
        Configuration.baseUrl="https://demoqa.com";
        Configuration.browserSize= "1920x1080";
    }
    @Test
    void fillpracticeFormTests(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

//        $("[alt='adplus-dvertising']").click(); // Minimize ad

        $("[id=firstName]").setValue("Vlad");
        $("[id=lastName]").setValue("Zhur");
        $("[id=userEmail]").setValue("mail@mail.ru");
        $("#genterWrapper").$(byText("Other")).click();
        //$("#gender-radio-3").parent().click();
        //$("label[for=gender-radio-3]").click();
        //$(byText("Other")).click(); //Bad practice

        $("[id=userNumber]").setValue("8005553535");
        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2008");
//        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
//        $$(".react-datepicker__day--030").filter(not(cssClass(".react-datepicker__day--outside-month")))
//                .first()// or  .get(0)
//                .click();
//        $("[aria-label='Choose Wednesday, July 30th, 2008']");
//        $x("//*[contains(@aria-label,'July 30th, 2008']").click();
//        $("[aria-label$='July 30th, 2008']").click(); //Ends with July 30th, 2008
        $("[aria-label*='July 30th, 2008']").click(); //contains July 30th, 2008
        //<div class=" react-datepicker__day--030 react-datepicker__day--outside-month" aria-label="Choose Monday, June 30th, 2008"
        //<div class=" react-datepicker__day--030"                                      aria-label="Choose Wednesday, July 30th, 2008"

        $("[id=subjectsInput]").setValue("Math").pressEnter();

//        $("#subjectsInput").setValue("Math"); //todo not working
//        $("#subjectsWrapper").$(byText("Math")).click();

        $("#hobbiesWrapper").$(byText("Sports")).click();

//        $("#uploadPicture").uploadFile(new File("src/test/resources/img/hello.png"));

//        File someFile = new File("src/test/resources/img/hello.png")
//        $("#uploadPicture").uploadFile(new File("src/test/resources/img/hello.png"));

        $("#uploadPicture").uploadFromClasspath("img/hello.png");


        $("[id=currentAddress]").setValue("Tomsk");

        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText("NCR")).click();

        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();

        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Vlad Zhur"));
//        $(".table-responsive").$(byText("Student Name")).sibling(0).shouldHave(text("Vlad Zhur"));  //Example
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("mail@mail.ru"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Other"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("8005553535"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("30 July,2008"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Maths"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("hello.png"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Tomsk"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Noida"));
    }
}
