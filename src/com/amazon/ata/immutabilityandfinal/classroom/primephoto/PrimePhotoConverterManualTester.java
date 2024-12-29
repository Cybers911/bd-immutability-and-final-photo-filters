package com.amazon.ata.immutabilityandfinal.classroom.primephoto;

import com.amazon.ata.immutabilityandfinal.classroom.primephoto.activity.ConvertPrimePhotoActivity;
import com.amazon.ata.immutabilityandfinal.classroom.primephoto.dependency.DaggerServiceComponent;
import com.amazon.ata.immutabilityandfinal.classroom.primephoto.dependency.ServiceComponent;
import com.amazon.ata.immutabilityandfinal.classroom.primephoto.model.ConversionType;

import com.google.common.collect.ImmutableList;
  //  //  Here we are using Dagger to create a new instance of ServiceComponent for each test.
/**
 * A class provided for interacting with the PrimePhotoConverterService
 */
public class PrimePhotoConverterManualTester {

    private static final ServiceComponent DAGGER = DaggerServiceComponent.create();
    //What Dagger do is to create a new instance of ServiceComponent for each test.

    /**
     * If you're having issues running the main method, check the "Before starting" steps in the README.
     */
    public static void main(String[] args) {
        //Run the test with the source picture and multiple filter types. And a list of conversion types
        runTest("src/resources/dalmatian.jpg", ImmutableList.of(ConversionType.INVERSION,
            ConversionType.GREYSCALE, ConversionType.SEPIA));
        //Aqui esta creando una immutabilty and final List de ConversionType en vez de
        // una lista de ConversionType  regular ImmutableList.of disenada para
        // garantizar que los cambios en el estado no sean visibles desde otras partes del código.
        //disenada para concurrent access.Por lo tanto cada threat tiene su propia version de la lista.
        //This test will start the inversion, greyscale, and sepia conversions in a new
        // thread as they run concurrently
        // PARTICIPANTS: uncomment the below line to run a test that converts an image to a single filter type.
//         runTest("src/resources/dalmatian.jpg", ImmutableList.of(ConversionType.SEPIA));
    }


    // This test will start each converion type in a new thread as they run concurrently
    // and collect the results at the end. We passing in a List of connversion types
    private static void runTest(String filePath, ImmutableList<ConversionType> conversions) {
        ConvertPrimePhotoActivity activity = DAGGER.provideConvertPhotoActivity();
        activity.handleRequest(filePath, conversions);
    }
}
