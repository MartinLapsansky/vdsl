# vdsl

# Doménovo-špecifický jazyk pre Escape Room

## Abstraktná syntax

Model jazyka vyjadrený vo forme [diagramu tried](escape_room.png). 
Koreňový pojem [EscapeRoom](escape-room/src/Interfaces/EscapeRoom.java) je vyznačený červenou farbou.

Abstraktnú syntax zapísaná v EBNF:
```
    WelcomeMessage -> String f
    EscapeMessage -> String
    Room -> String 
    Description -> String 
    TimeLimit -> int
    Task -> String 
    FinalTask -> String
    Hint -> String
    Solution -> String | int
    TaskType -> LogicPuzzle | VoicePuzzle | CodePuzzle | RiddlePuzzle
```

**Definovanie hry (sentence definition):** Escape room pre OpenLab je definovaný miestnosťou (Room) pozostávajúcou z rozličných typov úloh (LOGIC_PUZZLE,VOICE_PUZZLE,CODE_PUZZLE,RIDDLE_PUZZLE). Escape Room sa skladá z názvu (name), uvitacej spravy (welcomeMessage) a záverečnej správy (escapeMessage). Následnosť úloh je definovaná od počiatočnej úlohy po konečnú úlohu. Ukončenie hry definuje hodnota časovača (timeLimit) každej miestnosti a úspešné vyriešenie všetkých úloh.
Každá úloha (Task) obsahuje práve jedno riešenie (Solution), ktoré obsahuje práve jednu (correctAnswer) a niekoľko nápovied (Hint). Po úspešnom vyriešení úlohy sa hráčovi zobrazí farba (successColor) ktorá slúži ako základ pre vyriešenie finálnej úlohy (finalTask), v ktorej hráč musí zadať v správnej sekvencii tieto farby (successColors). Vo výsledku sa užívateľovi zobrazí výsledne skóre (roomScore), ktoré vznikne na základe počtu použitých hintov, vyriešených úloh a pokusov o správnu odpoveď za behu programu. 

**Hranie hry (sentence execution):** Cieľom hráčov je vyriešiť všetky úlohy hry pred vypršaním časového limitu. Riešením jednej úlohy sa odomkne ďalšia a zároveň získa nápoveda k finálnej úlohe, ktorej vyriešením sa hra úspešne končí.
Stav hry je definovaný poradim (indexom) riešenej úlohy.

### Validácia

Validácia je súčasťou [EscapeRoomBuild](escape-room/src/builder/EscapeRoomBuild.java) - metóda `validate()` zahŕňa overenie:
- null a prázdnych reťazcov
- každá Room má kladný časový limit
- ID úloh (Task) sú jedinečné v rámci Room
- výskyt hintov pri každom tasku
- výskyt finalTask a Task v Room

## Konkrétna syntax

### Interný doménovo-špecifický jazyk

Konkrétna syntax jazyka je implementovaná v hostiteľskom jazyku Java prostredníctvom vzoru reťazenia metód (angl. method chaining)", trieda [EscapeRoomBuild](escape-room/src/builder/EscapeRoomBuild.java).

Balík: [builder](escape-room/src/builder)

Ukážkové vety z jazyka:
- Hra [escapeRoom](escape-room/src/Main.java)

## Sémantika

Sémantika je definovaná pomocou:
- interptetátora - trieda [GameInterpreter](escape-room-spring/src/main/java/org/example/escaperoomspring/semantics/GameInterpreter.java)

### Externý doménovo-špecifický jazyk

Konkrétna sytax je definovaná prostredníctvom gramatiky [EscapeRoom.g4](escape-room-spring/Escaperoom.g4) pre nástroj ANTLR 4.
Strom odvodenia je spracovaný podľa vzoru Listener, trieda [EscaperoomParserListener](escape-room-spring/src/main/java/org/example/escaperoomspring/parser/EscaperoomParserListener.java).

Ukážkové vety z jazyka:
- Hra [escapeRoom](room.txt)

## Sémantika

Sémantika je definovaná pomocou:
- interptetátora - trieda [GameInterpreter](escape-room-spring/src/main/java/org/example/escaperoomspring/semantics/GameInterpreter.java)


