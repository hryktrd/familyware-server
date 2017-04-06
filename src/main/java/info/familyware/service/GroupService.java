package info.familyware.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import info.familyware.domain.Group;
import info.familyware.domain.GroupRepository;

import java.util.List;

@Service
@Transactional
public class GroupService {

	@Autowired
	GroupRepository groupRepository;

	public List<Group> findAll() {
		return groupRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	public Group save(Group group) {
		return groupRepository.save(group);
	}

	public void delete(Long id) {
		groupRepository.delete(id);
	}

	public Group find(Long id) {
		return groupRepository.findOne(id);
	}
	
	public List<Group> findByUserId(Long id) {
		try {
			Thread.sleep(5000);
		}catch (InterruptedException e) {
			
		}
		return groupRepository.findByUserId(id);
	}

}
