grammar LANGdradig;

import LANGdradigInlezer;

program		: 	statement*;

statement	:	declaration	PUNT															#declStat
			|	block PUNT																	#blockStat
			|	expression PUNT																#exprStat
			|	ALS expression (KLOPT | NIETKLOPT)? DAN statement (ANDERS statement)? 		#ifStat
			|	ZOLANG expression (KLOPT | NIETKLOPT)? statement							#whileStat
			|	BESTEEDUIT statement														#forkStat
			|	KRITIEK IDENTIFIER statement												#syncStat
			;
				
declaration		:	IDENTIFIER IS EEN type
				;

block			:	DOE statement* KLAAR
				;
				
assignment		:	IDENTIFIER WORDT expression
				;

expression	:	primary																					#primExpr
			
			|	MIN expression																			#negExpr
			|	NIET expression																			#notExpr
			
			|	<assoc=right>expression TOTDEMACHT expression											#powExpr
			|	expression (KEER | GEDEELDDOOR | MODULUS) expression									#factorExpr
			|	expression (PLUS | MIN) expression														#termExpr
			
			
			|	expression (LIGTTUSSEN | LIGTBUITEN) expression EN expression							#rangeExpr
			|	expression (KLEINERDAN | GROTERDAN | KLEINEROFGELIJK | GROTEROFGELIJK) expression		#cmpExpr
			|	expression (GELIJKAAN | ONGELIJKAAN) expression											#eqExpr
			|	expression (EN | OF) expression															#boolExpr
			
			|	<assoc=right>assignment																	#assExpr
			;

primary		:	LH expression RH						#parExpr
			|	WAAR									#trueExpr
			|	ONWAAR									#falseExpr
			|	IDENTIFIER								#idfExpr
			|	NUMBER									#numExpr
			;
			
type	: GEHEELGETAL		#intType
		| WAARHEID			#boolType
		| type REEKS		#arrayType
		;