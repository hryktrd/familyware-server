package info.familyware.domain;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import info.familyware.domain.Family;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FamilyRepository extends JpaRepository<Family, Long>{
	@Query (value = "SELECT * FROM familyware.family f left join family_user fu on f.id = fu.family_id where fu.user_id = :id", nativeQuery = true)
    List<Family> findByUserId(@Param("id") Long id);
}
