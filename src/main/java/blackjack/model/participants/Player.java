package blackjack.model.participants;

import blackjack.model.blackjackgame.ResultStatus;
import blackjack.model.cards.Cards;

public class Player extends Participant {
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public boolean checkDrawCardState() {
        return !cards.isGreaterThanWinningScore();
    }

    public ResultStatus getResultStatus(Cards otherCards) {
        if (cards.isGreaterThanWinningScore()) {
            return ResultStatus.LOSE;
        }
        if (otherCards.isGreaterThanWinningScore()) {
            return ResultStatus.WIN;
        }
        return compareScore(otherCards);
    }

    private ResultStatus compareScore(Cards otherCards) {
        int calculatedScore = cards.getScore();
        int otherScore = otherCards.getScore();

        if (calculatedScore > otherScore) {
            return ResultStatus.WIN;
        }
        if (calculatedScore < otherScore) {
            return ResultStatus.LOSE;
        }
        return ResultStatus.PUSH;
    }

    public String getName() {
        return name;
    }
}
