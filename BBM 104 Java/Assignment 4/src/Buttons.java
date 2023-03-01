import javafx.scene.control.Button;
import javafx.scene.control.Slider;

public class Buttons  {

    private  Button login;

    private  Button signup;

    private  Button addfilm;

    private  Button removefilm;

    private  Button edituser;

    private  Button logout;

    private  Button ok;

    private  Button back;

    private  Button addhall;

    private  Button removehall;

    private  Button playbutton ;

    private  Button backwardbutton;

    private  Button forwardbutton ;

    private  Button replaybutton ;

    private  Button promotemember;

    private  Button promoteadmin;

    private  Slider volumeslide =new Slider(0, 100, 50);

    public Buttons( ) {

        this.login =new Button("LOGIN");
        this.signup= new Button("SIGNUP");
        this.addfilm= new Button("Add Film");
        this.removefilm= new Button("Remove Film");
        this.edituser= new Button("Edit Users");
        this.logout = new Button("LOG OUT");
        this.ok = new Button("OK");
        this.back = new Button("<  BACK");
        this.addhall= new Button("Add Hall");
        this.removehall = new Button("Remove Hall");
        this.playbutton = new Button("  >  ");
        this.backwardbutton  = new Button("<< ");
        this.forwardbutton = new Button(">> ");
        this.replaybutton = new Button("|<<");
        this.promotemember = new Button("Promote/Demote Club Member");
        this.promoteadmin= new Button("Promote/Demote Admin");


    }

    public Button getLogin() {
        return login;
    }

    public Button getSignup() {
        return signup;
    }

    public Button getAddfilm() {
        return addfilm;
    }

    public Button getRemovefilm() {
        return removefilm;
    }

    public Button getEdituser() {
        return edituser;
    }

    public Button getLogout() {
        return logout;
    }

    public Button getOk() {
        return ok;
    }

    public Button getBack() {
        return back;
    }

    public Button getAddhall() {
        return addhall;
    }

    public Button getRemovehall() {
        return removehall;
    }

    public Button getPlaybutton() {
        return playbutton;
    }

    public Button getBackwardbutton() {
        return backwardbutton;
    }

    public Button getForwardbutton() {
        return forwardbutton;
    }

    public Button getReplaybutton() {
        return replaybutton;
    }

    public Button getPromotemember() {
        return promotemember;
    }

    public Button getPromoteadmin() {
        return promoteadmin;
    }

    public Slider getVolumeslide() {
        return volumeslide;
    }
}
