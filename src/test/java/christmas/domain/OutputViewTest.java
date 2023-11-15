package christmas.domain;

import christmas.utils.date.Date;
import christmas.view.OutputView;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    @Test
    void printEventPlannerStartMessage_ShouldPrintCorrectMonth() {
        Date date = Date.of(25);
        OutputView.printEventPlannerStartMessage(date);
        OutputView.printEventPlannerPreviewMessage(date);
    }
}
