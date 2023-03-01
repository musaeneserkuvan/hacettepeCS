public abstract class Map {

    private int locID;
    private int cost;
    private String Name;
    private String Type;
    private String SuperType;

    /// CONSTRUCTOR
    public Map(int id, int cost, String name, String type,String supertype) {
        this.locID=id;
        this.cost=cost;
        this.Name=name;
        this.Type=type;
        this.SuperType=supertype;
    }

    public Map() {

    }

    /// ABSTRACT FUNCTION
    public abstract void rent(Player player1,Player player2,Map[] maplist,String dicearg);

    ///GETTER SETTER


    public String getSuperType() {
        return SuperType;
    }



    public int getLocID() {
        return locID;
    }



    public int getCost() {
        return cost;
    }



    public String getName() {
        return Name;
    }



    public String getType() {
        return Type;
    }


}
