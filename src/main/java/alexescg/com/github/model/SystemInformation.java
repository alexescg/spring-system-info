package alexescg.com.github.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.sun.management.OperatingSystemMXBean;

import java.io.IOException;
import java.lang.management.ManagementFactory;

/**
 * System information model
 *
 * @author alex
 */
public class SystemInformation {

    private final String user;
    private final String host;
    private final String os;
    private final String version;
    private final String uptime;
    private final Disk disk;
    private final Cpu cpu;

    @JsonCreator
    public SystemInformation() throws IOException {
        OperatingSystemMXBean os =
                (OperatingSystemMXBean) java.lang.management.ManagementFactory.getOperatingSystemMXBean();
        this.user = System.getProperty("user.name");
        this.os = os.getName();
        this.version = os.getVersion();
        this.host = osCmd("hostname").replace("\n", "");
        this.uptime = formatUptime();
        this.cpu = new Cpu(os);
        this.disk = new Disk();
    }

    public String getUser() {
        return user;
    }

    public String getHost() {
        return host;
    }

    public String getOs() {
        return os;
    }

    public String getVersion() {
        return version;
    }

    /**
     * Get system uptime
     *
     * @return formatted in minutes, seconds
     */
    public String getUptime() {
        return this.uptime;
    }

    public Disk getDisk() {
        return disk;
    }

    public Cpu getCpu() {
        return cpu;
    }

    /**
     * Execute command on os
     *
     * @param cmd command name
     * @return cmd output
     * @throws java.io.IOException when command can't be used
     */
    private String osCmd(String cmd) throws java.io.IOException {
        java.util.Scanner s = new java.util.Scanner(Runtime.getRuntime().exec(cmd).getInputStream()).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

    /**
     * Format Uptime to m : s
     *
     * @return m s
     */
    private String formatUptime() {
        long uptime = ManagementFactory.getRuntimeMXBean().getUptime();
        int seconds = (int) (uptime / 1000);
        int minutes = (seconds / 60);
        seconds -= (minutes * 60);
        return minutes + " m " + seconds + " s";
    }
}
