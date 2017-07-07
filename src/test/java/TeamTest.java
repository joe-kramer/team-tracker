import org.junit.*;
import static org.junit.Assert.*;

public class TeamTest {

  @Before
  public void initialClear() {
    Team.clear();
  }

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

  @Test
  public void id_getTeamId_2() {
    Team testTeam1 = new Team("test1");
    Team testTeam2 = new Team("test2");
    assertEquals(2, testTeam2.getId());
  }

  @Test
  public void find_getParticularTeam_testTeam2() {
    Team testTeam1 = new Team("test1");
    Team testTeam2 = new Team("test2");
    assertEquals(testTeam2, Team.find(testTeam2.getId()));
  }

  @Test
  public void clear_clearInstances_0() {
    Team testTeam1 = new Team("test1");
    Team.clear();
    assertEquals(0, Team.getTeams().size());
  }

  @Test
  public void addMember_addsMemberToList_1() {
    Team testTeam1 = new Team("test1");
    Member testMember1 = new Member("Joe");
    testTeam1.addMember(testMember1);
    assertEquals(1, testTeam1.getMembers().size());
  }
}
