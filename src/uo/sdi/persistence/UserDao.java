package uo.sdi.persistence;

import uo.sdi.model.User;
import uo.sdi.persistence.util.GenericDao;

public interface UserDao extends GenericDao<User, Long>{

	User findByLoginPass(String login, String passwd);
	User findByLogin(String login);
	

}
