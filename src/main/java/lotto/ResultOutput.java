package lotto;

import java.util.Map;

public class ResultOutput {

    private Map<Rank, Integer> statisticResult;
    private double profitRate;

    public void printResult() {

        System.out.println("당첨 통계");
        System.out.println("---");

        statisticResult.entrySet().stream()
                .sorted((e1, e2) -> e2.getKey().getRank() - e1.getKey().getRank())
                .forEach(entry -> {
                    Rank rank = entry.getKey();
                    int count = entry.getValue();
                    String format = rank.isNeedsBonus()
                            ? "%d개 일치, 보너스 볼 일치 (%d원) - %d개%n"
                            : "%d개 일치 (%d원) - %d개%n";
                    System.out.printf(format, rank.getCount(), rank.getPrize(), count);
                });

        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }

    public ResultOutput(Map<Rank, Integer> statisticResult, double profitRate) {
        this.statisticResult = statisticResult;
        this.profitRate = profitRate;
    }
}