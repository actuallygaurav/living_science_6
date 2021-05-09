package com.gaurav.livingscience.model;

import com.gaurav.livingscience.model.Model;

public class SubjectiveModel implements Model {
    public String ques;
    private final int TYPE;

    public SubjectiveModel(String ques) {
        this.ques = ques;
        TYPE = Model.SUB_TYPE;
    }

    @Override
    public int getType() {
        return TYPE;
    }
}
