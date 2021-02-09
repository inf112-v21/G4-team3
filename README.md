# INF112 Maven template 
Simple skeleton with libgdx. 

## Brukerhistorier
1. Vise et spillebrett:
   
2. Vise brikke på spillebrett:
   
3. Flytte brikke(vha taster):
   
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
    2. spillet blir vunnet av den som tar flagget.
   
## Known bugs
