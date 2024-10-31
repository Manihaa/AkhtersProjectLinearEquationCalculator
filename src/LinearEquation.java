public class LinearEquation {
    private int x1;
    private int x2;
    private int y1;
    private int y2;

    public LinearEquation(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public double distance(){
        int x = x2 - x1;
        int y = y2 - y1;
        double d = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        return roundedToHundredth(d);
    }

    public double yIntercept(){
        double b = y1 - (slope() * x1);
        return roundedToHundredth(b);
    }

    public double slope(){
        int x = x2 - x1;
        int y = y2 - y1;
        double m = (double) y / x;
        return roundedToHundredth(m);
    }

    public String equation(){
        int x = x2 - x1;
        int y = y2 - y1;
        String str;
        String m = "";
        double b = yIntercept();
        String bee = "";
        //String b = "+ " + yIntercept();

        //slope issues
        if (y%x == 0 && y/x != 1 && y/x != -1){
            m = y/x + "";
        } else if ((double)y/x == 1) {
            m = "";
        } else if ((double)y/x == -1) {
            m = "-";
        } else if (x < 0 && y > 0) {
            String temp = x + "";
            m = "-" + y + "/" + temp.substring(1);
        } else if (x < 0 && y < 0) {
            String temp = y + "";
            m = temp.substring(1) + "/";
            temp = x + "";
            m += temp.substring(1);
        } else{
            m = y + "/" + x;
        }

        //if y = 0 or b = 0
        if (y == 0 && b == 0){
            str = "y = 0";
            return str;
        } else if (y == 0) {
            str = "y = " + b;
            return str;
        } else if (b == 0) {
            str = "y = " + m + "x";
            return str;
        }

        if (b < 0){
            bee = "- " + Math.abs(b);
        } else{
            bee = "+ " + b;
        }
        str = "y = " + m + "x " + bee;
        return str;
    }

    public String coordinateForX(double x){
        double y = (x * slope()) + yIntercept();
        y = Math.round(y * 100) / 100.0;
        String str = "(" + x + ", " + y + ")";
        return str;
    }

    public String lineInfo(String point1, String point2){
        String str = "";
        str += "The two points are: " + point1 + " and " + point2 + "\n";
        str += "The equation of the line between these points is: " + equation() + "\n";
        str += "The y-intercept of this line is: " + yIntercept() + "\n";
        str += "The slope of this line is: " + slope() + "\n";
        str += "The distance between these points is: " + distance() + "\n";
        return str;
    }

    private double roundedToHundredth(double toRound){
        double rounded = Math.round(toRound * 100) / 100.0;
        return rounded;
    }
}
