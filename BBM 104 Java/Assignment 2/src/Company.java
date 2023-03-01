public class Company extends Map {

    public Company(int id, int cost, String name, String company,String supertype) {
        super(id,cost,name,company,supertype);
    }

    public Company() {
    }

    public void rent(
            Player player1,
            Player player2,
            Map[] maplist,
            String str){

        player1.setMoney(- ((4 * Integer.parseInt(str)) ));
        player1.setTempMoney(- ((4 * Integer.parseInt(str)) ));

        player2.setTempMoney(((4 * Integer.parseInt(str)) ));
        player2.setMoney( ((4 * Integer.parseInt(str)) ) );
    }
}

