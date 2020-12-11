package task3;

public class OracleException extends Exception {
    OracleReaction reaction;

    public OracleException(OracleReaction reaction) {
        this.reaction = reaction;
    }
}
