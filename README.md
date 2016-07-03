LANGdradig --- De programmeertaal voor dummies!

De LANGdradig IDE kan worden opgestart door Main.java uit te voeren in src/scallywags/langdradig/ide/frames
De volgende dependencies zijn nodig:

forms_rt-7.0.3.jar 	--- De GUI library van de IDE (http://mvnrepository.com/artifact/com.intellij/forms_rt/7.0.3)
runhaskell			--- Dient toegevoegd te zijn aan de PATH variable van het OS.

Onder water maakt de IDE gebruik van Checker.java, ASTGenerator.java, AST.hs, Generator.hs, HardwareTypes.hs, Sprockell.hs, System.hs, Simulation.hs, BasicFunctions.hs.

Een aantal kant en klare voorbeeldprogramma's die kunnen worden geopend en uitgevoerd staan in src/scallywags/langdradig/example

Handmatig compileren en uitvoeren kan in 3 stappen:
1. Gebruik ASTGenerator.java voor het genereren van het foo.ast.hs bestand. De main methode kan worden ingecomment.
2. Voer foo.ast.hs uit met runghc. Dit genereert een nieuw bestand met SprIL-instructies genaamd foo.spril.hs.  Zorg er voor dat de bovengenoemde haskell bestanden aanwezig zijn in de map.
3. Voer foo.spril.hs uit met runghc voor de simulatie van het programma.

De Grammatica en Lexer en door ANTLR gegenereerde bestanden staan in src/scallywags/langdradig/grammatica/

Geautomatiseerde tests staan in src/scallywags/langdradig/test/