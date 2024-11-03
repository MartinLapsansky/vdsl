# vdsl

# Doménovo-špecifický jazyk pre textové adventúry

## Abstraktná syntax

Model jazyka vyjadrený vo forme [diagramu tried](escape-room.svg). 
Koreňový pojem [Room](src/main/java/sk/tuke/escaperoomlang/model/Room.java) je vyznačený červenou farbou.

Abstraktnú syntax zapísaná v EBNF:
```
    Room -> Title Intro Riddle Riddle Riddle+ Puzzle* Visualisation+ TerminationCondition;
    Title -> string;
    Intro -> string;
    Begin -> string;
    Unlocks -> string;
    Riddle -> Title Question Solution Hint Unlocks Clue Duration Lights+;
    Question -> string;
    Solution -> string;
    Hint -> string;
    Clue -> string;
    Duration -> int;
    Puzzle -> Titlen PuzzleIntro Solution Question Unlocks Clue Duration Lights+;
    PuzzleIntro -> string;
    Visualisation -> Title Message Lights Duration;
    Message -> string;
    TerminationCondition -> Value Visualisation;
    Value -> int;
    Lights ->  Mode RowNumber Color;
    Mode -> string;
    RowNumber -> string;
    Color -> string;
```

**Definovanie hry (sentence definition):** Escape room pre OpenLab je definovaný miestnosťou (Room) pozostávajúcou z dvoch rozličných typov úloh (Riddle/Puzzle) a opisuje ho krátky úvod do hry (Intro). Následnosť úloh je definovaná od počiatočnej úlohy (Begin), po konečnú úlohu pomocou odomknutia (Unlocks). Ukončenie hry definuje podmienka pre neúspešné ukončenie hry (TerminationCondition). Podmienku ukončenia hry opisuje počiatočná hodnota časovača (Value) a jej náseldkom je vizualizácia výsledku hry (Visualisation). 
Vizualizácia pozostáva zo svetiel (Lights), trvania vizualizácie (Duration) a správy pre hráča (Message).
Svetlá majú režim svietenia (Mode), farbu (Color) a číslo svetelného pásu, ktorý má byť rozsvietený (RowNumber).
Hra, úlohy a vizualizácie majú názvy (Title), úlohy majú v závislosti od typu nasledujúce prvky: nápovedu (Hint), otázku (Question), intro k aktivite (PuzzleIntro), riešenie (Solution) a všetky poskytujú nápovedu k finálnej úlohe (Clue);

**Hranie hry (sentence execution):** Cieľom hráčov je vyriešiť všetky úlohy hry pred naplnením podmienky pre neúspešné ukončenie hry. Riešením jednej úlohy sa odomkne ďalšia a zároveň získa nápoveda k finálnej úlohe, ktorej vyriešením sa hra úspešne končí.
Stav hry je definovaný poradím riešenej úlohy.

### Validácia

Validácia je súčasťou tried modelu jazyka - metóda `validate()` zahŕňa overenie:
- `null` a prázdnych reťazcov
- povinnosť minimálneho počtu pojmov
- dostupnosť všetkých taskov ich definíciou v správnej následnosti (NEMAME)
- dohrateľnosť hry - definícia práve jednej finálnej úlohy (NEMAME)

## Konkrétna syntax

### Interný doménovo-špecifický jazyk

Konkrétna syntax jazyka je implementovaná v hostiteľskom jazyku Java prostredníctvom vzoru "postupnosť funkcií (angl. function sequence)", trieda [FunctionSequenceBuilder](src/main/java/sk/tuke/dsl/gamelang/builder/FunctionSequenceBuilder.java).

Balík: [sk.tuke.dsl.gamelang.builder](src/main/java/sk/tuke/dsl/gamelang/builder)

Ukážkové vety z jazyka:
- Hra [Pečieme praženicu](src/main/java/sk/tuke/dsl/gamelang/main/PeciemePrazenicuGame.java)
- Hra [Vesmírny ženích](src/main/java/sk/tuke/dsl/gamelang/main/VesmirnyZenichGame.java)

### Externý doménovo-špecifický jazyk

Konkrétna sytax je definovaná prostredníctvom gramatiky [Room.g4](Room.g4) pre nástroj ANTLR 4.
Strom odvodenia je spracovaný podľa vzoru Listener, trieda [GameParserListener](src/main/java/sk/tuke/dsl/gamelang/parser/GameParserListener.java).

Balík: [sk.tuke.dsl.gamelang.parser](src/main/java/sk/tuke/dsl/gamelang/parser)

Ukážkové vety z jazyka:
- Miestnosť [Unlock (Your Time)](room1.txt)

## Sémantika

Sémantika je definovaná pomocou:
- interptetátora - trieda [GameInterpreter](src/main/java/sk/tuke/dsl/gamelang/semantics/GameInterpreter.java)
- generátora do jazyka Java prostredníctvom šablónovacieho systému Velocity - trieda [GameGeneratorVelocity](src/main/java/sk/tuke/dsl/gamelang/semantics/GameGeneratorVelocity.java), šablóna [Game.java.vm](src/main/resources/templates/Game.java.vm)  

Balík: [sk.tuke.dsl.gamelang.semantics](src/main/java/sk/tuke/dsl/gamelang/semantics)

