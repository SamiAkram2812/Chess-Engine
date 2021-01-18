package chess.pieces;

import java.util.LinkedList;

import chess.board.Position;
import chess.players.Color;

public class Knight extends Piece {

	public Knight(Position position, Color color) {
		super(position, color);
		setWeight(3);
	}

	@Override
	public LinkedList<Position> getLegalMoves() {
		return null;
	}

}
