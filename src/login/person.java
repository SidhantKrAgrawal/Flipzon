package login;

import java.util.Scanner;

public class person {

    private String name;
    private String password;

    public person(String name, String password) {
        this.name = name;
        this.password = password;
    }

    protected String getName() {
        return name;
    }


    protected boolean Authentication(String username, String password) {
        if (username == this.name && password == this.password) {
            return true;
        }
        return false;

    }

    protected boolean Authentication(String password) {
        if (password == this.password) {
            return true;
        }
        return false;

    }

}
