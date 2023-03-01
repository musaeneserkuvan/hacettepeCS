public class Player extends ActivePlayerCheck implements Comparable<Player> {

    private int points;
    private int temppoints;
    private String name;





    public Player(int points, String name) {
        this.points = points;
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points){

        this.points += points;
    }


    public int getTemppoints() {
        return temppoints;
    }

    public void setTempPoints(int temppoints) {
        this.temppoints = temppoints;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Player o) {

        return Integer.compare(points, o.points);
    }

}
