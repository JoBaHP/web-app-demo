package homeworkapp.wsuserservice.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import homeworkapp.ws.shared.Utils;
import homeworkapp.ws.ui.model.request.UserDetailRequestModel;
import homeworkapp.ws.ui.model.response.UserRest;
import homeworkapp.ws.userservice.UserService;

@Service
public class UserServiceImpl implements UserService {

	Map<String, UserRest> users;

	Utils utils;

	public UserServiceImpl() {

	}
    @Autowired
	public UserServiceImpl(Utils utils) {
		
		this.utils = utils;

	}

	@Override
	public UserRest createUser(UserDetailRequestModel userDetail) {
		// TODO Auto-generated method stub
		UserRest returnValue = new UserRest();
		returnValue.setEmail(userDetail.getEmail());
		returnValue.setFirstName(userDetail.getFirstName());
		returnValue.setLastName(userDetail.getLastName());

		String userId = utils.generateUserId();
		returnValue.setUserId(userId);

		if (users == null)
			users = new HashMap<>();
		users.put(userId, returnValue);

		return returnValue;

	}

}
