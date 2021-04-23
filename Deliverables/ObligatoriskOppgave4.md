## Obligatorisk oppgave 4
### Deloppgave 1: team og prosjekt
- Team roller som har blitt tildelt forsetter å fungere stort sett veldig bra.
  De individuelle medlemmene i teamet fyller rollene sine uten store problemer,
  vi ser ingen logisk grunn til å legge til flere roller. Det som har blitt tydelig
  med bruken av roller er at det viser seg vanskelig og lite effektivt å gi enkelte roller som koder og tester til en person.
  Dette er hovedsakelig grunnet arbeidsmengde som de enkelte rollene må gjennomføre. Roller som teamleader og designer
  fungerer mye bedre som roller enkelt personer kan ta ansvar for. Så selv om vi har satt opp en rolle for hvert
  medlem av teamet, så blir det mer riktig å se på dette som at medlemmet er hoved-ansvarlig for tildelt rolle.
  Rolle-systemet for oss blir dermed veldig flytende, vi kunne skrevet opp de fleste i gruppen på nesten alle rollene.
  Vi bestemte oss for å beholde fordelingen av roller slik den er hovedsakelig for å holde struktur, men som nevnt tidligere blir roller sett mer som
  hovedansvaret til medlemmene. Arbeidsmengde, tid individuelle medlemmer har og krav for oppfylling av de forskjellige obligatorsike oppgavene er noe som
  er i konstant forandring. Å holde rollene fleksible er dermed noe vi ser som essensielt for suksess i dette studentprosjektet.


- Prosjektmetodikkene vi har valgt å fokusere er det vi kanskje er mest fornøyd med.
  Vårt oppsett av scrum med mindre ukentlige sprints med tre faste møter hver sprint fører til at alle medlemmer
  konstant holdes oppdatert på progresjonen til prosjektet. Bruken av CodeWithMe og generell samarbeid med nesten alle
  oppgavene fører til få feil, god oversikt over alle medlem og konstruktive resultater. Bruk av project-board har forbedret
  seg men er fortsatt minimalt noe som fungerer bra på grunn av god kommunikastion og konstant tilbakemeldinger.
  Om prosjektet ville involvert flere personer og/eller vert mer komplekst ville vår bruk av project-board
  ikke vært tilstrekkelig. Bruk av project-board er kanskje den eneste tingen vi mener vi kan forbedre i vår bruk av valgte
  prosjektmetodikker.


- Gruppedynamikken har så langt fungert veldig bra. Det er mye kommunikasjon og tilbakemeldinger mellom de
  individuelle medlemmene. Vi føler at vi har satt opp et godt arbeidsmiljø der alle blir hørt og der ingen er redd for å si sin mening.
  Arbeidsfordelingen er relativt balansert men må ofte finjusteres basert på tiden til medlemmene og at
  visse oppgaver blir mer langvarig / komplisert enn andre. Noe som kan være vanskelig å presist forutse
  ved arbeidsfordeling.


- Kommunikasjon tar vi hovedsakelig gjennom discord der vi har en felles SMED gruppechat. Vi samles i en
  voice call sammen under møtene/arbeidstimer. Utenfor møter/arbeidstimer sender vi meldinger på discord
  i gruppechatten om spørsmål, oppfølging eller generell diskusjon.
  I forhold til i starten fungerer kommunikasjonen stort sett på samme måte, bare litt bedre ettersom vi er blitt bedre kjent.


- Prioritering av oppgaver fremover(Ting vi hadde gjort hvis vi hadde tid):
    - Refaktorere kode mer.
    - Vi har diskutert å implementere en 4-player modus, men det viste seg å ikke være tid til å få det gjort slik vi ønsket.
    - Bedre visuelle effekter.
    

