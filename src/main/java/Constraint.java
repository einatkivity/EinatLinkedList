
public class Constraint {

    // Constraint: < agentID , constraintPoint , constraintTime >


    private int agentID;
    private Point constraintPoint;
    private int constraintTime;


    public Constraint(int agentID, Point constraintPoint, int constrainttime) {
        this.agentID = agentID;
        this.constraintPoint = constraintPoint;
        this.constraintTime = constrainttime;
    }

    public int getAgentID() {
        return agentID;
    }

    public void setAgentID(int agentID) {
        this.agentID = agentID;
    }

    public Point getConstraintPoint() {
        return constraintPoint;
    }

    public void setConstraintPoint(Point constraintPoint) {
        this.constraintPoint = constraintPoint;
    }

    public int getConstraintTime() {
        return constraintTime;
    }

    public void setConstraintTime(int constraintTime) {
        this.constraintTime = constraintTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Constraint that = (Constraint) o;
        return  agentID == that.agentID &&
                constraintTime == that.constraintTime &&
                constraintPoint.equals( that.constraintPoint);
    }



    @Override
    public String toString() {
        return "Constraint{" +
                "agentID=" + agentID +
                ", constraintPoint=" + constraintPoint +
                ", constraintTime=" + constraintTime +
                '}';
    }
}
