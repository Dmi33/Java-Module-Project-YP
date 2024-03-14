public class Declension {

    String declension;
    double value;
    public Declension(double value) {
        this.value = value;
    }

    public String getDeclension() {
        if( ((int)value % 10 ==1) &&  ((int)value % 100 != 11)){
            return " рубль";}
        else if ((((int)value % 10 >= 2) && ((int)value %10 <= 4))&& (((int)value % 100 < 10) || ((int)value %100 >=20))){
            return " рубля";
            }
        else {return " рублей";}
    }
}

