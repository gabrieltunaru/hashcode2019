import java.util.HashSet;

public class Photo {
    private HashSet<String> tags = new HashSet<>(100);
    private char orientation;
    private boolean used;
    private int id;

    public Photo(char orientation, int id, HashSet<String> tags) {
        this.tags = tags;
        this.orientation = orientation;
        this.id = id;
        this.used = false;

    }

    public String toString() {
        return "" + id;
    }

    public HashSet<String> getTags() {
        return tags;
    }

    public void setTags(HashSet<String> tags) {
        this.tags = tags;
    }

    public char getOrientation() {
        return orientation;
    }

    public void setOrientation(char orientation) {
        this.orientation = orientation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



}
