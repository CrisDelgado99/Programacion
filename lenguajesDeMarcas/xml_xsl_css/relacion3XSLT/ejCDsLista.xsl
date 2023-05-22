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
        <h1>Artistas masculinos</h1>
        <xsl:for-each select="CDs/CD">
            <xsl:if test="artista/@genero = 'masculino'">
                <ul>
                    <li><h3><xsl:value-of select="titulo"/></h3></li>
                    <ul>
                        <li><xsl:value-of select="artista"/></li>
                        <li><xsl:value-of select="pais"/></li>
                        <li><xsl:value-of select="compania"/></li>
                        <li><xsl:value-of select="precio"/></li>
                        <li><xsl:value-of select="fecha_publicacion"/></li>
                        <li><xsl:value-of select="genero"/></li>
                        <li><xsl:value-of select="rating"/></li>
                    </ul>
                </ul>
            </xsl:if>
        </xsl:for-each>
        <h1>Artistas femeninas</h1>
        <xsl:for-each select="CDs/CD">
            <xsl:if test="artista/@genero = 'femenino'">
                <ul>
                    <li><h3><xsl:value-of select="titulo"/></h3></li>
                    <ul>
                        <li><xsl:value-of select="artista"/></li>
                        <li><xsl:value-of select="pais"/></li>
                        <li><xsl:value-of select="compania"/></li>
                        <li><xsl:value-of select="precio"/></li>
                        <li><xsl:value-of select="fecha_publicacion"/></li>
                        <li><xsl:value-of select="genero"/></li>
                        <li><xsl:value-of select="rating"/></li>
                    </ul>
                </ul>
            </xsl:if>
        </xsl:for-each>

                <h1>Grupos</h1>
        <xsl:for-each select="CDs/CD">
            <xsl:if test="artista/@genero = 'mixto'">
                <ul>
                    <li><h3><xsl:value-of select="titulo"/></h3></li>
                    <ul>
                        <li><xsl:value-of select="artista"/></li>
                        <li><xsl:value-of select="pais"/></li>
                        <li><xsl:value-of select="compania"/></li>
                        <li><xsl:value-of select="precio"/></li>
                        <li><xsl:value-of select="fecha_publicacion"/></li>
                        <li><xsl:value-of select="genero"/></li>
                        <li><xsl:value-of select="rating"/></li>
                    </ul>
                </ul>
            </xsl:if>
        </xsl:for-each>
    </body>
</html>
</xsl:template>


</xsl:stylesheet>