# Navigation-Tree-JFX
Bewerbungsprojekt

## Aufgabe
*	Ein Navigationsbaum mit 2 Seiten soll links dargestellt werden
*	Der Inhalt der aktuell ausgewählten Seite soll dann rechts angezeigt werden
  *	**Erste Seite** heißt „Dateneingabe“ und beinhaltet 2 Eingabeelemente: Vollständiger Name, Geburstdatum.
*	**Zweite Seite** heißt „Ergebnis“ und zeigt nichts falls die Felder auf der 1. Seite nicht befüllt sind und folgenden Text, wenn die Felder gefüllt sind: „{vollständiger Name aus 1. Seite} alles Gute zum Geburtstag am {das Datum aus der 1. Seite im Deutschformat TT.MM.JJJJ}“
*	Die Mockups sind nur für bessere Verständnis hinzugefügt und sollen nicht als genaue Umsetzung der Aufgabebeschreibung benutzt werden.

Die Aufgabe bitte als Maven Projekt implementieren. Um sich mit Maven selbst nicht intensiv befassen zu müssen, empfehlen wir Intellij IDEA für das Projekt zu installieren. Diese IDE verwenden alle Entwickler der intecsoft. Damit kann ein Maven Projekt angelegt werden. Die JavaFX-Abhängigkeiten sind in der pom.xml hinzuzufügen und es kann gestartet werden. Inhalt und Bedeutung der pom.xml, erklären sich nach dem Erstellen des Projekts.
Daher empfehlen wir JDK 11 oder JDK 17 zu verwenden.

## Beschreibung
Genau wie beschrieben, ist die Anwendung in zwei Seiten aufgeteilt. Erste schlägt vor, einen Namen und ein Geburtsdatum einzutragen, die andere zeigt den Glückwunschtext. Zusätzlich wurde bei der Eingabe eine Validierung implementiert, wenn die Anforderungen nicht erfüllt werden, dann wird der Rahmen von Eingabefeld rot und auf der zweiten Seite wird auch kein Ergebnis angezeigt. Genaue Anforderungen findet man im Tooltip. Die Anwendung ist dreisprachig (Englisch, Deutsch, Ukrainisch), dafür wurden entsprechende Resource bundels erstellt (um eine konkrete Sprache zu testen, nutzen Sie bitte VM-Optionen, z. B. für Deutsch **-Duser.country=DE -Duser.language=de**).

### Verwendete Technologien:
Java FX, JDK 17, JUnit, Mockito, SLF4J, logback, Gson