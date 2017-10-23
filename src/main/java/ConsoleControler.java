import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ConsoleControler {

    public static int fileDialogReturn = 1;

    public static String SelectGrayScaleHeightMap(){

        String heightMap;

        //Open JFileChooser for user to select height map
        JFileChooser fileChooser = new JFileChooser();

        //Filter for .bmp files
        FileNameExtensionFilter bmpFilter = new FileNameExtensionFilter(".png Image","png");
        fileChooser.setFileFilter(bmpFilter);

        //Open file dialog
        fileDialogReturn = fileChooser.showOpenDialog(null);

        //Check if correct file has been chosen
        if (fileDialogReturn == JFileChooser.APPROVE_OPTION)
        {
            heightMap = fileChooser.getSelectedFile().getAbsolutePath();

            String[] fileNameParts = heightMap.split("\\.");

            if(fileNameParts[fileNameParts.length - 1].equals("png") || fileNameParts[fileNameParts.length - 1].equals("PNG"))
            {
                return heightMap;
            }
            else
            {
                fileDialogReturn = 1;
                return null;
            }
        }
        else
        {
            fileDialogReturn = 1;
            return null;
        }
    }
}
