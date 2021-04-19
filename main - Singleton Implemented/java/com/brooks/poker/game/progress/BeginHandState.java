/**
 * 
 */
package com.brooks.poker.game.progress;

import com.brooks.poker.command.PlayerCommand;
import com.brooks.poker.game.GameActions;
import com.brooks.poker.game.data.GamePhase;
import com.brooks.poker.game.data.GameState;
import com.brooks.poker.game.data.Table;
import com.brooks.poker.player.Player;

/**
 * In the begin state we:
 * 
 * Make sure on the game constants are set up properly. Deal two cards to each
 * player.
 * 
 * @author Trevor
 */
public class BeginHandState extends GameProgressHandler{

    public BeginHandState(){
        super();
    }

    @Override
    public void handleState(){
    	GameActions.beginHand();
        dealCards();
    }

    @Override
    public GamePhase getNextPhase(){
        return GamePhase.FIRST_BET;
    }

    private void dealCards(){
        Table table = GameState.getGameStateInstance().getTable();
        Player player = GameActions.getPlayerAfterDealer();
        table.executeOnEachActivePlayer(player, new DealHoleCardCommand());
        table.executeOnEachActivePlayer(player, new DealHoleCardCommand());

    }

    private class DealHoleCardCommand implements PlayerCommand{
        @Override
        public void execute(Player player){
        	GameActions.dealCardToPlayer(GameState.getGameStateInstance().getDeck(), player);
        }
    }

}
