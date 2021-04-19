package com.brooks.poker.game.progress;

import com.brooks.poker.game.BettingRound;
import com.brooks.poker.game.GameActions;
import com.brooks.poker.game.data.GameState;
import com.brooks.poker.game.data.Table;
import com.brooks.poker.game.data.pot.Pot;
import com.brooks.poker.game.data.pot.Pots;
import com.brooks.poker.outcome.BettingOutcome;
import com.brooks.poker.outcome.BettingOutcomeFactory;
import com.brooks.poker.player.Player;
import com.brooks.poker.player.action.PlayerAction;

/**
 * @author Trevor
 */
public abstract class BetState extends GameProgressHandler {

    private Player actionOnPlayer;

    public BetState() {
        super();
    }

    public void bettingRound(Player startPlayer) {
        Table table = GameState.getGameStateInstance().getTable();
        actionOnPlayer = ensurePlayerIsActive(startPlayer);
        BettingRound bettingRound = new BettingRound(actionOnPlayer, false);
        while (!bettingRound.isComplete()){
            int currentBet = GameState.getGameStateInstance().getPots().getCurrentBet();
            modifyGameState(actionOnPlayer);
            bettingRound.actionComplete(actionOnPlayer);
            if(GameState.getGameStateInstance().getPots().getCurrentBet() != currentBet){
                bettingRound = new BettingRound(actionOnPlayer, true);
            }
            actionOnPlayer = table.getNextActivePlayer(actionOnPlayer);
        }
        GameActions.endBettingRound();
    }

    private void modifyGameState(Player player) {
        PlayerAction playerAction = player.getAction();
        BettingOutcome outcome = playerAction.getBettingOutcome(player);
        outcome.modifyGameState(player);
    }

    protected void betBlindAnte(Player player, int amount) {
        BettingOutcome outcome = BettingOutcomeFactory.createBlindsOutcome(amount);
        outcome.modifyGameState(player);
    }

    public boolean onePlayerInThePot() {
        Pots pots = gameState.getPots();

        for (Pot pot : pots.getPots()) {
            int count = pot.getEligiblePlayerCount();
            if (count > 1)
                return false;
        }
        return true;
    }

    private Player ensurePlayerIsActive(Player startPlayer) {
        Table table = gameState.getTable();
        if (table.isInactive(startPlayer) || startPlayer.isAllIn()) {
            startPlayer = table.getNextActivePlayer(startPlayer);
        }
        return startPlayer;
    }

    public Player getActionOnPlayer() {
        return actionOnPlayer;
    }

}
