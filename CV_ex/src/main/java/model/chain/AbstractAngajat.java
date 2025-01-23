package model.chain;

import model.Solicitare;

public abstract class AbstractAngajat {
    protected AbstractAngajat nextAngajat;

    public void setNextAngajat(AbstractAngajat nextAngajat) {
        this.nextAngajat = nextAngajat;
    }

    public abstract void gestioneazaSolicitarea(Solicitare solicitare);
}
