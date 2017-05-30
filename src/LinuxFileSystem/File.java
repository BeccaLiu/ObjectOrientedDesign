package LinuxFileSystem;

/**
 * Created by rliu on 5/29/17.
 */
public class File extends FileNodeBase {
    byte[] content;

    File(String name) {
        super(name);
    }

    File(String name,byte[] content){
        super(name);
        content=content;
        size=content.length;
    }

    public String getContent(){
        return content.toString();
    }

    public long getSize(){
        return size;
    }

    @Override
    public String toString() {
        return "File " + getName() + " size " + getSize()+ " bytes";
    }

}
