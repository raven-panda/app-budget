package fr.ravenpanda.hyperbudget.core.enumeration;

public enum PreferredTheme {
    LIGHT, DARK;

    public static PreferredTheme fromString(String value) {
        for (PreferredTheme type : PreferredTheme.values()) {
            if (type.name().equalsIgnoreCase(value)) {
                return type;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
