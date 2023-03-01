public class RailRoads extends Map{

    public RailRoads(int id, int cost, String name, String railRoad,String supertype) {
        super(id,cost,name,railRoad,supertype);
    }

    public RailRoads() {

    }

    public void rent(
            Player player1,
            Player player2,
            Map[] maplist,
            String str){

        player1.setTempMoney(- (25 * player2.getOwnedRailRoadList().size()));
        player1.setMoney(- (25 * player2.getOwnedRailRoadList().size()) );
        player2.setMoney( (25 * player2.getOwnedRailRoadList().size()) );
    }

}
