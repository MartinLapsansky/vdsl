grammar Escape_room;

room: 'room' title=STRING intro begin main_riddle riddle+ puzzle* visualisation+ termination_condition;

intro: 'intro' STRING;

begin: 'begin' STRING;

main_riddle: 'main' 'riddle' title=STRING question=STRING solution=STRING hint=STRING unlocks duration=INT;

unlocks: 'unlocks' STRING;

riddle: 'riddle' title=STRING question=STRING solution=STRING hint=STRING unlocks clue=STRING duration=INT lights+;

puzzle: 'puzzle' title=STRING puzzle_intro=STRING solution=STRING lightsarray? question=STRING unlocks clue=STRING duration:INT lights+;

visualisation: 'visualisation' title=STRING descr=STRING lights duration=INT;

termination_condition: 'if' 'duration' 'is' value=INT 'then' visualisation;

lights:  mode=STRING rownumber=INT color=STRING;
