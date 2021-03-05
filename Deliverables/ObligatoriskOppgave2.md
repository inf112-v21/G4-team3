##Obligatorisk oppgave 2
###Deloppgave 1 prosjekt og prosjektstruktur
- Rollene vi har satt opp til nå ser slik ut:
  - Team leader: Jan Malte Brunner
    - Team leader sine oppgaver innebærer å lede møte og ha innblikk i det større bildet av prosjektet. 
      Holde styr på når og eventuelt hvor møter skal finne sted. Team leader er også hovedkontaktperson for
      team medlemmer og skal distribuere informasjon videre til alle gruppemedlem. 
      
  - Kundekontakt: Jan Malte Brunner
    - Kundekontakt har hovedansvar for kommunikasjon og tilbakemeldinger til kunden/TA. 
      Det vil innebære å holde kunden/TA oppdatert med progresjon og eventuelle mangler i prosjektet. 
      Også eventuell oppklaring av hva kunden forventer for godkjenning av de forskjellige oppgavene 
      innenfor prosjektet.   
      
  - Design: Sigurd Loennechen
    - Design har hovedsakelig ansvar for hvordan de ulike objektene i programmet ser ut. 
      Dette bruker vi Tiles og Libgdx til.
      
  - Koder: Daan van Kessel
    -Som koder er det mitt ansvar å programmere dem denne kunden har til ett program, som enklast mulig å vedlikeholde.
    og at koden er strukturert og lesbart for andre kodere og brukere, slik at om nødvendig det blir lettere å gjøre modifikasjoner.


  - Tester: Eivind Skarstein
    -For å vite om programmet fungerer som ønsket er det nødvendig å ha gode og omfattende tester.
    I rollen som tester innebærer det hovedsakelig å ha kontroll over hva vi ønsker at koden skal gjøre.
    Det er også viktig å vite hvordan programmet fungerer slik at en kan skrive gode tester og gi tilbakemeldinger til koderene.


- Rollene vi satt opp har stort sett fungert bra, alle tildelte rollene har blitt 
oppfylt av gruppemedlemmene. Det vi har merket er at rollene ikke kan bli fulgt like 
sterkt som i et skikkelig jobb prosjekt. Det vil si at selv om en person er satt opp 
som for eksempel designer, team lead eller tester vil de ofte være med på å hjelpe med 
koding. Dette føles mest naturlig siden andel av arbeid for de forskjellige rollene 
varierer i stor grad fra obligatorisk oppgave 1 og 2. Rollene vi har valg dekker 
arbeidsoppgavene greit og vi tenker ikke å legge til flere roller med første. Det vi 
vurderer er å sette Sigurd opp som koder og tester siden design rollen har stor variasjon 
i arbeidsmengde. Som konklusjon er vi fornøyd med rollene så langt og føler ikke vi 
trenger flere av dem, men at rollene i dette prosjektet er fleksible og tilpasset arbeidsoppgavene.

- Gruppedynamikken har så langt fungert veldig bra. Det er mye kommunikasjon og tilbakemeldinger av de 
  individuelle medlemmene. Vi føler at vi har satt opp et godt arbeidsmiljø der alle blir hørt. 
  Arbeidsfordelingen er relativt balansert men må ofte finjusteres basert på tiden til medlemmene og at 
  visse oppgaver blir mer langvarig / komplisert en andre. Noe som kan være vanskelig å presist forutse 
  ved arbeidsfordeling.
  
-  Kommunikasjon tar vi hovedsakelig gjennom discord der vi har en felles SMED gruppechat. Vi samles i en 
  voice call sammen under møtene/arbeidstimer. Utenfor møter/arbeidstimer sender vi meldinger på discord 
  i gruppechatten om spørsmål, oppfølging eller generell diskusjon.
   
- Prosjektmetodikkene som har blitt valgt har vi brukt og fulgt til stor grad. Møter og hyppigheten av dem 
  har vi hovedsakelig klart å holde. Vi merket at vi måtte være mer fleksibel angående tidspunkt av møter 
  med tanke på at alle gruppemedlemmene har forskjellige andre fag / prosjekter å ta hensyn til. Spesielt 
  CodeWithMe har vist gode og veldig konstruktive resultater.  
  
- Ettersom vi ofte jobber i par ikke bare angående programmering (code with me) men også med tanke på 
  tekst-baserte oppgaver kan man se en skjevfordeling av commits fra enkeltpersoner. For eksempel CodeWithMe
  hosten vil også¨være den som pusher opp koden til slutt. 

