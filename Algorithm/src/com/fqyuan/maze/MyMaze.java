package com.fqyuan.maze;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

//https://ideone.com/CWwNwE
//https://www.cs.bu.edu/teaching/alg/maze/
public class MyMaze {
	static class Coord {
		/*
		 * Why y goes before x? The coordination goes as follows. y axis are of
		 * the contrary of the traditonal way.
		 */
		private int y;
		private int x;

		public Coord(int y, int x) {
			this.y = y;
			this.x = x;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		@Override
		public String toString() {
			return String.valueOf(y).concat(String.valueOf(x));
		}
	}

	public static void main(String[] args) {
		char[][] board = { { '0', '2', '1', '1', '1' }, { '0', '1', '0', '0', '1' }, { '0', '0', '0', '0', '1' },
				{ '0', '0', 'A', '0', '1' }, { '1', '1', 'a', '1', '1' }, { '1', 'b', '0', '0', 'B' },
				{ '1', '1', '0', '0', '1' }, { '0', '1', '0', '0', '3' } };
		System.out.println(solve(board));

	}

	public static ArrayList<Coord> solve(char[][] board) {
		ArrayList<Coord> shortestPathToGoal = new ArrayList<>();
		boolean[][] visited = initVisited(board);
		// printArr(board);
		for (int y = 0; y < board.length; y++) {
			for (int x = 0; x < board[y].length; x++) {
				if (board[y][x] == '2') {
					walk(board, y, x, 0, visited, new ArrayDeque<Coord>(), shortestPathToGoal);
				}
			}
		}
		// printArr(parseList(shortestPathToGoal, board));
		return shortestPathToGoal;
	}

	private static char[][] parseList(ArrayList<Coord> list, char[][] board) {
		char[][] result = new char[board.length][];
		for (int y = 0; y < board.length; y++) {
			result[y] = new char[board[y].length];
			Arrays.fill(result[y], '#');
		}
		for (Coord co : list) {
			int y = co.getY();
			int x = co.getX();
			result[y][x] = '+';
		}
		return result;
	}

	private static void printArr(char[][] board) {
		for (int y = 0; y < board.length; y++) {
			for (int x = 0; x < board[y].length; x++)
				System.out.print(board[y][x] + " ");
			System.out.println();
		}
	}

	private static void walk(char[][] board, int y, int x, int keyRing, boolean[][] visited, Deque<Coord> path,
			ArrayList<Coord> shortestPath) {
		if (y < 0 || y >= board.length || x < 0 || x >= board[y].length || visited[y][x])
			return; // Out of boundary or already visited.

		char point = board[y][x];
		if (point == '0') // Obstacle
			return;

		if (point == '3') { // Goal
			shortestPath.clear();
			shortestPath.addAll(path);
			shortestPath.add(new Coord(y, x));
			return; // return to look for alternate shorter path.
		}

		if (!shortestPath.isEmpty() && path.size() + 2 >= shortestPath.size())
			return; // Shorter path already found.

		// Deal with key lock issue.
		if (point >= 'A' && point <= 'Z') { // Door
			if ((keyRing & (1 << (point - 'A'))) == 0)
				return; // Missing key
		} else if (point >= 'a' && point <= 'z') { // Key
			if ((keyRing & (1 << (point - 'a'))) == 0) {
				keyRing |= (1 << (point - 'a')); // Add key to keyRing
				visited = initVisited(board); // May now revisit previous steps.
			}
		}

		visited[y][x] = true;
		path.addLast(new Coord(y, x));
		// Up
		walk(board, y - 1, x, keyRing, visited, path, shortestPath);
		// Right
		walk(board, y, x + 1, keyRing, visited, path, shortestPath);
		// Down
		walk(board, y + 1, x, keyRing, visited, path, shortestPath);
		// Left
		walk(board, y, x - 1, keyRing, visited, path, shortestPath);
		path.removeLast();

		visited[y][x] = false;
	}

	private static boolean[][] initVisited(char[][] board) {
		boolean visited[][] = new boolean[board.length][];
		for (int y = 0; y < board.length; y++)
			visited[y] = new boolean[board[y].length];
		return visited;
	}
}
