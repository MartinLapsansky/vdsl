# vdsl

# Doménovo-špecifický jazyk pre textové adventúry

## Abstraktná syntax

Model jazyka vyjadrený vo forme [diagramu tried](escape-room.svg). 
Koreňový pojem [Room](src/main/java/sk/tuke/escaperoomlang/model/Room.java) je vyznačený červenou farbou.

Abstraktnú syntax zapísaná v EBNF:
```
    EscapeRoom -> Name String WelcomeMessage String EscapeMessage String Room+
    Room -> Name String Description String TimeLimit int Task+ FinalTask
    Task -> Index int Name String Description String TaskType Type Solution Solution
    TaskDetails String SuccessColor String Hint*
    
    FinalTask -> Id int Description String SuccessColors list
    Hint -> Description String
    Solution -> CorrectAnswer String | int
    TaskType -> LogicPuzzle | VoicePuzzle | CodePuzzle | RiddlePuzzle
    FinalScore -> Value int
```

**Definovanie hry (sentence definition):** Escape room pre OpenLab je definovaný miestnosťou (Room) pozostávajúcou z rozličných typov úloh (LOGIC_PUZZLE,VOICE_PUZZLE,CODE_PUZZLE,RIDDLE_PUZZLE). Escape Room sa skladá z názvu (name), uvitacej spravy (welcomeMessage) a záverečnej správy (escapeMessage). Následnosť úloh je definovaná od počiatočnej úlohy po konečnú úlohu. Ukončenie hry definuje hodnota časovača (timeLimit) každej miestnosti a úspešné vyriešenie všetkých úloh.
Každá úloha (Task) obsahuje práve jedno riešenie (Solution), ktoré obsahuje práve jednu (correctAnswer) a niekoľko nápovied (Hint). Po úspešnom vyriešení úlohy sa hráčovi zobrazí farba (successColor) ktorá slúži ako základ pre vyriešenie finálnej úlohy (finalTask), v ktorej hráč musí zadať v správnej sekvencii tieto farby (successColors). Vo výsledku sa užívateľovi zobrazí výsledne skóre (finalScore), ktoré vznikne na základe počtu použitých hintov, vyriešených úloh a pokusov o správnu odpoveď. 

**Hranie hry (sentence execution):** Cieľom hráčov je vyriešiť všetky úlohy hry pred vypršaním časového limitu. Riešením jednej úlohy sa odomkne ďalšia a zároveň získa nápoveda k finálnej úlohe, ktorej vyriešením sa hra úspešne končí.
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

