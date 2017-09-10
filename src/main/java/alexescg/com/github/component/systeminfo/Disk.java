package alexescg.com.github.component.systeminfo;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.io.File;

/**
 * Disk model representation
 *
 * @author alex
 */
public class Disk {

    private static final int KILO = 1024;

    private final float usedPercentage;
    private final DiskInfo free;
    private final DiskInfo total;
    private final DiskInfo occupied;

    @JsonCreator
    public Disk() {
        File disk = new File("/");
        long freeSpace = disk.getFreeSpace();
        long totalSpace = disk.getTotalSpace();
        this.free = new DiskInfo(disk.getFreeSpace());
        this.total = new DiskInfo(disk.getTotalSpace());
        this.occupied = new DiskInfo(totalSpace - freeSpace);
        this.usedPercentage = ((float)this.occupied.getSize() / this.total.getSize()) * 100.0F;
    }

    public static int getKILO() {
        return KILO;
    }

    public DiskInfo getFree() {
        return free;
    }

    public DiskInfo getTotal() {
        return total;
    }

    public DiskInfo getOccupied() {
        return occupied;
    }

    public float getUsedPercentage() {
        return usedPercentage;
    }

    class DiskInfo {

        private final long size;
        private final long mb;
        private final long gb;

        DiskInfo(long size) {
            this.size = size;
            this.mb = this.size / KILO / KILO;
            this.gb = this.size / KILO / KILO / KILO;
        }

        public long getSize() {
            return size;
        }

        public long getMb() {
            return mb;
        }

        public long getGb() {
            return gb;
        }

    }

}