- Oppfølging av sist retrospektiv forbedringspunkt:
    - Utdyping av rollebeskrivelser, som nevnet tidligere har vi bestemt oss for å holde
      de tildelte rollene for struktur selv om disse er veldig fleksible.
    - Forbedre commits, vi har vert veldig fornøyd med commits med tanke på commit meldinger og å unngå merge-conflict.
      Fordelig av commits er fremdeles relativt ujevnt grunnet bruk av CodeWithMe og generelt samarbeid som fører til at en commit kan inneholde arbeid av flere medlemmer.
      Dette er vanskelig å unngå og vi foretrekker å holde godt samarbeid over balanserte commits.
      Vi kan gi credit for arbeid på andre måter og balansen av commits kan lett forklares.
    - Bruk av project board, vi har blitt bedre med bruken av project board i forhold til arbeidsfordeling, men vi kan
      bli bedre på å holde det oppdatert utover sprinten.


- Retrospektiv:
    - Fortsatt fornøyd med rollefordeling, metodikk og kommunikasjon.
    - Gruppedynamikken har god flyt og fungerer bra.


- Hva vi kunne gjort annerledes hvis vi begynte på nytt:
    - Sette oss inn i grafikk tidligere for at spillet skal være finere visuelt.
    - Bruke mer tid på å tyde oppgaveteksten ettersom vi hadde litt problemer med tolking av oppgaver de første innleveringene.
    - Bedre og hyppigere bruk av project board.
    - Kunne fulgt test-driven development strengere ettersom det ikke ble brukt på alt av programmet.
    - Hatt et klarere overblikk over sluttprodukt, slik at vi kunne hatt en fastere plan fram til sluttproduktet. 
    - Kunne gjerne hatt mer fysisk oppmøte, men det var ikke mulig mtp. epidemien. 


- Hva er det viktigste vi har lært:
    - Face-to-face kommunikasjon gir mindre rom for feil.
    - Planlegging av kode før man setter i gang er viktig.
    - Viktigheten av å tyde oppgavetekst ordentlig.
    - 

### Deloppgave 2: Krav

#### Brukerhistorier

Powerdown

Brukerhistorie:
- Som spiller skal roboten min ha muligheten til å kunne bruke en runde til å «powerdown» for å få fullt liv.
  Arbeidsoppgave:
- Lag en «powerdown» funksjon i «GameLogic» som gir spilleren maks HP og lar ikke roboten velge kort denne runden.
- Registre «p» som et keyboard input som tar i bruk «powerdown» funksjonen
  
Akseptansekriterier:
- Gitt at spilleren trykker på «p» før hen velger kort, så skal:
  i. Spilleren ikke gjøre noen egne handlinger den runden og få HP’en satt til fullt.
- Gitt at spilleren trykker på «p» etter å ha et eller flere kort, så skal:
  ingenting skje

Spiller kollisjon
Brukerhistorie:
- Som spiller skal roboten min kunne kollidere med andre roboter, og dytte de vekk eller bli dyttet selv.
  Arbeidsoppgave:
- Endre på «turn» i GameLogic til å la en av robotene bevege seg først. Roboter blir dyttet hvis de står på ruter hvor en annen robot beveger seg til. For øyeblikket skal det være tilfeldig hvilken robot som beveger seg først. Etter robotene har beveget seg skal brettet oppdateres for begge robotene.
  Akseptansekriterier:
  Robot1(R1), Robot2(R2)
- Hvis R1 står på en rute som R2 beveger seg til, så skal:
  i. R1 bevege seg 1 rute i retningen til R2 fra ruten, og R2 skal flyttes oppå ruten
- Hvis R1 står på en rute som R2 beveger seg til med en vegg i retningen til R2 fra ruten, så skal:
  i. R1 ikke bevege seg og R2 skal ikke bevege seg.
- Hvis R1 og R2 står på to sammenhengende ruter og beveger seg mot hverandre, så skal:
  i. R1 og R2 ikke flytte seg

Lås kort når spillerne mister liv
Brukerhistorie:
- Som spiller skal jeg miste muligheten til å velge 5 kort avhengig av hvor mye HP jeg har mistet. De første kortene jeg valgte runden jeg mistet HP skal være låst helt til jeg får fullt HP eller dør.
  Arbeidsoppgave:
