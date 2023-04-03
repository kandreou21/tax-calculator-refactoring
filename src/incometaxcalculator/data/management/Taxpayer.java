package incometaxcalculator.data.management;

import java.util.HashMap;

import incometaxcalculator.exceptions.WrongReceiptKindException;

public abstract class Taxpayer {

  protected final String fullname;
  protected final int taxRegistrationNumber;
  protected final float income;
  private float amountPerReceiptsKind[] = new float[5];
  private int totalReceiptsGathered = 0;
  private HashMap<Integer, Receipt> receiptHashMap = new HashMap<Integer, Receipt>(0);
  private String[] receiptKinds = {"Entertainment", "Basic", "Travel", "Health", "Other"};
  private HashMap<Float, Float> variationTaxPercentages = new HashMap<Float, Float>() {{
    put(0.2f, 0.08f); 
    put(0.4f, 0.04f);
    put(0.6f, -0.15f);
  }};  
  private final double[] incomeConstants; 
  private final double[] addConstants; 
  private final double[] mulConstants; 
  
  public double calculateBasicTax(double[] incomeCostants, double[] addConstants, double[] mulCostants) {
    for (int i = 1; i < incomeConstants.length; i++) {
      if (income < incomeConstants[i]) {
        return addConstants[i - 1] + mulConstants[i - 1] * (income - incomeConstants[i - 1]);
      }
    }
  return addConstants[4] + mulConstants[4] * (income - incomeConstants[3]);
  }

  protected Taxpayer(String fullname, int taxRegistrationNumber, float income, double[] incomeConstants, double[] addConstants,double[] mulConstants) {
    this.incomeConstants = incomeConstants;
    this.addConstants = addConstants;
    this.mulConstants = mulConstants;
    this.fullname = fullname;
    this.taxRegistrationNumber = taxRegistrationNumber;
    this.income = income;
  }

  public void addReceipt(Receipt receipt) throws WrongReceiptKindException {
    for (int i = 0; i < receiptKinds.length; i++) {
      if (receipt.getKind().equals(receiptKinds[i])) {
        amountPerReceiptsKind[i] += receipt.getAmount();
        receiptHashMap.put(receipt.getId(), receipt);
        totalReceiptsGathered++;
        return;
      } 
    }
    throw new WrongReceiptKindException();
  }

  public void removeReceipt(int receiptId) throws WrongReceiptKindException {
    Receipt receipt = receiptHashMap.get(receiptId);
    for (int i = 0; i < receiptKinds.length; i++) {
      if (receipt.getKind().equals(receiptKinds[i])) {
        amountPerReceiptsKind[i] -= receipt.getAmount();
        totalReceiptsGathered--;
        receiptHashMap.remove(receiptId);
        return;
      }
    }
    throw new WrongReceiptKindException();
  }

  public String getFullname() {
    return fullname;
  }

  public int getTaxRegistrationNumber() {
    return taxRegistrationNumber;
  }

  public float getIncome() {
    return income;
  }

  public HashMap<Integer, Receipt> getReceiptHashMap() {
    return receiptHashMap;
  }

  public double getVariationTaxOnReceipts() {
    float totalAmountOfReceipts = getTotalAmountOfReceipts();
    for (HashMap.Entry<Float, Float> entry : variationTaxPercentages.entrySet()) {
      if (totalAmountOfReceipts < entry.getKey() * income) {
        return calculateBasicTax(incomeConstants, addConstants, mulConstants) * entry.getValue();
      }
    }
    return -calculateBasicTax(incomeConstants, addConstants, mulConstants) * 0.3;
  }

  private float getTotalAmountOfReceipts() {
    int sum = 0;
    for (int i = 0; i < 5; i++) {
      sum += amountPerReceiptsKind[i];
    }
    return sum;
  }

  public int getTotalReceiptsGathered() {
    return totalReceiptsGathered;
  }

  public float getAmountOfReceiptKind(short kind) {
    return amountPerReceiptsKind[kind];
  }

  public double getTotalTax() {
    return calculateBasicTax(incomeConstants, addConstants, mulConstants) + getVariationTaxOnReceipts();
  }

  public double getBasicTax() {
    return calculateBasicTax(incomeConstants, addConstants, mulConstants);
  }

}