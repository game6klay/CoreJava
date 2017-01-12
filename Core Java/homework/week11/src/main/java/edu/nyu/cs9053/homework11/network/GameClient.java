package edu.nyu.cs9053.homework11.network;

import edu.nyu.cs9053.homework11.game.Difficulty;
import edu.nyu.cs9053.homework11.game.GameProvider;
import edu.nyu.cs9053.homework11.game.screen.InputMove;

import java.io.*;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Random;

/**
 * User: blangel
 * Date: 11/15/15
 * Time: 3:32 PM
 *
 * A blocking IO implementation of a client which requests moves from a remote server implementing the
 * {@linkplain edu.nyu.cs9053.homework11.network.NetworkGameProvider}
 */


public class GameClient implements GameProvider {

    private static final Random RANDOM = new Random() ;
    private final Difficulty difficulty;
    private final BufferedReader serverInput;
    private final PrintWriter serverOutput;

    public static GameClient construct(Difficulty difficulty) {
        try {

            Socket socket = new Socket(GameServer.SERVER_HOST, GameServer.SERVER_PORT);
            return new GameClient(difficulty,socket.getInputStream(),socket.getOutputStream());

        } catch(IOException ioe) {
            System.out.println("IOException:"+ioe.getMessage());
        }
        return null;

    }

    public GameClient(Difficulty difficulty, InputStream serverInput, OutputStream serverOutput) {

        this.difficulty = difficulty;
        this.serverInput = new BufferedReader(new InputStreamReader(serverInput));
        this.serverOutput = new PrintWriter((serverOutput), true);
    }

    @Override
    public Difficulty getDifficulty() {
        return this.difficulty;
    }

    @Override
    public int getRandomNumberOfNextFoes() {

            String request= "level";

            if(this.difficulty==Difficulty.Easy){
                request+="Easy";
            }
            else if(this.difficulty==Difficulty.Hard){
                request+="Hard";
            }
            else{
                request+="Medium";
            }


        return RANDOM.nextInt(getDifficulty().getLevel()+1);
    }

    @Override
    public InputMove getRandomNextMove() {

            if(RANDOM.nextInt(2)==0) {
                if(RANDOM.nextInt(2)==0) {
                    return InputMove.Up;
                }
                else {
                    return InputMove.Down;
                }
            }
            else {
                if(RANDOM.nextInt(20)==0) {
                    return InputMove.Right;
                }
                else {
                    return InputMove.Left;
                }
            }
        }
    }
