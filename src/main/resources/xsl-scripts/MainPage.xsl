<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <head>
                <title>
                    <xsl:value-of select="//pageInfo/title"/>
                </title>
            </head>
            <body>
                <h1>
                    <xsl:value-of select="//pageInfo/pageHeader"/>
                </h1>
                <form action="{//pageInfo/requestURL}" method="POST">
                    <input type="hidden" name="formId" value="{//pageInfo/formId}"/>

                    <label>
                        <xsl:value-of select="//pageInfo/firstNameLabel"/>
                    </label>
                    <xsl:choose>
                        <xsl:when test="//contact/firstName">
                            <label>
                                <xsl:value-of select="//contact/firstName"/>
                            </label>
                        </xsl:when>
                        <xsl:otherwise>
                            <input type="text" size="20" name="firstname"/>
                        </xsl:otherwise>
                    </xsl:choose>

                    <br/>
                    <label>
                        <xsl:value-of select="//pageInfo/lastNameLabel"/>
                    </label>
                    <xsl:choose>
                        <xsl:when test="//contact/lastName">
                            <label>
                                <xsl:value-of select="//contact/lastName"/>
                            </label>
                        </xsl:when>
                        <xsl:otherwise>
                            <input type="text" size="20" name="lastname"/>
                            <input type="hidden" name="action" value="name_registration"/>
                        </xsl:otherwise>
                    </xsl:choose>

                    <xsl:if test="//contact/lastName">
                        <br/>
                        <label>
                            <xsl:value-of select="//pageInfo/companyNameLabel"/>
                        </label>
                        <xsl:choose>
                            <xsl:when test="//contact/companyName">
                                <label>
                                    <xsl:value-of select="//contact/companyName"/>
                                </label>
                            </xsl:when>
                            <xsl:otherwise>
                                <input type="text" size="20" name="companyname"/>
                                <input type="hidden" name="action" value="company_registration"/>
                            </xsl:otherwise>
                        </xsl:choose>
                    </xsl:if>

                    <xsl:if test="//contact/companyName">
                        <br/>
                        <label>
                            <xsl:value-of select="//pageInfo/hobbyLabel"/>
                        </label>
                        <xsl:choose>
                            <xsl:when test="//contact/hobby">
                                <label>
                                    <xsl:value-of select="//contact/hobby"/>
                                </label>
                            </xsl:when>
                            <xsl:otherwise>
                                <input type="text" size="20" name="hobby"/>
                                <input type="hidden" name="action" value="hobby_registration"/>
                            </xsl:otherwise>
                        </xsl:choose>
                    </xsl:if>
                    <input type="submit" value="{//pageInfo/btnTitle}"/>
                </form>
            </body>
        </html>
    </xsl:template>


</xsl:stylesheet>