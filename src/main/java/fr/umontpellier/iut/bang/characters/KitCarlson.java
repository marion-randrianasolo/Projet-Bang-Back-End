package fr.umontpellier.iut.bang.characters;

import fr.umontpellier.iut.bang.Player;
import fr.umontpellier.iut.bang.cards.Card;

import java.util.ArrayList;
import java.util.List;

public class KitCarlson extends BangCharacter {

    public KitCarlson() {
        super("Kit Carlson", 4);
    }

    public void onStartTurn(Player player) {
        Card card = player.drawCard();
        Card card1 = player.drawCard();
        Card card2 =  player.drawCard();

        List<String> listChoix = new ArrayList<>();
        listChoix.add(card.getName());
        listChoix.add(card1.getName());
        listChoix.add(card2.getName());


        String reponse = player.choose("Choisissez la carte à remettre dans la pioche",listChoix,true,false);
        if(card.getName().equals(reponse)){
            player.getGame().remettreDansPioche(card);
            player.addToHand(card1);
            player.addToHand(card2);

        }else if(card1.getName().equals(reponse)){
            player.getGame().remettreDansPioche(card1);
            player.addToHand(card);
            player.addToHand(card2);

        }else{
            player.getGame().remettreDansPioche(card2);
            player.addToHand(card1);
            player.addToHand(card);

        }

    }

}
