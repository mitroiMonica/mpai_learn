package prototype_seminar;

import java.util.HashMap;
import java.util.Map;

public class PrototypeCollection {
    private final Map<String, BuildingBlock> blocks = new HashMap<>();

    public PrototypeCollection() {
        blocks.put("stone", new StoneBlock());
        blocks.put("wood", new WoodBlock());
    }

    public BuildingBlock getCloneBuildingBlock(String type) {
        try {
            return blocks.get(type).clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
