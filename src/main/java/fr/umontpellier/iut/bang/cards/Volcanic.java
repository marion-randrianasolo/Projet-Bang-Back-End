package fr.umontpellier.iut.bang.cards;

import fr.umontpellier.iut.bang.Player;

import java.util.ArrayList;
import java.util.List;

public class Volcanic extends WeaponCard {
    public Volcanic(int value, CardSuit suit) {
        super("Volcanic", value, suit);
    }

    @Override
    public int getRange() {
        return 1;
    }

    @Override
    public void playedBy(Player player) {
        super.playedBy(player);
        List<Player> playersInRange = player.getPlayersInRange(getRange());
        List<Card> cards = new ArrayList<>(player.getInPlay());
        if (player.getCardInPlay("Bang!") != null) {
            for (int i = 0; i < playersInRange.size(); i++) {
                player.choosePlayer("Choix joueurs", playersInRange, true);
                player.chooseCard("choix", cards, true, true);
            }
        }
    }

}
