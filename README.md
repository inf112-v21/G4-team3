# Step by step guide - starte programmet



### 1. Pulle programmet fra github til din IDE.
   
   Til å begynne med må programmet pulles fra github til Java IDE’en som du bruker. 
   IDE’en som brukes i denne guiden er IntelliJ.  IntelliJ kan lastes ned her: https://www.jetbrains.com/idea/
   For å pulle prosjektet fra github må du gå til github repositoriet og klikke på den grønne «Code» knappen 
   for å få en HTTPS lenke.
   ![img_7.png](assets/images/img_7.png)
   Deretter, går du til din IDE og åpner et nytt prosjekt fra «version controll». 
   I intelliJ gjøres dette ved å trykke på «File» -> «New» -> «Project from Version Control». 
   Det vil åpnes et vindu hvor du limer inn HTTPS lenken i URL feltet. 
   Husk å endre på navnet hvis du skal pulle flere versjoner av prosjektet.

![img_9.png](assets/images/img_9.png)

### 2. Kjøre programmet fra IDE’en:
   
   Applikasjonen kjøres ved å høyreklikke på main funksjonen under src/main/java/inf112.skeleton.app i prosjektet ditt og å trykke på «run» ved den grønne pilen.

![img_10.png](assets/images/img_10.png)

### 3. Bruke applikasjonen
   
   For å spille multiplayer trengs to versjoner av prosjektet fra github for å kjøre applikasjonen. 
   For øyeblikket støttes bare multiplayer over lokalt nettverk, 
   derfor for å kjøre programmet må du pulle to prosjekt versjoner på den samme datamaskinen 
   eller pulle prosjektet til en annen datamaskin på samme nettverk.
   Når du har to versjoner av prosjektet oppe, enten på samme datamaskin eller på to ulike datamaskiner, 
   kan begge Main funksjonene kjøres som vist i punkt 2. 


### 4. Ulike spill typer
   Det kan velges mellom fem ulike spilltyper når applikasjonen starter:
   
- "Play as server":
        Spill sammen på to datamaskiner eller på to instanser av IDE’en på en datamaskin. Må starte opp serveren før klienten.
  
  
- "Play as server" med debug:
        Likt som uten debug, men lar deg velge hvilke kort du vil bruke.
  

- "Play as client":
Spill sammen på to datamaskiner eller på to instanser av IDE’en på en datamaskin. Klienten må vente med å starte før serveren er satt opp.
For å spille på en datamaskin må 127.0.0.1 brukes som IP adresse.
For å spille på to maskiner må IP adresse til serveren skrives inn. Du kan finne din IP adresse her: https://www.med.unc.edu/it/guide/operating-systems/how-do-i-find-the-host-name-ip-address-or-physical-address-of-my-machine/.


- "Play as client" med debug:
Likt som uten debug, men lar deg velge hvilke kort du vil bruke.
  

--- "Test game": TA'ene sin favoritt. Starter spillet opp som enkelt spiller, brukt til testing av spill funksjoner.

-  Test game -> Single-step:
Bruk piltastene eller kortene på skjermen til å styre roboten ett steg av gangen.

-  Test game -> Round-based:
Beveg roboten ved bruk av runde systemet. Når fem kort er valgt beveger roboten på seg.

   
##Automatiske tester utførelse
- høgre klikk på den klassen i src/test/java/inf112.skeleton.app du ønsker å kjøre og klikk kjør. 
  dem som gjek gjenom og får grønn "kjek-mark"
  og er godkjent
  
##Manuelle tester utførelse
### Manuell test for at fem kort blir valgt.
- Hvordan testen utføres:
   - Kjør main så skriv 3 i terminalen for test mode client eller server "1/2" etter det skriv "true" for debug mode, etter det kan man se kortene i terminalen og velge.
   - Velg 5 kort fra de 9 som blir vist i terminal gjennom nummer taster på tastatur(1-9) der de
      valgte blir fjernet for hvert valg

	- Kriterier for at testen blir godkjent:
		- Velge fem kort.
		- De fem valgte kortene vises i spillet.

### Manuell test for winCondition.
-Hvordan testen utføres:
   - Kjør main så velg enten client eller server "1/2" etter det skriv "true" for debug mode, etter det kan man se kortene i terminalen og velge.
   - Etter det velg kort og naviger til et flagg. Da skal spillet fryse og en tekst skal si hvem som vant.
   
- Kriterer for at testen blir godkjent:
   - Når en wincondition blir triggeret fryser spillet og det står hvem som har vunnet

### Manuell test for nettverk.
- Hvordan testen utføres:
   - Kjør main så velg enten client eller server "1/2" etter det skriv "true" for debug mode, sjekk deretter at begge instansene av spillet får valgt kort og gjennomført
      handlinger og den andre mottar/får sett handlingene gjort av den andre spilleren.

- Kriterier for at testen blir godkjent:
    - De to instansene av spillet skal kommunisere med hverandre og får sett hverandres handlinger på spillbrett.

### Manuell test for loseCondition.
- Hvordan testen utføres:
    - Kjør main så velg enten client eller server "1/2" etter det skriv "true" for debug mode, etter det kan man se kortene i terminalen og velge.
    - Etter det velg kort og naviger utenfor kartet eller til et hull. Da skal spillet fryse og en tekst skal si hvem som tapte.
- Kriterer for at testen blir godkjent:
    - Når en losecondition blir triggeret fryser spillet og det står hvem som har tapt
    
### Manuell test for Laser
- Hvordan testen utføres:
   - Kjør main så velg enten client eller server "1/2" etter det skriv "true" for debug mode. 
   - Naviger robot frem til en laser og så inn i laseren enten ved bruk av kort eller piltaster. Da skal det vises at at HP blir redusert med -1
- Kriterer for at testen skal godkjennes: 
    - Når robot blir beveget gjennom en laser skal HP bli redusert med -1. 
    
### Manuell test for Wall 
- Hvordan testen utføres: 
    - Kjør main så velg enten client eller server "1/2" etter det skriv "true" for debug mode.
    - Naviger robot frem til en wall ved bruk av enten kort eller piltaster, etter det prøv å gjennomføre en bevegelse som vil bevege robot gjennom en wall.
    Då skal robot ikke bevege seg fra orginal posisjon foran wall.
- Kriterier for at testen skal godkjennes:
    Når en bevegelses-input styrer gjennom en wall skal inputen ikke gjennomføres og roboten deremed ikke beveges.
  
### Manuell test for Belt 
- Hvordan testen utføres: 
    - Kjør main så velg enten client eller server "1/2" etter det skriv "true" for debug mode.
    - Naviger robot frem til starten av et belt ved bruk av enten kort eller piltaster, etter det beveg robot på starten av belt indikert av en pil på brettet. 
    Då skal robot beveges helt fra starten av belt frem til slutten av belt.
- Kriterier for at testen skal godkjennes:
    Når robot beveges opp på starten av et belt skal robot beveges frem til slutten av belt. 
-