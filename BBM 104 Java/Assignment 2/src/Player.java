import java.util.ArrayList;


public  class Player  {

    private int Playerlocation;
    private int TempMoney;
    private int Playermoney;
    private int JailTimer=0;
    private int DiceNumber;
    private String TempBuyName;

    private String PlayerName;
    private final ArrayList<String> OwnedPropertyList= new ArrayList<>();
    private final ArrayList<String> OwnedLandList= new ArrayList<>();
    private final ArrayList<String> OwnedCompanyList= new ArrayList<>();
    private final ArrayList<String> OwnedRailRoadList= new ArrayList<>();


    public Player(){

    }

    public Player(String name,int money,int loc) {
        this.Playerlocation=loc;
        this.PlayerName=name;
        this.Playermoney=money;
    }

    public void GoMoney(int location,Player player1,Player banker){
        if(location==40){

        }
        else{
            player1.setMoney((location/40)*200);
            banker.setMoney( -((location/40)*200));
        }
    }

    public int getLocation() {
        return Playerlocation;
    }

    public void setLocation(int location) {

        if(location==40 ){
            this.Playerlocation = 40;
        }
        else{
            this.Playerlocation = location % 40;
        }
    }

    public String getTempBuyName() {
        return TempBuyName;
    }

    public void setTempBuyName(String tempBuyName) {
        TempBuyName = tempBuyName;
    }

    public int getMoney() {
        return Playermoney;
    }

    public int getTempMoney() {
        return TempMoney;
    }

    public void setTempMoney(int mon){
        this.TempMoney=mon;
    }

    public void setMoney(int money) {
        this.Playermoney = Playermoney+ money;
    }

    public String getPlayerName() {
        return PlayerName;
    }





    public void setOwnedLandList(String str) {
        OwnedLandList.add(str);
    }


    public void setOwnedCompanyList(String str) {
        OwnedCompanyList.add(str);
    }

    public ArrayList<String> getOwnedRailRoadList() {
        return OwnedRailRoadList;
    }

    public void setOwnedRailRoadList(String str) {
        OwnedRailRoadList.add(str);
    }

    public ArrayList<String> getOwnedPropertyList() {
        return OwnedPropertyList;
    }

    public void setOwnedPropertyList(String str) {
        OwnedPropertyList.add(str);

    }

    public int getJailTimer() {
        return JailTimer;
    }

    public void setJailTimer(int jailTimer,Player player1) {
        if(player1.getLocation() == 11){
            this.JailTimer = (this.JailTimer + jailTimer) % 4;
        }
        else if(player1.getLocation() == 21){
            this.JailTimer = (this.JailTimer + jailTimer) % 2  ;
        }
    }

    public int getDiceNumber() {
        return DiceNumber;
    }

    public void setDiceNumber(int diceNumber) {
        DiceNumber = diceNumber;
    }


}
