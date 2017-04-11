package info.familyware.domain;

import java.io.Serializable;
 
import lombok.Getter;
import lombok.Setter;
 
public class FamilyUserKey implements Serializable {
   
  @Getter
  @Setter
  private Long family_id;
   
  @Getter
  @Setter
  private Long user_id;
   
}