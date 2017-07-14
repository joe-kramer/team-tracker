import java.util.List;
import java.util.ArrayList;

public class Member {
  private String mName;
  private int mId;
  private static List<Member> instances = new ArrayList<Member>();

  public Member(String name) {
    mName = name;
    instances.add(this);
    mId = instances.size();
  }

  public String getName() {
    return mName;
  }
}
