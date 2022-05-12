package Code;

public class Calculator {
    public double calculate(double amount, double tips) throws Exception {
        if (amount < 0 || tips < 0) {
            throw new Exception("not ok");
        }

        var tipsAmount = amount / 100 * tips;
        return amount + tipsAmount;
    }
    public double calculate(double amount, double tips, int personNumber) throws Exception {
        if (amount < 0 || tips < 0) {
            throw new Exception("not ok");
        }

        var tipsAmount = amount / 100 * tips;
        return (amount + tipsAmount) / personNumber;
    }

    public int getSum(String s) {
        int sum = 0;

        if (s == null)
            return sum;

        if (s.length() == 0) {
            return sum;
        }

        String[] arr = s.split("\\?|\\.|;|:|!|[A-Z]|[a-z]| |,");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() != 0)
                sum += Integer.parseInt(arr[i]);
        }

        return sum;
    }
}
