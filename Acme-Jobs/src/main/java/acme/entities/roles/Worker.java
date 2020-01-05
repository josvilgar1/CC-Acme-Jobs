
package acme.entities.roles;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import acme.framework.entities.UserRole;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Worker extends UserRole {

	// Serialization identifier -----------------------

	private static final long	serialVersionUID	= 1L;

	//Attributes ---------------------------------------

	@NotBlank
	@Length(max = 1200)
	private String				qualifications;

	@NotBlank
	@Length(max = 1200)
	private String				skills;

	//Derived attributes --------------------------------

	//Relationships -------------------------------------

}
