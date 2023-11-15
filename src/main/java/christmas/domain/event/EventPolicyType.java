package christmas.domain.event;

public enum EventPolicyType {

    GIFT_EVENT("증정 이벤트", new GiftEvent()),
    BADGE_EVENT("뱃지 이벤트", new BadgeEvent());

    private final String eventName;
    private final EventPolicy policy;

    EventPolicyType(String eventName, EventPolicy policy) {
        this.eventName = eventName;
        this.policy = policy;
    }

    public String getEventName() {
        return eventName;
    }

    public EventPolicy getPolicy() {
        return policy;
    }
}

