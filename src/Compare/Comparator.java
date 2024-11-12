package Compare;

public class Comparator {

    /**
     * Метод, проверяющий вводимую строку, являеется ли она числом
     * @param str проверяемая строка
     * @return true или false - результат проверки
     */
    public static boolean isNumeric(String str) {
        return str != null && !str.trim().isEmpty() && str.matches("\\d*\\.?\\d+");
    }

    /**
     * Метод, проверяющий вводимую строку, является ли она логическим значением
     * @param str проверяемая строка
     * @return true или false - результат проверки
     */
    public static boolean isBoolean(String str) {
        return "true".equalsIgnoreCase(str) || "false".equalsIgnoreCase(str);
    }

    /**
     * Метод, проверяющий вводимую строку, является ли она строкой
     * @param str проверяемая строка
     * @return true или false - результат проверки
     */
    public static boolean isString(String str) {
        if (str == null || str.trim().isEmpty()) return false;
        return !isNumeric(str) && !isBoolean(str);
    }
}