package com.brooks.poker.outcome;

import com.brooks.poker.game.data.GameState;
import com.brooks.poker.player.Player;

/**
 * @author Trevor
 */
public interface BettingOutcome{
    
    void modifyGameState(Player player);

    int getBetAmount(Player player);
}
