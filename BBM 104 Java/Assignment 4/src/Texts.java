
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Texts {

    private  Text text1 ;

    private  Text text2;

    private Text text3;

    private  Text text4;

    private  Text text5 ;

    private  Text text6;

    private  Text text7 ;

    private  Text text8 ;

    private Text text9 ;

    private  Text text10;

    private  Text text11 ;

    private  Text text12;

    private  Text text13 ;

    private  Text text14;



    private  Text text16;

    private  Text text17;

    private  Text text18;

    private  Text text19;

    private  Text text20;

    private  Text hoverText;

    private  Text password2;


    private  Text system;

    private  Text info;

    private  Text sign1;

    private  Text sign2;

    public Texts() {

        this.sign1=new Text("Fill the form below to create a new account.");
        this.sign2= new Text("You can go to Log In page by clicking LOG IN Button");
        this.text1 = new Text("Username:");
        this.text2  = new Text("Password:");

        this.text4  = new Text("Select the film that you desire to remove and then click OK.");
        this.text5 = new Text("Please give name, relative path of the trailer and the duration of the film.");
        this.text6  = new Text("Name:");
        this.text7 = new Text("Trailer (Path):");
        this.text8 = new Text("Duration (m):");

        this.text9 = new Text("movie name + (duration minutes)");/// değişecek kontrol

        this.password2 = new Text("Password:");

        this.text10  = new Text("Row:");
        this.text11 = new Text("Column:");
        this.text12  = new Text("Name:");
        this.text13 = new Text("Price:");

        this.text14  = new Text("Select the hall that you desire to remove from +movie name+ and then click OK."); // kontrol


        this.text16 = new Text("Welcome to the HUCS Cinema Resarvation System!");// propertiden al

        this.text17 = new Text("Please enter your credentials below and click LOGIN.");

        this.text18 = new Text("You can create a new account by clicking SIGN UP button.");

        this.text19 = new Text("You can either select film below or do edits.");

        this.text20 = new Text("Select a film and then click OK to continue.");

        this.hoverText = new Text("   ");
        this.hoverText.setFont(new Font(20));




        this.system= new Text("System info:");
        this.system.setFont( new Font(20));
        this.system.relocate(100,895);

        this.info= new Text("");
        this.info.setFont(new Font(20));
        this.info.relocate(220,895);




    }

    public Text getSign1() {
        return sign1;
    }

    public Text getSign2() {
        return sign2;
    }

    public Text getInfo() {
        return info;
    }

    public Text getSystem() {
        return system;
    }



    public Text getPassword2() {
        return password2;
    }

    public void setText9(String text) {
        this.text9 = new Text(text);
    }

    public Text getText20() {
        return text20;
    }

    public void setText3(String text) {
        this.text3 = new Text(text);
    }

    public Text getHoverText() {
        return hoverText;
    }



    public Text getText19() {
        return text19;
    }

    public Text getText16() {
        return text16;
    }

    public Text getText17() {
        return text17;
    }

    public Text getText18() {
        return text18;
    }

    public Text getText1() {
        return text1;
    }

    public Text getText2() {
        return text2;
    }

    public Text getText3() {
        return text3;
    }

    public Text getText4() {
        return text4;
    }

    public Text getText5() {
        return text5;
    }

    public Text getText6() {
        return text6;
    }

    public Text getText7() {
        return text7;
    }

    public Text getText8() {
        return text8;
    }

    public Text getText9() {
        return text9;
    }

    public Text getText10() {
        return text10;
    }

    public Text getText11() {
        return text11;
    }

    public Text getText12() {
        return text12;
    }

    public Text getText13() {
        return text13;
    }

    public Text getText14() {
        return text14;
    }


}
