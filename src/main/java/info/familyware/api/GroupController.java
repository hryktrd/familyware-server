package info.familyware.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import info.familyware.domain.Group;
import info.familyware.service.GroupService;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/groups")
@CrossOrigin
public class GroupController {
	@Autowired
	GroupService groupService;

	@RequestMapping(method = RequestMethod.GET)
	List<Group> getGroups(@RequestParam("userId") Optional<Long> userId) {
		if(userId.isPresent()){
			return groupService.findByUserId(userId.get());
		}else{
			System.out.println("kitayo");
			return groupService.findAll();
		}
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	Group getGroup(@PathVariable("id") Long id) {
        return groupService.find(id);
    }
	
	@RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
	Group insertGroup(@Validated @RequestBody Group group) {
        return groupService.save(group);
    }
     
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    Group updateGroup(@PathVariable("id") Long id, @Validated @RequestBody Group group) {
    	group.setId(id);
      return groupService.save(group);
    }
      
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    void deleteGroup(@PathVariable("id") Long id) {
    	groupService.delete(id);
    }

}
