package util.db;

import java.util.List;

import model.User;

public interface UsersMapper {
	User getClientById(User user);
	List<User> getAllUsers();
	boolean insertClient(User user);
	boolean updateClient(User user);
	boolean deleteClient(User user);
}
