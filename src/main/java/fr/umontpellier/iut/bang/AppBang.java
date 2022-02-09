package fr.umontpellier.iut.bang;

import fr.umontpellier.iut.bang.cards.Bang;
import fr.umontpellier.iut.bang.characters.BangCharacter;
import fr.umontpellier.iut.bang.characters.SuzyLafayette;

import java.util.ArrayList;
import java.util.List;

public class AppBang {
    public static void main(String[] args) {
        // Instancie et exécute une partie
       /* List<Player> players = Game.makePlayers(new String[]{"John", "Paul", "Ringo", "George"});
        Game g = new Game(players);
        g.run();*/

        BangCharacter bangCharacter= new SuzyLafayette();
        Player player = new Player("0",bangCharacter,Role.SHERIFF);
        Player player1 = new Player("1", bangCharacter,Role.RENEGADE);
        Player player2 = new Player("2", bangCharacter,Role.OUTLAW);
        List<Player> list = new ArrayList<>();
        list.add(player);
        list.add(player1);
        list.add(player2);
        Game game = new Game(list);
        game.run();

    }
}
