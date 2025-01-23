package model.query;

import model.Solicitare;

import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Select {
    private final Set<Solicitare> solicitari;

    public Select(Set<Solicitare> solicitari) {
        this.solicitari = solicitari;
    }

//    public Select where(UUID clientCode) {
//        Set<Solicitare> filtered = this.solicitari.stream()
//                .filter(solicitare -> solicitare.getClient().getId().equals(clientCode))
//                .collect(Collectors.toSet());
//        return new Select(filtered);
//    }
//
//    public Select where(String locatie) {
//        Set<Solicitare> filtered = this.solicitari.stream()
//                .filter(solicitare -> solicitare.getLocatie().equalsIgnoreCase(locatie))
//                .collect(Collectors.toSet());
//        return new Select(filtered);
//    }

    public Select where(Predicate<Solicitare> condition) {
        Set<Solicitare> filtered = this.solicitari.stream()
                .filter(condition)
                .collect(Collectors.toSet());
        return new Select(filtered);
    }

    public Set<Solicitare> getResult() {
        return this.solicitari;
    }
}
