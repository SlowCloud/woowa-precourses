package lotto.view;

import lotto.domain.LottoPack;
import lotto.domain.Result;
import lotto.util.Printer.IPrinter;

import static lotto.constant.OutputMessage.*;

public class OutputView {

    private final IPrinter printer;

    public OutputView(IPrinter printer) {
        this.printer = printer;
    }

    public void printGetMoney() {
        printer.println(GET_MONEY_MESSAGE.getMessage());
    }

    public void newline() {
        printer.println();
    }

    public void printLottoPack(LottoPack lottoPack) {
        printer.println(buildLottoPackMessage(lottoPack));
        printer.println(lottoPack.toString());
    }

    private String buildLottoPackMessage(LottoPack lottoPack) {
        return String.format(BOUGHT_LOTTO_PACK.getMessage(), lottoPack.size());
    }

    public void printGetWinningNumbers() {
        printer.println(GET_WINNING_NUMBERS.getMessage());
    }

    public void printGetBonusNumber() {
        printer.println(GET_BONUS_NUMBER.getMessage());
    }

    public void printResult(Result result) {
        printer.println(result.toString());
    }

    public void printException(Exception exception) {
        printer.println(exception.getMessage());
    }

}
