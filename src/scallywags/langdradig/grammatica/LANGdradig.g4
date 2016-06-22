grammar LANGdradig;

import LANGdradigInlezer;

program		: 	statement*
            ;

//              Rule of thumb: If a statement does not end in a statement, it should end with a PUNT
statement	:	IDENTIFIER IS EEN type PUNT		            										    #declStat
            |   IDENTIFIER IS EEN GEDEELDE type PUNT												    #sharedDeclStat
			|	DOE statement* KLAAR PUNT 																#blockStat
			|	expression PUNT																            #exprStat
			|	ALS expression (NIET? KLOPT)? DAN statement (ANDERS statement)? 		                #ifStat
			|	ZOLANG expression (NIET? KLOPT)? statement					        		            #whileStat
			|	BESTEED UIT AAN IDENTIFIER statement  										            #forkStat
			|   BESTEED statement UIT AAN IDENTIFIER PUNT                                               #forkStat
			|   WACHT OP IDENTIFIER PUNT                                                                #joinStat
			|	KRITIEK IDENTIFIER statement												            #syncStat
			;

expression	:	primary																					#primExpr
			
			|	MIN expression																			#negExpr
			|	NIET expression 																		#notExpr
			|   (((VERHOOG | VERLAAG) IDENTIFIER) | (HOOG IDENTIFIER OP))                               #crementExpr
			
			|	<assoc=right> expression TOTDEMACHT expression              							#powExpr
			|	expression (KEER | GEDEELDDOOR | MODULUS) expression      	                			#factorExpr
			|	expression (PLUS | MIN) expression														#termExpr

			|	expression LIGT (TUSSEN | BINNEN | BUITEN) expression EN expression                     #rangeExpr
			|   expression (TUSSEN | BINNEN | BUITEN) expression EN expression LIGT                     #rangeExpr
			|	expression (KLEINERDAN | GROTERDAN | KLEINEROFGELIJK | GROTEROFGELIJK) expression		#cmpExpr
			|	expression (GELIJKAAN | ONGELIJKAAN) expression		                    				#eqExpr
			|	expression (EN | OF) expression															#boolExpr
			
			|	<assoc=right> IDENTIFIER WORDT expression												#assExpr
			;

primary		:	LH expression RH						                                                #parExpr
			|	WAAR									                                                #trueExpr
			|	ONWAAR									                                                #falseExpr
			|	IDENTIFIER								                                                #idfExpr
			|	NUMBER									                                                #numExpr
			;
			
type	    :   GETAL   		                                                                        #intType
		    |   STELLING			                                                                    #boolType
		    |   REEKS VAN NUMBER type                                                                   #arrayType
		    ;