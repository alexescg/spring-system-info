package com.github.alexescg.component.systeminfo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.sun.management.OperatingSystemMXBean;

/**
 * @author alex
 */
public class Cpu {
    private final double load;
    private final String arch;
    private final int cores;
    private final double loadAverage;

    @JsonCreator
    public Cpu(OperatingSystemMXBean os) {
        this.cores = os.getAvailableProcessors();
        this.arch = os.getArch();
        this.load = os.getProcessCpuLoad();
        this.loadAverage = os.getSystemLoadAverage();
    }

    public double getLoad() {
        return load;
    }

    public String getArch() {
        return arch;
    }

    public int getCores() {
        return cores;
    }

    public double getLoadAverage() {
        return loadAverage;
    }
}
