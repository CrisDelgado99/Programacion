<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
xmlns:xs="http://www.w3.org/2001/XMLSchema"
exclude-result-prefixes="xs" version="2.0">
    <xsl:template match="/">
        <html>
            <head>
                <title>Albumes con fotos</title>
            </head>
            <body>
                <xsl:for-each select="CDs/CD">
                    <div>
                        <h3><xsl:value-of select="titulo"/></h3>
                        <xsl:variable name="fotoUrl" select="titulo/@foto"/>
                        <img src="{$fotoUrl}" alt="FotoAlbum"/>
                        <p><xsl:value-of select="artista"/></p>
                        <p><xsl:value-of select="pais"/></p>
                        <p><xsl:value-of select="compania"/></p>
                        <p><xsl:value-of select="precio"/></p>
                        <p><xsl:value-of select="fecha_publicacion"/></p>
                        <p><xsl:value-of select="genero"/></p>
                        <p><xsl:value-of select="rating"/></p>
                    </div>
                </xsl:for-each>
            </body>
        </html>

    </xsl:template>

</xsl:stylesheet>