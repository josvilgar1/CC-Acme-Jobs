
package acme.entities.companyrecords;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Companyrecord extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				name;

	@NotBlank
	private String				sector;

	@NotBlank
	private String				ceo;

	@NotBlank
	private String				description;

	@NotBlank
	@URL
	private String				web;

	@NotBlank
	@Pattern(regexp = "^(\\+\\d{1,3})?(\\(\\d{1,4}\\))?\\d{6,10}$")
	@Column(unique = true)
	private String				phone;

	@NotBlank
	@Email
	@Column(unique = true)
	private String				email;

	private Boolean				incorporated;

	@Range(min = 1, max = 5)
	private Integer				stars;

}
