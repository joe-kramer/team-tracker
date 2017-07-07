import org.junit.*;
import static org.junit.Assert.*;

public class MemberTest {

  @Test
  public void member_instanceOfMember_true() {
    Member memberTest1 = new Member("test");
    assertEquals(true, memberTest1 instanceof Member);
  }

  @Test
  public void getName_nameReturned_test() {
    Member memberTest1 = new Member("test");
    assertEquals("test", memberTest1.getName());
  }
}
