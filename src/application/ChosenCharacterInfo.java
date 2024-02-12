/**

 * File: ChosenCharacterInfo.java

 * Author: Magdalena Zheleva

 * Date: 11/28/2023

 */
package application;

public class ChosenCharacterInfo {
    private static int chosenCharacterIndex;

    // Method to retrieve the chosen character index
    public static int getChosenCharacterIndex() {
        return chosenCharacterIndex;
    }

    // Method to set the chosen character index
    public static void setChosenCharacterIndex(int index) {
        chosenCharacterIndex = index;
    }
}
