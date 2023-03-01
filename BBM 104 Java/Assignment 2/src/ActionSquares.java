public abstract class ActionSquares {

    public ActionSquares(){

    }

    public abstract void TakeAction(
            Player player1,
            Player player2,
            Player banker,
            Map[] maplist,
            Chance chancelist,
            CommunityChest chestlist,
            Land land,
            Company company,
            RailRoads railroad,
            Banker banking);

}
