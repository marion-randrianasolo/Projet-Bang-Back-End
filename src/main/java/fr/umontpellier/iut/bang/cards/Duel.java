package fr.umontpellier.iut.bang.cards;

import fr.umontpellier.iut.bang.Player;

import java.util.ArrayList;
import java.util.List;

public class Duel extends OrangeCard {

    public Duel(int value, CardSuit suit) {
        super("Duel", value, suit);
    }


    @Override
    public void playedBy(Player player) {

        boolean gagnant =true;
        Card card2;
        Card card1;
        Player newPlayer = player.choosePlayer("Entrez le nom du joueur ciblé",player.getOtherPlayers(),false);

            if (newPlayer.getBangCharacter().getName().equals("Calamity Janet")) {
                while (gagnant) {
                    if (newPlayer.getCardInHand("Bang!") != null || newPlayer.getCardInHand("Missed!") != null) {
                        List<Card> listeBang = new ArrayList<>();
                        if (newPlayer.getCardInHand("Bang!") != null) {
                            listeBang.add(newPlayer.getCardInHand("Bang!"));
                        }
                        if (newPlayer.getCardInHand("Missed!") != null) {
                            listeBang.add(newPlayer.getCardInHand("Missed!"));
                        }
                        card1 = newPlayer.chooseCard("Défaussez une carte Bang! ou Passez et perdez un point", listeBang, true, true);
                        if (card1 == null) {
                            newPlayer.decrementHealth(1, player);
                            break;
                        } else {
                            newPlayer.discard(card1);
                            newPlayer.removeFromHand(card1);
                        }
                    } else {
                        newPlayer.decrementHealth(1, player);
                        break;
                    }

                    if (player.getBangCharacter().getName().equals("Calamity Janet")) {
                        if (player.getCardInHand("Bang!") != null || player.getCardInHand("Missed!") != null) {
                            List<Card> listeBang2 = new ArrayList<>();
                            if (player.getCardInHand("Bang!") != null) {
                                listeBang2.add(player.getCardInHand("Bang!"));
                            }
                            if (player.getCardInHand("Missed!") != null) {
                                listeBang2.add(player.getCardInHand("Missed!"));
                            }
                            card1 = player.chooseCard("Défaussez une carte Bang! ou Passez et perdez un point", listeBang2, true, true);
                            if (card1 == null) {
                                player.decrementHealth(1, newPlayer);
                                gagnant = false;
                            } else {
                                player.discard(card1);
                                player.removeFromHand(card1);
                            }
                        } else {
                            newPlayer.decrementHealth(1, player);
                            gagnant = false;
                        }
                    } else {
                        if (player.getCardInHand("Bang!") != null) {
                            List<Card> listeBang2 = new ArrayList<>();

                            listeBang2.add(player.getCardInHand("Bang!"));
                            card2 = player.chooseCard("Défaussez une carte Bang! ou Passez et perdez un point", listeBang2, true, true);

                            if (card2 == null) {
                                player.decrementHealth(1, newPlayer);
                                gagnant = false;
                            } else {
                                player.discard(card2);
                                player.removeFromHand(card2);
                            }

                        } else {
                            player.decrementHealth(1, newPlayer);
                            gagnant = false;
                        }

                    }
                }
            }else if (player.getBangCharacter().getName().equals("Calamity Janet")) {
                while (gagnant) {

                    if (newPlayer.getCardInHand("Bang!") != null) {
                        List<Card> listeBang = new ArrayList<>();
                        listeBang.add(newPlayer.getCardInHand("Bang!"));
                        card1 = newPlayer.chooseCard("Défaussez une carte Bang! ou Passez et perdez un point", listeBang, true, true);
                        if (card1 == null) {
                            newPlayer.decrementHealth(1, player);
                            break;
                        } else {
                            newPlayer.discard(card1);
                            newPlayer.removeFromHand(card1);
                        }
                    } else {
                        newPlayer.decrementHealth(1, player);
                        break;
                    }
                    if (player.getCardInHand("Bang!") != null || player.getCardInHand("Missed!") != null) {
                        List<Card> listeBang2 = new ArrayList<>();
                        if (player.getCardInHand("Bang!") != null) {
                            listeBang2.add(player.getCardInHand("Bang!"));
                        }
                        if (player.getCardInHand("Missed!") != null) {
                            listeBang2.add(player.getCardInHand("Missed!"));
                        }
                        card1 = player.chooseCard("Défaussez une carte Bang! ou Passez et perdez un point", listeBang2, true, true);
                        if (card1 == null) {
                            player.decrementHealth(1, newPlayer);
                            gagnant = false;
                        } else {
                            player.discard(card1);
                            player.removeFromHand(card1);
                        }
                    } else {
                        newPlayer.decrementHealth(1, player);
                        gagnant = false;
                    }
                }
            }
            else {
                while (gagnant) {

                    if(newPlayer.getCardInHand("Bang!")!=null){
                        List<Card> listeBang = new ArrayList<>();
                        listeBang.add(newPlayer.getCardInHand("Bang!"));
                        card1 = newPlayer.chooseCard("Défaussez une carte Bang! ou Passez et perdez un point", listeBang, true, true);
                        if (card1 == null) {
                            newPlayer.decrementHealth(1, player);
                            break;
                        }else{
                            newPlayer.discard(card1);
                            newPlayer.removeFromHand(card1);
                        }
                    }else{
                        newPlayer.decrementHealth(1, player);
                        break;
                    }

                    if(player.getCardInHand("Bang!")!=null){
                        List<Card> listeBang2 = new ArrayList<>();

                        listeBang2.add(player.getCardInHand("Bang!"));
                        card2 = player.chooseCard("Défaussez une carte Bang! ou Passez et perdez un point", listeBang2, true, true);

                        if (card2 == null) {
                            player.decrementHealth(1, newPlayer);
                            gagnant = false;
                        }else{
                            player.discard(card2);
                            player.removeFromHand(card2);
                        }

                    }else{
                        player.decrementHealth(1,newPlayer);
                        gagnant = false;
                    }
                }

            }
    }
}


