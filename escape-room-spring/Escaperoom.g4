grammar Escaperoom;

escaperoom: 'escapeRoom' welcomeMessage escapeMessage room+;

welcomeMessage: 'welcomeMessage' STRING;

escapeMessage: 'escapeMessage' STRING;

room: 'room' timeLimit=INT name=STRING description task+ finalTask?;

description: 'description' STRING;

finalTask : 'finalTask' successColors;

task: 'task' index=INT name=STRING description type hint solution taskDetails attempts=INT lightSequence successColor;

taskDetails: 'taskDetails' STRING;

successColors : STRING+;

type: 'LOGIC_PUZZLE' | 'VOICE_PUZZLE' | 'CODE_PUZZLE' | 'LIGHT_PUZZLE' | 'RIDDLE_PUZZLE';

hint: 'hint' STRING+;

solution: 'solution' correctAnswer=STRING;

lightSequence: 'lightSequence' STRING+;

successColor: 'successColor' STRING;

STRING: '"' (~["\r\n])* '"' ;
WS: [ \t\r\n]+ -> skip;
INT: [0-9]+ ;
