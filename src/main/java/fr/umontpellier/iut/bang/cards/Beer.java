package fr.umontpellier.iut.bang.cards;

import fr.umontpellier.iut.bang.Player;

public class Beer extends OrangeCard {

    public Beer(int value, CardSuit suit) {
        super("Beer", value, suit);
    }

    @Override
    public boolean canPlayFromHand(Player player) {
        return player.getOtherPlayers().size() > 1;
    }
    @Override
    public void playedBy(Player player) {
        player.incrementHealth(1);
        player.discard(this);
    }

}
