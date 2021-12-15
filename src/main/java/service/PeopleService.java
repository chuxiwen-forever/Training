package service;

import entity.People;

import java.util.Map;

public interface PeopleService {
    People login(String username, String password);

    void register(String username,String password);

    Map<String,Object> selectPeople();

    void deletePeople(String username);
}
