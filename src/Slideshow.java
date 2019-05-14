import java.util.*;

public class Slideshow {

    private List<Slide> slides= new ArrayList<>(100000);


    public List<Slide> getSlides() {
        return slides;
    }
    public void addSlide(Slide slide){
        slides.add(slide);
    }

    public void addSlide2(int nr, Slide slide){
        slides.add(nr,slide);
    }

    @Override
    public String toString() {
//        Collections.shuffle(slides);
        String rez = slides.size() + "\n";
        for(Slide s: slides)
            rez+= s.toString();
        System.out.println(getScore() + "\n");
        return rez;
    }

    public int getScore() {
        int score = 0;
        for( int i = 0 ; i< slides.size()-1; i++) {
            score += slides.get(i).compareSlides(slides.get(i+1));
        }
        return score;
    }

}
