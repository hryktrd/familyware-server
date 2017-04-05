package info.familyware.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import info.familyware.domain.User;
import info.familyware.domain.UserRepository;

import java.util.List;

@Service
@Transactional
public class UserService {

	@Autowired
	UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	public User save(User user) {
		return userRepository.save(user);
	}

	public void delete(Long id) {
		userRepository.delete(id);
	}

	public User find(Long id) {
		return userRepository.findOne(id);
	}
	
	public List<User> findByUuid(String uuid) {
		try {
			Thread.sleep(5000);
		}catch (InterruptedException e) {
			
		}
		return userRepository.findByUuid(uuid);
	}

}
