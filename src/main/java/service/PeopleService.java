package service;

import entity.People;

public interface PeopleService {
    People login(String username, String password);

    void register(String username,String password);
}
