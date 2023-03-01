import java.util.Objects;

public class Banker extends ActionSquares{

    private String WinnerName;

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

        player1.setMoney(-maplist[player1.getLocation()].getCost());
        player1.setTempMoney(-maplist[player1.getLocation()].getCost());
        player1.setTempBuyName(maplist[player1.getLocation()].getName());

        banker.setMoney(maplist[player1.getLocation()].getCost());
        banker.setTempMoney(maplist[player1.getLocation()].getCost());

        if(Objects.equals(maplist[player1.getLocation()].getType(), "Land")){
            player1.setOwnedLandList(maplist[player1.getLocation()].getName());
            player1.setOwnedPropertyList(maplist[player1.getLocation()].getName());
        }
        else if(Objects.equals(maplist[player1.getLocation()].getType(), "Company")){
            player1.setOwnedCompanyList(maplist[player1.getLocation()].getName());
            player1.setOwnedPropertyList(maplist[player1.getLocation()].getName());
        }
        else if(Objects.equals(maplist[player1.getLocation()].getType(), "RailRoad")){
            player1.setOwnedRailRoadList(maplist[player1.getLocation()].getName());
            player1.setOwnedPropertyList(maplist[player1.getLocation()].getName());
        }
    }
    public String getWinnerName() {
        return WinnerName;
    }

    public void setWinnerName(Player player1, Player player2) {

        if(player1.getMoney() > player2.getMoney()){
            WinnerName= "Winner "+player1.getPlayerName();
        }
        else if(player2.getMoney() > player1.getMoney()){
            WinnerName= "Winner "+player2.getPlayerName();
        }
    }
}
