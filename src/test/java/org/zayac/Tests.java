package org.zayac;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class Tests {

    @BeforeAll
    static void BeforeAll() {
        Configuration.holdBrowserOpen = false;
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void testGit () {
        open("https://github.com");
        $(".list-style-none").$(byText("Solutions")).hover();
        $(byText("Enterprise")).click();
        $(".application-main").shouldBe(visible).shouldHave(text("Build like the best"));
    }

    @Test
    void testDrags () {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDropTo("#column-b");
        $("#column-a").shouldHave(text("B"));
    }
}

