package fr.umontpellier.iut.bang.cards;

import fr.umontpellier.iut.bang.Player;

import java.util.ArrayList;
import java.util.List;

public class Bang extends OrangeCard {

    public Bang(int value, CardSuit suit) {
        super("Bang!", value, suit);
    }
    public boolean canPlayFromHand(Player player) {
        return 0 != player.getPlayersInRange2(player.getWeaponRange());

    }


    public void playedBy(Player player){
        if(getValue()!=-1){  super.playedBy(player); }
        Player player1 = player.choosePlayer("Choisissez un autre joueur à attaquer",player.getPlayersInRange(player.getWeaponRange()),false);

        //Slab the killer
        if(player.getBangCharacter().getName().equals("Slab the Killer")){
            int k = 0;

            if(player1.getCardInPlay("Barrel")!=null){
                Card card1 = player1.drawCard();
                if(card1.getSuit().equals(CardSuit.HEART)){ k++; }
                player.discard(card1);
            }
            while(k<2 && player1.getCardInHand("Missed!")!=null){
                if (player1.getCardInHand("Missed!") != null) {
                    List<Card> cardList = new ArrayList<>();
                    cardList.add(player1.getCardInHand("Missed!"));
                    Card test = player1.chooseCard("Choisissez de jouer ou passez et perdez un point", cardList, true, true);
                    if (test == null) {
                        player1.decrementHealth(1, player);
                    } else {
                        player1.discardFromHand(player1.getCardInHand("Missed!"));
                        k++;
                    }
                }
            }
            if(k==0){ player1.decrementHealth(2, player); }
            else if(k==1){ player1.decrementHealth(1, player); }

        }else{
            if (player1.getBangCharacter().getName().equals("Jourdonnais")){
                Card card = player1.drawCard();
                if(!card.getSuit().equals(CardSuit.HEART)){
                    // si il n'a pas de coeur il peut jouer un barrel
                    if (player1.getCardInPlay("Barrel")!=null){
                        Card card1 = player1.randomDraw();
                        // si la carte qu il tire n est pas un coeur il peut jouer un missed
                        if(!card1.getSuit().equals(CardSuit.HEART)) {

                            if (player1.getCardInHand("Missed!") != null) {
                                List<Card> cardList = new ArrayList<>();
                                cardList.add(player1.getCardInHand("Missed!"));
                                Card test = player1.chooseCard("Choisissez de jouer ou passez et perdez un point", cardList, true, true);

                                if (test == null) { player1.decrementHealth(1, player); }
                                else { player1.discardFromHand(player1.getCardInHand("Missed!")); }

                            }else { player1.decrementHealth(1, player); }
                            player.discard(card1);
                        }
                    }else{ player1.decrementHealth(1, player); }
                }
                player.discard(card);
            } else{
                if (player1.getCardInPlay("Barrel")!=null){
                    Card card1 = player1.randomDraw();
                    // si la carte qu il tire n est pas un coeur il peut jouer un missed
                    if(!card1.getSuit().equals(CardSuit.HEART)) {
                        if(player1.getBangCharacter().getName().equals("Calamity Janet")){
                            if (player1.getCardInHand("Missed!") != null || player1.getCardInHand("Bang!") != null) {
                                List<Card> cardList = new ArrayList<>();
                                if(player1.getCardInHand("Missed!") != null) {
                                    cardList.add(player1.getCardInHand("Missed!"));
                                }
                                if(player1.getCardInHand("Bang!")!=null){
                                    cardList.add(player1.getCardInHand("Bang!"));
                                }
                                Card test = player1.chooseCard("Choisissez de jouer un Missed!, un Bang! remplaçant un Missed! ou passez et perdez un point", cardList, true, true);
                                if (test == null) {
                                    player1.decrementHealth(1, player);
                                } else if( test.equals(player1.getCardInHand("Missed!"))){
                                        player1.discardFromHand(player1.getCardInHand("Missed!"));
                                    }
                                else{
                                    player1.discardFromHand(player1.getCardInHand("Bang!"));

                                }
                            } else {
                                player1.decrementHealth(1, player);
                            }
                        }
                        else if (player1.getCardInHand("Missed!") != null) {
                            List<Card> cardList = new ArrayList<>();
                            cardList.add(player1.getCardInHand("Missed!"));
                            Card test = player1.chooseCard("Choisissez de jouer ou passez et perdez un point", cardList, true, true);
                            if (test == null) {
                                player1.decrementHealth(1, player);
                            } else {
                                player1.discardFromHand(player1.getCardInHand("Missed!"));
                            }
                        } else {
                            player1.decrementHealth(1, player);
                        }

                        player.discard(card1);
                    }
                } else {
                    if(player1.getBangCharacter().getName().equals("Calamity Janet")){
                        if (player1.getCardInHand("Missed!") != null || player1.getCardInHand("Bang!") != null) {
                            List<Card> cardList = new ArrayList<>();
                            if(player1.getCardInHand("Missed!") != null) {
                                cardList.add(player1.getCardInHand("Missed!"));
                            }
                            if(player1.getCardInHand("Bang!")!=null){
                                cardList.add(player1.getCardInHand("Bang!"));
                            }
                            Card test = player1.chooseCard("Choisissez de jouer un Missed!, un Bang! remplaçant un Missed! ou passez et perdez un point", cardList, true, true);
                            if (test == null) {
                                player1.decrementHealth(1, player);
                            } else if( test.equals(player1.getCardInHand("Missed!"))){
                                player1.discardFromHand(player1.getCardInHand("Missed!"));
                            }
                            else{
                                player1.discardFromHand(player1.getCardInHand("Bang!"));

                            }
                        } else {
                            player1.decrementHealth(1, player);
                        }
                    }
                    else if (player1.getCardInHand("Missed!") != null) {
                        List<Card> cardList = new ArrayList<>();
                        cardList.add(player1.getCardInHand("Missed!"));
                        Card test = player1.chooseCard("Choisissez de jouer ou passez et perdez un point", cardList, true, true);
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
}




