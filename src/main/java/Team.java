import java.util.List;
import java.util.ArrayList;

public class Team {
  private String mName;
  private static List<Team> instances = new ArrayList<Team>();

  public String getName() {
    return mName;
  }

  public Team(String name) {
    mName = name;
    instances.add(this);
  }

  public static List<Team> getTeams() {
    return instances;
  }


}