- Lage en funksjon i GameLogic som leser hvor mye liv spilleren har mistet og bruker det til å låse kort.
  Akseptansekriterier:
- Gitt at spilleren har mistet 20%, 40%, 60%, 80% av HP’en sin, så skal:
  i. Spilleren velge henholdsvis 1, 2, 3, 4 mindre kort og få låst henholdsvis 1, 2, 3, 4 av kortene sine fra runden spilleren mistet HP.

La spillere velge kort samtidig
Brukerhistorie:
- Som spiller vil jeg kunne velge kort samtidig som motspillerne mine.
  Arbeidsoppgave:
- Implementer multi-threading slik at en thread alltid lar render() funksjonen i ServerRender kjører og ungår at programmet fryser, og la en thread vente på å motta kortene fra motspillerne.
- Implementer multi-threading slik at når spillet starter som en server skal det bli laget en thread som lagrer kortene som spillerne sender inn, for deretter å sende kort ut igjen til spillerne når alle spillerne er ferdige med å sende inn kortene sine, og la en thread knytte seg til serveren som en klient.
  Akseptansekriterier:
- Gitt at flere spillere spiller spillet, så skal:
  i. begge spillere kunne velge kort samtidig uten at programmet fryser.
  ii. spillerne som er ferdig å velge kort skal vente helt til alle andre spillere har valgt kort. 
vegger stopper spillere 
Brukerhistorie:
- Som vegg ønsker eg å ikkje la spillere gå gjennom meg, for å gjøre spille meir utfordrende.
  Arbeidsoppgave:
- Implementer en skjek som plir brukt i move() som skjekker om det eksisterer en veg som skal stoppe deg på ruten der du står eller en fram i forhold til den rettningen du står.
- Gitt at en spiller står på brettet med en vegg foran seg så skal:
  i. spilleren ikkje kunne bevege seg gjennom veggen.

### Bugs:
- Spillere kan bevege seg over hull uten å avslutte spillet midt i en runde hvis spilleren beveger seg 2 eller 3 felt fremover på en turn.
- Hvis en trykker på et tall på tastaturet høyere enn det er tilgjengelige kort krasjer programmet. For eksempel, det er 8 kort å velge mellom og brukeren trykker på 9.
- Knapper i GUI kan miste posisjon avhenging av operativsystem.

### Deloppgave 3: Produktleveranse og kodekvalitet

### Credits
- Ressurser for utseendet av menyen er ikke laget selv.
  - GlassyUI:
    - Created by Raymond "Raeleus" Buckley
    - Visit ray3k.wordpress.com for games, tutorials, and much more!

- Roborally grafikk:
  - https://www.thealexandrian.net/creations/roborally/roborally-ultimate-collection-rulebook.pdf

## Meetingminutes

### Påskepause 29.03.2021 -> 04.04.2021
### Mandag 05.04.2021
### Deltakere: Daan, Eivind, Sigurd, Malte
### Sprint-planlegging møte på Discord 12-13
- Fordeling av arbeidsoppgaver:
    - Implementere vegger
    - Refaktorering av kode/slette ubrukt kode
    - Nytt spillbrett


### Onsdag 07.04.2021
### Deltakere: Daan, Eivind, Sigurd, Malte
### Discord Møte - oppfølging av utdelte arbeidsopppgaver 12-12:15
- Konklusjon:
    - Brukerhistorier for dokumentasjon av vegger er ferdig.
    - Slettet noe ubrukt kode.
- Gjenstående:
    - Implementasjon av vegger.
    - Nytt spillbrett.

### Discord gruppetime fellesarbeid - med tilgang til TA. 12:15-14
- Konklusjon:
    - Ferdig implementert vegger, samt tilhørende manuelle og automatiske tester.

### Fredag 09.04.2021
### Deltakere: Daan, Eivind, Sigurd, Malte
### Discord møte - Sprint review og retrospektiv
- Sprint review konklusjon:
    - Fikk gjort det vi satte opp for sprinten.
    - Spillbrett kan finpusses.
- Sprint review retrospektiv konklusjon:
    - Fornøyd med fullført arbeid.

