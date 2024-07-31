package entities;

import base.BaseEntity;

public class ActorReport extends BaseEntity {
    private int actorID;
    private String firstName;
    private int filmCount;

    // getter methods
    public int getActorID() {
        return actorID;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getFilmCount() {
        return filmCount;
    }

    // setter methods
    public void setActorID(int actorID) {
        this.actorID = actorID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setFilmCount(int filmCount) {
        this.filmCount = filmCount;
    }

    @Override
    public String toString() {
        return "ActorReport{" +
                "actor id=" + actorID +
                ", first name='" + firstName + '\'' +
                ", film count=" + filmCount +
                '}';
    }
}
