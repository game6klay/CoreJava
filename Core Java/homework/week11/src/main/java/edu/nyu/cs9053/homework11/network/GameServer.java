package edu.nyu.cs9053.homework11.network;

import edu.nyu.cs9053.homework11.game.Difficulty;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.channels.spi.SelectorProvider;
import java.util.*;

/**
 * User: blangel
 * Date: 11/15/15
 * Time: 3:31 PM
 *
 * A NIO implementation of a NetworkGameProvider.
 *
 * The server takes the following commands:
 * <pre>
 *     foes Difficulty
 * </pre>
 * <pre>
 *     move
 * </pre>
 * where the String "foes Easy" would be a call to {@linkplain NetworkGameProvider#getRandomNumberOfNextFoes(String)}
 * with "Easy"
 * and a call using String "move" would be a call to {@linkplain NetworkGameProvider#getRandomNextMove()}
 */
public class GameServer implements NetworkGameProvider, Runnable {

    public static final String SERVER_HOST = "localhost";

    public static final int SERVER_PORT = 8080;
    private static final Random RANDOM = new Random();
    private final ServerSocketChannel channel;
    private final Selector selector;
    private final ByteBuffer readBuffer=ByteBuffer.allocate(1024);
    private final Map<SocketChannel, List<String>> info;


    public static void main(String[] args) throws IOException {
        GameServer server = new GameServer();
        server.run();
    }

    public GameServer() throws IOException {
        selector = SelectorProvider.provider().openSelector();
        channel = ServerSocketChannel.open();
        channel.configureBlocking(false);

        InetSocketAddress isa = new InetSocketAddress(SERVER_HOST, SERVER_PORT);
        channel.socket().bind(isa);

        channel.register(selector, SelectionKey.OP_ACCEPT);
        info = new HashMap<>();


    }

    @Override
    public String getRandomNumberOfNextFoes(String difficulty) {

        Difficulty randomDifficulty;

        switch(difficulty){
            case "Easy":
                randomDifficulty=Difficulty.Easy;
                break;
            case "Medium":
                randomDifficulty=Difficulty.Medium;
                break;
            case "Hard":
                randomDifficulty=Difficulty.Hard;
                break;
            default:
                randomDifficulty=null;
        }
        return ""+RANDOM.nextInt(randomDifficulty.getLevel());

    }

    @Override
    public String getRandomNextMove() {

        if(RANDOM.nextInt(2)==0) {

            if(RANDOM.nextInt(2)==0) {
                return "Up";
            }
            else {
                return "Down";
            }
        }
        else {
            if(RANDOM.nextInt(20)==0) {
                return "R";
            }
            else {
                return "Right";
            }
        }
    }

    @Override
    public void run() {

        while(!Thread.currentThread().isInterrupted()) {

            try {
                int readyChannels = selector.select();
                if (readyChannels == 0) {
                    continue;
                }

                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> keyIterator = selectedKeys.iterator();

                while(keyIterator.hasNext()) {
                    SelectionKey key = keyIterator.next();
                    SelectableChannel channel = key.channel();
                    if(key.isReadable()){
                        SocketChannel socketChannel = (SocketChannel) key.channel();

                        readBuffer.clear();

                        int numRead;
                        try {
                            numRead = socketChannel.read(readBuffer);
                        } catch (IOException e) {
                            key.cancel();
                            socketChannel.close();
                            return;
                        }

                        if (numRead == -1) {
                            key.channel().close();
                            key.cancel();
                            return;
                        }
                    }
                    else if(key.isWritable()) {
                        SocketChannel clientChannel = (SocketChannel) key.channel();
                        List<String> pendingData = info.get(clientChannel);
                        Iterator<String> items = pendingData.iterator();
                        while (items.hasNext()) {
                            String serverOutput = items.next()+"\n";
                            items.remove();
                            clientChannel.write(ByteBuffer.wrap(serverOutput.getBytes()));
                        }
                        key.interestOps(SelectionKey.OP_READ);

                    }
                    keyIterator.remove();
                }
            } catch(IOException ioe) {
                System.out.println("IOException : "+ioe.getMessage());
            }
        }

    }
}
