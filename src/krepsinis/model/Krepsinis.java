package krepsinis.model;

public class Krepsinis {
    private int id;
    private String teamName;
    private String nameSurname;
    private String league;
    private String sponsors;
    private int teams;
    private int userid;
    // for update and delete
    public Krepsinis(int id, String teamName, String nameSurname, String league, String sponsors, int teams, int userid) {
        this.id = id;
        this.teamName = teamName;
        this.nameSurname = nameSurname;
        this.league = league;
        this.sponsors = sponsors;
        this.teams = teams;
        this.userid = userid;
    }

    // for create
    public Krepsinis(String teamName, String nameSurname, String sponsors, String racingCars, int members, int userid) {
        this.teamName = teamName;
        this.nameSurname = nameSurname;
        this.league = league;
        this.sponsors = sponsors;
        this.teams = teams;
        this.userid = userid;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public String getSponsors() {
        return sponsors;
    }

    public void setSponsors(String sponsors) {
        this.sponsors = sponsors;
    }

    public int getTeams() {
        return teams;
    }

    public void setTeams(int teams) {
        this.teams = teams;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Krepsinis " +
                " teamName='" + teamName + '\'' +
                ", nameSurname='" + nameSurname + '\'' +
                ", leagueu='" + league + '\'' +
                ", sponsors='" + sponsors + '\'' +
                ", teams=" + teams+'\''+
                ", userid="+userid;

    }
}

