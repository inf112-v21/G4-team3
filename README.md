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
For å spille på to maskiner må IP adresse til serveren skrives inn. Du kan finne din IP adresse her:https://vitux.com/how-to-find-your-ip-address-in-linux/
  https://www.avast.com/c-how-to-find-ip-address?v=b


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
   - Kjør main så velg "Test game" og deretter "Round-based", etter det kan man se kortene på skjermen og velge.
   - Velg 5 kort fra de som blir vist i terminal gjennom nummer taster på tastatur(1-7) 

	- Kriterier for at testen blir godkjent:
		- Velge fem kort.
		- Roboten utfører de fem valgte kortene i rekkefølge.

### Manuell test for winCondition.
-Hvordan testen utføres:
   - Kjør main så velg "Test game" og deretter "Single-step", etter det kan man se kortene på skjermen og velge.
   - Etter det velg kort og naviger til et flagg1, flagg2 og flagg3 i den rekkefølgen. Da skal spillet fryse og en tekst skal si at du vant.
   
- Kriterer for at testen blir godkjent:
   - Når en wincondition blir triggeret fryser spillet og det står hvem som har vunnet

### Manuell test for nettverk.
- Hvordan testen utføres:
   - Kjør main så velg enten client eller server, sjekk deretter at begge instansene av spillet får valgt kort og gjennomført
      handlinger og den andre mottar/får sett handlingene gjort av den andre spilleren. Kan gjøres med eller uten debugmode.

- Kriterier for at testen blir godkjent:
    - De to instansene av spillet skal kommunisere med hverandre og får sett hverandres handlinger på spillbrett.

### Manuell test for loseCondition.
- Hvordan testen utføres:
    - Kjør main så velg "Test game" og deretter "Single-step", etter det kan man se kortene på skjermen og velge.
    - Etter det naviger utenfor kartet eller til et hull 3 ganger. Da skal spillet fryse og en tekst skal si du tapte.
- Kriterer for at testen blir godkjent:
    - Når en losecondition blir triggeret fryser spillet og det står hvem som har tapt
    
### Manuell test for Laser
- Hvordan testen utføres:
   - Kjør main så velg "Test game" og deretter "Single-step", etter det kan man se kortene på skjermen og velge.
   - Naviger robot frem til en laser og så inn i laseren enten ved bruk av kort eller piltaster. Da skal det vises at at HP blir redusert med -1.
- Kriterer for at testen skal godkjennes: 
    - Når robot blir beveget gjennom en laser skal HP bli redusert med -1. 
    
### Manuell test for Belt 
- Hvordan testen utføres: 
    - Kjør main så velg "Test game" og deretter "Single-step", etter det kan man se kortene på skjermen og velge.
    - Naviger robot frem til starten av et transportbånd ved bruk av enten kort eller piltaster, etter det beveg robot på starten av transportbåndet indikert av en pil på brettet. 
    Da skal roboten beveges fra transportbånd ruten til ruten transportbåndet peker på.
- Kriterier for at testen skal godkjennes:
     - Når robot beveges på et trasporbånd skal roboten flyttes til ruten transporbåndet peker på. 

 ### Manuell test for Wall 
- Hvordan testen utføres:
    - Kjør main så velg "Test game" og deretter "Single-step", etter det kan man se kortene på skjermen og velge.
    - Naviger robot frem til en vegg ved bruk av enten kort eller piltaster,
      etter det prøv å gjennomføre en beveglse som vil bevege robot gjennom veggen, da skal roboten ikke bevege seg fra sin posisjon.
      
- Kriterier for at testen skal godkjennes:
    - Robot skal ikke bevege seg om en bevegelses-input går gjennom en vegg.
 
### Manuell test for Power Down  
- Hvordan testen utføres:
    - Kjør main så velg "Test game" og deretter "Single-step", etter det kan man se kortene på skjermen og velge.
    - Naviger robot frem til en laser ved bruk av enten kort eller piltaster, etter det beveg robot inn i laser for å miste hp.
      Deretter trykk på Power Down kanppen. Power Down skal regenerere liv men på bekostning av beveglsene du kunne utført den runden.
- Kriterier for at testen skal godkjennes:
    - Når Power Down aktiveres skal hp regenereres og skippe turen til robot. 

### Manuell test for Collision
- Hvordan testen utføres:
    - Kjør main så velg en som "server" og en som "client" og deretter "debug mode", etter det kan man se kortene på skjermen og velge.
    - Naviger en robot slik at den beveger seg gjennom en posisjoion til en annen robot ved bruk av enten kort eller piltaster for å velge eksakte kort.
      Da skal roboten som beveger seg gjennom den andre skubbe den andre roboten en rute i retning av beveglsen. 
- Kriterier for at testen skal godkjennes:
    - Når en robot beveger seg over en posisjoin til en annen skal den bli skubbet i retningen av beveglsen.