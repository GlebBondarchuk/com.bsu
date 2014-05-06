package by.bsu.gbondarchuk.model.enums;

public enum Action {
    START_REGISTRATION("start_registration"),
    REGISTER_NAME("name_registration"),
    REGISTER_COMPANY("company_registration"),
    REGISTER_HOBBY("hobby_registration"),
    DEFAULT("default"),
    UPDATE_LIST("update_list");

    private final String actionName;

    private Action(String actionName) {
        this.actionName = actionName;
    }

    public String getActionName() {
        return actionName;
    }

    public static Action resolve(String actionName) {
        if (actionName == null) {
            return DEFAULT;
        }
        Action[] actions = Action.values();
        for (Action value : actions) {
            if (value.actionName.equals(actionName)) {
                return value;
            }
        }
        return DEFAULT;
    }
}
