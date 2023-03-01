import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;

public class Users {

    private StringProperty username ;

    private String passwordBase64encoded;

    private BooleanProperty member;

    private BooleanProperty admin;

    public Users(String username, String passwordBase64encoded, boolean member, boolean admin) {
        this.username  = new SimpleStringProperty(this,username,username);
        this.passwordBase64encoded = passwordBase64encoded;
        this.member = new SimpleBooleanProperty(this,username,member);
        this.admin = new SimpleBooleanProperty(this,username,admin);

    }

    public ObservableValue<? extends String> getUserObsername() {
        return username;
    }

    public  String getUsername() {
        return username.get();
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getPasswordBase64encoded() {
        return passwordBase64encoded;
    }

    public void setPasswordBase64encoded(String passwordBase64encoded) {
        this.passwordBase64encoded = passwordBase64encoded;
    }

    public boolean isMember() {
        return member.get();
    }

    public BooleanProperty memberProperty() {
        return member;
    }

    public void setMember(boolean member) {
        this.member.set(member);
    }

    public boolean isAdmin() {
        return admin.get();
    }

    public BooleanProperty adminProperty() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin.set(admin);
    }
}
