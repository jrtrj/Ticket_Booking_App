package com.trainBooking.app.Services;

import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.trainBooking.app.Util.AuthUtil;
import com.trainBooking.app.entities.User;

public class UserService {
    private static final File userDBPath = new File("src/main/java/com/trainBooking/app/LocalDB/User.json");
    private User loggedInUser;
    private JsonDBService jsonDBService;
    private List<User> userList;
    public UserService() {}
    public UserService(JsonDBService jsonDBService) {
        this.jsonDBService = jsonDBService;
        try {
            readUserFromDB();
        } catch (IOException e) {
            System.err.println("Could not load users during service init" + e.getMessage());
        }
    }

    public void readUserFromDB() throws IOException {
        userList = jsonDBService.readAll(userDBPath,new TypeReference<List<User>>(){});
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
    public Boolean signUp(User newUser) {
        try {
            Optional<User> existingUser = userList
                    .stream()
                    .filter(user -> user.getEmail().equalsIgnoreCase(newUser.getEmail()))
                    .findFirst();
            if(existingUser.isPresent())
                return false;
            userList.add(newUser);
            jsonDBService.writeAll(userDBPath,userList);
            return true;
        }catch (IOException e) {
            System.err.println("Could not write into db during signUp "+e.getMessage());
        }
    }
}
//                userList.add(loggedInUser);
//                try {
//                        jsonDBService.writeAll(userDBPath, userList);
//                }catch(IOException e) {
//        System.err.println("loginUser failed at writing to DB" + e.getMessage());
//        }
//