##Deloppgave 2 krav
6. Spille fra flere maskiner (vise brikker for alle spillere, flytte brikker for alle spillere):
    - Brukerhistorie:
      Som spiller ønsker eg å kunne spille med andre,
      slik at eg kan ha en meir utforandre spillerfaring med
      andre spillere.
    - Løsningsbeskrivelse:

    - Aksepteansekriterier:
        - git:
            1. maskin A og B
            2. git RobotA (1,0) og RobotB(0,0)
        - *****:
            1. når MaskinA sender at den flytter RobotA så Flytter RobotA seg både på skermen til Maskin A og B.
            2. at begge Maskinane viser samme Bretet med Robotane på samme posison.
            3.

7. Dele ut kort:
    - Brukerhustorie:
      som spiller vil jeg få utdelt kort
      Slik at jeg kan velge ut bestemte typer kort
      for å kunne bestemme robotens bevegelser.
      - Løsningsbeskrivelse:
      Programmet skal dele ut 9 tilfeldige kort fra et Deck i en array list som inneholder alle typer kort av
      riktig antall og presentere disse i terminalen.
      - Akseptansekriterier:
      Gitt at spilleren får utdelt kort
      så skal:
      Kortene bli vist i terminalen


8. Velge 5 kort:
    - Brukerhistorie:
      Som spiller
      vil jeg kunne velge kort,
      slik at jeg har 5 kort å spille med.
    - Løsningsbeskrivelse:
      Når kortene er delt ut skal spiller velge med enten taster eller klikk fra mus og da blir de lagt
      til i "hånden"
    - Aksepteansekriterier:
      Gitt at spiller velger 5 kort,
      så skal:
        - Riktige kortene bli valgt
        - Kortene bli lagt til i "hånden" til spiller

9. Bevege robot ut fra valgte kort
   Brukerhistorie:
- Som spiller vil jeg at roboten min skal bevege seg i rekkefølge ut fra valgte kort.
  Løsningsbeskrivelse:
- Knytte spillkortene sine bevegelses verdier til bevegelse av roboten i koden.
  Akseptansekriterier:
- Gitt at spilleren har et kort med en spesifikk bevegelse, så skal:
  i. Roboten bevege seg med bevegelsen kortet beskriver.
- Gitt at spilleren har flere kort, så skal:

###Bugs:
- Spillere kan bevege seg over hull/flagg uten å avslutte spillet midt i en runde hvis spilleren beveger seg 2 eller 3 felt fremover på en turn.
- Applikasjonsvinduet «fryser» mens den andre spilleren velger kort. Ikke noe problem egentlig. 
- Hvis en trykker på et tall på tastaturet høyere enn det er tilgjengelige kort krasjer programmet. For eksempel, det er 8 kort å velge mellom og brukeren trykker på 9.

###Endring siden siste innlevering:
- Vi har fullført resten av MVP kravene; spille multiplayer, dele ut kort, 
  la spillerne velge 5 kort og å bevege robotene ut fra de valgte kortene.



##Deloppgave 3 Kode
- Se step-by-step guide for prosjektbygging, tester og hvordan programmet skal kjøres finner du i README.md


- Klassediagram


##Meetingminutes

### Mandag 15.02.2021
### Deltakere: Daan, Eivind, Sigurd, Malte
### Sprint-planlegging møte på Discord 12-13
- Fordeling av arbeidsoppgaver:
    - Skrive brukerhistorier for MVP-krav 6-9.
    - Begynner å tenke på løsning for MVP-krav 6: flerspiller.
    - Enighet om mindre arbeidsmengde denne uken grunnet andre prosjekter/fag.
    
### Onsdag 17.02.2021
### Deltakere: Daan, Eivind, Sigurd, Malte 
### Discord Møte - oppfølging av utdelte arbeidsopppgaver 12-12:15
- Konklusjon:
    - Alle brukerhistorier har blitt skrevet ferdig, med unntak av løsningsforslag for
      brukerhistorie 6 grunnet usikkerhet rundt flerspiller implementasjon.
- Gjenstående:
    - Brukerhistorie 6 løsningsforslag.
    - Begynne på implementasjon av brukerhistorie 6.
    
