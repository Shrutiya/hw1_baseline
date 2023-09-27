import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The InputValidation class validates the input given by the users when adding
 * a new transaction.
 */
public class InputValidation {

    // constants
    public final String[] VALID_CATEGORIES = { "food", "travel", "bills", "entertainment", "other" };
    public final String ERROR_MESSAGE_AMOUNT = "Amount should be greater than 0 and less than 1000";
    public final String ERROR_MESSAGE_CATEGORY_EMPTY = "Category is empty";
    public final String ERROR_MESSAGE_CATEGORY_INVALID = "Category is invalid";

    private double amount;
    private String category;
    private List<String> validationErrors = new ArrayList<String>();

    public InputValidation(double amount, String category) {
        this.amount = amount;
        this.category = category;
    }

    /**
     * Validating amount range - amount greater than 0 and less than 1000
     * If not valid, add to the list of validation errors
     */
    private void validateAmount() {
        if (amount <= 0 || amount >= 1000) {
            validationErrors.add(ERROR_MESSAGE_AMOUNT);
        }
    }

    /**
     * Validating category - Not empty and is restricted to valid categories
     * If not valid, add to the list of validation errors
     */
    private void validateCategory() {
        if (category == null || category.trim().isEmpty()) {
            validationErrors.add(ERROR_MESSAGE_CATEGORY_EMPTY);
        } else if (!Arrays.asList(VALID_CATEGORIES).contains(category)) {
            validationErrors.add(ERROR_MESSAGE_CATEGORY_INVALID);
        }
    }

    public List<String> validateInput() {
        validateAmount();
        validateCategory();
        return validationErrors;
    }

}