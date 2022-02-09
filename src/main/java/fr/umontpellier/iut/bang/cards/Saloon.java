package fr.umontpellier.iut.bang.cards;

import fr.umontpellier.iut.bang.Player;

import java.util.List;

public class Saloon extends OrangeCard {

    public Saloon(int value, CardSuit suit) {
        super("Saloon", value, suit);
    }

    public void playedBy(Player player) {
        super.playedBy(player);
        List<Player> allPlayers = player.getOtherPlayers();
        allPlayers.add(0, player);
        for(Player player1 : allPlayers){
            player1.incrementHealth(1);
        }
        player.discard(this);
    }
}
