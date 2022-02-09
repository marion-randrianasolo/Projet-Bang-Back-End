package fr.umontpellier.iut.bang.characters;

import fr.umontpellier.iut.bang.Player;
import fr.umontpellier.iut.bang.cards.Card;

import java.util.ArrayList;
import java.util.List;

public class LuckyDuke extends BangCharacter {

    public LuckyDuke() {
        super("Lucky Duke", 4);
    }

    public Card randomDraw(Player player) {
        Card card = player.drawCard();
        Card card1 = player.drawCard();
        List<String> cardList = new ArrayList<>();
        cardList.add(card.getPokerString());
        cardList.add(card1.getPokerString());
        player.discard(card);
        player.discard(card1);
        String card2 = player.choose("Choisissez la carte que vous préférez", cardList, true, false);
        if (card1.getPokerString().equals(card2)) {
            return card1;
        } else {
            return card;
        }
    }
}

