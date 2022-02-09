package fr.umontpellier.iut.bang.cards;

import fr.umontpellier.iut.bang.Player;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Panic extends OrangeCard {

    public Panic(int value, CardSuit suit) {
        super("Panic!", value, suit);
    }

    @Override
    public void playedBy(Player player) {
        super.playedBy(player);
        List<Player> allPlayers = new ArrayList<>(player.getPlayersInRange(1));
        Player player1 = player.choosePlayer("Choisissez un joueur",allPlayers,false);

        if(player1.getInPlay()==null){
            player.addToHand(player1.removeRandomCardFromHand());

        }else{
            List<Card> cartes = new ArrayList<>(player1.getInPlay());
            Card card = player.chooseCard("Choisissez une carte ou passez pour prendre une carte aléatoirement dans sa main",  cartes, true, true);
            if(card==null){
                player.addToHand(player1.removeRandomCardFromHand());
            }
            else {
                player1.removeFromInPlay(card.getName());
                player.addToHand(card);
            }
        }

    }

}



