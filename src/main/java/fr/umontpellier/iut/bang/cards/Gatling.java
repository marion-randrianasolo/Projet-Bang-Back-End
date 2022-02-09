package fr.umontpellier.iut.bang.cards;

import fr.umontpellier.iut.bang.Player;

import java.util.ArrayList;
import java.util.List;

public class Gatling extends OrangeCard {

    public Gatling(int value, CardSuit suit) {
        super("Gatling", value, suit);
    }

    public  void playedBy(Player player){

        for(Player player1 : player.getOtherPlayers()){
            if(player1.getBangCharacter().getName().equals("Jourdonnais") || player1.getCardInPlay("Barrel")!=null){
                Card card = player1.drawCard();
                if(!card.getSuit().equals(CardSuit.HEART)) {
                    if (player1.getCardInHand("Missed!") != null) {
                        List<Card> cardList = new ArrayList<>();
                        cardList.add(player1.getCardInHand("Missed!"));
                        Card test = player1.chooseCard("Choisissez de jouer ou non", cardList, true, true);
                        if (test == null) {
                            player1.decrementHealth(1, player);
                        } else {
                            player1.discardFromHand(player1.getCardInHand("Missed!"));
                        }
                    } else {
                        player1.decrementHealth(1, player);
                    }
                }
                player1.discard(card);
            }else{
                if (player1.getCardInHand("Missed!") != null) {
                    List<Card> cardList = new ArrayList<>();
                    cardList.add(player1.getCardInHand("Missed!"));
                    Card test = player1.chooseCard("Choisissez de jouer ou non", cardList, true, true);
                    if (test == null) {
                        player1.decrementHealth(1, player);
                    } else {
                        player1.discardFromHand(player1.getCardInHand("Missed!"));
                    }
                } else {
                    player1.decrementHealth(1, player);
                }

            }

        }
    }

}
