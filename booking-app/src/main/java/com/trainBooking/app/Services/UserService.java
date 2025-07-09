package com.trainBooking.app.Services;

import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.util.List;
import java.util.Optional;

import com.trainBooking.app.Util.AuthUtil;
import com.trainBooking.app.entities.User;

public class UserService {
    private static final String userDBPath = "src/main/java/com/trainBooking/app/LocalDB/User.json";
    private User loggedInUser;
    private JsonDBService jsonDBService;
    private List<User> userList;
    public UserService() {}
    public UserService(JsonDBService jsonDBService) {
        this.jsonDBService = jsonDBService;
        readUserFromDB(userDBPath);
    }
    public void readUserFromDB(String userDBPath) {
        File path = new File(userDBPath);
        userList = jsonDBService.readAll(path,new TypeReference<List<User>>(){});
    }
    public Boolean loginUser(String email, String password) {
        Optional<User> foundUser = userList
                                    .stream()
                                    .filter(u -> u.getEmail().equals(email))
                                    .findFirst();
        if(foundUser.isPresent()) {
            User user = foundUser.get();
            if (AuthUtil.verifyPasswd(password,foundUser.get().getHashedPassword())) {
                loggedInUser = user;
                return true;
            }
        }
        return false;
    }
}
