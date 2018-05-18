package com.rts.gigantes.services;

import com.rts.gigantes.entities.User;

public interface UserService {

	User findUserByLogin(String login);

	void saveUser(User user);
}
