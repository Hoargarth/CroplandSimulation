

public class Simulation {
    public static void main(String[] args) {

        String heightMap;

        while (ConsoleController.fileDialogReturn == 1) {

            //Prompt user for input
            System.out.println("You have to select a gray-scale height map with .png file format from your folder.\nPress ENTER to open your file browser:");

            /*
            * Todo: User needs to see the what to do, eg. press enter before filechooser pops up
            * */

            heightMap = ConsoleController.SelectGrayScaleHeightMap();

            System.out.println(heightMap);
        }
    }
}
