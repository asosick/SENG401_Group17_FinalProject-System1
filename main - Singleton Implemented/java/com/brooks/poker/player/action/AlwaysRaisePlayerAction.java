package com.brooks.poker.player.action;

import com.brooks.poker.game.GameActions;
import com.brooks.poker.game.data.GameState;
import com.brooks.poker.outcome.BettingOutcome;
import com.brooks.poker.outcome.BettingOutcomeFactory;
import com.brooks.poker.player.Player;

/**
 * @author Trevor
 *
 */
public class AlwaysRaisePlayerAction implements PlayerAction{

    public static final int RAISE_AMOUNT = 50;

    @Override
    public BettingOutcome getBettingOutcome(Player player){
        return BettingOutcomeFactory.createRaiseOutcome(getBetAmount());
    }

    private int getBetAmount(){
        if (GameActions.getMinBet() > RAISE_AMOUNT)
            return GameActions.getMinBet();

        return RAISE_AMOUNT;
    }
}
