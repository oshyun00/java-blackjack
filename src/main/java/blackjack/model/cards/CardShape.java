package blackjack.model.cards;

import java.util.Arrays;

public enum CardShape {
    SPADE(0),
    DIAMOND(1),
    HEART(2),
    CLOVER(3);

    private final int order;

    CardShape(int order) {
        this.order = order;
    }

    public static CardShape generate(int number) {
        return Arrays.stream(values())
                .filter(cardShape -> cardShape.order == number)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("카드모양을 고르는 숫자가 올바르지 않습니다."));
    }
}
