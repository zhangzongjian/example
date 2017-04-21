package pers.example.service;

import pers.example.model.User;
import pers.example.util.Pager;

public interface UserService {

	User searchById(String id);
	
	Pager search(Pager pager);
	
	int insert(User user);

	int update(User user);
	
	int delete(String id);
	
}