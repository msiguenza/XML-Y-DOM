<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
<html>
			<body>
				<h1>Fechas Miguel Angel Siguenza Marquez AD</h1>
				<table>
					<tr bgcolor="yellow">
						<th>Dia</th>
						<th>Mes</th>
						<th>Anio</th>
					</tr>
					<xsl:for-each select="fechas/fecha">
						
						<tr>
							<td bgcolor="#F5F5DC">
								<xsl:value-of select="dia"/>
							</td>
							<td bgcolor="#F5F5DC">
								<xsl:value-of select="mes"/>
							</td>
							<td bgcolor="#F5F5DC">
								<xsl:value-of select="anio"/>
							</td>
							
						</tr>
					</xsl:for-each>
				</table>
			</body>
		</html>
</xsl:template>

</xsl:stylesheet>