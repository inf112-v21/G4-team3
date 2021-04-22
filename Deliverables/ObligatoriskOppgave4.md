##Obligatorisk oppgave 4
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


- Prioritering av oppgaver fremover:
    - Refaktorere kode.
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


### Deloppgave 2: Krav

#### Brukerhistorier

###Bugs:
- Spillere kan bevege seg over hull/flagg uten å avslutte spillet midt i en runde hvis spilleren beveger seg 2 eller 3 felt fremover på en turn.
- Applikasjonsvinduet «fryser» mens den andre spilleren velger kort. Ikke noe problem egentlig.
- Hvis en trykker på et tall på tastaturet høyere enn det er tilgjengelige kort krasjer programmet. For eksempel, det er 8 kort å velge mellom og brukeren trykker på 9.
- Godtar feil input men setter verdi til null. (Et valg utenfor 1-9)
- Knapper i GUI mister posisjon avhenging av operativsystem.
- I runde baserte moduser (Klient/Server, Test game: Round-based) vil kort velge systemet tulle hvis det blir valgt kort for fort.
- Noen ganger oppdateres ikke teksten på skjermen før første fase i neste runde.

### Deloppgave 3: Produktleveranse og kodekvalitet

### Credits
- Ressurser for utseendet av menyen er ikke laget selv.
- GlassyUI:
    - Created by Raymond "Raeleus" Buckley
    - Visit ray3k.wordpress.com for games, tutorials, and much more!

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

### Project Board
![projectboard.png](projectboard.png)
