public class Land extends Map {

    public Land(){
    }
    public Land(int id, int cost, String name, String land,String supertype) {
        super(id,cost,name,land,supertype);
    }

    public void rent(
            Player player1,
            Player player2,
            Map[] maplist,
            String str) {

        if(maplist[player1.getLocation()].getCost() > -1 && maplist[player1.getLocation()].getCost() < 2001){
            player1.setMoney(-((maplist[player1.getLocation()].getCost())*40)/100);
            player1.setTempMoney(-((maplist[player1.getLocation()].getCost())*40)/100);

            player2.setMoney(((maplist[player1.getLocation()].getCost())*40)/100);
            player2.setTempMoney(((maplist[player1.getLocation()].getCost())*40)/100);
        }
        else if (maplist[player1.getLocation()].getCost() > 2000 && maplist[player1.getLocation()].getCost() < 3001){
            player1.setTempMoney(-((maplist[player1.getLocation()].getCost())*30)/100);
            player1.setMoney(-((maplist[player1.getLocation()].getCost())*30)/100);

            player2.setMoney(((maplist[player1.getLocation()].getCost())*30)/100);
            player2.setTempMoney(((maplist[player1.getLocation()].getCost())*30)/100);
        }
        else if (maplist[player1.getLocation()].getCost() > 3000 && maplist[player1.getLocation()].getCost() < 4001){
            player1.setTempMoney(-((maplist[player1.getLocation()].getCost())*35)/100);
            player1.setMoney(-((maplist[player1.getLocation()].getCost())*35)/100);

            player2.setMoney(((maplist[player1.getLocation()].getCost())*35)/100);
            player2.setTempMoney(((maplist[player1.getLocation()].getCost())*35)/100);
        }
    }

}
