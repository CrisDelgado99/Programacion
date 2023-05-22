<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
xmlns:xs="http://www.w3.org/2001/XMLSchema"
exclude-result-prefixes="xs" version="2.0">
    
    <xsl:template match="/">
    <html>
        <head>
            <title>Álbumes musicales</title>
            <link rel="stylesheet" href="EjCDsParte1.css" type="text/css"/>
        </head>
        <body>
            <h1>Artistas masculinos</h1>
            <xsl:for-each select="CDs/CD">
                <xsl:if test="artista/@genero = 'masculino'">
                    <div>
                        <xsl:variable name="fotoUrl" select="titulo/@foto"/>
                        <img src="{$fotoUrl}" alt="FotoAlbum"/>
                        <ul class="ppal"> <!-- class principal, ul padre-->
                            <li><h3><xsl:value-of select="titulo"/></h3></li>
                            <ul class="sec"> <!-- class secundaria, ul hijo-->
                                <li><p><xsl:value-of select="artista"/></p></li>
                                <li><p><xsl:value-of select="pais"/></p></li>
                                <li><p><xsl:value-of select="compania"/></p></li>
                                <li><p><xsl:value-of select="precio"/></p></li>
                                <li><p><xsl:value-of select="fecha_publicacion"/></p></li>
                                <li><p><xsl:value-of select="genero"/></p></li>
                                <li><p><xsl:value-of select="rating"/></p></li>
                            </ul>
                        </ul>
                    </div>       
                </xsl:if>
            </xsl:for-each>

                <h1>Artistas femeninos</h1>
                <xsl:for-each select="CDs/CD">
                    <xsl:if test="artista/@genero = 'femenino'">
                        
                        <div>
                            <xsl:variable name="fotoUrl" select="titulo/@foto"/>
                            <img src="{$fotoUrl}" alt="FotoAlbum"/>
                            <ul class="ppal"> <!-- class principal, ul padre-->
                                <li><h3><xsl:value-of select="titulo"/></h3></li>
                                <ul class="sec"> <!-- class secundaria, ul hijo-->
                                    <li><p><xsl:value-of select="artista"/></p></li>
                                    <li><p><xsl:value-of select="pais"/></p></li>
                                    <li><p><xsl:value-of select="compania"/></p></li>
                                    <li><p><xsl:value-of select="precio"/></p></li>
                                    <li><p><xsl:value-of select="fecha_publicacion"/></p></li>
                                    <li><p><xsl:value-of select="genero"/></p></li>
                                    <li><p><xsl:value-of select="rating"/></p></li>
                                </ul>
                            </ul>
                        </div>        
                    </xsl:if>
                </xsl:for-each>

                <h1>Grupos</h1>
                <xsl:for-each select="CDs/CD">
                    <xsl:if test="artista/@genero = 'mixto'">
                        
                        <div>
                            <xsl:variable name="fotoUrl" select="titulo/@foto"/>
                            <img src="{$fotoUrl}" alt="FotoAlbum"/>
                            <ul class="ppal"> <!-- class principal, ul padre-->
                                <li><h3><xsl:value-of select="titulo"/></h3></li>
                                <ul class="sec"> <!-- class secundaria, ul hijo-->
                                    <li><p><xsl:value-of select="artista"/></p></li>
                                    <li><p><xsl:value-of select="pais"/></p></li>
                                    <li><p><xsl:value-of select="compania"/></p></li>
                                    <li><p><xsl:value-of select="precio"/></p></li>
                                    <li><p><xsl:value-of select="fecha_publicacion"/></p></li>
                                    <li><p><xsl:value-of select="genero"/></p></li>
                                    <li><p><xsl:value-of select="rating"/></p></li>
                                </ul>
                            </ul>
                        </div>        
                    </xsl:if>
                </xsl:for-each>
            </body>
        </html>

    </xsl:template>

</xsl:stylesheet>