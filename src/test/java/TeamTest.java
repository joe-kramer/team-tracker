import org.junit.*;
import static org.junit.Assert.*;

public class TeamTest {

  @Test
  public void team_instantiatesCorrectly_true() {
    Team testTeam = new Team("test");
    assertEquals(true, testTeam instanceof Team);
  }

  @Test
  public void team_storesNameAndGetsIt_String() {
    Team testTeam = new Team("test");
    assertEquals("test", testTeam.getName());
  }

  @Test
  public void instances_containsAllInstances_true() {
    Team testTeam1 = new Team("test1");
    Team testTeam2 = new Team("test2");
    assertEquals(true, Team.getTeams().contains(testTeam2));
  }
}
