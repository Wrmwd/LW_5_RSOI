package by.rest.carsharing.exeptions;

public class TravelNotFoundException extends RuntimeException {
    public TravelNotFoundException(Long id) {
        super("Could not find violation with id " + id);
    }
}
