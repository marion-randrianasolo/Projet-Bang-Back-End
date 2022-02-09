package fr.umontpellier.iut.bang.cards;

import fr.umontpellier.iut.bang.Player;

public class CatBalou extends OrangeCard {

    public CatBalou(int value, CardSuit suit) {
        super("Cat Balou", value, suit);
    }

    public void playedBy(Player player) {
        super.playedBy(player);
        Player player1 = player.choosePlayer("Choisissez un joueur à attaquer", player.getOtherPlayers(),false);
        BlueCard blueCard = player1.chooseBlueCard("Choisissez une carte à défausser de votre jeu ou passez pour défausser une carte de votre main",player1.getInPlay(), true, true);

        if(blueCard==null){
            Card card = player1.chooseCard("Choisissez une carte dans votre main", player1.getHand(),true, false);
            player1.discardFromHand(card);
        }
        else{
            player1.discard(blueCard);
            player1.removeFromInPlay(blueCard);
        }
    }
}
