package model;

import model.enumerations.ProfNames;
import tools.RollCall;

public class Professor {
    private int id;
    private String name;
    private int groupId;

    public Professor(int id) {
        this.id = id;
        this.name = ProfNames.values()[id].name();
        this.groupId=id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String rollCallStudents(int groupId){
        return RollCall.performRollCall(this,groupId);
    }

    public int getGroupId() {
        return groupId;
    }
}
