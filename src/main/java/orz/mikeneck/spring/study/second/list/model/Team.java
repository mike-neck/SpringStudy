package orz.mikeneck.spring.study.second.list.model;

/**
 * Created by IntelliJ IDEA.
 * Account: mike
 * Date: 11/09/11
 * Time: 14:23
 * To change this template use File | Settings | File Templates.
 */
public class Team {

    private Integer id;

    private String name;

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object object) {
        if(object instanceof Team) {
            Team team = Team.class.cast(object);
            return team.id == this.id;
        } else {
            return false;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
