package com.brooks.poker.outcome;

import com.brooks.poker.game.GameActions;
import com.brooks.poker.game.data.GameState;
import com.brooks.poker.player.Player;

/**
 * @author Trevor
 * 
 */
public class CallOutcome implements BettingOutcome{

    protected CallOutcome(){
    }

    @Override
    public void modifyGameState(Player player){
        int betAmount = getBetAmount(player);        
        player.requestBet(betAmount);
        GameActions.updateCurrentBet(GameState.getGameStateInstance().getPots(), player.getPendingBet());

        if (player.isAllIn()){
        	GameState.getGameStateInstance().getPots().insertSubpot(player);
        }

    }

    @Override
    public int getBetAmount(Player player){
        return GameState.getGameStateInstance().getPots().getCurrentBet() - player.getPendingBet();
    }

}
