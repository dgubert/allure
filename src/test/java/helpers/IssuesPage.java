package helpers;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class IssuesPage {

    @Step("Открываем страницу Issues репозитория {0}")
    public void openIssuesPage(String repoName) {
        open("/qa-guru/" + repoName + "/issues");
    }

    @Step("Проверяем наличие нужного Issue на странице")
    public void checkIssueIsPresent(String issueName) {
        $("#repo-content-pjax-container").shouldHave(text(issueName));
    }
}
