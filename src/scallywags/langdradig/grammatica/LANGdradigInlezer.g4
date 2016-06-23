lexer grammar LANGdradigInlezer;

// Operators
PLUS			:	P L U S					            | '+'		;
MIN				:	M I N 					            | '-'		;
KEER			:	K E E R					            | '*'		;
GEDEELDDOOR		:	GEDEELD WITRUIMTE DOOR              | '/'       ;
TOTDEMACHT      :   TOT WITRUIMTE DE WITRUIMTE MACHT    | '^'       ;
MODULUS			:	M O D U L U S 			            | '%'		;
NIET			: 	N I E T 				            | '!'		;

// Comparators
EN				:	E N			            			| '&' '&'	;
OF				:	O F					              	| '|' '|'	;

GELIJKAAN		:	(GELIJK WITRUIMTE IS | IS WITRUIMTE GELIJK) WITRUIMTE AAN
                |   '=' '='                                         ;
ONGELIJKAAN		:	(ONGELIJK WITRUIMTE IS | IS WITRUIMTE ONGELIJK) WITRUIMTE AAN
                |   '!' '='                                         ;
KLEINERDAN		:	(IS WITRUIMTE KLEINER | KLEINER WITRUIMTE IS) WITRUIMTE DAN
                |   '<'                                             ;
GROTERDAN		:	(GROTER WITRUIMTE IS | IS WITRUIMTE GROTER) WITRUIMTE DAN
                |   '>'		                                        ;
KLEINEROFGELIJK	:	(IS WITRUIMTE KLEINER WITRUIMTE (DAN WITRUIMTE)? OF WITRUIMTE (IS WITRUIMTE)? GELIJK WITRUIMTE AAN
				|   KLEINER WITRUIMTE (IS WITRUIMTE)? (DAN WITRUIMTE)? OF WITRUIMTE GELIJK WITRUIMTE (IS WITRUIMTE)? AAN)
				|   '<' '='                                         ;
GROTEROFGELIJK	:	(IS WITRUIMTE GROTER WITRUIMTE (DAN WITRUIMTE)? OF WITRUIMTE (IS WITRUIMTE)? GELIJK WITRUIMTE AAN
				|   GROTER WITRUIMTE (IS WITRUIMTE)? (DAN WITRUIMTE)? OF WITRUIMTE GELIJK WITRUIMTE (IS WITRUIMTE)? AAN)
				|   '>' '='                                         ;

// Assignment
WORDT			:	W O R D T               | '='		            ;

// "Als" block
ALS				: 	A L S				                            ;
DAN				:	D A N				                            ;
ANDERS			:	A N D E R S			                            ;

// "Zolang" block
VOOR			:	V O O R				                            ;
ZOLANG			:	Z O L A N G			                            ;

// Types
GETAL		    :   G E T A L                                       ;
STELLING		:	S T E L L I N G				                    ;
REEKS			:	R E E K S					                    ;
TEKST			:	T E K S T					                    ;

// Values for stelling
WAAR			:	W A A R								            ;
ONWAAR			:	O N WAAR							            ;

// Syntactic sugar
KLOPT			:	K L O P T							            ;

VERHOOG         :   V E R H O O G                                   ;
HOOG            :   H O O G                                         ;
VERLAAG         :   V E R L A A G                                   ;

LIGT			:   L I G T                                         ;
TUSSEN  		:   T U S S E N		                                ;
BINNEN          :   B I N N E N                                     ;
BUITEN  		:   B U I T E N		                                ;

// Statement block
DOE				:	D O E						            		;
KLAAR			:	K L A A R							            ;

// "Kritiek" block
KRITIEK			:	K R I T I E K						            ;

// "Besteed uit" block
BESTEED         :   B E S T E E D                                   ;
UIT             :   U I T                                           ;
AAN             :   A A N                                           ;
WACHT           :   W A C H T                                       ;
GEDEELDE        :   G E D E E L D
                |   G E D E E L D E                                 ;

PUNT			: '.'                                               ;
KOMMA			: ','                                               ;
LH				: '('                                               ;
RH				: ')'                                               ;
IS				: I S                                               ;
EEN				: E E N                                             ;
OP              : O P	                                            ;
VAN				: V A N												;

NUMBER			: DIGIT+			                                ;
IDENTIFIER		: LETTER ALPHANUM*	                                ;

fragment DIGIT		: [0-9]				                            ;
fragment LETTER		: [a-zA-Z]			                            ;
fragment ALPHANUM	: DIGIT	| LETTER	                            ;

fragment GELIJK		: G E L I J K		                            ;
fragment ONGELIJK	: O N GELIJK | NIET WITRUIMTE GELIJK		    ;

fragment KLEINER	: K L E I N E R		                            ;
fragment GROTER		: G R O T E R		                            ;

// Operators
fragment GEDEELD    : G E D E E L D                                 ;
fragment DOOR       : D O O R                                       ;
fragment TOT        : T O T                                         ;
fragment DE         : D E                                           ;
fragment MACHT      : M A C H T                                     ;

// Special characters
fragment SPATIE     : ' '                                           ;
fragment TAB        : '\t'                                          ;
fragment RETURN     : '\r'                                          ;
fragment NEWLINE    : '\n'                                          ;

// Alphabet upper- and lowercase
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

COMMENTAAR      :   '#' .*? ('\n' | EOF)    -> skip ;
WITRUIMTE		: 	[ \t\r\n]+	-> skip	            ;
ERRORCHARACTER  :   .                               ;