### Mandag 12.04.2021
### Deltakere: Daan, Eivind, Sigurd, Malte
### Discord møte - Sprint-planlegging 12-13
- Sprint-planlegging:
    - Implementere power down funksjon
    - Spillere kan velge kort samtidig
    - Skrive .md-fil
- Fordeling av arbeidsoppgaver:
    - Power down funksjon(Daan)
    - Skriving av .md-fil(Malte, Sigurd)
    - Spillere kan velge kort samtidig(Eivind)
### Onsdag 14.04.2021
### Deltakere: Daan, Eivind, Sigurd, Malte
### Discord møte - Oppfølging av utdelte arbeidsoppgaver 12-12:15
- Konklusjon:
    - Brukerhistorier ferdigstilt for power down og velge kort samtidig.
    - Power down nesten ferdig implementert.
- Gjenstående:
    - Implementere ferdig power down.
    - Implementere velge kort samtidig.
    - Ferdigstilling av .md-fil for uken.
    
### Discord gruppetime fellesarbeid - med tilgang til TA 12:15-14
### Deltakere: Daan, Eivind, Sigurd, Malte
- Konklusjon:
    - Power down ferdig implementert, samt tilhørende tester.
    - Begynt på velge kort samtidig.
    
### Fredag 16.04.2021
### Deltakere: Daan, Eivind, Sigurd, Malte
### Discord møte - Sprint review og retrospektiv
- Sprint review konklusjon:
    - Power down og velge kort samtidig ferdig implementert. Samt automatiske tester, mangler manuelle tester på velge kort samtidig.
    - .md-fil ferdigstilt for ukens sprint.
- Sprint retrospektiv konklusjon:
    - God flyt på arbeidet
    - Tilnærmet ferdig med utdelte arbeidsoppgaver.

### Mandag 19.04.2021
### Deltakere: Daan, Eivind, Sigurd, Malte
### Discord møte - Sprint-planlegging 12-13
- Sprint planlegging:
    - Roboter kan kollidere
    - .md-fil ferdigstilles for innlevering
    - Implementere HP-regler
    - Gjennomgår alt av kode for kvalitetssjekk
    - Generell finpussing av prosjekt

- Arbeidsfordeling:
    - Implementere hp-regler(Daan)
    - Roboter kan kollidere(Eivind, Daan)
    - .md-fil(Malte, Sigurd)
    - Se på om utseendet kan forbedres(Sigurd)

### Onsdag 21.04.2021
### Deltakere: Daan, Eivind, Sigurd, Malte
### Discord møte - oppfølging av arbeid.
- Konklusjon:
    - Ferdig med brukerhistorier for arbeidsoppgavene.
    - HP-regler ferdig implementert, samt tilhørende tester.
    - Litt igjen av .md-fil
- Gjenstående:
    - Resterende av .md-fil
    - Implementasjon av roboter kan kollidere, samt tilhørende tester.
    - Generell finpussing av prosjekt
    - Gå gjennom all kode.

### Discord gruppetime fellesarbeid - med tilgang til TA 12:15-14
### Deltakere: Daan, Eivind, Sigurd, Malte
- Konklusjon:
    - Alle arbeidsoppgaver ferdig oppdatert
    - Mangler finpussing av prosjektet

### Fredag 23.04.2021
### Deltakere: Daan, Eivind, Sigurd, Malte
### Discord møte - Sprint review og retrospektiv
- Sprint review konklusjon:
    - Ferdig med alle utdelte arbeidsoppgaver
    - Ferdig med finpussing av prosjekt
- Sprint retrospektiv konklusjon:
    - Fornøyd med siste uken av prosjektet
    - Samtlige fornøyd med innsats og utføring. 
    - I siste innleveringen har det ikke blitt implementert like mye som de tidligere, men det som ble implementert
      er mer tidkrevende og kompliserte oppgaver.
    - Det er noen punkter fra project board vi ikke fikk implementert, grunnet prioritering av andre oppgaver.
      
### Project Board
![pb4.png](pb4.png)
