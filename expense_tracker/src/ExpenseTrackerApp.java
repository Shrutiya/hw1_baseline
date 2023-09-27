import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 * The ExpenseTrackerApp class allows users to add/remove daily transactions.
 */
public class ExpenseTrackerApp {

  public static void main(String[] args) {

    // Create MVC components
    DefaultTableModel tableModel = new DefaultTableModel();
    tableModel.addColumn("Serial");
    tableModel.addColumn("Amount");
    tableModel.addColumn("Category");
    tableModel.addColumn("Date");

    ExpenseTrackerView view = new ExpenseTrackerView(tableModel);

    // Initialize view
    view.setVisible(true);

    // Handle add transaction button clicks
    view.getAddTransactionBtn().addActionListener(e -> {
      double amount = 0;
      String category = "";

      try {
        // Get transaction data from view
        amount = view.getAmountField();
        category = view.getCategoryField();

        // Validate the transaction data from view
        InputValidation validate = new InputValidation(amount, category);
        List<String> validationResult = validate.validateInput();

        if (!validationResult.isEmpty()) {
          throw new CustomException.InputValidationException(
              "InputValidationException:\n" + String.join("\n", validationResult));
        }

        // Create transaction object
        Transaction t = new Transaction(amount, category);

        // Call controller to add transaction
        view.addTransaction(t);

      } catch (NumberFormatException error) {
        view.errorBox("Invalid Amount (should be number)", "NumberFormatException");
        error.printStackTrace();
      } catch (CustomException.InputValidationException error) {
        view.errorBox(error.getMessage(), "InputValidationError");
        error.printStackTrace();
      } catch (Exception error) {
        view.errorBox(error.getMessage(), "UnexpectedException");
        error.printStackTrace();
      }

    });

  }

}