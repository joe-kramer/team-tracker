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
}
