package by.bsu.gbondarchuk.model.enums;

public enum Messages {
    TITLE("title"),
    SUCCESS_MESSAGE("successMessage"),
    CONGRETE_MESSAGE("congreteMessage"),
    FIRST_NAME_LABEL("label.firstname"),
    LAST_NAME_LABEL("label.lastname"),
    COMPANY_NAME_LABEL("label.companyname"),
    HOBBY_LABEL("label.hobby"),
    WELCOME_CAPTION("caption.welcome"),
    LINK_CAPTION("link.caption"),
    ERROR_PAGE_TITLE("errorpage.title"),
    DEFAULT_ERROR_TEXT("caption.error");
    private String key;

    Messages(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
