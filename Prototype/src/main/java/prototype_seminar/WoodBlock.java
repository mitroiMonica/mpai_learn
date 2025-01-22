package prototype_seminar;

import java.util.Arrays;

public class WoodBlock extends BuildingBlock {
    private byte[] texture;

    public WoodBlock() {
        System.out.println("Loading Texture...");
        texture = new byte[]{10, 20, 30};
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void render() {
        System.out.println("Rendering the WoodBlock at " +
                getX() + " " + getY() + " " + getZ());
    }

    @Override
    public WoodBlock clone() throws CloneNotSupportedException {
        WoodBlock copy = (WoodBlock) super.clone();
        copy.texture = Arrays.copyOf(this.texture, this.texture.length);
        return copy;
    }
}
