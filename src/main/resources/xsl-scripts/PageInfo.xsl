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
                    <xsl:value-of select="//pageInfo/congreteMessage"/>
                </h1>
                <P/>
                <label>
                    <xsl:value-of select="//pageInfo/successMessage"/>
                </label>
                <table>
                    <thead>
                        <th>First name</th>
                        <th>Last name</th>
                        <th>Company</th>
                        <th>Hobby</th>
                    </thead>
                    <tbody>
                        <xsl:for-each select="//pageInfo/contacts">
                            <tr>
                                <td>
                                    <xsl:value-of select="firstName"/>
                                </td>
                                <td>
                                    <xsl:value-of select="LastName"/>
                                </td>
                                <td>
                                    <xsl:value-of select="companyName"/>
                                </td>
                                <td>
                                    <xsl:value-of select="hobby"/>
                                </td>
                            </tr>
                        </xsl:for-each>
                    </tbody>
                </table>
                <div>
                    <span>
                        <a href="{//pageInfo/requestURL}?step=first">First</a>
                    </span>
                    <span>
                        <a href="{//pageInfo/requestURL}?step=prev">Prev</a>
                    </span>
                    <span>
                        <a href="{//pageInfo/requestURL}?step=next">Next</a>
                    </span>
                    <span>
                        <a href="{//pageInfo/requestURL}?step=last">Last</a>
                    </span>
                </div>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>