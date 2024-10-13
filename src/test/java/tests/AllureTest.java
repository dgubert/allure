package tests;

import helpers.IssuesPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class AllureTest extends BaseTest {
    private static final String issuesUrl = "/qa-guru/qa_guru_14_10/issues";
    private static final String issuesName = "Issue for Autotest";

    IssuesPage issuesPage = new IssuesPage();

    @Test
    @Feature("Allure Reports")
    @Story("Alllure Reports by Default")
    @Owner("Dima Petrov")
    @Severity(SeverityLevel.NORMAL)
    @Link(name = "TestRail", url = "http://testrail.spb.local?id=1")
    @DisplayName("Тест на проверку формирования Allure отчета c чистым Selenide")
    public void generateAllureReportTest() {
        open(issuesUrl);

        $("#repo-content-pjax-container").shouldHave(text(issuesName));
    }

    @Test
    @Feature("Allure Reports")
    @Story("Alllure Reports by Lambda")
    @Owner("Vasya Pupkin")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "TestRail", url = "http://testrail.spb.local?id=2")
    @DisplayName("Тест на проверку формирования Allure отчета с использованием лямбда-степов")
    public void generateAllureReportByLambdaTest() {
        step("Открываем страницу Issues репозитория", () -> {
            open(issuesUrl);
        });

        step("Проверяем наличие нужного Issue на странице", () -> {
            $("#repo-content-pjax-container").shouldHave(text(issuesName));
        });
    }

    @Test
    @Feature("Allure Reports")
    @Story("Alllure Reports by Steps")
    @Owner("Alla Grib")
    @Severity(SeverityLevel.BLOCKER)
    @Link(name = "TestRail", url = "http://testrail.spb.local?id=3")
    @DisplayName("Тест на проверку формирования Allure отчета с использованием степов")
    public void generateAllureReportByStepTest() {
        issuesPage.openIssuesPage("qa_guru_14_10");
        issuesPage.checkIssueIsPresent(issuesName);
    }
}
