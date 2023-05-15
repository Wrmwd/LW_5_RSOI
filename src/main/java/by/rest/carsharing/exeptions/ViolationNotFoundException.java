package by.rest.carsharing.exeptions;

public class ViolationNotFoundException extends RuntimeException {
    public ViolationNotFoundException(Long id) {
        super("Could not find violation with id " + id);
    }
}
