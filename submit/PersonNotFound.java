/**
 * Exception class for non-existing persons.
 */
public class PersonNotFound extends Exception {
    public PersonNotFound(String message) {
        super(message);
    }
}
