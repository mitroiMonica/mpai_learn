package model.chain;

import model.Solicitare;
import model.state.Acceptata;
import model.state.EchipajPeDrum;
import model.state.Respinsa;

import java.util.Random;

public class AngajatOperator extends AbstractAngajat {
    private static final Random random = new Random();

    @Override
    public void gestioneazaSolicitarea(Solicitare solicitare) {
        try {
            solicitare.trimiteNotificatiTuturor(solicitare.getState().preiaMesajSpecific());
            Thread.sleep(random.nextInt(3000));
            boolean isUrgent = random.nextBoolean();
            if (isUrgent) {
                solicitare.setState(new Acceptata());
                solicitare.trimiteNotificatiTuturor(solicitare.getState().preiaMesajSpecific());
                if (super.nextAngajat != null) {
                    Thread.sleep(random.nextInt(3000));
                    solicitare.setState(new EchipajPeDrum(random.nextInt(60)));
                    super.nextAngajat.gestioneazaSolicitarea(solicitare);
                }
            } else {
                solicitare.setState(new Respinsa());
                solicitare.trimiteNotificatiTuturor(solicitare.getState().preiaMesajSpecific());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
