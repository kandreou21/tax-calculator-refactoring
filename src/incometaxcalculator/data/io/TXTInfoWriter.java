package incometaxcalculator.data.io;

import java.io.PrintWriter;

import incometaxcalculator.data.management.Receipt;

public class TXTInfoWriter extends InfoWriter {

  private static final String[] txtTaxpayerConstants = {"_INFO.txt", "Name: ", "", "AFM: ", "", "Status: ", "", "Income: ", "", "Receipts:"};

  
  public TXTInfoWriter() {
    super(txtTaxpayerConstants);
  }
  
  public String manipulateConstant(String constant){
    return "";
  }
  
  public String printTaxpayerReceiptInfo(PrintWriter outputStream, Receipt receipt) {
    outputStream.println("Receipt ID: " + getReceiptId(receipt));
    outputStream.println("Date: " + getReceiptIssueDate(receipt));
    outputStream.println("Kind: " + getReceiptKind(receipt));
    outputStream.println("Amount: " + getReceiptAmount(receipt));
    outputStream.println("Company: " + getCompanyName(receipt));
    outputStream.println("Country: " + getCompanyCountry(receipt));
    outputStream.println("City: " + getCompanyCity(receipt));
    outputStream.println("Street: " + getCompanyStreet(receipt));
    outputStream.println("Number: " + getCompanyNumber(receipt));
    return null;
  }
 
}