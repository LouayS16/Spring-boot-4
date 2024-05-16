package com.louay.Medecins.service;

import com.louay.Medecins.entities.Role;
import com.louay.Medecins.entities.User;

public interface UserService {
	void deleteAllusers();
	void deleteAllRoles();
	User saveUser(User user);
	User findUserByUsername (String username);
	Role addRole(Role role);
	User addRoleToUser(String username, String rolename);
}