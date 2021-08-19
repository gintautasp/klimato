temperaturos
id id_miesto metai laikotarpis temperatura
1    1	   1998  metine       5
2    1           1999  metine       6
3    2           1998  sausio       -7
4    2           1999  sausio       -9
..
127

miestai
id pav 	    plotas  gyv_sk
1  Vilnius     500000  500000
2  Kaunas    300000  280000

SELECT
	temperaturos.id AS id
	, miestai.pav AS miestas
	, temperaturos.metai
	, temperaturos.temperatura
FROM
	temperaturos
LEFT JOIN 
	miestai ON ( 
		temperaturos.id_miesto = miestai.id 
	)
WHERE
	laikotarpis='metine'
HAVING
	 temperatura>5
	 
pirma vykdomas jungimas ( JOIN ) ir gaunam:	
	
temperaturos						miestai
-----------------------------------------------------------------------------
id id_miesto metai laikotarpis temperatura 	id pav 	    plotas  gyv_sk
------------------------------------------------------------------------------
1    1	   1998  metine       5			1  Vilnius     500000  500000
2    1           1999  metine       6			1  Vilnius     500000  500000
3    2           1998  sausio       -7			2  Kaunas    300000  280000
4    2           1999  sausio       -9			2  Kaunas    300000  280000

po tai WHERE, GROUP BY, ORDER BY

tada SELECT ir gaunam

--------------------------------
id miestas metai temperatura
-------------------------------
1  Vilnius	1998    5	
2  Vilnius   1999    6

ir iš tokios galima atrinkti su HAVING temperatura>5

id miestas metai temperatura
1  Vilnius	1998    5	


