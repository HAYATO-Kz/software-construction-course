package lec10observer.weatherorama.ver2;

public class PollutionData extends Subject {
    private String pollution;

    public void setPollution(String p){
        pollution = p;
        notifyObservers();
    }

    public String getPollution(){
        return pollution;
    }
}
