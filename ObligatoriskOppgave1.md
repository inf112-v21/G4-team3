# Obligatorisk Oppgave1

##Deloppgave: Organiser teamet
###Kompetanse 
Sigurd Loennechen - kiq013:
- IKT 4. semester
- har tatt INF100, INF101, INF102
- erfaring med python og java
- har også hatt litt om kunstig intelligens og diskret matematikk

Jan Malte Brunner: - caq008
- 4 semester IKT
- har hatt kurs I INF100, INF101, INF102 diverse info fag
- Kodespråk erfaring innenfor Java, Python
- Diskret matematikk og generell tech-interesse

Eivind Skarstein - nit005
- har tatt INF109, INF101, INF102, INF264
- har erfaring med python, java og MATLAB
- går siste semester i Data Science
- har fullført en bachelorgrad i geofysikk, med mye programmering i MATLAB

Daan van Kessel - dke004
- har tatt INF100
- tar INF101
- litt erfaring med c++ og arduino boards
- sett java tutorial
  
###Roller innenfor prosjektet
- Team leader: Jan Malte Brunner
1. Hovedjobben til Team leader overse den agile prosessen for både
   teamet og kunden. En av oppgavene til team leader er å være et mellomledd
   mellom de forskjellige aktørene involvert i prosjektet og holde styr på
   det helhetlige bildet av prosjektet. Team leader jobber også som teamets
   ansikt utad og har hovedansvaret for kommunikasjonen for teamet.

- Kundekontakt: Jan Malte Brunner
1. Team leader er også satt opp som kundekontakt ettersom en stor del av 
   team leaders rolle går ut på kommunikasjon både innenfor teamet og med kunden.
   Jevnlig tilbakemeldinger mellom teamet og kunden i forhold til fremgang av prosjekt
   og eventuelle problemer som kan oppstå.
   
- Design: Sigurd Loennechen
1. Hovedansvaret for designansvarlig er først og fremst å tilrettelegge for
   så intuitivt program som mulig for kunden/bruker. Programmet skal ikke bare se bra
   ut men også være lett å navigere gjennom.
   
- Koder: Daan van Kessel
1. Koderen i et prosjekt skal ikke bare bygge leveranser, men har også ansvar for å kommunisere
   statusen til prosjektet til Team leader. Koderen er avhengig av at de andre medlemmene
   i laget også kommuniserer de tekniske kravene effektivt til koderen slik at han får de 
   beste forutsetningene som mulig. 
   
- Tester: Eivind Skarstein
1. For å vite om programmet fungerer som ønsket er det nødvendig å ha gode og 
   omfattende tester. Rollen som Tester setter opp tester og har ansvar for at 
   testene til programmet fungerer og dekker situasjoner programmet vil møte.




##Deloppgave 2 Velg og tilpass en prosess for laget

##Deloppgave 3 Få oversikt over forventet produkt 

## Deloppgave 4: Kode 



## Brukerhistorier
1. Vise et spillebrett:
   - Brukerhistorie:
     Som bruker av applikasjonen må jeg ha en visuell / logisk representasjon av spillebrettet for å kunne bruke applikasjonen I det hele tatt.
   - Løsningsbeskrivelse:
     Ved å følge instrukser gitt av Libgdx and Tiled Tutorial.pdf tar vi i bruk programvaren Tiled for å sette opp et bredt ved å følge utdelt spreadsheet.
   - Akseptansekriterier:
     Gitt at vi starter applikasjonen så skal
   1. Vi få opp en visuell representasjon av spillebrettet
   
2. Vise brikke på spillebrett:
   - Brukerhistorie:
   Som bruker av applikasjonen, vil jeg ha tydelige visuelle representasjoner av brikker på spillbrettet, slik at det er mulig å bruke applikasjonen.
   - Løsningsbeskrivelse:
   Bruker Libgdx og Tiled til å vise brikker på spillbrettet.
   - Akseptansekriterier:
   Gitt at en brikke skal være synlig på spillbrettet, så skal:
   1. Brikken ha en tydelig visuell representasjon på spillbrettet.
 
3. Flytte brikke(vha taster):
   - Brukerhistorie: som spiller ønsker eg å kunne flytte roboten, 
     slik at eg kan nå plassene eg ønsker.
   - løsningsbeskrivelse: iplimentere en getinnput fra taste trykk og 
     bruke det til å bevege seg.
   - Akseptansekriterier:
      1. git en robot pos(1,1) som får innput til høgrepill, så beveger den til høgre.
      2. git at robot pos(1,1) og får ikkje et innput 
         så beveger den seg ikkje i noen rettning.
   
4. Robot besøker flagg:
   - Brukerhistorie: 
   Som robot   
   vil jeg kunne besøke flagg
   slik at det registreres ved besøk gjennom for eksempel
   en enum som markerer et flagg ved besøk.
   - Løsningsbeskrivelse:
   Lage en flagg-enum som aktiveres når koordinater 
   til roboten overlapper med koordinater til flagget.
   - Akseptansekriterier
   Gitt at roboten besøker et flag, 
   så skal: 
   1. Flagget bli registrert som besøkt 

5. Robot vinner ved å besøke flagg:
   - Brukerhistorie:
   Som robot 
   vil jeg kunne vinne ved å besøke flagg, 
   slik at spillet blir over.
   - Løsningsbeskrivelse:
   Lager en flagg-enum som holder styr på om flagget er besøkt eller ikke
   og om flagget blir besøkt i dette tilfellet blir game-enum til ferdig og avslutter.
   - Aksepteansekriterier:
   Gitt at robot besøker flagg, 
   så skal:
    1. flagget bli registrert som besøkt.
    2. spillet bli vunnet av den som tar flagget.
   
## Known bugs
