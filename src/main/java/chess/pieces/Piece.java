package chess.pieces;

import java.util.LinkedList;

import chess.board.Board;
import chess.board.Position;
import chess.exception.ChessException;
import chess.players.Color;

public abstract class Piece {
	private int weight;
	private boolean white;
	private boolean black;
	private Position position;
	private Color color;

	public Piece(Position position, Color color) {
		setPosition(position);
		setColor(color);
	}

	public abstract LinkedList<Position> getLegalMoves();

	public boolean moveTo(Position position) {
		if (Board.getPosition(position) == null) {
			try {
				Board.movePiece(this, position);
			} catch (ChessException e) {
				return false;
			}
			setPosition(position);
			return true;
		}
		return false;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public int getWeight() {
		return this.weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public boolean isWhite() {
		return white;
	}

	public void setWhite(boolean white) {
		this.white = white;
		this.black = !white;
	}

	public boolean isBlack() {
		return black;
	}

	public void setBlack(boolean black) {
		this.black = black;
		this.white = !black;
	}

}
