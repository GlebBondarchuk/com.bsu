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
                <a href="{//pageInfo/requestURL}?action=start_registration">
                    <xsl:value-of select="//pageInfo/linkText"/>
                </a>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>