package info.familyware.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import info.familyware.domain.FamilyUser;
import info.familyware.domain.FamilyUserRepository;
import info.familyware.domain.User;

import java.util.List;

@Service
@Transactional
public class FamilyUserService {
	
	@Autowired
	FamilyUserRepository familyUserRepository;
	
	public List<FamilyUser> findUnConfirmed(Long id) {
		return familyUserRepository.findUnConfirmed(id);
	}
	
	public void confirm(Long userId, Long familyId){
		familyUserRepository.confirm(userId, familyId);
	}
	public FamilyUser save(FamilyUser familyUser) {
		return familyUserRepository.save(familyUser);
	}

}
