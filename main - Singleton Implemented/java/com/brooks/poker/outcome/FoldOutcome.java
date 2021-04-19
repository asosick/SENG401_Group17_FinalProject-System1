package com.brooks.poker.outcome;

import com.brooks.poker.game.data.GameState;
import com.brooks.poker.game.data.Table;
import com.brooks.poker.game.data.pot.Pots;
import com.brooks.poker.player.Player;

/**
 * @author Trevor
 * 
 */
public class FoldOutcome implements BettingOutcome{

    protected FoldOutcome(){
    }

    @Override
    public void modifyGameState(Player player){
        Table table = GameState.getGameStateInstance().getTable();
        table.makeInactive(player);

        Pots pots = GameState.getGameStateInstance().getPots();
        pots.fold(player);
    }

    @Override
    public int getBetAmount(Player player){
        return 0;
    }

}
