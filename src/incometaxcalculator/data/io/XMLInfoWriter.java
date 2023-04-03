package incometaxcalculator.data.io;

import java.io.PrintWriter;

import incometaxcalculator.data.management.Receipt;

public class XMLInfoWriter extends InfoWriter {
  
  private static final String[] xmlTaxpayerConstants = {"_INFO.xml", "<Name> ", " </Name>", "<AFM> ", " </AFM>", "<Status> ", " </Status>", "<Income> ", " </Income>", "<Receipts>"};
  
  
  public XMLInfoWriter() {
    super(xmlTaxpayerConstants);
  }
  
  public String manipulateConstant(String constant) {
    return constant.replaceFirst("<", " </");
  }
   
  public String printTaxpayerReceiptInfo(PrintWriter outputStream, Receipt receipt) {
    outputStream.println("<ReceiptID> " + getReceiptId(receipt) + " </ReceiptID>");
    outputStream.println("<Date> " + getReceiptIssueDate(receipt) + " </Date>");
    outputStream.println("<Kind> " + getReceiptKind(receipt) + " </Kind>");
    outputStream.println("<Amount> " + getReceiptAmount(receipt) + " </Amount>");
    outputStream.println("<Company> " + getCompanyName(receipt) + " </Company>");
    outputStream.println("<Country> " + getCompanyCountry(receipt) + " </Country>");
    outputStream.println("<City> " + getCompanyCity(receipt) + " </City>");
    outputStream.println("<Street> " + getCompanyStreet(receipt) + " </Street>");
    outputStream.println("<Number> " + getCompanyNumber(receipt) + " </Number>");
    return null;
  }
  
}