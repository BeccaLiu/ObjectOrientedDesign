package LinuxFileSystem;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by rliu on 5/29/17.
 */
abstract class FileNodeBase {
    long size;
    FileNodeBase prev;
    LocalDateTime createdTime;
    LocalDateTime modifiedTime;

    private String name;

    FileNodeBase(String name) {
        this.name = name;
        createdTime = LocalDateTime.now();
    }

    public String getName() {
        return this.name;
    }

    public abstract String toString();


}
