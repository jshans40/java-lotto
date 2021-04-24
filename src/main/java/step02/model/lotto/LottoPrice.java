package step02.model.lotto;

import step02.model.rank.Rank;
import step02.model.rank.Ranks;
import step02.utils.Validation;

import static step02.utils.LottoConfig.*;

public class LottoPrice {
    private final int buyPrice;

    public LottoPrice(int price) {
        Validation.checkMinPrice(price);
        this.buyPrice = price;
    }

    public int calculationCount() {
        return buyPrice / LOTTO_PRICE;
    }

    public static double calculateTotalReward(LottoPrice price, Ranks ranks) {
        int totalReward = 0;
        totalReward += Rank.calculate(Rank.FIRST, ranks.getNumberOfEachRank(Rank.FIRST));
        totalReward += Rank.calculate(Rank.SECOND, ranks.getNumberOfEachRank(Rank.SECOND));
        totalReward += Rank.calculate(Rank.THIRD, ranks.getNumberOfEachRank(Rank.THIRD));
        totalReward += Rank.calculate(Rank.FOURTH, ranks.getNumberOfEachRank(Rank.FOURTH));

        return calculateYield(price.buyPrice, totalReward);
    }

    private static double calculateYield(int price, int totalReward) {
        return Math.round((totalReward / (double) price) * ONE_HUNDRED) / ONE_HUNDRED_D;
    }

}