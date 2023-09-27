public class CustomException {

    public static class InputValidationException extends Exception {
        public InputValidationException(String errorMessage) {
            super(errorMessage);
        }
    }
}