### Discord gruppetime fellesarbeid - med tilgang til TA. 12:15-14
- Konklusjon:
    - - Begynt med implementasjon av MVP-krav 6, spille fra flere maskiner.
    - Ferdigstilt alle brukerhistorier.
    - Fungerende MVP-krav 6 spille fra flere maskiner, men trenger finpussing/refaktorering
    
### Fredag 19.02.2021
### Deltakere: Daan, Eivind, Sigurd, Malte
### Discord møte - Sprint review og retrospektiv
-Scrum review konklusjon:
    - Fullførte oppsatte arbeidsoppgaver.
    - Spille fra flere maskiner trenger fortsatt forbedringer og implementasjon av resterende MVP-krav.
- Scrum review retrospektiv konklusjon:
    - Passe mengde arbeidsoppgaver.
    - Bra kommunikasjon og oppfølging.
    - Større arbeidsmengde kan bli satt opp for neste sprint grunnet mer tid.
    
### Mandag 22.02.2021
### Deltakere: Eivind, Sigurd, Malte(Daan manglet grunnet annet obligatorisk oppmøte)
### Discord møte - Sprint-planlegging 12-13
- Sprint planning: Tar sikte på å ferdigstille MVP-krav 7-8 i løpet av sprinten og beggynne på tekstbaserte oppgaver.
- Fordeling av arbeidsoppgaver:
    - MVP-krav 7 - dele ut kort.
    - MVP-krev 8 - velge 5 kort.
    - Tilhørende tester for krav.
    - Skriving av .md- fil.

### Onsdag 24.02.2021
### Deltakere: Daan, Eivind, Sigurd, Malte
### Discord møte - Oppfølging av utdelte arbeidsoppgaver 12-12:15
- Konklusjon:
    - MVP-krav 7 nær ferdigstilling.
    - Deler av md.- fil skrevet.
    - Test for MVP-krav 7 ferdigstilt.
- Gjenstående:
    - MVP-krav 8 må gjøres etter 7.
    - Videre arbeid med .md- fil.

### Discord gruppetime fellesarbeid - med tilgang til TA 12:15-14
### Deltakere: Daan, Eivind, Sigurd, Malte
- Konklusjon:
    - MVP-krav 7 ferdigstilt og passerer tester.
    - Oppdatering av .md- fil.
    - Begynt med MVP-krav 8.

### Fredag 26.02.2021
### Deltakere: Daan, Eivind, Sigurd, Malte
### Discord møte - Sprint review og retrospektiv
- Sprint review konklusjon:
    - MVP-krav 7 ferdigstilt med tilhørende tester.
    - MVP-krav 8 nært ferdigstilling fremdeles noen bugs.
    - Manuell test for MVP-krav 8 ferdigstilt.
    - Kommet godt i gang med .md- fil.
-Sprint retrospektiv konklusjon:
    - Tilnærmet alle arbeidsoppgaver fullført.
    - God kommunkiasjon og oppfølging.
    - Trenger bedre fordeling og beskrivelse av commits.

### Mandag 01.03.2021
### Deltakere: Daan, Eivind, Sigurd, Malte
### Discord møte - Sprint-planlegging 12-13
- Sprint planlegging:
    - Fullføring av obligatorisk innlevering 2.
    - Ferdigstilling av MVP-krav 8 og 9.
    - Resterende tester for MVP-krav.
    - Ferdigstilling av .md- fil.
- Arbeidsfordeling:
    - MVP-krav 8 ()
    - MVP-krav 9 ()
    - Tester ()
    - .md- fil ()

### Onsdag 03.03.2021
### Deltakere: Daan, Eivind, Sigurd, Malte
### Discord møte - oppfølging av arbeid.
- Konklusjon:
    - Ferdig med MVP-krav 8.
    - Ferdig med tester for MVP-krav 8.
    - .md- fil oppdatert.
- Gjenstående:
    - MVP-krav 9.
    - Fler tester der det trengs.
    - Ferdigstilling av .md- fil.

### Discord gruppetime fellesarbeid - med tilgang til TA 12:15-14
### Deltakere: Daan, Eivind, Sigurd, Malte
- Konklusjon:
    - MVP-krav 9 nær ferdigstilling.
    - Tester ferdigstilt. 
    - .md- fil nær ferdig, mangler for kommende fredagsmøte.

### Fredag 05.03.2021
### Deltakere: Daan, Eivind, Sigurd, Malte















