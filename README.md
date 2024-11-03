# vdsl

# Doménovo-špecifický jazyk pre textové adventúry

## Abstraktná syntax

Model jazyka vyjadrený vo forme [diagramu tried](escape-room.svg). 
Koreňový pojem [Room](src/main/java/sk/tuke/dsl/gamelang/model/Game.java) je vyznačený červenou farbou.

Abstraktnú syntax zapísaná v EBNF:
```
    Room -> Title Intro Riddle Riddle Riddle+ Puzzle* Visualisation+ TerminationCondition;
    Title -> string;
    Intro -> string;
    Begin -> string;
    Unlocks -> string;
    Riddle -> Name Question Solution Hint Unlocks Clue Duration Lights+;
    Name -> string;
    Question -> string;
    Solution -> string;
    Hint -> string;
    Clue -> string;
    Duration -> int;
    Puzzle -> Name PuzzleIntro Solution Question Unlocks Clue Duration Lights+;
    PuzzleIntro -> string;
    Visualisation -> Name Descr Color Duration;
    Descr -> string;
    TerminationCondition -> Value Visualisation;
    Value -> int;
    Lights ->  Mode RowNumber Color;
    Mode -> string;
    RowNumber -> string;
    Color -> string;
```

**Definovanie hry (sentence definition):** Hra (Game) je definovaná miestami (Place) medzi ktorými sú prechody. V mieste sa môže nachádzať viacero predmetov (Item). Spájanie 2 predmetov s cieľom vytvorenia ďalšieho predmetu je definované receptom (Recipe). 
Pre hru je definovaný finálny predmet, miesto štartu, úvodný a finálny text a texty opisujúce miesta a predmety.

**Hranie hry (sentence execution):** Cieľom hráča je vytvoriť finálny predmet prostredníctvom prechádzanie medzi miestami, zbierania vecí do batohu a ich vzájomného spájania.
Stav hrania hry je definovaný obsahom batohu a aktuálnym miestom.

### Validácia

Validácia je súčasťou tried modelu jazyka - metóda `validate()` zahŕňa overenie:
- `null` a prázdnych reťazcov
- povinnosť minimálneho počtu pojmov
- dostupnosť všetkých miest prostredníctvom východov
- dohrateľnosť hry - získanie finálneho predmetu

## Konkrétna syntax

### Interný doménovo-špecifický jazyk

Konkrétna syntax jazyka je implementovaná v hostiteľskom jazyku Java prostredníctvom vzoru "postupnosť funkcií (angl. function sequence)", trieda [FunctionSequenceBuilder](src/main/java/sk/tuke/dsl/gamelang/builder/FunctionSequenceBuilder.java).

Balík: [sk.tuke.dsl.gamelang.builder](src/main/java/sk/tuke/dsl/gamelang/builder)

Ukážkové vety z jazyka:
- Hra [Pečieme praženicu](src/main/java/sk/tuke/dsl/gamelang/main/PeciemePrazenicuGame.java)
- Hra [Vesmírny ženích](src/main/java/sk/tuke/dsl/gamelang/main/VesmirnyZenichGame.java)

### Externý doménovo-špecifický jazyk

Konkrétna sytax je definovaná prostredníctvom gramatiky [Game.g4](src/main/antlr4/sk/tuke/dsl/gamelang/parser/Game.g4) pre nástroj ANTLR 4.
Strom odvodenia je spracovaný podľa vzoru Listener, trieda [GameParserListener](src/main/java/sk/tuke/dsl/gamelang/parser/GameParserListener.java).

Balík: [sk.tuke.dsl.gamelang.parser](src/main/java/sk/tuke/dsl/gamelang/parser)

Ukážkové vety z jazyka:
- Hra [Pečieme praženicu](game1.game)
- Hra [Vesmírny ženích](game2.game)

## Sémantika

Sémantika je definovaná pomocou:
- interptetátora - trieda [GameInterpreter](src/main/java/sk/tuke/dsl/gamelang/semantics/GameInterpreter.java)
- generátora do jazyka Java prostredníctvom šablónovacieho systému Velocity - trieda [GameGeneratorVelocity](src/main/java/sk/tuke/dsl/gamelang/semantics/GameGeneratorVelocity.java), šablóna [Game.java.vm](src/main/resources/templates/Game.java.vm)  

Balík: [sk.tuke.dsl.gamelang.semantics](src/main/java/sk/tuke/dsl/gamelang/semantics)

