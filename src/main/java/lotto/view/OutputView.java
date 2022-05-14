package lotto.view;

import lotto.domain.LottoNumbers;
import lotto.dto.LottoRankDto;
import lotto.dto.MatchRankDto;

import java.util.List;

public class OutputView {
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static final String LEFT_BRACKET = "[";
    private static final String RIGHT_BRACKET = "]";
    private static final String LEFT_PARENTHESIS = "(";
    private static final String RIGHT_PARENTHESIS = ")";
    private static final String DASH = " - ";
    private static final String SPACE = " ";

    private static final String PURCHASE_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String LINE_BREAK = "\n";
    private static final String WINNING_RESULT = "당첨 통계";
    private static final String WINNING_RESULT_LINE = "---------";
    private static final String WINNING_MATCH_COUNT = "개 일치";
    private static final String KR_WON = "원";
    private static final String COUNT = "개";


    public static void printPurchaseLotto(int amount) {
        stringBuilder.append(amount)
                .append(PURCHASE_COUNT_MESSAGE)
                .append(LINE_BREAK);

        System.out.println(stringBuilder);
        initStringBuilder();
    }

    public static void printLottoNumbers(List<LottoNumbers> lottoNumbersList) {
        for (LottoNumbers lottoNumbers : lottoNumbersList) {
            stringBuilder.append(LEFT_BRACKET);
            stringBuilder.append(lottoNumbers.toString());
            stringBuilder.append(RIGHT_BRACKET);
            System.out.println(stringBuilder);
            initStringBuilder();
        }
    }

    public static void printWinningResult(MatchRankDto matchRankDto) {
        resultMessage();
        printMatchResult(matchRankDto);
        printBenefitRate(matchRankDto.getBenefitRate());
    }

    private static void resultMessage() {
        stringBuilder.append(WINNING_RESULT);
        stringBuilder.append(LINE_BREAK);
        stringBuilder.append(WINNING_RESULT_LINE);
        System.out.println(stringBuilder);
        initStringBuilder();
    }

    private static void printMatchResult(MatchRankDto matchRankDto) {
        for (LottoRankDto lottoRankDto : matchRankDto.getLottoRankDtos()) {
            stringBuilder.append(lottoRankDto.getRank().getCorrespondCount())
                    .append(WINNING_MATCH_COUNT)
                    .append(SPACE)
                    .append(LEFT_PARENTHESIS)
                    .append(lottoRankDto.getRank().getPrizeMoney())
                    .append(KR_WON)
                    .append(RIGHT_PARENTHESIS)
                    .append(DASH)
                    .append(lottoRankDto.getCount())
                    .append(COUNT);
            System.out.println(stringBuilder);
            initStringBuilder();
        }
    }

    private static void printBenefitRate(double benefitRate) {
        final String TOTAL_BENEFIT_RATE_MESSAGE
                = String.format("총 수익률은 %.2f입니다. (기준이 1이기 때문 결과적으로 손해라는 의미임)", benefitRate);
        stringBuilder.append(TOTAL_BENEFIT_RATE_MESSAGE);
        System.out.println(stringBuilder);
        initStringBuilder();
    }

    private static void initStringBuilder() {
        stringBuilder.setLength(0);
    }
}
