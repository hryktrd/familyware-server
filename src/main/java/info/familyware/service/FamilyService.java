package info.familyware.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import info.familyware.domain.Family;
import info.familyware.domain.FamilyRepository;

import java.util.List;

@Service
@Transactional
public class FamilyService {

	@Autowired
	FamilyRepository familyRepository;

	public List<Family> findAll() {
		return familyRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	public Family save(Family group) {
		return familyRepository.save(group);
	}

	public void delete(Long id) {
		familyRepository.delete(id);
	}

	public Family find(Long id) {
		return familyRepository.findOne(id);
	}
	
	public List<Family> findByUserId(Long id) {
		try {
			Thread.sleep(5000);
		}catch (InterruptedException e) {
			
		}
		return familyRepository.findByUserId(id);
	}

}
