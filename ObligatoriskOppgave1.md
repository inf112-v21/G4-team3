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
- Prosjektmetodikk:
1. Vi baserer oss på scrum som den hovedsaklige prosjektmetodikken, men vi tilpasser den
   til formålet til prosjektet ettersom det er noen forskjeller på et standard scrum team
   og en liten gruppe av 4 studenter. Vi gjennomfører ukentlige sprints på en mandag-fredag syklus.
   I sprint-planning setter vi oppgavene som skal bli gjennomført innenfor tidsrammen av sprinten. Planleggingen av 
   ukens sprint skjer mandager på et online-møte hvor vi tar sikt på at planleggingen blir gjort
   på en time. Under sprint-planning fordeles arbeidsoppgavene for sprinten. Vi setter opp sprinten på project board i git-repoet vårt. Den daglige scrumen blir gjennomført 
   annenhver dag ettersom alle gruppemedlemmene har andre fag og oppgaver å forholde seg til parallelt. Det er 
   korte møter hvor vi oppdaterer hverandre om progresjonen i prosjektet og de forskjellige oppgavene før neste møte. 
   Vi gir hyppige tilbakemeldinger 
   hvilket gjør selve arbeidsprosessen mer agil. Vi prøver å få TA - Knut, til å være med på noen scrumsene
   ettersom han spiller rollen som kunde i dette tilfellet og kan også gi verdifull tilbakemelding på hvor 
   vi står. Denne syklusen med tilbakemelding hvor TA er involvert gjør at vi kan oppdage antagelser
   eller eventuelle dårlige retninger før vi begynner på dem. På fredager har vi et sprint-review og 
   sprint-retrospektiv, i starten ble møtet holdt fysisk, men pga. situasjonen til universitetet kan de også
   bli holdt over discord. I sprint-review ser vi hva som har blitt gjort og ikke iløpet av sprinten. Sprint-review 
   skal også oppdatere kunden om prosjektets standpunkt og progresjon i løpet av sprinten. Rett etter sprint-review 
   går vi inn i sprint-retrospektiv delen av møtet. I denne delen prøver vi å gi hverandre tilbakemeldinger
   om sprinten og hva som kan bli gjort bedre neste sprint. Vi prøver å holde review og retrospektiv i underkanten av
   en time. Vi tar i bruk par-programmering hvor code-with-me hovedsaklig er verktøyet det fører til en
   mer agil programmeringsprosess ettersom det blir konstant gitt feedback mellom parene. Vi bruker git-repoet
   for deling av dokumenter, diagram og som kodebase. Vi følger test-drevet utvikling hvor tester skrives før 
   koden og koden skal være så enkel som mulig og kun oppfylle kravene for å bestå testen. Etter det refaktoreres
   først testene og så koden.
   
##Deloppgave 3 Få oversikt over forventet produkt 
### - Overordnete målet for applikasjonen: 
- Fullfører 9 mvp-kravene:
  Vise et spillebrett
  Vise brikke på spillebrett
  Flytte brikke (vha taster e.l. for testing)
  Robot besøker flagg
  Robot vinner ved å besøke flagg
  
  Spille fra flere maskiner (vise brikker for alle spillere, flytte brikker for alle spillere)
  Dele ut kort
  Velge 5 kort
  Bevege robot ut fra valgte kort

- Det overordnete målet for vår applikasjon ved slutten av prosessen kan deles opp i X deler:
1. Applikasjonen skal kjøre feilfritt med minimalt med bugs og oppfylle minst alle MVP-kravene.
2. Har god kodepraksis med abstrahering, innkapsling, arv og generelt hovedtrekkende fra objektorientert
programmering.
3. Hensiktsmessige tester med god kodedekkelse og som sørger for at krav blir oppfylt og at kodebyggingen
   basert på testene blir mer effektiv.
4. Levere et resultat, hver enkelt i teamet kan stå bak og være fornøyd med. 

### Brukerhistorier
Vi vil basere oss på brukerhistorie formatet vist av [ENTUR](https://design.entur.org/kom-i-gang/for-designere/brukerhistorier) 09.02.2021
Siden den virker klar og tydelig og viser oss steg for steg hvordan vi skal sette opp våre brukerhistorier.
Brukerhistoriene er numerert etter hvilket MVP-krav de oppfyller og prioritet.
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
     Sjekker om flagget eksisterer i samme celle som spiller
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
     Setter win-condition til true om flagget eksisterer i samme celle som spiller. 
   - Aksepteansekriterier:
     Gitt at robot besøker flagg,
     så skal:
   1. flagget bli registrert som besøkt.
   2. spillet bli vunnet av den som tar flagget.
   
###Prioriteringer
- Vi har prioritert brukerhistoriene/kravene ut fra den viste rekkefølgen i oppgaveteksten, grunnet
det er en naturlig fremgangsmåte med tanke på utviklingen av MVP for eksempel vil det være vankselig å vise
  en brikke på spillebrettet uten å ha fullført kravet: "Vise et spillbrett".
1. Vise et spillbrett
2. Vise brikke på spillebrett
3. Flytte brikke(vha. taster)
4. Robot besøker flagg
5. Robot vinner ved å besøke flagg 

Vi har valgt å ikke oppfylle flere MVP-krav enn gitt, ettersom vi bruker perioden til første innlevering
som prøve-periode på måten vi jobber sammen på. 


## Deloppgave 4: Kode 


