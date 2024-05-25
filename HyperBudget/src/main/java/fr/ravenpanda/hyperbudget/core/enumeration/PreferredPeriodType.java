package fr.ravenpanda.hyperbudget.core.enumeration;

public enum PreferredPeriodType {
    MONTHLY, ANNUALLY;

    public static PreferredPeriodType fromString(String value) {
        for (PreferredPeriodType type : PreferredPeriodType.values()) {
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
