/*
 * 633-2 project Oliv&Jon - Client - Client.java
 * Author : Jonathan Schnyder
 * Created : 1 d�c. 2017
 */

package client;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Client {
    static String serverName = "192.168.180.10";
    static String localName = "192.168.180.1";
    static int serverPort = 50000;
    static int clientPort = 50001;
    static int disconnectPort = 50002;
    static ServerSocket listeningSocket = null;

    static List<String[]> serverFileList = null;
    static String path = "data/";
    static String[] fileInfo = null;

    static JList<String> downloadbleList = new JList<>();
    static JScrollPane scrollPane = new JScrollPane(downloadbleList);
    static JLabel selectedFile = new JLabel("");
    static JButton download = new JButton("Donwload");
    static JButton refresh = new JButton("Refresh files");
    static JButton showFolder = new JButton("Show folder");
    static JFrame mainFrame = new JFrame("Download files");
    static JPanel southPanel = new JPanel(new BorderLayout());
    static JPanel northPanel = new JPanel(new BorderLayout());

    public static void main(String[] args) {
        //get connection details from config.properties
        try {
            InputStream input = new FileInputStream("config.properties");
            Properties prop = new Properties();
            prop.load(input);
            serverName = prop.getProperty("serverName");
            localName = prop.getProperty("localName");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(mainFrame, "Config file not found");
        }

        /*GUI elements*/

        //listeners
        downloadbleList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                if (downloadbleList.getSelectedIndex() == -1) return;
                //Change the label to show that it is selected
                int index = downloadbleList.getSelectedIndex();
                fileInfo = serverFileList.get(index);
                selectedFile.setText("File " + fileInfo[1] + " selected");
                download.setEnabled(true);
            }
        });

        download.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (downloadFileFromClient(clientPort, fileInfo, path)) {
                        selectedFile.setText(fileInfo[1] + " downloaded");
                    } else {
                        selectedFile.setText("Could not download file");
                    }

                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                fileInfo = null;

                downloadbleList.clearSelection();
                download.setEnabled(false);
            }
        });

        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    serverFileList = refreshFileList(path, localName, serverName, serverPort);
                    downloadbleList.setListData(getFileNames(serverFileList));
                } catch (Exception e1) {
                    fileInfo = null;
                    downloadbleList.clearSelection();
                    download.setEnabled(false);
                    JOptionPane.showMessageDialog(mainFrame, "Could not connect to server");
                }
                fileInfo = null;
                selectedFile.setText("");
                downloadbleList.clearSelection();
                download.setEnabled(false);
            }
        });

        showFolder.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Desktop.getDesktop().open(new File(path));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                disconnect(serverName, disconnectPort);
            }
        });
        download.setEnabled(false);
        scrollPane.setPreferredSize(new Dimension(350, 300));
        northPanel.add(refresh, BorderLayout.EAST);
        northPanel.add(showFolder, BorderLayout.WEST);
        mainFrame.add(northPanel, BorderLayout.NORTH);
        mainFrame.add(scrollPane, BorderLayout.CENTER);
        southPanel.add(selectedFile, BorderLayout.WEST);
        southPanel.add(download, BorderLayout.EAST);
        mainFrame.add(southPanel, BorderLayout.SOUTH);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);

        /*Connection to the server*/

        //connect on the app launch
        try {
            serverFileList = refreshFileList(path, localName, serverName, serverPort);
            downloadbleList.setListData(getFileNames(serverFileList));
        } catch (Exception e) {
            fileInfo = null;
            downloadbleList.clearSelection();
            download.setEnabled(false);
            JOptionPane.showMessageDialog(mainFrame, "Could not connect to server");
        }

        /*Preparing to send a file to another client*/
        //socket for sending files to client
        try {
            InetAddress localAddress = InetAddress.getByName(localName);
            listeningSocket = new ServerSocket(clientPort, 5, localAddress);
        } catch (UnknownHostException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        //Creating thread for accepting incoming connections
        Thread waitToSendThread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        //accept incoming connection
                        Socket clientSendingSocket;
                        clientSendingSocket = listeningSocket.accept();
                        //Create new thread for connecting client
                        Thread sendingThread = new Thread() {
                            @Override
                            public void run() {
                                //get requested file name
                                String fileName;
                                try {
                                    fileName = getRequestedFileName(clientSendingSocket);
                                    //send requested file to client
                                    sendFileToClient(clientSendingSocket, path, fileName);

                                    //close connection to client
                                    clientSendingSocket.close();
                                } catch (ClassNotFoundException | IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        };
                        //start the client thread
                        sendingThread.start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        waitToSendThread.start();
    }

    /*Broadcasting and retrieving file list to/from server*/

    public static List<String> getClientFiles(String path) {
        File directory = new File(path);
        List<String> clientFiles = new ArrayList<>();
        File[] files = directory.listFiles();
        for (File f : files) {
            clientFiles.add(f.getName());
        }
        return clientFiles;
    }

    //method for available file list
    public static Vector<String[]> refreshFileList(String path, String localName, String serverName, int serverPort) throws IOException, ClassNotFoundException {
        File directory = new File(path);
        if (!directory.exists()) directory.mkdirs();
        List<String> clientFiles = getClientFiles(path);
        List<String[]> serverFileList = null;
        Vector<String[]> fileList = new Vector<String[]>();
        InetAddress serverAddress = InetAddress.getByName(serverName);
        Socket serverSocket = new Socket();
        serverSocket.connect(new InetSocketAddress(serverAddress, serverPort), 5);

        ObjectOutputStream outputStream = new ObjectOutputStream(serverSocket.getOutputStream());
        outputStream.writeObject(clientFiles);
        outputStream.flush();

        ObjectInputStream inputStream = new ObjectInputStream(serverSocket.getInputStream());
        serverFileList = (ArrayList<String[]>) inputStream.readObject();

        serverSocket.close();
        for (String[] fileName : serverFileList) {
            if (!fileName[0].equals(localName)) fileList.add(fileName);

        }
        if (fileList.isEmpty()) {
            JOptionPane.showMessageDialog(mainFrame, "No available files");
        }
        return fileList;
    }

    //method for creating a file name list
    public static Vector<String> getFileNames(List<String[]> serverFileList) {
        Vector<String> fileNames = new Vector<String>();
        for (String[] fileInfo : serverFileList) {
            fileNames.add(fileInfo[1]);
        }
        return fileNames;
    }

    /*Sending a file to a client*/

    public static String getRequestedFileName(Socket clientSendingSocket) throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(clientSendingSocket.getInputStream());
        String fileName = (String) inputStream.readObject();
        return fileName;
    }

    public static boolean sendFileToClient(Socket clientSendingSocket, String path, String fileName) throws IOException {
        OutputStream outputStream = clientSendingSocket.getOutputStream();
        Files.copy(Paths.get(path + fileName), outputStream);
        return true;
    }

    /*Recieving a file from a client*/

    public static boolean downloadFileFromClient(int clientPort, String[] fileInfo, String path) throws IOException, ClassNotFoundException, FileAlreadyExistsException {
        String fileName = fileInfo[1];
        String clientName = fileInfo[0];

        InetAddress clientAddress = InetAddress.getByName(clientName);
        Socket clientSocket = new Socket();
        try {
            clientSocket.connect(new InetSocketAddress(clientAddress, clientPort), 5);
            InputStream inputStream = clientSocket.getInputStream();
            ObjectOutputStream output = new ObjectOutputStream(clientSocket.getOutputStream());

            //send wanted file anme
            output.writeObject(fileName);

            //download file to path
            try {
                Files.copy(inputStream, Paths.get(path + fileName));
            } catch (Exception e) {
                clientSocket.close();
                JOptionPane.showMessageDialog(mainFrame, "File already exists");
                return false;
            }
            clientSocket.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(mainFrame, "Client is AFK");
            return false;
        }
        return true;
    }

    //method for notifying the server that the client is disconnecting
    public static int disconnect(String serverName, int disconnectServerPort) {
        InetAddress serverAddress;
        try {
            serverAddress = InetAddress.getByName(serverName);
            Socket serverSocket = new Socket();
            serverSocket.connect(new InetSocketAddress(serverAddress, disconnectServerPort), 5);
            serverSocket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
