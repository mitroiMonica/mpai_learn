package prototype_seminar;

public abstract class BuildingBlock implements Cloneable {
    private int x;
    private int y;
    private int z;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public abstract void render();

    @Override
    public BuildingBlock clone() throws CloneNotSupportedException {
        return (BuildingBlock) super.clone();
    }
}
