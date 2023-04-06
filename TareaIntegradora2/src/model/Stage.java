package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class Stage {
    private StageType type;
    private Calendar plannedstageBeginDate;
    private Calendar plannedstageEndDate;
    private Calendar realStageBeginDate;
    private Calendar realStageEndDate;
    private Boolean finishedState;
    public List<Capsule> capsulesOnStage;

    public Stage(StageType type, Calendar plannedstageBeginDate, Calendar plannedstageEndDate,
                 Calendar realStageBeginDate, Calendar realStageEndDate, Boolean finishedState) {
        this.type = type;
        this.plannedstageBeginDate = plannedstageBeginDate;
        this.plannedstageEndDate = plannedstageEndDate;
        this.realStageBeginDate = realStageBeginDate;
        this.realStageEndDate = realStageEndDate;
        this.finishedState = finishedState;
        this.capsulesOnStage = new ArrayList<>();
    }
    public void addCapsule(Capsule capsule){
        capsulesOnStage.add(capsule);
    }
    public StageType getStageType() {
        return this.type;
    }

    public boolean getFinishedState() {
        return finishedState;
    }

    public void setFinishedState(boolean finishedState) {
        this.finishedState=finishedState;
    }
}
