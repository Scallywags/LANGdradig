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
GEDEELDDOOR		:	G E D E E L D  D O O R 	| '/'					;
TOTDEMACHT		:	T O T  D E  M A C H T	| '^'					;
MODULUS			:	M O D U L U S 			| '%'					;
NIET			: 	N I E T 				| '!'					;
EN				:	E N						| '&' '&'					;
OF				:	O F						| '|' '|'					;

GELIJKAAN		:	(GELIJK IS | IS GELIJK) AAN 											| '=' '='	;
ONGELIJKAAN		:	(ONGELIJK IS | IS ONGELIJK) AAN 										| '!' '='	;
KLEINERDAN		:	(IS KLEINER | KLEINER IS) DAN 											| '<'		;
GROTERDAN		:	(GROTER IS | IS GROTER) DAN												| '>'		;
KLEINEROFGELIJK	:	(IS KLEINER DAN OF IS? GELIJK AAN | KLEINER IS DAN OF GELIJK IS AAN)	| '<' '='	;
GROTEROFGELIJK	:	(IS GROTER DAN OF IS? GELIJK AAN | GROTER IS DAN OF GELIJK IS AAN) 		| '>' '='	;
LIGTTUSSEN		:	LIGT TUSSEN 															;
LIGTBUITEN		:	LIGT BUITEN																;

GEHEELGETAL		:	G E H E E L GETAL			;
WAARHEID		:	W A A R H E I D				;
REEKS			:	R E E K S					;
TEKST			:	T E K S T					;

KLOPT			:	K L O P T							;
NIETKLOPT		:	NIET KLOPT							;
WAAR			:	W A A R								;
ONWAAR			:	O N WAAR							;

DOE				:	D O E								;
KLAAR			:	K L A A R							;
BESTEEDUIT		:	B E S T E E D  U I T				;
KRITIEK			:	K R I T I E K						;

PUNT			: '.';
KOMMA			: ',';
LH				: '(';
RH				: ')';
IS				: I S;
EEN				: E E N;
LIGT			: L I G T;

NUMBER			: DIGIT+			;
IDENTIFIER		: LETTER ALPHANUM*	;

fragment DIGIT		: [0-9]				;
fragment LETTER		: [a-zA-Z]			;
fragment ALPHANUM	: DIGIT	|	LETTER	;

fragment GELIJK		: G E L I J K		;
fragment ONGELIJK	: O N GELIJK		;
fragment KLEINER	: K L E I N E R		;
fragment GROTER		: G R O T E R		;
fragment AAN		: A A N				;
fragment TUSSEN		: T U S S E N		;
fragment BUITEN		: B U I T E N		;

fragment GETAL	: G E T A L	;
fragment SPATIE	: ' ';
fragment TAB	: '/t';
fragment RETURN	: '/r';
fragment NEWLINE: '/n';
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