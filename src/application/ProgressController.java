/**

 * File: ProgressController.java

 * Author: Magdalena Zheleva

 * Date: 11/28/2023

 */
package application;

public class ProgressController {
    private double hBarProgress;
    private double eBarProgress;
    private double fBarProgress;
    private static ProgressController instance;

    private ProgressController() {
        // Initialize progress values
        hBarProgress = 0.0;
        eBarProgress = 0.0;
        fBarProgress = 0.0;
    }

    public static ProgressController getInstance() {
        if (instance == null) {
            instance = new ProgressController();
        }
        return instance;
    }

    public double getHBarProgress() {
        return hBarProgress;
    }

    public double getEBarProgress() {
        return eBarProgress;
    }

    public double getFBarProgress() {
        return fBarProgress;
    }

    // Update methods for each progress bar
    public void updateHBarProgress(double value) {
        hBarProgress = value;
    }

    public void updateEBarProgress(double value) {
        eBarProgress = value;
    }

    public void updateFBarProgress(double value) {
        fBarProgress = value;
    }
    
    // Reset method to reset all progress values to zero
    public void resetProgress() {
        hBarProgress = 0.0;
        eBarProgress = 0.0;
        fBarProgress = 0.0;
    }
}
