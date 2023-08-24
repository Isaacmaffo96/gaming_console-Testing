// snake game

asm Snake

import StandardLibrary

signature:
	// DOMAINS
	domain Coord subsetof Integer
	enum domain Sign = {EMPTY | WALL |HEAD| BODY | APPLE }
	enum domain Status = {SETUP | IN_GAME | GAME_OVER}
	enum domain Direction = {UP | DOWN | RIGHT | LEFT}
	// FUNCTIONS
	controlled board: Prod(Coord, Coord) -> Sign
	controlled status: Status
	controlled score: Integer
	controlled headx: Coord
	controlled heady: Coord
	controlled applex: Coord
	controlled appley: Coord
	controlled message: String
	monitored userChoice: Direction

definitions:
	// DOMAIN DEFINITIONS
	domain Coord = {1 : 6}

	// FUNCTION DEFINITIONS
		
	// RULE DEFINITIONS
	rule r_setWalls =
		par
			forall $x1 in {1 : 5} do board($x1,6) := WALL
			forall $x2 in {2 : 6} do board($x2,1) := WALL
			forall $y1 in {1 : 5} do board(1,$y1) := WALL
			forall $y2 in {2 : 6} do board(6,$y2) := WALL
		endpar
	
	rule r_setHead =
		par
			headx := 2
			heady := 3
			board(2,3) := HEAD
		endpar
	
	rule r_setBody =
		board(2,2) := BODY
		
	rule r_setFirstApple =
		par
			board(3,4) := APPLE
			applex := 3
			appley := 4
		endpar
	
	rule r_newApple =
		choose $x in Coord, $y in Coord with isUndef(board($x, $y)) do
			par
				board($x,$y) := APPLE
				applex := $x
				appley := $y
			endpar
		
	rule r_checkApple($xHead in Coord, $yHead in Coord) = 
		if board($xHead,$yHead) = APPLE then 
			par
				score := score + 1
				r_newApple[]
			endpar
		endif
	
	rule r_moveHead =
		let ($d = userChoice) in 
			switch($d)
				case UP:
					if (headx = 2 or board(headx-1,heady) = BODY) then status := GAME_OVER
					else
						par
							board(headx,heady) := BODY
							board(headx-1,heady) := HEAD
							headx := headx - 1
							r_checkApple[headx-1,heady]
						endpar
					endif
				case DOWN: 
					if (headx = 6 or board(headx+1,heady) = BODY) then status := GAME_OVER
					else
						par
							board(headx,heady) := BODY
							board(headx+1,heady) := HEAD
							headx := headx + 1
							r_checkApple[headx+1,heady]
						endpar
					endif
				case LEFT: 
					if (heady = 1 or board(headx,heady-1) = BODY) then status := GAME_OVER
					else
						par
							board(headx,heady) := BODY
							board(headx,heady-1) := HEAD
							heady := heady - 1
							r_checkApple[headx,heady-1]
						endpar
					endif
				case RIGHT: 
					if (heady = 6 or board(headx,heady+1) = BODY) then status := GAME_OVER
					else
						par
							board(headx,heady) := BODY
							board(headx,heady+1) := HEAD
							heady := heady + 1
							r_checkApple[headx,heady+1]
						endpar
					endif
			endswitch
		endlet

	// INVARIANTS

	// MAIN RULE
	main rule r_Main =
		switch status
			case SETUP:
				par
					r_setWalls[]
					r_setHead[]
					r_setBody[]
					r_setFirstApple[]
					score:= 0
					status := IN_GAME
				endpar
			case IN_GAME:
				r_moveHead[]
			case GAME_OVER:
				message := concat("Game Over, your score: ",toString(score))
		endswitch

// INITIAL STATE
default init s0:
	function status = SETUP
