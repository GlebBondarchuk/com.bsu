package by.bsu.gbondarchuk.model.enums;

public enum XslScript {
    COMMON_PAGE_SCRIPT("xsl-scripts/MainPage.xsl"),
    ERROR_PAGE_SCRIPT("xsl-scripts/ErrorPage.xsl"),
    INFO_PAGE("xsl-scripts/PageInfo.xsl");

    private String path;

    private XslScript(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
