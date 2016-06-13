grammar LANGdradig;

import LANGdradigInlezer;

program		: 	statement*;

statement	:	declaration	PUNT											#declStat
			|	block PUNT													#blockStat
			|	expression PUNT												#exprStat
			|	ALS expression DAN statement (ANDERS statement)? 			#ifStat
			|	ZOLANG expression statement									#whileStat
			|	BESTEEDUIT block PUNT										#forkStat
			;
				
declaration		:	IDENTIFIER IS EEN type
				;

block			:	DOE statement* KLAAR
				;
				
assignment		:	IDENTIFIER WORDT expression
				;

expression	:	assignment							#assExpr
			| 	LH expression RH					#parExpr
			|	expression GELIJKAAN expression		#eqExpr
			|	expression ONGELIJKAAN expression	#neqExpr
			|	booleanExpr							#boolExpr
			|	numberExpr							#numExpr
			;

booleanExpr		:	booleanExpr EN booleanExpr				#andExpr
				|	booleanExpr OF booleanExpr				#orExpr
				|	NIET booleanExpr						#notExpr
				|	numberExpr KLEINERDAN numberExpr		#ltExpr
				|	numberExpr GROTERDAN numberExpr			#gtExpr
				|	numberExpr KLEINEROFGELIJK numberExpr	#leExpr
				|	numberExpr GROTEROFGELIJK numberExpr	#geExpr
				|	WAAR									#trueExpr
				|	ONWAAR									#falseExpr
				|	IDENTIFIER								#idfBoolExpr
				;

numberExpr		:	term PLUS term		#plusExpr
				|	term MIN term		#minExpr
				|	term				#termExpr
				;

term	: factor KEER factor			#multTerm
		| factor GEDEELDDOOR factor		#divTerm
		| factor MODULUS factor			#modTerm
		| factor						#facTerm
		;

factor	: <assoc=right> factor TOTDEMACHT factor	#powFac
		| NUMBER 									#numFac
		| '(' expression ')'						#exprFac
		| IDENTIFIER								#idfFac
		| '-' factor								#negFac
		;

type	: GEHEELGETAL		#intType
		| WAARHEID			#boolType
		;

