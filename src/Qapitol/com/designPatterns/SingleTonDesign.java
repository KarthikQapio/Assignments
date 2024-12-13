package Qapitol.com.designPatterns;

public class SingleTonDesign {

    private static SingleTonDesign singleTonDesign;

    private SingleTonDesign() {

    }

    public static SingleTonDesign getInstance() {

        if(singleTonDesign == null) {
            singleTonDesign = new SingleTonDesign();
            return singleTonDesign;
        }
        return singleTonDesign;
    }


}
