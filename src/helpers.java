public class helpers {
    final static double INCOME_LVL=90000.00;
    final static double MIN_RENT=650.00;
    static double successPercentage;
    static double gamesPlayed;

    static void setSuccess(double s){
        successPercentage+=s;
    }

    static double getSuccess(){
        return successPercentage;
    }

    static boolean finalSpinner(double fin){
        gamesPlayed++;
        if(!canAfford(fin)){
            return false;
        } else {
            double spinner=Math.random()*100;
            if(spinner<=getSuccess()){
                return true;
            } else {
                return false;
            }
        }
    }

    static boolean canAfford(double finalDollars){
        double weeklyIncome=finalDollars/7;
        double monthlyIncome=weeklyIncome*4;
        double yearlyIncome=weeklyIncome*48;
        if(yearlyIncome>INCOME_LVL){
            return true;
        } else if(monthlyIncome<MIN_RENT){
            return false;
        } else {
            double spinner=Math.random()*(INCOME_LVL-MIN_RENT)+MIN_RENT;
            if(spinner<=monthlyIncome){
                return true;
            } else {
                return false;
            }
        }
    }

    public static void eat(){
        setSuccess(0.5);
    }

    public static void sleep(){
        setSuccess(1.0);
    }

    public static void hygiene(){
        setSuccess(1.5);
    }

    public static void learn(){
        setSuccess(Math.random()*(5-1)+1);
    }


}
