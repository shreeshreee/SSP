package org.jasig.ssp.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.jasig.ssp.model.reference.ConfidentialityDisclosureAgreement;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class PersonConfidentialityDisclosureAgreement
		extends AbstractAuditable
		implements PersonAssocAuditable {

	private static final long serialVersionUID = 27277225191519712L;

	/**
	 * Associated person. Changes to this Person are not persisted.
	 */
	@ManyToOne()
	@JoinColumn(name = "person_id", updatable = false, nullable = false)
	private Person person;

	@ManyToOne()
	@Cascade({ CascadeType.MERGE, CascadeType.PERSIST })
	@JoinColumn(name = "confidentiality_disclosure_agreement_id", updatable = false, nullable = false)
	private ConfidentialityDisclosureAgreement confidentialityDisclosureAgreement;

	public PersonConfidentialityDisclosureAgreement() {
		super();
	}

	public PersonConfidentialityDisclosureAgreement(
			final Person person,
			final ConfidentialityDisclosureAgreement confidentialityDisclosureAgreement) {
		super();
		this.person = person;
		this.confidentialityDisclosureAgreement = confidentialityDisclosureAgreement;
	}

	@Override
	public Person getPerson() {
		return person;
	}

	@Override
	public void setPerson(final Person person) {
		this.person = person;
	}

	public ConfidentialityDisclosureAgreement getConfidentialityDisclosureAgreement() {
		return confidentialityDisclosureAgreement;
	}

	public void setConfidentialityDisclosureAgreement(
			final ConfidentialityDisclosureAgreement confidentialityDisclosureAgreement) {
		this.confidentialityDisclosureAgreement = confidentialityDisclosureAgreement;
	}

	/**
	 * Overwrites simple properties with the parameter's properties.
	 * 
	 * @param source
	 *            Source to use for overwrites.
	 */
	public void overwrite(final PersonConfidentialityDisclosureAgreement source) {
		person = source.getPerson();
		confidentialityDisclosureAgreement = source
				.getConfidentialityDisclosureAgreement();
	}

	@Override
	protected int hashPrime() {
		return 7;
	};

	@Override
	final public int hashCode() { // NOPMD by jon.adams on 5/24/12 1:34 PM
		int result = hashPrime();

		// AbstractAuditable properties
		result *= hashField("id", getId());
		result *= hashField("objectStatus", getObjectStatus());

		// PersonConfidentialityDisclosureAgreement
		result *= hashField("person", person);
		result *= hashField("confidentialityDisclosureAgreement",
				confidentialityDisclosureAgreement);

		return result;
	}
}