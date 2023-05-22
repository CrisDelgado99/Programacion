<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
xmlns:xs="http://www.w3.org/2001/XMLSchema"
exclude-result-prefixes="xs" version="2.0">
    <xsl:template match="/">
        <html>
            <head>
                <title>Álbumes musicales</title>
                <link rel="stylesheet" href="EjCDsParte3.css" type="text/css"/>
            </head>
            <body>
            <!--Artistas de ESPAÑA////////////////////////////////////////////////////////-->
                <h1>Artistas españoles</h1>
                <table>
                    <tr>
                        <th>Diseño del disco</th>
                        <th>Título</th>
                        <th>Artista</th>
                        <th>Compañía</th>
                        <th>Precio</th>
                        <th>Publicación</th>
                        <th>Género</th>
                        <th>Rating</th>
                    </tr>
                    <xsl:for-each select="CDs/CD">
                        <xsl:if test="pais = 'España'">
                            <xsl:variable name="fotoUrl" select="titulo/@foto"/>
                            <tr>
                                <td>
                                    <img src="{$fotoUrl}" alt="FotoAlbum"/>
                                </td>
                                <td>
                                    <p>
                                        <xsl:value-of select="titulo"/>
                                    </p>
                                </td>
                                <td>
                                    <p>
                                        <xsl:value-of select="artista"/>
                                    </p>
                                </td>
                                <td>
                                    <p>
                                        <xsl:value-of select="compania"/>
                                    </p>
                                </td>
                                <td>
                                    <p>
                                        <xsl:value-of select="precio"/>
                                    </p>
                                </td>
                                <td>
                                    <p>
                                        <xsl:value-of select="fecha_publicacion"/>
                                    </p>
                                </td>
                                <td>
                                    <p>
                                        <xsl:value-of select="genero"/>
                                    </p>
                                </td>
                                <td class="rating">
                                    <xsl:choose>
                                        <xsl:when test="rating &gt; 5">
                                            <p>
                                                <xsl:value-of select="rating"/>
                                                /10
                                            </p>
                                        </xsl:when>
                                        <xsl:otherwise>
                                            <img src="../imgs/caratriste.png" alt="CaraTriste"/>
                                            <p id="menor5">
                                                <xsl:value-of select="rating"/>
                                                /10
                                            </p>
                                        </xsl:otherwise>
                                    </xsl:choose> 
                                </td>
                            </tr>
                        </xsl:if>
                    </xsl:for-each>
                </table>
                <!--Artistas de EEUU///////////////////////////////////////////////////////////////-->
                <h1>Artistas estadounidenses</h1>
                <table>
                    <tr>
                        <th>Diseño del disco</th>
                        <th>Título</th>
                        <th>Artista</th>
                        <th>Compañía</th>
                        <th>Precio</th>
                        <th>Publicación</th>
                        <th>Género</th>
                        <th>Rating</th>
                    </tr>
                    <xsl:for-each select="CDs/CD">
                        <xsl:if test="pais = 'EEUU'">
                            <xsl:variable name="fotoUrl" select="titulo/@foto"/>
                            <tr>
                                <td>
                                    <img src="{$fotoUrl}" alt="FotoAlbum"/>
                                </td>
                                <td>
                                    <p>
                                        <xsl:value-of select="titulo"/>
                                    </p>
                                </td>
                                <td>
                                    <p>
                                        <xsl:value-of select="artista"/>
                                    </p>
                                </td>
                                <td>
                                    <p>
                                        <xsl:value-of select="compania"/>
                                    </p>
                                </td>
                                <td>
                                    <p>
                                        <xsl:value-of select="precio"/>
                                    </p>
                                </td>
                                <td>
                                    <p>
                                        <xsl:value-of select="fecha_publicacion"/>
                                    </p>
                                </td>
                                <td>
                                    <p>
                                        <xsl:value-of select="genero"/>
                                    </p>
                                </td>
                                <td class="rating">
                                    <xsl:choose>
                                        <xsl:when test="rating &gt; 5">
                                            <p>
                                                <xsl:value-of select="rating"/>
                                                /10
                                            </p>
                                        </xsl:when>
                                        <xsl:otherwise>
                                            <img src="../imgs/caratriste.png" alt="CaraTriste"/>
                                            <p id="menor5">
                                                <xsl:value-of select="rating"/>
                                                /10
                                            </p>
                                        </xsl:otherwise>
                                    </xsl:choose> 
                                </td>
                            </tr>
                        </xsl:if>
                    </xsl:for-each>
                </table>
                <!--Artistas de SUECIA///////////////////////////////////////////////////////////////-->
                <h1>Artistas Suecos</h1>
                <table>
                    <tr>
                        <th>Diseño del disco</th>
                        <th>Título</th>
                        <th>Artista</th>
                        <th>Compañía</th>
                        <th>Precio</th>
                        <th>Publicación</th>
                        <th>Género</th>
                        <th>Rating</th>
                    </tr>
                    <xsl:for-each select="CDs/CD">
                        <xsl:if test="pais = 'Suecia'">
                            <xsl:variable name="fotoUrl" select="titulo/@foto"/>
                            <tr>
                                <td>
                                    <img src="{$fotoUrl}" alt="FotoAlbum"/>
                                </td>
                                <td>
                                    <p>
                                        <xsl:value-of select="titulo"/>
                                    </p>
                                </td>
                                <td>
                                    <p>
                                        <xsl:value-of select="artista"/>
                                    </p>
                                </td>
                                <td>
                                    <p>
                                        <xsl:value-of select="compania"/>
                                    </p>
                                </td>
                                <td>
                                    <p>
                                        <xsl:value-of select="precio"/>
                                    </p>
                                </td>
                                <td>
                                    <p>
                                        <xsl:value-of select="fecha_publicacion"/>
                                    </p>
                                </td>
                                <td>
                                    <p>
                                        <xsl:value-of select="genero"/>
                                    </p>
                                </td>
                                <td class="rating">
                                    <xsl:choose>
                                        <xsl:when test="rating &gt; 5">
                                            <p>
                                                <xsl:value-of select="rating"/>
                                                /10
                                            </p>
                                        </xsl:when>
                                        <xsl:otherwise>
                                            <img id="cara" height="20px" width="20px" src="../imgs/caratriste.png" alt="CaraTriste"/>
                                            <p id="menor5">
                                                <xsl:value-of select="rating"/>
                                                /10
                                            </p>
                                        </xsl:otherwise>
                                    </xsl:choose> 
                                </td>
                            </tr>
                        </xsl:if>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>