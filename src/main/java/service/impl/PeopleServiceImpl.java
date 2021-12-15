package service.impl;

import entity.People;
import mapper.PeopleMapper;
import mapper.impl.PeopleMapperImpl;
import service.PeopleService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public Map<String, Object> selectPeople() {
        Map<String,Object> map = new HashMap<>();
        List<People> peopleList = peopleMapper.selectAllPeople();
        StringBuilder builder = new StringBuilder();
        if (peopleList.isEmpty()){
            map.put("value","No");
        }else {
            map.put("value","Yes");
            for (People people : peopleList){
                builder.append(people.toString());
            }
            map.put("data",builder.toString());
        }
        return map;
    }

    @Override
    public void deletePeople(String username) {
        People people = new People();
        people.setUsername(username);
        peopleMapper.deletePeople(people);
    }
}
