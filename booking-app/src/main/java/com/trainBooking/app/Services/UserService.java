package com.trainBooking.app.Services;

import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.util.List;
import com.trainBooking.app.entities.User;

public class UserService {
    private static final String userDBPath = "src/main/java/com/trainBooking/app/LocalDB/User.json";
    private User user;
    private JsonDBService jsonDBService;
    private List<User> userList;
    public UserService() {}
    public UserService(User user, JsonDBService jsonDBService) {
        this.user = user;
        this.jsonDBService = jsonDBService;
        readUserFromDB(userDBPath);
    }
    public void readUserFromDB(String userDBPath) {
        File path = new File(userDBPath);
        userList = jsonDBService.readAll(path,new TypeReference<<List User>(){});
    }
    public Boolean loginUser() {
        Boolean isPresent = userList.stream()
                                    .map(u -> u.getUserId())
                                    .filter(id -> user.getUserId().equalsIgnoreCase(id)
                                            && AuthenticationService.checkPassword())
    }
}
