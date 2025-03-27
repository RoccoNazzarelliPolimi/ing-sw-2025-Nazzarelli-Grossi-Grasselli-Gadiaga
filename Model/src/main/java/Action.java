import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Action {
    private String targetCondition; //condition to lose: "passenger", "heater", "drill"
    private String penaltyType; // "days", "passenger", "cargo"
    private int penaltyValue; // num of object to lose
    private List<Pair> shootsMap; //size(1 small, 2 big), direction (1sx, 2up, 3dx, 4down)

    public Action(String targetCondition, String penaltyType, int penaltyValue, List<Pair> shootsMap) {
        this.targetCondition = targetCondition;
        this.penaltyType = penaltyType; //null se serve la mappa
        this.penaltyValue = penaltyValue; //0 se serve la mappa
        this.shootsMap = new ArrayList<>(); // null quando vengono utilizzate penaltyType e Value
    }

    public String getTargetCondition() {
        return targetCondition;
    }

    public String getPenaltyType() {
        return penaltyType;
    }

    public int getPenaltyValue() {
        return penaltyValue;
    }

    public List<Pair> getShootsMap() {
        return shootsMap;
    }
}
