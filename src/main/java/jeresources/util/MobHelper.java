package jeresources.util;

import jeresources.entry.MobEntry;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.passive.SheepEntity;

public class MobHelper {
    public static int getExpDrop(MobEntry entry) {
        if (entry.getEntity() instanceof MobEntity)
            return ((MobEntity) entry.getEntity()).experienceValue;
        return 0;
    }

    public static String getExpandedName(MobEntry entry) {
        String raw = entry.getEntity().getName().getFormattedText();
        if (entry.getEntity() instanceof SheepEntity)
            raw = ((SheepEntity) entry.getEntity()).getFleeceColor().getName().replace("_", " ") + " " + raw;
        StringBuilder sb = new StringBuilder();
        for (String s : raw.split(" "))
            sb.append(s.substring(0, 1).toUpperCase()).append(s.substring(1).toLowerCase()).append(" ");
        return sb.toString().trim();
    }
}
