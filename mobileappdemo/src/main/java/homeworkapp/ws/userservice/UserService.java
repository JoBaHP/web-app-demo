package homeworkapp.ws.userservice;

import homeworkapp.ws.ui.model.request.UserDetailRequestModel;
import homeworkapp.ws.ui.model.response.UserRest;

public interface UserService {
	UserRest createUser(UserDetailRequestModel userDetail);


}
