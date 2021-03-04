# Einzelbeispiel-SE2
Software Engineering II (621.250, 21S) Einzelbeispiel

2.	Projektbeschreibung
2.1
Erstellen Sie	eine	einfache	Android-Anwendung, die	ein	Eingabefeld,	ein	Textfeld	und	
einen	Button	enthält.	Das	Eingabefeld	soll	nur	numerische	Eingaben	erlauben.	Durch	
Tap	auf	den	Button	soll	die	Eingabe	via	TCP	an	einen	Server	geschickt	werden.	Sobald	
eine	Antwort	vom	Server	eintrifft,	soll	diese	am	Bildschirm	erscheinen.	
Der	Server	nimmt	eine	Matrikelnummer	als	Bytestream	über	die	TCP	Verbindung	
entgegen,	führt	eine	Berechnung	aus	und	sendet	das	Ergebnis	zurück.
Die	Server-Domain	lautet:	se2-isys.aau.at,	Port: 53212.	

2.2
Erweitern	Sie	die	Applikation	aus	2.1	entsprechend	Ihrer	Matrikelnummer.	Berechnen	
Sie dazu	den	Wert	Matrikelnummer	Modulo	7 und	lösen	sie	die	dazugehörige	Aufgabe	
aus	der	Tabelle.	Das	Ergebnis	soll	wieder	am	Bildschirm	ausgegeben	werden.
Nutzen	Sie	dafür	das	existierende	Nummernfeld und	Textfeld	für	Ein- und	Ausgabe.	
Fügen	Sie	außerdem	noch	einen	weiteren	Button	ein,	der	die	Berechnung	auslöst.	
