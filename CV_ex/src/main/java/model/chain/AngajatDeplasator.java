package model.chain;

import model.Solicitare;

public class AngajatDeplasator extends AbstractAngajat {
    @Override
    public void gestioneazaSolicitarea(Solicitare solicitare) {
        solicitare.trimiteNotificatiTuturor(solicitare.getState().preiaMesajSpecific());
    }
}
