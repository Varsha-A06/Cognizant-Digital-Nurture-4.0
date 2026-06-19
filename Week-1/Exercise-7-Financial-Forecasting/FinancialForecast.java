public class FinancialForecast {

    public static double forecastValue(double principal, double annualGrowthRate, int years) {

        if (years <= 0) {
            return principal;
        }

        double updatedValue = principal * (1 + annualGrowthRate);

        return forecastValue(updatedValue, annualGrowthRate, years - 1);
    }

    public static void main(String[] args) {

        final double INITIAL_INVESTMENT = 10000.0;
        final double GROWTH_RATE = 0.10;
        final int FORECAST_YEARS = 5;

        double predictedValue = forecastValue(
                INITIAL_INVESTMENT,
                GROWTH_RATE,
                FORECAST_YEARS);

        System.out.println("Financial Forecast");
        System.out.println("------------------------------");
        System.out.println("Initial Value : " + INITIAL_INVESTMENT);
        System.out.println("Growth Rate   : " + (GROWTH_RATE * 100) + "%");
        System.out.println("Years         : " + FORECAST_YEARS);
        System.out.printf("Future Value  : %.2f%n", predictedValue);
    }
}