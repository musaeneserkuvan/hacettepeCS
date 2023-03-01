import java.util.ArrayList;


public class Chance extends ActionSquares {

    private final ArrayList<String> ChanceList = new ArrayList<>();
    private int CardOrder;

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


        if( chancelist.getCardOrder()==0){

            player1.setLocation(player1.getLocation() + (40-player1.getLocation()) + maplist[1].getLocID());
            player1.GoMoney(player1.getLocation() + (40-player1.getLocation()) + maplist[1].getLocID(), player1, banker);

        }
        else if(chancelist.getCardOrder()==1){

            if(player1.getLocation() > maplist[27].getLocID()) {
                player1.GoMoney(player1.getLocation() + (40-player1.getLocation()) + maplist[27].getLocID(), player1, banker);
                player1.setLocation(player1.getLocation() + (40 - player1.getLocation()) + maplist[27].getLocID());


            }
            else{

                player1.setLocation(maplist[27].getLocID());

            }

        }
        else if(chancelist.getCardOrder()==2){

            player1.setLocation(  player1.getLocation() -3 );

        }
        else if (chancelist.getCardOrder()==3){
            player1.setMoney(-15);
            player1.setTempMoney(-15);
            banker.setTempMoney(15);
            banker.setMoney(+15);

        }
        else if(chancelist.getCardOrder()==4){

            player1.setMoney(+150);
            player1.setTempMoney(150);
            banker.setTempMoney(-150);
            banker.setMoney(-150);

        }
        else if (chancelist.getCardOrder()==5){
            player1.setMoney(+100);
            player1.setTempMoney(100);
            banker.setTempMoney(-100);
            banker.setMoney(-100);

        }
    }

    public ArrayList<String> getChanceList() {
        return ChanceList;
    }

    public void setChanceList(String str) {
        ChanceList.add(str);
    }

    public int getCardOrder() {
        return CardOrder;
    }

    public void setCardOrder(int cardOrder) {
        CardOrder = cardOrder;
    }
}
