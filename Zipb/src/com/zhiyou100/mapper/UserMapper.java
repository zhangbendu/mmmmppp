package com.zhiyou100.mapper;

import java.util.HashMap;
import java.util.List;

import com.zhiyou100.model.User;

import javassist.compiler.ast.Keyword;

public interface UserMapper {
	User findUserById(int id);
	void insertUser(User user);
	void updateUser(User user);
	void deleteUserById(int id);
	User findUserByHashMap(HashMap hm);
	List<User> findUserByLikeName(String name);
	List<User> fidUserByKwd(Keyword keyword);
	
}
