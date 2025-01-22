package prototype_seminar;

import java.util.Arrays;

public class StoneBlock extends BuildingBlock {
    private byte[] texture;

    public StoneBlock() {
        System.out.println("Loading Texture...");
        texture = new byte[]{30, 50, 70};
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void render() {
        System.out.println("Rendering the StoneBlock at " +
                getX() + " " + getY() + " " + getZ());
    }

    @Override
    public StoneBlock clone() throws CloneNotSupportedException {
        StoneBlock copy = (StoneBlock) super.clone();
        copy.texture = Arrays.copyOf(this.texture, this.texture.length);
        return copy;
    }
}
