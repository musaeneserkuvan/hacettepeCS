import java.util.ArrayList;



public class CommunityChest extends ActionSquares {

    private final ArrayList<String> CommunityChestList = new ArrayList<>();
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


        if(chestlist.getCardOrder()==0){
            player1.GoMoney(player1.getLocation() + (40-player1.getLocation()) + maplist[1].getLocID(), player1, banker);
            player1.setLocation(player1.getLocation() + (40-player1.getLocation()) + maplist[1].getLocID());
        }
        else if(chestlist.getCardOrder()==1){

            player1.setTempMoney(75);
            player1.setMoney(+75);

            banker.setMoney(-75);
            banker.setTempMoney(-75);

        }
        else if(chestlist.getCardOrder()==2){

            player1.setMoney(-50);
            player1.setTempMoney(-50);

            banker.setMoney(+50);
            banker.setTempMoney(+50);

        }
        else if (chestlist.getCardOrder()==3){

            player1.setMoney(+10);
            player1.setTempMoney(10);

            player2.setMoney(-10);
            player2.setTempMoney(-10);

        }
        else if(chestlist.getCardOrder()==4){

            player1.setMoney(+50);
            player1.setTempMoney(50)
            ;
            player2.setMoney(-50);
            player2.setTempMoney(-50);
        }
        else if(chestlist.getCardOrder()==5) {

            player1.setMoney(+20);
            player1.setTempMoney(20);

            banker.setMoney(-20);
            banker.setTempMoney(-20);
        }
        else if(chestlist.getCardOrder()==6) {

            player1.setMoney(+100);
            player1.setTempMoney(100);

            banker.setTempMoney(-100);
            banker.setMoney(-100);
        }
        else if(chestlist.getCardOrder()==7) {
            player1.setMoney(-100);
            player1.setTempMoney(-100);

            banker.setMoney(+100);
            banker.setTempMoney(100);
        }
        else if(chestlist.getCardOrder()==8) {

            player1.setMoney(-50);
            player1.setTempMoney(-50);

            banker.setMoney(+50);
            banker.setTempMoney(+50);
        }
        else if(chestlist.getCardOrder()==9) {

            player1.setMoney(+100);
            player1.setTempMoney(100);

            banker.setTempMoney(-100);
            banker.setMoney(-100);
        }
        else if(chestlist.getCardOrder()==10){

            player1.setMoney(+50);
            player1.setTempMoney(50);
            banker.setTempMoney(-50);
            banker.setMoney(-50);
        }

    }

    public  int getCardOrder() {
        return CardOrder;
    }

    public  void setCardOrder(int cardOrder) {
        CardOrder = cardOrder;
    }

    public ArrayList<String> getCommunityChestList() {
        return CommunityChestList;
    }

    public void setCommunityChestList(String str) {
        CommunityChestList.add(str);
    }
}
