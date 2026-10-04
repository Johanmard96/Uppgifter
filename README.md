En konsolapplikation (CLI) i Java som administrerar ett litet bibliotek:
böcker, medlemmar och utlåning. Byggd utan Collections Framework, utan
Generics, utan fil-I/O, utan JUnit och utan arv/interface - enligt
uppgiftens begränsningar.

Hur man kör programmet: mvn compile exec:java


eller bygg en körbar jar:
mvn package
java -jar target/bibliotekshanteraren.jar

Struktur

Bok (record) - ISBN, titel, författare.
Medlem (klass) - id, namn, antal aktiva lån, med inkapslade fält och
  metoden `canBorrowMore()`.
Bibliotek (klass) - håller böcker och medlemmar i arrayer med
  ursprungligen fast storlek, samt en parallell array som håller reda på
  vilken medlem (om någon) som lånat respektive bok.
Main - menyloopen (Scanner) och all in-/utmatning.



Bok är en record eftersom dess data (ISBN,
titel, författare) är bokens identitet och inte ska ändras efter att den
skapats. En bok byter inte titel eller författare. Medlem är däremot en
vanlig klass, eftersom en medlems tillstånd (antal aktiva lån) förändras
kontinuerligt medan programmet körs. Det är just den föränderligheten som
motiverar en klass med privata fält och kontrollerad åtkomst i stället för
en record.

Själva utlåningen (vilken bok som är lånad av
vem) hålls i Bibliotek via den
parallella arrayen lånadAvId. Det gör att Bok kan förbli
helt oföränderlig samtidigt som biblioteket ändå kan svara på frågor om
lånestatus.

Eftersom `Arrays.sort()` och
Collections-baserad sökning inte var tillåtna implementerades en egen
selection sort för att sortera böcker på titel, och en egen linjär
sökloop för fritextsökning på titel/författare.

Både bok- och medlemsarrayen börjar med en liten
fast storlek och dubbleras manuellt (ny array + kopiering) när de blir
fulla, i stället för att krascha eller vägra ta emot fler poster.



Om List/Map/ArrayList hade varit tillåtna hade lösningen blivit
enklare på framför allt tre punkter:

Ingen manuell kapacitetshantering. `ArrayList` växer automatiskt,
   så hela kapacitets och kopieringslogiken hade kunnat tas bort helt. 

Sökning och sortering. `Collections.sort()` (eller
   `list.sort(Comparator.comparing(Book::title))`) hade ersatt
   selection sort-implementationen, och en enkel `for`-loop med
   `.filter()`-liknande logik hade kunnat ersatt den manuella
   sökloopen.

   I stället för en parallell `int[]`-array
   hade en `Map<String, Integer>` (ISBN → medlems-id) eller
   `Map<Book, Member>` kunnat uttrycka relationen mer direkt, utan att
   behöva hålla två arrayer i synk index för index.

Poängen med att bygga det här utan Collections är att förstå vad de
här klasserna faktiskt gör under huven - manuell array-växling visar till
exempel konkret varför `ArrayList` är bekvämt, i stället för att bara ta
det för givet.