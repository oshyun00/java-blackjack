package domain.participant;

public final class Player extends Participant {

    private Player(final String name) {
        super(name);
    }

    public static Player create(final String name) {
        validatePlayerName(name);
        return new Player(name);
    }

    private static void validatePlayerName(final String name) {
        if (DEALER_NAME.isSame(name)) {
            throw new IllegalArgumentException("플레이어는 '딜러'라는 이름을 가질 수 없습니다.");
        }
    }
}
