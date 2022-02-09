package fr.umontpellier.iut.bang.cards;

import fr.umontpellier.iut.bang.Player;

import java.util.ArrayList;
import java.util.List;

public class Missed extends OrangeCard {

    public Missed(int value, CardSuit suit) {
        super("Missed!", value, suit);
    }
    @Override
    public boolean canPlayFromHand(Player player) {
        return player.getBangCharacter().getName().equals("Calamity Janet");
    }

    public void playedBy(Player player){
        player.discard(this);
        Bang bang = new Bang(-1,this.getSuit());
            bang.playedBy(player);
    }

}
