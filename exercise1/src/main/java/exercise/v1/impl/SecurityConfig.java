package exercise.v1.impl;

import java.util.HashMap;

public class SecurityConfig {

    private final HashMap<String, String> userPasswordMap;

    public SecurityConfig() {
        // set key-value-pairs for login
        userPasswordMap = new HashMap<>();
        userPasswordMap.put("admin", "admin");
        userPasswordMap.put("supp", "Supp!");
        userPasswordMap.put("marcel2000", "1233");
    }

    public boolean authorizationCheck(String user, String password) {
        if(userPasswordMap.containsKey(user)) {
            return userPasswordMap.get(user).equals(password);
        } else {
            return false;
        }
    }
}
