import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;

public class App {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/teams", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/teams.vtl");
      model.put("teams", Team.getTeams());
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/teams/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/team-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/teams", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/teams.vtl");
      String teamName = request.queryParams("name");
      Team team = new Team(teamName);
      model.put("teams", Team.getTeams());
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/teams/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/team.vtl");
      Integer id = Integer.parseInt(request.params(":id"));
      Team team = Team.find(id);
      model.put("team", team );
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("teams/:id/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/member-form.vtl");
      Integer id = Integer.parseInt(request.params(":id"));
      Team team = Team.find(id);
      model.put("team", team);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("teams/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/team.vtl");
      Integer id = Integer.parseInt(request.params("id"));
      Team team = Team.find(id);
      String memberName = request.queryParams("name");
      Member member = new Member(memberName);
      team.addMember(member);
      model.put("team", team);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
