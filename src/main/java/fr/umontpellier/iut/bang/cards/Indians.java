package fr.umontpellier.iut.bang.cards;

import fr.umontpellier.iut.bang.Player;

public class Indians extends OrangeCard {

    public Indians(int value, CardSuit suit) {
        super("Indians!", value, suit);
    }

    public void playedBy(Player player) {
        super.playedBy(player);
        for (Player player1 : player.getOtherPlayers()) {
            if (player1.getCardInHand("Bang!") != null) {


                Card card = player1.chooseCard("Choisissez une carte Bang ou passez et perdez un point", player1.getHand(), false, true);

                if (card == null) {
                    player1.decrementHealth(1, player);
                } else {
                    player1.discardFromHand(card);
                }
            } else {
                player1.decrementHealth(1, player);

            }
        }
    }
}
