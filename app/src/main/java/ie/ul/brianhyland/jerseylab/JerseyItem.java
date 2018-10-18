package ie.ul.brianhyland.jerseylab;

public class JerseyItem {

    private String mName;
    private int mNumber;
    private boolean mColour;

    public JerseyItem(){
        mName = "ANDROID";
        mNumber = 17;
        mColour = true;
    }

    public JerseyItem(String name, int number, Boolean colour){
        mName = name;
        mNumber = number;
        mColour = colour;
    }

    public static JerseyItem getDefaultItem() {return new JerseyItem("ANDROID",17, Boolean.TRUE);}

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public int getmNumber() {
        return mNumber;
    }

    public void setmNumber(int mNumber) {
        this.mNumber = mNumber;
    }

    public boolean ismColour() {
        return mColour;
    }

    public void setmColour(boolean mColour) {
        this.mColour = mColour;
    }
}
