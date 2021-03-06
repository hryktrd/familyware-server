package info.familyware.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import info.familyware.domain.FamilyUser;
import info.familyware.domain.User;
import info.familyware.service.UserService;
import info.familyware.service.FamilyUserService;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/users")
@CrossOrigin
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	FamilyUserService familyUserService;
	@RequestMapping(method = RequestMethod.GET)
	List<User> getUsers(@RequestParam("uuid") Optional<String> uuid) {	//TODO: UUIDは後で必須に
		if(uuid.isPresent()){
			return userService.findByUuid(uuid.get());
		}else{
			return userService.findAll();
		}
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
    User getUser(@PathVariable("id") Long id) {
        return userService.find(id);
    }
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    User insertUser(@Validated @RequestBody User user) {
        return userService.save(user);
    }
     
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    User updateUser(@PathVariable("id") Long id, @Validated @RequestBody User user) {
      user.setId(id);
      return userService.save(user);
    }
    
    @RequestMapping(value = "{uid}/{fid}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    FamilyUser confirm(@PathVariable("uid") Long uid, @PathVariable("fid") Long fid, @RequestBody FamilyUser familyUser) {
    	familyUser.setFamily_id(fid);
    	familyUser.setUser_id(uid);
    	familyUser.setConfirm(true);
    	return familyUserService.save(familyUser);
    }
      
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    void deleteUser(@PathVariable("id") Long id) {
    	userService.delete(id);
    }

}
