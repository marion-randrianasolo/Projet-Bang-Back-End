package fr.umontpellier.iut.bang.cards;

import fr.umontpellier.iut.bang.Player;
import fr.umontpellier.iut.bang.Role;

import java.util.ArrayList;

public class Jail extends BlueCard {
    public Jail(int value, CardSuit suit) {
        super("Jail", value, suit);
    }

    public void playedBy(Player player) {

        ArrayList<Player> listPlayer= new ArrayList<>();
        for (Player player1 : player.getOtherPlayers()){
            if(player1.getRole()!= Role.SHERIFF){
                listPlayer.add(player1);
            }
        }

        Player player2 = player.choosePlayer("Choisis un joueur", listPlayer,false);
        player2.addToInPlay(this);
    }
}
