package pers.example.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pers.example.mapper.UserMapper;
import pers.example.model.User;
import pers.example.service.UserService;
import pers.example.util.Pager;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;
	
	public User searchById(String id){
		return userMapper.selectByPrimaryKey(id);
	}
	
	public int insert(User user) {
		return userMapper.insert(user);
	}
	
	public int update(User user) {
		return userMapper.updateByPrimaryKey(user);
	}
	
	public int delete(String id){
		return userMapper.deleteByPrimaryKey(id);
	}
	
	public Pager search(Pager pager) {
		if(pager == null){
		  pager = new Pager();
		}
		List<User> items = userMapper.search(pager);
		pager.setDatas(items);	  
		return pager;
	}

}