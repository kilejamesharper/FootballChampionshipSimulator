public class FootballClub extends SportsClub {

    //variables specific to this class
    byte clubWins;
    byte clubDraws;
    byte clubDefeats;
    byte goalsScored;
    byte goalsConceded;
    byte clubPoints;
    byte matchesPlayed;

    //methods overridden from SportsClub abstract class
    @Override
    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    @Override
    public void setClubLocation(String clubLocation) {
        this.clubLocation = clubLocation;
    }

    @Override
    public String getClubName() {
        return clubName;
    }

    @Override
    public String getClubLocation() {

        return clubLocation;
    }

    public void setClubWins(byte clubWins) {

        this.clubWins = clubWins;
    }

    public void setClubDefeats(byte clubDefeats) {

        this.clubDefeats = clubDefeats;
    }

    public void setClubDraws(byte clubDraws) {

        this.clubDraws = clubDraws;
    }

    public void setGoalsScored(byte goalsScored) {

        this.goalsScored = goalsScored;
    }

    public void setGoalsConceded(byte goalsConceded) {

        this.goalsConceded = goalsConceded;
    }

    public void setClubPoints(byte clubPoints) {

        this.clubPoints = clubPoints;
    }

    public void setMatchesPlayed(byte matchesPlayed) {

        this.matchesPlayed = matchesPlayed;
    }

    public byte getClubWins() {

        return clubWins;
    }

    public byte getClubDefeats() {
        return clubDefeats;
    }

    public byte getClubDraws() {
        return clubDraws;
    }

    public byte getGoalsScored() {
        return goalsScored;
    }

    public byte getGoalsConceded() {

        return goalsConceded;
    }

    public byte getClubPoints() {

        return clubPoints;
    }

    public byte getMatchesPlayed() {

        return matchesPlayed;
    }

    @Override
    public String toString() {
        return "FootballClub{" +
                "clubName='" + clubName + '\'' +
                ", clubLocation='" + clubLocation + '\'' +
                ", clubWins=" + clubWins +
                ", clubDraws=" + clubDraws +
                ", clubDefeats=" + clubDefeats +
                ", goalsScored=" + goalsScored +
                ", goalsConceded=" + goalsConceded +
                ", clubPoints=" + clubPoints +
                ", matchesPlayed=" + matchesPlayed +
                '}';
    }
}
