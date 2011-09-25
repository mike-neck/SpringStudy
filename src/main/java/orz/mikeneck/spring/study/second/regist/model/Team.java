package orz.mikeneck.spring.study.second.regist.model;

/**
 * Created by IntelliJ IDEA.
 * Account: mike
 * Date: 11/09/11
 * Time: 17:57
 * To change this template use File | Settings | File Templates.
 */
public class Team {

    private int id;

    private String name;

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

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Team) {
            Team team = (Team) object;
            return team.id == this.id;
        }
        return false;
    }
}
