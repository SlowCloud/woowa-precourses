package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.function.Supplier;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {

        LottoPack lottoPack = buyLottoPack();
        outputView.newline();
        WinningNumbers winningNumbers = loop(this::getWinningNumbers);
        outputView.newline();
        WinningNumber bonusNumber = loop(this::getBonusNumber);
        outputView.newline();

        Result result = lottoPack.calculate(winningNumbers, bonusNumber);
        outputView.printResult(result);

        IncomeRate incomeRate = new IncomeRate(lottoPack.getPrice(), result.getIncome());
        outputView.printIncomeRate(incomeRate);

    }

    private LottoPack buyLottoPack() {
        Money money = loop(this::getMoney);
        outputView.newline();
        LottoPack lottoPack = LottoPack.createLottoPack(money.count());
        outputView.printLottoPack(lottoPack);
        return lottoPack;
    }

    private <T> T loop(Supplier<T> function) {
        while (true) {
            try {
                return function.get();
            } catch (IllegalArgumentException e) {
                outputView.printException(e);
            }
        }
    }

    private Money getMoney() {
        outputView.printGetMoney();
        return new Money(inputView.getNumber());
    }

    private WinningNumbers getWinningNumbers() {
        outputView.printGetWinningNumbers();
        return WinningNumbers.createWinningNumbers(inputView.getNumbers());
    }

    private WinningNumber getBonusNumber() {
        outputView.printGetBonusNumber();
        return new WinningNumber(inputView.getNumber());
    }

}
