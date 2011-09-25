package orz.mikeneck.spring.study.second.regist.model;

/**
 * Created by IntelliJ IDEA.
 * Account: mike
 * Date: 11/09/11
 * Time: 17:55
 * To change this template use File | Settings | File Templates.
 */
public class Player {

    private int id;

    private String name;

    private Team team;

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Player) {
            Player player = (Player) object;
            return player.id == this.id;
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
