import java.util.HashSet;
import java.util.List;

public class Slide{
    private Photo photo1;
    private Photo photo2;
    private HashSet<String> tags = new HashSet<>(100);

    @Override
    public String toString() {
        if(photo2!=null)
            return photo1.toString() + " " + photo2.toString() + "\n";
        return photo1.toString() + "\n";
    }

    public Slide(Photo photo1) {
        this.photo1 = photo1;
        photo2 = null;
        this.tags.addAll(photo1.getTags());
    }

    public Slide(Photo photo1, Photo photo2) {
        this.photo1 = photo1;
        this.photo2 = photo2;
        this.tags.addAll(photo1.getTags());
        this.tags.addAll(photo2.getTags());
    }

    public int hashCode() {
        return this.tags.size();
    }

    public void setPhoto2(Photo photo2) {
        this.photo2 = photo2;
    }

    public int compareSlides(Slide s) {
        HashSet<String> copy = new HashSet<>(this.tags);
        copy.removeAll(s.tags);
        int a_b = copy.size();
        int intersectie = this.tags.size() - a_b;
        int b_a = s.tags.size() - intersectie;

        int min = Math.min(a_b,intersectie);
        //System.out.println(a_b + " " + b_a + " " + intersectie + "\n");
        return Math.min(min,b_a);
    }

}
