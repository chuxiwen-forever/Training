package service.impl;

import entity.People;
import mapper.PeopleMapper;
import mapper.impl.PeopleMapperImpl;
import service.PeopleService;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PeopleServiceImpl implements PeopleService {
    private PeopleMapper peopleMapper = new PeopleMapperImpl();

    @Override
    public People login(String username, String password) {
        return peopleMapper.selectByPeople(username, password);
    }

    @Override
    public void register(String username, String password) {
        peopleMapper.insert(username, password);
    }
}
