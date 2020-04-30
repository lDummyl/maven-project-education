package simpleTasks.School;

import java.sql.Struct;
import java.util.List;

public class ClassRoom {

    int holdingCapacity;
    List<FaimousScientistPortrait> portretsOnWalls;
    boolean geraniumOnTheWindowsill = true;
    short roomNumber;

    public ClassRoom(List<FaimousScientistPortrait> portretsOnWalls, short roomNumber) {
        this.portretsOnWalls = portretsOnWalls;
        this.roomNumber = roomNumber;
    }


}
