package chess.board;

import chess.exception.ChessException;
import chess.pieces.Piece;
import chess.players.Color;

public abstract class Board {

	private static Piece[][] positions = new Piece[8][8];
	public static Color turn = Color.WHITE;

	public static void movePiece(Piece piece, Position position) throws ChessException {
		if (turn != piece.getColor())
			throw new ChessException(ChessException.ILlegalTurn);
		if (piece.getPosition().equals(position)) {
			throw new ChessException(ChessException.IllegalMove);
		}
		setPosition(piece.getPosition(), null);
		setPosition(position, piece);
		flipTurn();
	}

	private static void flipTurn() {
		if (turn == Color.WHITE)
			turn = Color.BLACK;
		else
			turn = Color.WHITE;
	}

	public static Piece getPosition(Position position) {
		return positions[position.getColumn() - 1][position.getRow() - 1];
	}

	public static boolean isEmpty(Position position) {
		if (!(position.isValid()))
			return false;
		return getPosition(position) == null;
	}

	public static boolean isKill(Position position, Color color) {
		if (!(position.isValid()) || getPosition(position) == null)
			return false;
		return getPosition(position).getColor() != color;
	}

	public static boolean isAlly(Position position, Color color) {
		try {
			return getPosition(position).getColor() == color;
		} catch (Exception e) {
			return false;
		}
	}

	public static void setPosition(Position position, Piece piece) {
		positions[position.getColumn() - 1][position.getRow() - 1] = piece;
	}
}
