package BST.BSTspring.controller;

import java.util.UUID;

public class MemberDTO {
    private String email;
    private String authKey;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAuthKey() {
        return authKey;
    }

    public void generateAuthKey() {
        this.authKey = UUID.randomUUID().toString();
    }

    public void setAuthKey(String authKey) {
        this.authKey = authKey;
    }
}

