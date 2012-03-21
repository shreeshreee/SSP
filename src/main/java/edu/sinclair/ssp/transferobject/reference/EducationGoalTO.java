package edu.sinclair.ssp.transferobject.reference;

import java.util.UUID;

import edu.sinclair.ssp.model.reference.EducationGoal;
import edu.sinclair.ssp.transferobject.TransferObject;

public class EducationGoalTO extends AbstractReferenceTO implements
		TransferObject<EducationGoal> {

	public EducationGoalTO() {
		super();
	}

	public EducationGoalTO(UUID id) {
		super(id);
	}

	public EducationGoalTO(UUID id, String name) {
		super(id, name);
	}

	public EducationGoalTO(UUID id, String name, String description) {
		super(id, name, description);
	}

	public EducationGoalTO(EducationGoal model) {
		super();
		pullAttributesFromModel(model);
	}

	@Override
	public void pullAttributesFromModel(EducationGoal model) {
		super.fromModel(model);
	}

	@Override
	public EducationGoal pushAttributesToModel(EducationGoal model) {
		super.addToModel(model);
		return model;
	}

	@Override
	public EducationGoal asModel() {
		return pushAttributesToModel(new EducationGoal());
	}

}
