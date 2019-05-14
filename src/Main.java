import java.io.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.*;

public class Main {
    private static List<Photo> photos = new ArrayList<Photo>(100000);
    private static List<Slide> slides = new ArrayList<>(100000);
    private static Slideshow slideshow = new Slideshow();
    private static Slideshow slideshowBun = new Slideshow();

    public static void createPhoto(String[] words, int id) {
        HashSet<String> tags = new HashSet<>();
        for (int i = 2; i < words.length; i++) {
            tags.add(words[i]);
        }
        Photo p = new Photo(words[0].charAt(0), id, tags);
        photos.add(p);
    }

    public static void createSlide(List<Photo> poze) {

    }

    public static void write() throws IOException {

        String fileContent = slideshow.toString();

        BufferedWriter writer = new BufferedWriter(
                new FileWriter("/home/gabrieltunaru/Downloads/hashcode/e_iesire.txt"));
        writer.write(fileContent);
        writer.close();
    }

    public static void main(String args[]) {
        BufferedReader reader;
        Photo verticalPhoto = null;
        int no_photos = 0;
        try {
            reader = new BufferedReader(new FileReader(
                    "/home/gabrieltunaru/Downloads/hashcode/e_shiny_selfies.txt"));
            String line = reader.readLine();
            no_photos = Integer.parseInt(line);
            for (int i = 0; i < no_photos; i++) {
                line = reader.readLine();
                createPhoto(line.split(" "), i);
            }
            reader.close();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        for (Photo photo : photos) {
            Slide s;
            if (photo.getOrientation() == 'V') {
                if (verticalPhoto == null) {
                    verticalPhoto = photo;
                } else {
                    s = new Slide(verticalPhoto, photo);
                    slideshow.addSlide(s);
                    verticalPhoto = null;
                }
            } else {
                s = new Slide(photo);
                slideshow.addSlide(s);
            }
        }
        List<Slide> goodSlides = slideshow.getSlides();
        List<Slide> slideuri = slideshowBun.getSlides();
        for (Slide slide : goodSlides) {
            if (goodSlides.size() == 0) {
                slideshowBun.addSlide(slide);
            } else {
                int max = 0;
                int pos = 0;
                int nr = 0;
                for (int i = 0; i < slideuri.size(); i++) {
                    nr = slide.compareSlides(slideuri.get(i));
                    if (nr > max) {
                        max = nr;
                        pos = i;
                    }
                }
                slideshowBun.addSlide2(pos, slide);
            }
        }
        //System.out.println(slideshow);
        slideshow = slideshowBun;
        try {
            write();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        Date date = new Date();
        System.out.println(new Timestamp(date.getTime()));
    }
}
