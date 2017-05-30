package LinuxFileSystem;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Created by rliu on 5/29/17.
 */
public class Directory extends FileNodeBase {
    HashMap<String, FileNodeBase> next;

    Directory(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Dir " + getName() + " size: " + getSize() + " bytes";
    }

    public void addNode(FileNodeBase f) {
        next.put(f.getName(), f);
        f.prev = this;
    }

    public int getSize() {
        int total = 0;
        ArrayDeque<FileNodeBase> queue = new ArrayDeque<>();
        queue.add(this);
        while (!queue.isEmpty()) {
            FileNodeBase curr = queue.poll();
            if (curr instanceof File) {
                total += ((File) curr).getSize();
            } else {
                queue.addAll(((Directory) curr).next.values());
            }
        }
        return total;
    }

    public HashMap<String, FileNodeBase> getChildren() {
        return next;
    }

    public void delete(FileNodeBase f) {
        LocalDateTime modifiedTime = LocalDateTime.now();
        while (f.prev != null) {
            prev.modifiedTime = modifiedTime;
        }
        next.remove(f);

    }
}
