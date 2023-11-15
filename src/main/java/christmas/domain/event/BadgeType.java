package christmas.domain.event;

public enum BadgeType {
    STAR("별", 5000),
    TREE("트리", 10000),
    SANTA("산타", 20000);

    private final String displayName;
    private final int price;

    BadgeType(String displayName, int price) {
        this.displayName = displayName;
        this.price = price;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getPrice() {
        return price;
    }

    public static BadgeType getBadgeTypeForTotalBenefit(int totalBenefit) {
        for (BadgeType badgeType : BadgeType.values()) {
            if (totalBenefit >= badgeType.getPrice()) {
                return badgeType;
            }
        }
        return null;
    }
}
