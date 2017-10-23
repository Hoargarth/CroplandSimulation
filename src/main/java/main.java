import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class main {
    public static void main(String[] args){

        //Prompt user for input
        System.out.println("You have to select a gray-scale height map with .png file format from your folder.\nPress ENTER to open your file browser:");
        /*
        * Todo: User needs to see the what to do, eg. press enter before filechooser pops up
        * */
        //Open JFileChooser for user to select height map
        JFileChooser fileChooser = new JFileChooser();
        //Filter for .bmp files
        FileNameExtensionFilter bmpFilter = new FileNameExtensionFilter(".png Image","png");
        fileChooser.setFileFilter(bmpFilter);
        //Open file dialog
        fileChooser.showOpenDialog(null);
    }
}
