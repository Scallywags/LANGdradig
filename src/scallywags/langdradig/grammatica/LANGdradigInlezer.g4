lexer grammar LANGdradigInlezer;

ALS				: 	A L S				;
DAN				:	D A N				;
ANDERS			:	A N D E R S			;
VOOR			:	V O O R				;
ZOLANG			:	Z O L A N G			;

GEHEELGETAL		:	G E H E E L SPATIE G E T A L 		;
WAARHEID		:	W A A R H E I D						;
REEKS			:	R E E K S							;

KLOPT			:	K L O P T							;
KLOPTNIET		:	K L O P T SPATIE N I E T			;
WAAR			:	W A A R								;
ONWAAR			:	O N W A A R							;

BESTEEDUIT		:	B E S T E E D SPATIE U I T			;


PUNT			: '.';
KOMMA			: ',';

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



WITRUIMTE		: 	[ /t/r/n]	-> skip	;
