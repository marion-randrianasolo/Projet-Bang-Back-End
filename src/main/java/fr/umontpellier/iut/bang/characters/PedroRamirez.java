package fr.umontpellier.iut.bang.characters;

import fr.umontpellier.iut.bang.Player;
import fr.umontpellier.iut.bang.cards.Card;

import java.util.ArrayList;
import java.util.List;

public class PedroRamirez extends BangCharacter {

    public PedroRamirez() {
        super("Pedro Ramirez", 4);
    }

    public void onStartTurn(Player player) {

        if(player.getGame().getTopOfDiscardPile()!=null){
            List<Card> listChoix = new ArrayList<>();

            listChoix.add(player.getGame().getTopOfDiscardPile());
            Card reponse = player.chooseCard("Choisissez entre la dernière carte de la défausse ou passer pour piocher",listChoix,true,true);
            if(reponse==player.getGame().getTopOfDiscardPile()){
                player.getGame().removeFromDiscard(reponse);
                player.addToHand(reponse);
            }
            else{
                player.drawToHand();

            }
        }else{
            player.drawToHand();

        }
        player.drawToHand();


    }
}
