package homeworkapp.ws.ui.controlloer;



import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import homeworkapp.ws.ui.model.request.UpdateUserDetailRequestModel;
import homeworkapp.ws.ui.model.request.UserDetailRequestModel;
import homeworkapp.ws.ui.model.response.UserRest;
import homeworkapp.ws.userservice.UserService;

@RestController
@RequestMapping("/users") //http://localhost:8080/users
public class UserController {
	
	Map<String, UserRest> users;
	
	@Autowired
	UserService userService;
	
	@GetMapping
	public String getUsers(@RequestParam(value="page", defaultValue="1")int page,
			@RequestParam(value="limit" , defaultValue="50")int limit,
			@RequestParam(value="sort", defaultValue = "desc", required = false) String sort) {
		return "get user was called whith limit + " + page + "limit" + limit + "sort" + sort ;
	}
	
	@GetMapping(path="/{userId}", 
	produces = {org.springframework.http.MediaType.APPLICATION_XHTML_XML_VALUE, 
			    org.springframework.http.MediaType.APPLICATION_PROBLEM_JSON_VALUE} ) 
	public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
		
		
		if (users.containsKey(userId)) {
			return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
				
		
	}
	@PostMapping(consumes = {
			org.springframework.http.MediaType.APPLICATION_XHTML_XML_VALUE, 
		    org.springframework.http.MediaType.APPLICATION_PROBLEM_JSON_VALUE},
			produces = {
					org.springframework.http.MediaType.APPLICATION_XHTML_XML_VALUE, 
				    org.springframework.http.MediaType.APPLICATION_PROBLEM_JSON_VALUE} ) 
	public ResponseEntity<UserRest> creteUser(@Valid@RequestBody UserDetailRequestModel userDetails)
	{
	UserRest returnValue = userService.createUser(userDetails);	
	return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
	}
	
	@PutMapping(path="/{userId}",consumes = {
			org.springframework.http.MediaType.APPLICATION_XHTML_XML_VALUE, 
		    org.springframework.http.MediaType.APPLICATION_PROBLEM_JSON_VALUE},
			produces = {
					org.springframework.http.MediaType.APPLICATION_XHTML_XML_VALUE, 
				    org.springframework.http.MediaType.APPLICATION_PROBLEM_JSON_VALUE} )
	public UserRest updateUser(@PathVariable String userId, 
			@Valid @RequestBody UpdateUserDetailRequestModel userDetails) {
		
		   UserRest storedUserDetails = users.get(userId);
		   storedUserDetails.setFirstName(userDetails.getFirstName());
		   storedUserDetails.setLastName(userDetails.getLastName());
		   
		   users.put(userId, storedUserDetails);
		   
		   return storedUserDetails;
	}
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable String id) {
		users.remove(id);
		return ResponseEntity.noContent().build();
	}

}
