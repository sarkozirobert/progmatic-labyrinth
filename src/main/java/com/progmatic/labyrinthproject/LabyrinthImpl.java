package com.progmatic.labyrinthproject;

import com.progmatic.labyrinthproject.enums.CellType;
import com.progmatic.labyrinthproject.enums.Direction;
import com.progmatic.labyrinthproject.exceptions.CellException;
import com.progmatic.labyrinthproject.exceptions.InvalidMoveException;
import com.progmatic.labyrinthproject.interfaces.Labyrinth;
import com.progmatic.labyrinthproject.interfaces.Player;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author pappgergely
 */
public class LabyrinthImpl implements Labyrinth {

    public LabyrinthImpl() {
        
    }
    char[][] maze;

    @Override
    public int getWidth() {
        int counter = 0;
        for (int index1 = 0; index1 < maze.length; index1++) {
            for (int index2 = 0; index2 < maze[index1].length; index2++) {
                counter = index2;
            }
        }
        return counter;
    }

    @Override
    public int getHeight() {
        int counter = 0;
        for (int index1 = 0; index1 < maze.length; index1++) {
            for (int index2 = 0; index2 < maze[index1].length; index2++) {
                counter = index1;
            }
        }
        return counter;
    }

    @Override
    public void loadLabyrinthFile(String fileName) {
        try {
            Scanner sc = new Scanner(new File(fileName));
            int width = Integer.parseInt(sc.nextLine());
            int height = Integer.parseInt(sc.nextLine());

            for (int hh = 0; hh < height; hh++) {
                String line = sc.nextLine();
                for (int ww = 0; ww < width; ww++) {
                    switch (line.charAt(ww)) {
                        case 'W':
                            Coordinate c1 = new Coordinate(ww, hh);
                            setCellType(c1, CellType.WALL);
                            maze[hh][ww] = line.charAt(ww);
                            break;
                        case 'E':
                            Coordinate c2 = new Coordinate(ww, hh);
                            setCellType(c2, CellType.END);
                            maze[hh][ww] = line.charAt(ww);
                            break;
                        case 'S':
                            Coordinate c3 = new Coordinate(ww, hh);
                            setCellType(c3, CellType.START);
                            maze[hh][ww] = line.charAt(ww);
                            break;
                        case ' ':
                            Coordinate c4 = new Coordinate(ww, hh);
                            setCellType(c4, CellType.EMPTY);
                            maze[hh][ww] = line.charAt(ww);
                            break;
                    }
                }
            }
        } catch (FileNotFoundException | NumberFormatException | CellException ex) {
            System.out.println(ex.toString());
        }
    }

    @Override
    public CellType getCellType(Coordinate c) throws CellException {
        int height = c.getRow();
        int width = c.getCol();
        CellException cellE = new CellException(height, width, "There's no cell found on this coordinate.");
        if (height > getHeight() || width > getWidth()) {
            throw cellE;
        }
        switch (maze[height][width]) {
            case 'W':
                return CellType.WALL;
            case 'E':
                return CellType.END;
            case 'S':
                return CellType.START;
        }
        return CellType.EMPTY;
    }

    @Override
    public void setSize(int width, int height) {
        maze = new char[height][width];
    }

    @Override
    public void setCellType(Coordinate c, CellType type) throws CellException {

    }

    @Override
    public Coordinate getPlayerPosition() {
        return null;
    }

    @Override
    public boolean hasPlayerFinished() {
        return false;
    }

    @Override
    public List<Direction> possibleMoves() {
        return null;
    }

    @Override
    public void movePlayer(Direction direction) throws InvalidMoveException {

    }

}
