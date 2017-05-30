package LinuxFileSystem;

import java.util.LinkedList;

/**
 * Created by rliu on 5/29/17.
 * Design a Linux Style In memory File System
 * API needed: ls, cd, touch, mkdir, rm, vi,
 */
public class LinuxFileSystem {
    Directory root;
    Directory curr;

    LinuxFileSystem() {
        root = new Directory("/");
        curr = root;
    }

    public String list(Directory curr) {
        StringBuilder sb = new StringBuilder();
        for (FileNodeBase fnb : curr.getChildren().values()) {
            sb.append(fnb.getName());
            sb.append(" ");
        }
        return sb.toString();
    }

    public void mkdir(String folderName) {
        curr.addNode(new Directory(folderName));
    }

    public void touch(String filename) {
        curr.addNode(new File(filename));
    }

    public void cd(Directory dir) {
        if (curr.getChildren().containsKey(dir.getName())) {
            curr = dir;
        }
    }

    public String vi(File file) {
        if (curr.getChildren().containsKey(file.getName()))
            return file.getContent();
        else return "";
    }

    public void rm(String path) {
        String[] paths = path.split("/");
        Directory parent;
        if (isAbsPath(path)) {
            parent = getPath(root, paths);
        } else {
            parent = getPath(curr, paths);
        }
        if (parent != null && parent.getChildren().containsKey(paths[paths.length - 1])) {
            FileNodeBase fnb = parent.getChildren().get(paths[paths.length - 1]);
            parent.delete(fnb);
        }
    }


    public void rm(FileNodeBase fnb) {
        curr.delete(fnb);
    }

    public Directory getPath(Directory root, String[] paths) {
        Directory dir = root;
        for (int i = 0; i < paths.length - 1; i++) {
            if (dir.getChildren().containsKey(paths[i])) {
                dir = (Directory) dir.getChildren().get(paths[i]);
            } else
                break;
        }
        if (dir.getName() == paths[paths.length - 2]) {
            return dir;
        } else {
            System.out.println("path not found");
            return null;
        }
    }

    public boolean isAbsPath(String path) {
        if (path.charAt(0) == '/')
            return true;
        else return false;
    }
}
