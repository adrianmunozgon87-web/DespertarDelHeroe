<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

  <xsl:output method="html" encoding="UTF-8" indent="yes"/>

  <xsl:template match="/">

    <html>
      <head>
        <title>Ranking - El Despertar del Heroe</title>
        <link rel="stylesheet" href="ranking.css"/>
      </head>
      
      <body>

        <h1>El Despertar del Heroe</h1>
        <h2>Ranking de jugadores</h2>

        <table border="1">
          <tr>
            <th>Posicion</th>
            <th>Usuario</th>
            <th>Puntos</th>
          </tr>

          <xsl:for-each select="ranking/jugador">

            <xsl:sort select="puntos"
                      data-type="number"
                      order="descending"/>

            <tr>
              <td>
                <xsl:value-of select="position()"/>
              </td>

              <td>
                <xsl:value-of select="usuario"/>
              </td>

              <td>
                <xsl:value-of select="puntos"/>
              </td>
            </tr>

          </xsl:for-each>

        </table>

      </body>
    </html>

  </xsl:template>

</xsl:stylesheet>
