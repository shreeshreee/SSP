package org.jasig.ssp.transferobject;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Nullable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.jasig.ssp.model.Person;

import com.google.common.collect.Lists;

/**
 * Person transfer object
 */
public class PersonTO
		extends AbstractAuditableTO<Person>
		implements TransferObject<Person> {

	private String firstName, middleInitial, lastName;

	private Date birthDate;

	private String primaryEmailAddress, secondaryEmailAddress;

	private String username, userId;

	private String homePhone, workPhone, cellPhone;

	private String addressLine1, addressLine2, city, state, zipCode;

	private String photoUrl;

	private String schoolId;

	private boolean enabled;

	private UUID coachId;

	private String strengths;

	@Nullable
	private Boolean abilityToBenefit;

	@Nullable
	@Size(max = 20)
	private String anticipatedStartTerm;

	@Nullable
	@Max(2100)
	@Min(2000)
	private Integer anticipatedStartYear;

	/**
	 * Empty constructor
	 */
	public PersonTO() {
		super();
	}

	/**
	 * Construct a transfer object from a related model instance
	 * 
	 * @param model
	 *            Initialize instance from the data in this model
	 */
	public PersonTO(final Person model) {
		super();
		from(model);
	}

	@Override
	public final void from(final Person model) {
		super.from(model);

		firstName = model.getFirstName();
		middleInitial = model.getMiddleInitial();
		lastName = model.getLastName();
		birthDate = model.getBirthDate();
		primaryEmailAddress = model.getPrimaryEmailAddress();
		secondaryEmailAddress = model.getSecondaryEmailAddress();
		username = model.getUsername();
		userId = model.getUserId();
		homePhone = model.getHomePhone();
		workPhone = model.getWorkPhone();
		cellPhone = model.getCellPhone();
		addressLine1 = model.getAddressLine1();
		addressLine2 = model.getAddressLine2();
		city = model.getCity();
		state = model.getState();
		zipCode = model.getZipCode();
		photoUrl = model.getPhotoUrl();
		schoolId = model.getSchoolId();
		enabled = model.isEnabled();
		coachId = model.getCoach() == null ? null : model.getCoach().getId();
		strengths = model.getStrengths();
		abilityToBenefit = model.isAbilityToBenefit();
		anticipatedStartTerm = model.getAnticipatedStartTerm();
		anticipatedStartYear = model.getAnticipatedStartYear();
	}

	/**
	 * Convert a collection of models to a List of equivalent transfer objects.
	 * 
	 * @param models
	 *            A collection of models to convert to transfer objects
	 * @return List of equivalent transfer objects
	 */
	public static List<PersonTO> toTOList(
			@NotNull final Collection<Person> models) {
		final List<PersonTO> tos = Lists.newArrayList();
		for (Person model : models) {
			tos.add(new PersonTO(model)); // NOPMD by jon.adams on 5/13/12
		}

		return tos;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleInitial() {
		return middleInitial;
	}

	public void setMiddleInitial(final String middleInitial) {
		this.middleInitial = middleInitial;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate == null ? null : new Date(birthDate.getTime());
	}

	public void setBirthDate(final Date birthDate) {
		this.birthDate = birthDate == null ? null : new Date(
				birthDate.getTime());
	}

	public String getPrimaryEmailAddress() {
		return primaryEmailAddress;
	}

	public void setPrimaryEmailAddress(final String primaryEmailAddress) {
		this.primaryEmailAddress = primaryEmailAddress;
	}

	public String getSecondaryEmailAddress() {
		return secondaryEmailAddress;
	}

	public void setSecondaryEmailAddress(final String secondaryEmailAddress) {
		this.secondaryEmailAddress = secondaryEmailAddress;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(final String userId) {
		this.userId = userId;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(final String homePhone) {
		this.homePhone = homePhone;
	}

	public String getWorkPhone() {
		return workPhone;
	}

	public void setWorkPhone(final String workPhone) {
		this.workPhone = workPhone;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(final String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(final String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(final String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(final String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(final String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(final String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(final String photoUrl) {
		this.photoUrl = photoUrl;
	}

	/**
	 * Gets the SchoolID (a.k.a. Student ID given by the school)
	 * 
	 * @return the SchoolID
	 */
	public String getSchoolId() {
		return schoolId;
	}

	/**
	 * Sets the SchoolID (a.k.a. Student ID given by the school)
	 * 
	 * @param schoolId
	 *            the SchoolID (a.k.a. Student ID given by the school); maximum
	 *            length of 50 characters
	 */
	public void setSchoolId(final String schoolId) {
		this.schoolId = schoolId;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(final boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return the coachId
	 */
	public UUID getCoachId() {
		return coachId;
	}

	/**
	 * @param coachId
	 *            the coachId to set
	 */
	public void setCoachId(final UUID coachId) {
		this.coachId = coachId;
	}

	public String getStrengths() {
		return strengths;
	}

	public void setStrengths(final String strengths) {
		this.strengths = strengths;
	}

	public Boolean getAbilityToBenefit() {
		return abilityToBenefit;
	}

	public void setAbilityToBenefit(final Boolean abilityToBenefit) {
		this.abilityToBenefit = abilityToBenefit;
	}

	public String getAnticipatedStartTerm() {
		return anticipatedStartTerm;
	}

	public void setAnticipatedStartTerm(final String anticipatedStartTerm) {
		this.anticipatedStartTerm = anticipatedStartTerm;
	}

	public Integer getAnticipatedStartYear() {
		return anticipatedStartYear;
	}

	public void setAnticipatedStartYear(final Integer anticipatedStartYear) {
		this.anticipatedStartYear = anticipatedStartYear;
	}

}
