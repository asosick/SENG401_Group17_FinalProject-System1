package com.brooks.poker.player.action;

import com.brooks.poker.game.data.GameState;
import com.brooks.poker.outcome.BettingOutcome;
import com.brooks.poker.outcome.BettingOutcomeFactory;
import com.brooks.poker.player.Player;

/**
 * @author Trevor
 *
 */
public class AlwaysCallPlayerAction implements PlayerAction{

    @Override
    public BettingOutcome getBettingOutcome(Player player){
        return BettingOutcomeFactory.createCallOutcome();
    }

}
