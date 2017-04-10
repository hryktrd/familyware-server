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

import info.familyware.domain.Family;
import info.familyware.service.FamilyService;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/families")
@CrossOrigin
public class FamilyController {
	@Autowired
	FamilyService familyService;

	@RequestMapping(method = RequestMethod.GET)
	List<Family> getGroups(@RequestParam("userId") Optional<Long> userId) {
		if(userId.isPresent()){
			System.out.println("findByUserId");
			return familyService.findByUserId(userId.get());
		}else{
			System.out.println("findAll");
			return familyService.findAll();
		}
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	Family getGroup(@PathVariable("id") Long id) {
        return familyService.find(id);
    }
	
	@RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
	Family insertGroup(@Validated @RequestBody Family family) {
        return familyService.save(family);
    }
     
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    Family updateGroup(@PathVariable("id") Long id, @Validated @RequestBody Family family) {
    	family.setId(id);
    	return familyService.save(family);
    }
      
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    void deleteGroup(@PathVariable("id") Long id) {
    	familyService.delete(id);
    }

}
