<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
xmlns:xs="http://www.w3.org/2001/XMLSchema"
exclude-result-prefixes="xs" version="2.0">

<xsl:template match="/">
<html>
    <head>
        <title>CDs de música</title>
    </head>
    <body>
        <h1>País: España</h1>
        <xsl:for-each select="CDs/CD">
            <xsl:if test="pais = 'España'">
                <div>
                    <h3><xsl:value-of select="titulo"/></h3>
                    <p><xsl:value-of select="artista"/></p>
                    <p><xsl:value-of select="pais"/></p>
                    <p><xsl:value-of select="compania"/></p>
                    <p><xsl:value-of select="precio"/></p>
                    <p><xsl:value-of select="fecha_publicacion"/></p>
                    <p><xsl:value-of select="genero"/></p>
                    <p><xsl:value-of select="rating"/></p>
                </div>
            </xsl:if>
        </xsl:for-each>
        <h1>País: Estados Unidos</h1>
        <xsl:for-each select="CDs/CD">
            <xsl:if test="pais = 'EEUU'">
                <div>
                    <h3><xsl:value-of select="titulo"/></h3>
                    <p><xsl:value-of select="artista"/></p>
                    <p><xsl:value-of select="pais"/></p>
                    <p><xsl:value-of select="compania"/></p>
                    <p><xsl:value-of select="precio"/></p>
                    <p><xsl:value-of select="fecha_publicacion"/></p>
                    <p><xsl:value-of select="genero"/></p>
                    <p><xsl:value-of select="rating"/></p>
                </div>
            </xsl:if>
        </xsl:for-each>

                <h1>País: Suecia</h1>
        <xsl:for-each select="CDs/CD">
            <xsl:if test="pais = 'Suecia'">
                <div>
                    <h3><xsl:value-of select="titulo"/></h3>
                    <p><xsl:value-of select="artista"/></p>
                    <p><xsl:value-of select="pais"/></p>
                    <p><xsl:value-of select="compania"/></p>
                    <p><xsl:value-of select="precio"/></p>
                    <p><xsl:value-of select="fecha_publicacion"/></p>
                    <p><xsl:value-of select="genero"/></p>
                    <p><xsl:value-of select="rating"/></p>
                </div>
            </xsl:if>
        </xsl:for-each>
    </body>
</html>
</xsl:template>


</xsl:stylesheet>