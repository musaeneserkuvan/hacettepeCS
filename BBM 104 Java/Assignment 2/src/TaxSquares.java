public class TaxSquares extends ActionSquares {

    public void TakeAction(
            Player player1,
            Player player2,
            Player banker,
            Map[] maplist,
            Chance chancelist,
            CommunityChest chestlist,
            Land land,
            Company company,
            RailRoads railroad,
            Banker banking){

        player1.setTempMoney(-100);
        player1.setMoney(-100 );
        banker.setMoney(100);

    }

}
