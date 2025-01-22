package seminar.facade;

public class CarFacade {
    private final Engine engine;
    private final BrakingSystem brakingSystem;
    private final LightingSystem lightingSystem;

    public CarFacade() {
        engine = new Engine();
        brakingSystem = new BrakingSystem();
        lightingSystem = new LightingSystem();
    }

    public void emergencyBrake() {
        engine.setLoad(0);
        brakingSystem.applyFrontBrakes();
        brakingSystem.applyRearBrakes();
        lightingSystem.turnOnHazardLights();
    }

    public void start() {
        lightingSystem.turnOnLowBeam();
        brakingSystem.resetBrakes();
        engine.setLoad(10);
    }
}
