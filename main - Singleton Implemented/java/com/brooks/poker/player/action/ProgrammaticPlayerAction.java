package com.brooks.poker.player.action;

import com.brooks.poker.game.data.GameState;
import com.brooks.poker.outcome.BettingOutcome;
import com.brooks.poker.player.Player;

/**
 * @author Trevor
 *
 */
public class ProgrammaticPlayerAction implements PlayerAction{

    public PlayerAction delegate = NullPlayerAction.INSTANCE;

    @Override
    public BettingOutcome getBettingOutcome(Player player){
        return delegate.getBettingOutcome(player);
    }

    public void setPlayerAction(PlayerAction action){
        delegate = action;
    }

}
