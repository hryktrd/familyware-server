package info.familyware.domain;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import info.familyware.domain.FamilyUser;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FamilyUserRepository extends JpaRepository<FamilyUser, FamilyUserKey>{
	@Query (value = "SELECT * FROM familyware.family_user fu where fu.user_id = :id", nativeQuery = true)
    List<FamilyUser> findUnConfirmed(@Param("id") Long id);
	
	@Query (value = "UPDATE familyware.family_user fu SET confirm=1 where fu.user_id = :uid AND fu.family_id = :fid", nativeQuery = true)
    void confirm(@Param("uid") Long uid, @Param("fid") Long fid);
}
