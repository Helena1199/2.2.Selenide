package ru.netology.selenide;


import com.codeborne.selenide.Browser;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class TestCardDelivery {
    private String generateDate(int addDays, String pattern) {
        return LocalDate.now().plusDays(addDays).format(DateTimeFormatter.ofPattern(pattern));
    }

    @Test
    <gradlew>
    void shouldTestVPositive() {
        Configuration.headless = true;
        open("http://localhost:9999");
        $("span[data-test-id=city] input").setValue("Москва");
        String currentDate = generateDate(3, "dd.MM.yyyy");
        $("span[data-test-id=date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("span[data-test-id=date] input").sendKeys(currentDate);
        $("span[data-test-id=name] input").setValue("Василий");
        $("span[data-test-id=phone] input").setValue("+79012345678");
        $("[data-test-id=agreement]").click();
        $$("button").find(exactText("Забронировать")).click();
        $x("//div[contains(text(), 'Встреча успешно забронирована на ')]").shouldBe(visible, Duration.ofSeconds(15));
    }
}