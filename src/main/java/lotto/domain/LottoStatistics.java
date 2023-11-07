package lotto.domain;

import lotto.constant.LottoRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

public class LottoStatistics {

    private final EnumMap<LottoRank, Integer> statistics;

    public LottoStatistics(LottoPack lottoPack, Result result) {

        statistics = new EnumMap<>(LottoRank.class);
        Arrays.stream(LottoRank.values())
                .forEach(lottoRank -> statistics.put(lottoRank, 0));

        lottoPack.calculate(result)
                .forEach(rank -> statistics.put(rank, statistics.get(rank) + 1));

    }

    @Override
    public String toString() {

        List<String> response = new ArrayList<>();

        statistics.entrySet().stream()
                .filter(pair -> pair.getKey() != LottoRank.NOTHING)
                .forEach(pair -> response.add(buildLine(pair.getKey(), pair.getValue())));

        return String.join("\n", response);

    }

    private String buildLine(LottoRank rank, Integer count) {
        return rank.toString() + String.format(" - %d개", count);
    }

    public int calculateIncome() {
        return statistics.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

}
