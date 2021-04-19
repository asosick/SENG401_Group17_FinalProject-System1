package com.brooks.poker.game;

import com.brooks.poker.cards.Card;
import com.brooks.poker.cards.Deck;
import com.brooks.poker.game.data.GameState;
import com.brooks.poker.game.data.Table;
import com.brooks.poker.game.data.pot.Pot;
import com.brooks.poker.game.data.pot.Pots;
import com.brooks.poker.player.Player;

import java.util.Set;

public class GameActions {

    private static final int MAXIMUM_NUMBER_OF_PLAYERS = 20;
    private static final int MINIMUM_NUMBER_OF_PLAYERS = 2;

    private GameActions() {
    }

    public static void beginHand() {
    	GameState.getGameStateInstance().getTable().reset();
    	GameState.getGameStateInstance().getDeck().reset();
    	GameState.getGameStateInstance().getCommunityCards().reset();
    	GameState.getGameStateInstance().getTable().makeNextPlayerDealer();
    	GameState.getGameStateInstance().getPots().reset(GameState.getGameStateInstance().getTable().getAllPlayers());
    }

    public static Player getPlayerAfterDealer() {
        Table table = GameState.getGameStateInstance().getTable();

        Player dealer = table.getDealer();
        return table.getNextActivePlayer(dealer);
    }

    public static void dealCardToPlayer(Deck deck, Player player) {
        Card card = deck.dealCard();
        player.addCard(card);
    }

    public static void burnCard(Deck deck) {
        deck.dealCard();
    }

    public static void dealCommunityCard() {
        Card dealtCard = GameState.getGameStateInstance().getDeck().dealCard();
        GameState.getGameStateInstance().getCommunityCards().add(dealtCard);
        for (Player p : GameState.getGameStateInstance().getTable().getSortedActivePlayers()) {
            p.addCard(dealtCard);
        }
    }

    public static void updateCurrentBet(Pots pots, int pendingBet) {
        pots.updateAmountOwed(pendingBet);
    }

    public static void endBettingRound() {
    	GameState.getGameStateInstance().getPots().putPendingBetsIntoPots(GameState.getGameStateInstance().getTable().getAllPlayers());
    }

    public static int getMinBet() {
        int minBet = GameState.getGameStateInstance().getPots().getCurrentBet() + GameState.getGameStateInstance().getBlindsAnte().bigBlind;
        if (minBet < GameState.getGameStateInstance().getBlindsAnte().bigBlind) {
            minBet = GameState.getGameStateInstance().getBlindsAnte().bigBlind;
        }
        return minBet;
    }

    public static boolean invalid() {
        Set<Player> players = GameState.getGameStateInstance().getTable().getAllPlayers();
        if (players == null)
            return true;
        if (players.size() < MINIMUM_NUMBER_OF_PLAYERS)
            return true;
        return players.size() > MAXIMUM_NUMBER_OF_PLAYERS;
    }


}
