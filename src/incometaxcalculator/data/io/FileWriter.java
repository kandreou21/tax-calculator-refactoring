package incometaxcalculator.data.io;

import java.io.IOException;

public interface FileWriter {

  public void generateFile(int taxRegistrationNumber) throws IOException;

}