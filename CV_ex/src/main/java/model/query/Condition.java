package model.query;

import model.Solicitare;

import java.util.UUID;
import java.util.function.Predicate;

public class Condition {
    public static Predicate<Solicitare> clientEquals(UUID clientId) {
        return solicitare -> solicitare.getClient().getId().equals(clientId);
    }

    public static Predicate<Solicitare> locationEquals(String locatie) {
        return solicitare -> solicitare.getLocatie().equalsIgnoreCase(locatie);
    }

    public static Predicate<Solicitare> and(Predicate<Solicitare>... predicates) {
        Predicate<Solicitare> result = predicates[0];
        for (int i = 1; i < predicates.length; i++) {
            result = result.and(predicates[i]);
        }
        return result;
    }
}
