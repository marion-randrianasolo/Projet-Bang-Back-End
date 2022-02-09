package fr.umontpellier.iut.bang.characters;

import fr.umontpellier.iut.bang.Player;
import fr.umontpellier.iut.bang.cards.Card;

public class JesseJones extends BangCharacter {

    public JesseJones() {
        super("Jesse Jones", 4);
    }
    public void onStartTurn(Player player) {

        Player player1 = player.choosePlayer("Choisis un adversaire ou passe pour piocher",player.getOtherPlayers(),true);

        if(player1!=null){
            Card card = player1.removeRandomCardFromHand();
            player.addToHand(card);
        }
        else{
            player.drawToHand();

        }


        player.drawToHand();


    }

}
