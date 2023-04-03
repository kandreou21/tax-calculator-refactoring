package incometaxcalculator.data.management;

public class MarriedFilingSeparatelyTaxpayer extends Taxpayer {
  
  private static final double[] incomeConstants = {0, 18040, 71680, 90000, 127120};
  private static final double[] addConstants = {0, 965.14, 4746.76, 6184.88, 9098.80};
  private static final double[] mulConstants = {0.0535, 0.0705, 0.0785, 0.0785, 0.0985};
  
  public MarriedFilingSeparatelyTaxpayer(String fullname, int taxRegistrationNumber, float income) {
    super(fullname, taxRegistrationNumber, income, incomeConstants, addConstants, mulConstants);
  }
}