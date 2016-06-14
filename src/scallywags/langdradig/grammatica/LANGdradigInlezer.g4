lexer grammar LANGdradigInlezer;

WORDT			:	W O R D T | '='		;
ALS				: 	A L S				;
DAN				:	D A N				;
ANDERS			:	A N D E R S			;
VOOR			:	V O O R				;
ZOLANG			:	Z O L A N G			;

PLUS			:	P L U S					| '+'					;
MIN				:	M I N 					| '-'					;
KEER			:	K E E R					| '*'					;
GEDEELDDOOR		:	G E D E E L D WITRUIMTE D O O R 		| '/'	;
TOTDEMACHT		:	T O T WITRUIMTE D E WITRUIMTE M A C H T	| '^'	;
MODULUS			:	M O D U L U S 			| '%'					;
NIET			: 	N I E T 				| '!'					;
EN				:	E N						| '&' '&'				;
OF				:	O F						| '|' '|'				;

GELIJKAAN		:	(GELIJK WITRUIMTE IS | IS WITRUIMTE GELIJK) WITRUIMTE AAN 					    						| '=' '='	;
ONGELIJKAAN		:	(ONGELIJK WITRUIMTE IS | IS WITRUIMTE ONGELIJK) WITRUIMTE AAN 			    							| '!' '='	;
KLEINERDAN		:	(IS WITRUIMTE KLEINER | KLEINER WITRUIMTE IS) WITRUIMTE DAN 											| '<'		;
GROTERDAN		:	(GROTER WITRUIMTE IS | IS WITRUIMTE GROTER) WITRUIMTE DAN												| '>'		;
KLEINEROFGELIJK	:	(IS WITRUIMTE KLEINER WITRUIMTE DAN WITRUIMTE OF WITRUIMTE (IS WITRUIMTE)? GELIJK WITRUIMTE AAN
					| KLEINER WITRUIMTE IS WITRUIMTE DAN WITRUIMTE OF WITRUIMTE GELIJK WITRUIMTE IS WITRUIMTE AAN)	
				| '<' '='	;
GROTEROFGELIJK	:	(IS WITRUIMTE GROTER WITRUIMTE DAN WITRUIMTE OF WITRUIMTE (IS WITRUIMTE)? GELIJK WITRUIMTE AAN 
					| GROTER WITRUIMTE IS WITRUIMTE DAN WITRUIMTE OF WITRUIMTE GELIJK WITRUIMTE IS WITRUIMTE AAN
) 				| '>' '='	;
LIGTTUSSEN		:	LIGT WITRUIMTE TUSSEN 								    							;
LIGTBUITEN		:	LIGT WITRUIMTE BUITEN																;

GEHEELGETAL		:	GEHEEL WITRUIMTE GETAL		;
WAARHEID		:	W A A R H E I D				;
REEKS			:	R E E K S					;
TEKST			:	T E K S T					;

KLOPT			:	K L O P T							;
NIETKLOPT		:	NIET WITRUIMTE KLOPT				;
WAAR			:	W A A R								;
ONWAAR			:	O N WAAR							;

DOE				:	D O E								;
KLAAR			:	K L A A R							;
BESTEEDUIT		:	B E S T E E D WITRUIMTE U I T		;
KRITIEK			:	K R I T I E K						;

PUNT			: '.';
KOMMA			: ',';
LH				: '(';
RH				: ')';
IS				: I S;
EEN				: E E N;

LIGT			:   L I G T           ;
TUSSEN  		:   T U S S E N		;
BUITEN  		:   B U I T E N		;

NUMBER			: DIGIT+			;
IDENTIFIER		: LETTER ALPHANUM*	;

fragment DIGIT		: [0-9]				;
fragment LETTER		: [a-zA-Z]			;
fragment ALPHANUM	: DIGIT	|	LETTER	;

fragment GELIJK		: G E L I J K		;
fragment ONGELIJK	: O N GELIJK | N I E T WITRUIMTE GELIJK		;
fragment KLEINER	: K L E I N E R		;
fragment GROTER		: G R O T E R		;
fragment AAN		: A A N				;

fragment GEHEEL : G E H E E L;
fragment GETAL	: G E T A L	;
fragment SPATIE	: ' ';
fragment TAB	: '\t';
fragment RETURN	: '\r';
fragment NEWLINE: '\n';
fragment A		: [Aa];
fragment B		: [Bb];
fragment C		: [Cc];
fragment D		: [Dd];
fragment E		: [Ee];
fragment F		: [Ff];
fragment G		: [Gg];
fragment H		: [Hh];
fragment I		: [Ii];
fragment J		: [Jj];
fragment K		: [Kk];
fragment L		: [Ll];
fragment M		: [Mm];
fragment N		: [Nn];
fragment O		: [Oo];
fragment P		: [Pp];
fragment Q		: [Qq];
fragment R		: [Rr];
fragment S		: [Ss];
fragment T		: [Tt];
fragment U		: [Uu];
fragment V		: [Vv];
fragment W		: [Ww];
fragment X		: [Xx];
fragment Y		: [Yy];
fragment Z		: [Zz];

WITRUIMTE		: 	[ \t\r\n]+	-> skip	;