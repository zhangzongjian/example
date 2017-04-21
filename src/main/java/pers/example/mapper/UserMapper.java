package pers.example.mapper;

import java.util.List;
import pers.example.model.User;
import pers.example.util.Pager;

public interface UserMapper {
	
    int deleteByPrimaryKey(String id);

    int insert(User user);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKey(User user);

	List<User> search(Pager pager);
	
}